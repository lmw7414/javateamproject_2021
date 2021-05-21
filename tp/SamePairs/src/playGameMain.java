import java.util.Scanner;
public class playGameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cho;
		Game game = new Game();
		Scanner scan = new Scanner(System.in);
		game.init();
		while(true)
		{
			game.printMenu();
			cho= scan.nextInt();
			if(cho == 0) {
				System.out.print("HAVE A NICE DAY\n TNAHK YOU FOR PLAYING GAME.. BYE BYE");
				break;
			}
			switch(cho)
			{
			case 1:
				game.printMenuFirst();
				break;
			case 2:
				game.LoadGame();
				System.out.println("Game Start");
				break;
			case 3:
				game.showRanking();
				break;
			default:
				System.out.println("Invalid Select...");
				break;
				
			}
		}
	}

}
