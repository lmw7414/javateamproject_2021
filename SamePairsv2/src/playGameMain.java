import java.util.Scanner;
import javax.swing.JFrame;

public class playGameMain {
	public static void main(String[] args) {
		int cho;
		ButtonFrame buttonFrame = new ButtonFrame(); // create ButtonFrame
		buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buttonFrame.setSize(1280, 960); // set frame size
		buttonFrame.setVisible(true); // display frame
		Game game = new Game();
		Scanner scanner = new Scanner(System.in);
		game.init();

		while (true) {
			game.printMenu();
			cho = scanner.nextInt();
			if (cho == 0) {
				System.out.print("HAVE A NICE DAY\n TNAHK YOU FOR PLAYING GAME.. BYE BYE");
				break;
			}
			switch (cho) {
			case 1:
				game.startGame();
				break;
			case 2:
				game.LoadGame();
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