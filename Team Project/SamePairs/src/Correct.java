
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class Correct extends JFrame{
	private JLabel label;
	Voice voice;
	
	public Correct(String cardName, Icon picture) {
		super("Correct!");
		setLayout(new FlowLayout());
		label = new JLabel();
		label.setText(cardName);
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		label.setIcon(picture);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setVerticalTextPosition(SwingConstants.BOTTOM);
		add(label);
	}
}