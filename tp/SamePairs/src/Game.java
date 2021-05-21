import java.util.Scanner;
import java.security.SecureRandom;

public class Game {
	int time = 300;
	static int userCnt = 0;
	Person[] user = new Person[100];
	Card card;

	public void init() {
		for (int i = 0; i < 100; i++) {
			user[i] = new Person();
		}
	}

	public void printMenuFirst() {
		System.out.println("************************************************");
		System.out.println("***              make user INFO              ***");
		System.out.println("************************************************");
		setUser();
	}

	public void printMenu() {
		System.out.println("************************************************");
		System.out.println("***             Welcome To GAME              ***");
		System.out.println("***                                          ***");
		System.out.println("***             1. New Game                  ***");
		System.out.println("***             2. Load Game                 ***");
		System.out.println("***             3. Show Ranking              ***");
		System.out.println("***             0. Exit Game                 ***");
		System.out.println("************************************************");
		System.out.print("Choose Menu : ");
	}

	public void setUser() {
		String name;
		Scanner scan = new Scanner(System.in);
		System.out.println("...What`s your name...");
		System.out.print("USER NAME : ");
		name = scan.nextLine();
		user[userCnt++].setPerson(name);
		startGamelevel1();
	}

	public void sortRanking() {
		Person temp = new Person();
		for (int i = 0; i < userCnt - 1; i++) {
			for (int j = 0; j < userCnt - i - 1; j++)
				if (user[j].getPersonScore() > user[j + 1].getPersonScore()) {
					temp.clonePerson(user[j].getPersonName(), user[j].getPersonScore(), user[j].getPersonSecond(),
							user[j].getPersonHighLevel());
					user[j].clonePerson(user[j + 1].getPersonName(), user[j + 1].getPersonScore(),
							user[j + 1].getPersonSecond(), user[j + 1].getPersonHighLevel());
					user[j + 1].clonePerson(temp.getPersonName(), temp.getPersonScore(), temp.getPersonSecond(),
							temp.getPersonHighLevel());
				}
		}
	}

	// level1 game
	public void startGamelevel1() {
		System.out.println("level1 start Game..");
		int[][] gameboard1 = new int[5][4];
		int[] gamecard1 = new int[11];
		SecureRandom sr = new SecureRandom();
		int value = sr.nextInt(10) + 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				value = sr.nextInt(10) + 1;
				if (gamecard1[value] == 2) {
					j--;
					continue;
				} else {
					gameboard1[i][j] = value;
					gamecard1[value]++;

				}
			}
		}
		showGameboard(gameboard1, 5, 4);
		startGamelevel2();
	}

	public void showGameboard(int[][] gameboard, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.printf("[%2d]", gameboard[i][j]);
			}
			System.out.println();
		}
	}

	// level2 game
	public void startGamelevel2() {
		System.out.println("level2 start Game..");
		int[][] gameboard2 = new int[5][6];
		int[] gamecard2 = new int[16];
		SecureRandom sr = new SecureRandom();
		int value = sr.nextInt(15) + 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				value = sr.nextInt(15) + 1;
				if (gamecard2[value] == 2) {
					j--;
					continue;
				} else {
					gameboard2[i][j] = value;
					gamecard2[value]++;

				}
			}
		}
		showGameboard(gameboard2, 5, 6);
		startGamelevel3();
	}

	// level3 game
	public void startGamelevel3() {
		System.out.println("level3 start Game..");
		int[][] gameboard3 = new int[5][8];
		int[] gamecard3 = new int[21];
		SecureRandom sr = new SecureRandom();
		int value = sr.nextInt(20) + 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				value = sr.nextInt(20) + 1;
				if (gamecard3[value] == 2) {
					j--;
					continue;
				} else {
					gameboard3[i][j] = value;
					gamecard3[value]++;

				}
			}
		}
		showGameboard(gameboard3, 5, 8);
		System.out.println("GAME END");
	}

	// 랭킹 보여주기
	public void showRanking() {
		int j;
		System.out.println("USER RANKING TOP 10");
		if (userCnt > 10)
			j = 10;
		else
			j = userCnt;

		System.out.printf("%20s %20s %20s %20s\n", "NAME", "SCORE", "SECOND", "LEVEL");
		for (int i = 0; i < j; i++) {
			System.out.printf("%d. %-18s %19d %19d %19d\n", i + 1, user[i].getPersonName(), user[i].getPersonScore(),
					user[i].getPersonSecond(), user[i].getPersonHighLevel());

		}
	}
	public void LoadGame() {
	      int i, j=0;;
	      String name2;
	      Scanner scan = new Scanner(System.in);
	      System.out.println("************************************************");
	       System.out.println("***              Search Name                ***");
	       System.out.println("***********************************************");
	       System.out.print("SEARCH NAME : ");
	      name2 = scan.nextLine();
	      for(i=0; i<=userCnt; i++)
	      {
	         if(name2.equals(user[i].getPersonName()))
	         {
	            j=1;
	            System.out.println("Your name founded");
	            break;
	         }
	      }
	      if(j!=1) {
	         System.out.println("There is no name that you wrote.");
	         return;
	      }
	      startGamelevel1();
	   }
}
