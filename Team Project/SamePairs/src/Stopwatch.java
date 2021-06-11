/*import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener{
		JFrame frame = new JFrame();
		JLabel timeLabel = new JLabel();
		JButton stopButton = new JButton("STOP");
		int elapsedTime=0;
		int seconds=0;
		int minutes=0;
		int hours=0;
		boolean stoped=false;
		String seconds_string = String.format("%02d", seconds);
		String minutes_string = String.format("%02d", minutes);
		String hours_string = String.format("%02d", hours);
		
		Timer timer = new Timer(1000, new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				elapsedTime=elapsedTime+1000;
				hours=(elapsedTime/3600000);
				minutes=(elapsedTime/60000)%60;
				seconds=(elapsedTime/1000)%60;
				seconds_string = String.format("%02d", seconds);
				minutes_string = String.format("%02d", minutes);
				hours_string = String.format("%02d", hours);
				timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
				
				stopButton.setBounds(100,200,100,50);
				stopButton.setFont(new Font("Ink Free", Font.PLAIN, 20));
				stopButton.setFocusable(false);
				stopButton.addActionListener(this);
			}
		});
		Stopwatch(){
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
			timeLabel.setBounds(100, 100, 200, 100);
			timeLabel.setFont(new Font("Verdana", Font.PLAIN, 35));
			timeLabel.setBorder(BorderFactory.createBevelBorder(1));
			timeLabel.setOpaque(true);
			timeLabel.setHorizontalAlignment(JTextField.CENTER);
			
			frame.add(timeLabel);
			frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			frame.setSize(420, 420);
			frame.setLayout(null);
			frame.setVisible(true);
			timer.start();
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
			
}*/