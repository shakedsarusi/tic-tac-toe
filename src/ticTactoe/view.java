package ticTactoe;


public class view implements Iview {
	
	private Ipresenter ipresenter = new presenter(this);
	private char[][] Screen = new char[3][3];

	
	public view()
	{
		this.ipresenter = ipresenter;
		this.Screen = Screen;
	}
	
	public void startGame()
	{
		System.out.println("new game");

		int i;
		int j;
		for (i = 0; i < 3; ++i) {
			for (j = 0; j < 3; ++j) {
				this.Screen[i][j] = ' ';
			}
		}

		i = 0;
		j = 0;

		for (i = 0; i < 3; ++i) {
			for (j = 0; j < 3; ++j) {
				System.out.print(this.Screen[i][j] + "|");
			}

			System.out.println("");
		}
		ipresenter.startGame();

	}
	
	public void event()
	{
		ipresenter.event();
	}

	public void move(int a[]) 
	{
		if(a[2] == 0)
			Screen[a[0]][a[1]] = 'X';
		if(a[2] == 1)
			Screen[a[0]][a[1]] = 'O';
		
		
		updateScreen();
		event();

	}

	public void updateScreen() 
	{
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				System.out.print(this.Screen[i][j] + "|");
			}

			System.out.println("");
		}

	}

	public void masseges(String msg) 
	{
		System.out.println(msg);
	}

	public void resetScreen()
	{
		int i,j;
		for (i = 0; i < 3; ++i) 
		{
			for (j = 0; j < 3; ++j) 
			{
				this.Screen[i][j] = ' ';
			}
	    }
	}
	

}

