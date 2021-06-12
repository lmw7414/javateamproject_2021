import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import javax.swing.*;

public class Tutorial extends JPanel {
	public JmainTest win;
	public JButton[] fancyJButton = new JButton[5];
	public Icon[] picture = new Icon[3];
	public Card[] cards = new Card[5];
	private final String[] Word = { "backp","apple", "kiwi"};
	public int flippedCard = -1, firstCard = 0, secondCard = 0, score = 0, matchedCard = 0, size = 4;
	public boolean matched = true;
	Voice voice;

	public Tutorial(JmainTest win) {
		this.win = win;
		setLayout(null);

		picture[0] = new ImageIcon(getClass().getResource("backp.png"));
		picture[1] = new ImageIcon(getClass().getResource("apple.png"));
		picture[2] = new ImageIcon(getClass().getResource("kiwi.png"));
		
		ButtonHandler handler = new ButtonHandler();

		int[] pic = new int[size/2 + 1];
		int x = 15, y = 15, row = 2, col = 2;
		int horizon, height;
		
		horizon = row * 110 + 50;
		height = col * 120 + 200;

		for (int i = 1; i <= size; i++) {
			SecureRandom ri = new SecureRandom(); // random icon
			int value = 0;

			boolean overlap = true;
			while (overlap) {
				value = ri.nextInt(size/2) + 1;
				if (pic[value] == 2)
					continue;
				else {
					pic[value]++;
					overlap = false;
				}
			}
			fancyJButton[i] = new JButton(picture[0]);// set image
			fancyJButton[i].setBounds(x, y, 110, 130);

			add(fancyJButton[i]);
			if (i % row == 0) {
				y += 130;
				x = 15;
			} else
				x += 110;

			cards[i] = new Card(Word[value], Status.back, picture[value]);
			fancyJButton[i].addActionListener(handler);
		}
	}
	public class ButtonHandler implements ActionListener {

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
					}
				}
				if (cards[firstCard].getCardPicture() == cards[secondCard].getCardPicture()
						&& firstCard != secondCard) { // if matched
					Correct correct = new Correct(cards[firstCard].getCardWord(),cards[firstCard].getCardPicture());
					correct.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					correct.setSize(260,260);
					correct.setVisible(true);
					matched = true;
					score += 10;
					cards[firstCard].setCardState(Status.correct);
					cards[secondCard].setCardState(Status.correct);
					fancyJButton[firstCard].setVisible(false);
					fancyJButton[secondCard].setVisible(false);
					voice = new Voice(cards[firstCard].getCardWord());
					voice = new Voice(cards[firstCard].getCardWord());
					matchedCard++;
				} else {
					score -= 1;
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
			if(matchedCard == size / 2)
				win.change("Menu", 0);
		}
		// JOptionPane.showMessageDialog( ButtonFrame.this, String.format(
		// "You pressed: %s", event.getActionCommand() ) );
		// end method actionPerformed
	} // end private inner class ButtonHandler
}