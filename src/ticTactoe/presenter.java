package ticTactoe;


public class presenter implements Ipresenter 
{
	private Iview iview;
	private Model model = new Model();

	public presenter(Iview iview) 
	{
		this.iview = iview;
		this.model = model;
	}
	
	public void startGame()
	{
		model.startGame();
		
	}
	
	public void event()
	{
		int a[] = new int[3];
		a = model.event();
		if(a[2]!= 2)
		{
			String str = model.endGame();
			
			if(str.equals("next player"))
			{
				masseges(str);
				iview.move(a);
				
			}
			else if(!str.equals("next player"))
			{
				masseges(str);
				model.resetArr();
				iview.resetScreen();
				model.upNumOfPlays();
				
			}
			
			
		}
		else
		{
			
			iview.move(a);

		}
		
		
		
		
	}
	
	
	public void masseges(String msg)
	{
		iview.masseges(msg);
	}
	
}
