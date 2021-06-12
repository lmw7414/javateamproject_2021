
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Level extends JFrame {
	public JButton[] fancyJButton = new JButton[41];
	public Icon[] picture = new Icon[21];
	public Card[] cards = new Card[41];
	private final String[] Word = { "backp", "apple", "kiwi", "banana", "soup", "strawberry", "pizza", "hamburger",
			"chicken", "lemon", "tomato", "cherry", "mushroom", "carrot", "cake", "radish", "onion", "corn", "broccoli",
			"mango", "cucumber" };
	public JLabel nameLabel = new JLabel();
	public JLabel levelLabel = new JLabel();
	public JLabel scoreLabel = new JLabel();
	public int flippedCard = -1, firstCard = 0, secondCard = 0, matchedCard = 0;
	public int score = 0, size, LEV = 1;
	static long afterTime, secDiffTime = 0, beforeTime = System.currentTimeMillis();
	public boolean matched = true;
	public String nextLevel;
	private Dimension frameSize, screenSize;
	JFrame frame = new JFrame("Game");
	Voice voice;

	public Level(int n, Person p) {
		size = n;
		init();
		int[] pic = new int[size / 2 + 1];
		int x = 0, y = 15, row;

		if (size == 20) {
			row = 5;
			LEV = 1;
		} else if (size == 30) {
			row = 6;
			LEV = 2;
		} else {
			row = 8;
			LEV = 3;
		}

		levelLabel.setText("LEVEL : " + LEV);
		levelLabel.setBounds(300, 15, 100, 100);
		nameLabel.setText("NAME : " + p.getPersonName());
		nameLabel.setBounds(560, 15, 300, 100);
		nameLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		levelLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		scoreLabel.setText("SCORE : " + p.getPersonScore());
		scoreLabel.setBounds(800, 15, 200, 100);
		scoreLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		frame.add(nameLabel);
		frame.add(levelLabel);
		frame.add(scoreLabel);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(1500, 900);
		frame.setVisible(true); // display frame
		Stopwatch stopwatch = new Stopwatch(frame);
		stopwatch.timer.start();

		for (int i = 1; i <= size; i++) {
			SecureRandom ri = new SecureRandom(); // random icon
			int value = 0;

			boolean overlap = true;
			while (overlap) {
				value = ri.nextInt(size / 2) + 1;
				if (pic[value] == 2)
					continue;
				else {
					pic[value]++;
					overlap = false;
				}
			}
			fancyJButton[i] = new JButton(picture[0]);// set image
			fancyJButton[i].setBounds(x, y, 110, 130);

			if (size == 20)
				fancyJButton[i].setBounds(x + 450, y + 100, 110, 130);
			else if (size == 30)
				fancyJButton[i].setBounds(x + 400, y + 100, 110, 130);
			else
				fancyJButton[i].setBounds(x + 250, y + 100, 110, 130);
			frame.add(fancyJButton[i]);

			if (i % row == 0) { // set card location
				y += 130;
				x = 0;
			} else
				x += 110;

			cards[i] = new Card(Word[value], Status.back, picture[value]);
			fancyJButton[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent event) { // fix : change to other class
					if (flippedCard == -1) { // first flip
						for (int i = 1; i <= size; i++) {
							if (event.getSource() == fancyJButton[i]) {
								if (cards[i].getCardState() != Status.front) {
									fancyJButton[i].setIcon(cards[i].getCardPicture()); // flip card to frontward
									cards[i].setCardState(Status.front);
									flippedCard = 1;
									firstCard = i;
								}
							}
						}
					} else if ((flippedCard == 0 || flippedCard == 1)) { // when one card is flipped
						for (int i = 1; i <= size; i++) {
							if (event.getSource() == fancyJButton[i]) {
								if (cards[i].getCardState() != Status.front) {
									fancyJButton[i].setIcon(cards[i].getCardPicture()); // flip card to frontward
									cards[i].setCardState(Status.front);
									flippedCard = 2;
									secondCard = i;
								}
								else
									secondCard = 0;
							}
						}
						if (cards[secondCard] != null
								&& cards[firstCard].getCardPicture() == cards[secondCard].getCardPicture()
								&& firstCard != secondCard) { // if matched
							p.setPersonScore(10);
							scoreLabel.setText("SCORE : " + p.getPersonScore());
							scoreLabel.setBounds(800, 15, 200, 100);
							frame.add(scoreLabel);
							Correct correct = new Correct(cards[firstCard].getCardWord(),
									cards[firstCard].getCardPicture());
							correct.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
							correct.setSize(260, 260);
							correct.setVisible(true);
							matched = true;
							cards[firstCard].setCardState(Status.correct);
							cards[secondCard].setCardState(Status.correct);
							fancyJButton[firstCard].setVisible(false);
							fancyJButton[secondCard].setVisible(false);
							voice = new Voice(cards[firstCard].getCardWord());
							voice = new Voice(cards[firstCard].getCardWord());
							matchedCard++;
						} else {
							p.setPersonScore(-1);
							scoreLabel.setText("SCORE : " + p.getPersonScore());
							scoreLabel.setBounds(800, 15, 200, 100);
							frame.add(scoreLabel);
							matched = false;
						}
					} else // when two cards are flipped
						for (int i = 1; i <= size; i++) {
							if (!matched) {
								fancyJButton[firstCard].setIcon(picture[0]);
								fancyJButton[secondCard].setIcon(picture[0]);
								cards[firstCard].setCardState(Status.back);
								cards[secondCard].setCardState(Status.back);
								matched = true;
							}
							flippedCard = 0;
							if (event.getSource() == fancyJButton[i]) {
								if (cards[i].getCardState() != Status.front) {
									fancyJButton[i].setIcon(cards[i].getCardPicture()); // flip card to frontward
									cards[i].setCardState(Status.front);
									flippedCard++;
									firstCard = i;
								}
							}
						}
					if (matchedCard == size / 2) {
						frame.dispose();
						afterTime = System.currentTimeMillis();
						secDiffTime = (afterTime - beforeTime) / 1000;
						p.setPersonSecond(secDiffTime);
						p.setPersonScore(score);
						if (size == 20)
							new Level(30, p);
						else if (size == 30)
							new Level(40, p);
						else {
							
							frame.dispose();
						}
					}
				}
			});
		}
	}

	public void init() {
		// initialize array picture
		picture[0] = new ImageIcon(getClass().getResource("backp.png"));
		picture[1] = new ImageIcon(getClass().getResource("apple.png"));
		picture[2] = new ImageIcon(getClass().getResource("kiwi.png"));
		picture[3] = new ImageIcon(getClass().getResource("banana.png"));
		picture[4] = new ImageIcon(getClass().getResource("soup.png"));
		picture[5] = new ImageIcon(getClass().getResource("strawberry.png"));
		picture[6] = new ImageIcon(getClass().getResource("pizza.png"));
		picture[7] = new ImageIcon(getClass().getResource("hamburger.png"));
		picture[8] = new ImageIcon(getClass().getResource("chicken.png"));
		picture[9] = new ImageIcon(getClass().getResource("lemon.png"));
		picture[10] = new ImageIcon(getClass().getResource("tomato.png"));
		picture[11] = new ImageIcon(getClass().getResource("cherry.png"));
		picture[12] = new ImageIcon(getClass().getResource("mushroom.png"));
		picture[13] = new ImageIcon(getClass().getResource("carrot.png"));
		picture[14] = new ImageIcon(getClass().getResource("cake.png"));
		picture[15] = new ImageIcon(getClass().getResource("radish.png"));
		picture[16] = new ImageIcon(getClass().getResource("onion.png"));
		picture[17] = new ImageIcon(getClass().getResource("corn.png"));
		picture[18] = new ImageIcon(getClass().getResource("broccoli.png"));
		picture[19] = new ImageIcon(getClass().getResource("mango.png"));
		picture[20] = new ImageIcon(getClass().getResource("cucumber.png"));
	}

	class Stopwatch implements ActionListener {
		JFrame frame = new JFrame();
		JLabel timeLabel = new JLabel();
		JButton stopButton = new JButton("STOP");
		int elapsedTime = 0;
		int seconds = 0;
		int minutes = 0;
		int hours = 0;
		boolean stoped = false;
		String seconds_string = String.format("%02d", seconds);
		String minutes_string = String.format("%02d", minutes);
		String hours_string = String.format("%02d", hours);

		Timer timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				elapsedTime = elapsedTime + 1000;
				hours = (elapsedTime / 3600000);
				minutes = (elapsedTime / 60000) % 60;
				seconds = (elapsedTime / 1000) % 60;
				seconds_string = String.format("%02d", seconds);
				minutes_string = String.format("%02d", minutes);
				hours_string = String.format("%02d", hours);
				timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
			}
		});

		Stopwatch(JFrame e) {
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
			frameSize = frame.getSize();
			screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			timeLabel.setBounds(1100, 7, 200, 100);
			timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
			timeLabel.setBorder(BorderFactory.createBevelBorder(1));
			timeLabel.setOpaque(true);
			timeLabel.setHorizontalAlignment(JTextField.CENTER);

			e.add(timeLabel);

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
}