import javax.swing.*;
import java.awt.*;

public class ShowRank {
	private Person[] top10 = new Person[11];
	private JFrame rframe = new JFrame();
	private JLabel Label;
	String[][] mat = new String[12][5];

	public ShowRank(Person[] user, int userCnt) {
		rframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		rframe.setTitle("RANKING");
		rframe.setSize(415, 235);

		sortRanking(user, userCnt);
		showRanking(user, userCnt);

		rframe.setVisible(true);
	}

	public void sortRanking(Person[] user, int userCnt) {
		Person temp = new Person();
		for (int i = 1; i <= userCnt; i++) {
			for (int j = 1; j <= userCnt - i; j++)
				if (user[j].getPersonScore() < user[j + 1].getPersonScore()) {
					temp.clonePerson(user[j].getPersonName(), user[j].getPersonScore(), user[j].getPersonSecond());
					user[j].clonePerson(user[j + 1].getPersonName(), user[j + 1].getPersonScore(),
							user[j + 1].getPersonSecond());
					user[j + 1].clonePerson(temp.getPersonName(), temp.getPersonScore(), temp.getPersonSecond());
				}
		}
	}

	public void showRanking(Person[] user, int userCnt) {
		int j;
		System.out.println("USER RANKING TOP 10");
		if (userCnt > 10)
			j = 10;
		else
			j = userCnt;

		for (int i = 1; i <= j; i++) {
			top10[i] = user[i];
		}

		mat[0][1] = "Rank";
		mat[0][2] = "Name";
		mat[0][3] = "Score";
		mat[0][4] = "Time";
		for (int i = 1; i <= j; i++) {
			mat[i][1] = Integer.toString(i);
			mat[i][2] = top10[i].getPersonName();
			mat[i][3] = Integer.toString(top10[i].getPersonScore());
			mat[i][4] = Integer.toString(top10[i].getPersonSecond());
		}
		rframe.setLayout(null);
		
		int x = 0, y = 15;
		for (int i = 0; i <= j; i++) {
			for (int k = 1; k <= 4; k++) {
				Label = new JLabel(mat[i][k], JLabel.CENTER);
				Label.setBounds(x, y, 100, 15);
				rframe.add(Label);
				
				x += 100;
			}
			x = 0;
			y += 15;
		}

		
		
		/*
		 * for (int i = 1; i <= j; i++) { String num = Integer.toString(i);
		 * numberLabel.setText(num); numberLabel.setBounds(x, y, 200, 100);
		 * nameLabel.setText(user[i].getPersonName()); nameLabel.setBounds(x + 200, y,
		 * 200, 100); scoreLabel.setText(Integer.toString(user[i].getPersonScore()));
		 * scoreLabel.setBounds(x + 400, y, 200, 100);
		 * timeLabel.setText(Integer.toString(user[i].getPersonSecond()));
		 * timeLabel.setBounds(x + 600, y, 200, 100);
		 * frame.add(numberLabel);frame.add(nameLabel);frame.add(scoreLabel);frame.add(
		 * timeLabel); y += 10; }
		 */

	}
}
