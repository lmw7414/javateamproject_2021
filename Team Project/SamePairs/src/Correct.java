import java.awt.FlowLayout;
import javax.swing.*;

public class Correct extends JFrame{
	private JLabel label;
	Voice voice;
	
	public Correct(String cardName, Icon picture) {
		super("Correct!");
		setLayout(new FlowLayout());
		label = new JLabel();
		label.setText(cardName);
		label.setIcon(picture);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(label);
		//voice = new Voice(cardName);
		//voice = new Voice(cardName);

	}
}
