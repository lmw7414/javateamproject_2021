import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;

public class Game {
	int leftTime, takeTime, currscore;
	boolean tt = false;
	static int userCnt = 0;
	Person[] user = new Person[100];
	Card card;

	public void startGame() {
		// timer
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				if (leftTime > 0) {
					takeTime++;
					if (takeTime % 10 == 0) {
						leftTime -= 10000;
						System.out.printf("\nLeft Time is... %dsec...\n", leftTime / 1000);
					}
				} else if (leftTime <= 0) {
					if (tt = false)
						System.out.println("GAME OVER");
					timer.cancel();
				}
			}
		};

		setUser();
		takeTime = 0;
		leftTime = 60000;
		currscore = 0;
		timer.schedule(task, 0, 1000);
		while (leftTime > 0) {
			tt = testGame();
			if (tt == true) {
				user[userCnt].setPersonSecond(takeTime);
				leftTime = -1;
				user[userCnt].setPersonScore(currscore);
				System.out.println("END");
				break;
			}
		}
	}

	public boolean testGame() {
		System.out.println("test game start...");
		Card[][] gameboard1 = new Card[2][2];
		int[] gamecard1 = new int[3];
		SecureRandom sr = new SecureRandom();
		int value = sr.nextInt(2) + 1;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				value = sr.nextInt(2) + 1;
				if (gamecard1[value] == 2) {
					j--;
					continue;
				} else {
					gameboard1[i][j] = new Card(value, Status.back);
					gamecard1[value]++;
				}
			}
		}
		showGameboard(gameboard1, 2, 2);
		while (!stageClear(gameboard1, 2, 2))
			selectCard(gameboard1, 2, 2);
		System.out.println("Stage1 Clear!");
		return true;
	}

	public void init() {
		for (int i = 0; i < 100; i++) {
			user[i] = new Person();
		}
	}

	public void printMenuFirst() {
		System.out.println("************************************************");
		System.out.println("***              make user INFO              ***");
		System.out.println("************************************************");
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
		printMenuFirst();
		String name;
		Scanner scanner = new Scanner(System.in);
		System.out.println("...What`s your name...");
		System.out.print("USER NAME : ");
		name = scanner.nextLine();
		userCnt++;
		user[userCnt].setPerson(name);
	}

	// print cards
	public void showGameboard(Card[][] gameboard, int row, int col) {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (gameboard[i][j].getCardState() == Status.back)
					System.out.printf("[OO]");
				else if (gameboard[i][j].getCardState() == Status.front)
					System.out.printf("[%2d]", gameboard[i][j].getCardWord());
				else if (gameboard[i][j].getCardState() == Status.correct) {
					System.out.printf("[  ]");
					// add TTS
				}
			}
			System.out.println();
		}
	}

	// level1 game
	public void startGamelevel1() {
		System.out.println("level1 start Game..");
		Card[][] gameboard1 = new Card[5][4];
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
					gameboard1[i][j] = new Card(value, Status.back);
					gamecard1[value]++;
				}
			}
		}
		showGameboard(gameboard1, 5, 4);
		while (!stageClear(gameboard1, 5, 4))
			selectCard(gameboard1, 5, 4);
		System.out.println("Stage1 Clear!");
		startGamelevel2();
	}

	// level2 game
	public void startGamelevel2() {
		System.out.println("level2 start Game..");
		Card[][] gameboard2 = new Card[5][6];
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
					gameboard2[i][j] = new Card(value, Status.back);
					gamecard2[value]++;
				}
			}
		}
		showGameboard(gameboard2, 5, 6);
		while (!stageClear(gameboard2, 5, 6))
			selectCard(gameboard2, 5, 6);
		System.out.println("Stage2 Clear!");
		startGamelevel3();
	}

	// level3 game
	public void startGamelevel3() {
		System.out.println("level3 start Game..");
		Card[][] gameboard3 = new Card[5][8];
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
					gameboard3[i][j] = new Card(value, Status.back);
					gamecard3[value]++;

				}
			}
		}
		showGameboard(gameboard3, 5, 8);
		while (!stageClear(gameboard3, 5, 8))
			selectCard(gameboard3, 5, 8);
		System.out.println("Stage3 Clear!");
		System.out.println("GAME END");
	}

	public void selectCard(Card[][] gameboard, int row, int col) {
	      Scanner scanner = new Scanner(System.in);
	      int row1, col1, row2, col2;
	      
	      while(true)
	      {
	         System.out.print("Select Card1 (row col)");
	         row1 = scanner.nextInt();
	         col1 = scanner.nextInt();
	         if(row1<=row && col1<=col)
	            break;
	         System.out.println("Please write again");
	      }
	      flipCard(gameboard, row1 - 1, col1 - 1, Status.front);
	      showGameboard(gameboard, row, col);
	      while(true)
	      {
	         System.out.print("Select Card2 (row col)");
	         row2 = scanner.nextInt();
	         col2 = scanner.nextInt();
	         if(row2<=row && col2<=col)
	            break;
	         System.out.println("Please write again");
	      }
	      flipCard(gameboard, row2 - 1, col2 - 1, Status.front);
	      showGameboard(gameboard, row, col);
	      if (gameboard[row1 - 1][col1 - 1].getCardWord() == gameboard[row2 - 1][col2 - 1].getCardWord() ) {
	         if((row1 == row2 && col1 == col2 ))
	         {
	        	 currscore -= 2;
		         flipCard(gameboard, row1 - 1, col1 - 1, Status.back);
		         flipCard(gameboard, row2 - 1, col2 - 1, Status.back);
		         System.out.println("same index!!");
		         showGameboard(gameboard, row, col);
	         }
	         else {
	        	 currscore += 10;
	        	 flipCard(gameboard, row1 - 1, col1 - 1, Status.correct);
	        	 flipCard(gameboard, row2 - 1, col2 - 1, Status.correct);
	        	 System.out.printf("Matched! Score : %d", user[userCnt].getPersonScore());
	        	 System.out.println();
	        	 showGameboard(gameboard, row, col);
	         }
	      } else {
	         currscore -= 2;
	         flipCard(gameboard, row1 - 1, col1 - 1, Status.back);
	         flipCard(gameboard, row2 - 1, col2 - 1, Status.back);
	         System.out.println("Not Matched!");
	         showGameboard(gameboard, row, col);
	      }
	   }

	// flip cards
	public void flipCard(Card[][] gameboard, int row, int col, Status state) {
		if (gameboard[row][col].getCardState() != Status.correct)
			gameboard[row][col].setCardState(state);
	}

	public boolean stageClear(Card[][] gameboard, int row, int col) {
		for (int i = 0; i < row; i++)
			for (int j = 0; j < col; j++) {
				if (gameboard[i][j].getCardState() != Status.correct)
					return false;
			}
		return true;
	}

	public void sortRanking() {
		Person temp = new Person();
		for (int i = 1; i <= userCnt; i++) {
			for (int j = 1; j <= userCnt - i; j++)
				if (user[j].getPersonScore() < user[j + 1].getPersonScore()) {
					temp.clonePerson(user[j].getPersonName(), user[j].getPersonScore(), user[j].getPersonSecond(),
							user[j].getPersonHighLevel());
					user[j].clonePerson(user[j + 1].getPersonName(), user[j + 1].getPersonScore(),
							user[j + 1].getPersonSecond(), user[j + 1].getPersonHighLevel());
					user[j + 1].clonePerson(temp.getPersonName(), temp.getPersonScore(), temp.getPersonSecond(),
							temp.getPersonHighLevel());
				}
		}
	}
	
	//show rank
	public void showRanking() {
		sortRanking();
		int j;
		System.out.println("USER RANKING TOP 10");
		if (userCnt > 10)
			j = 10;
		else
			j = userCnt;

		System.out.printf("%20s %20s %20s %20s\n", "NAME", "SCORE", "SECOND", "LEVEL");
		for (int i = 1; i <= j; i++) {
			System.out.printf("%d. %-18s %19d %19d %19d\n", i, user[i].getPersonName(), user[i].getPersonScore(),
					user[i].getPersonSecond(), user[i].getPersonHighLevel());

		}
	}

	public void LoadGame() {
		int i, j = 0;

		String name2;
		Scanner scan = new Scanner(System.in);
		System.out.println("***********************************************");
		System.out.println("***              Search Name                ***");
		System.out.println("***********************************************");
		System.out.print("SEARCH NAME : ");
		name2 = scan.nextLine();
		for (i = 0; i <= userCnt; i++) {
			if (name2.equals(user[i].getPersonName())) {
				j = 1;
				System.out.println("Your name founded");
				user[userCnt++].setPerson(name2);
				break;
			}
		}
		if (j != 1) {
			System.out.println("There is no name that you wrote.");
			return;
		}
		startGamelevel1();
	}

}