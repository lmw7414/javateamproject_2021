import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame 
{
   
   private JButton fancyJButton1; // button with icons
   private JButton fancyJButton2;
   private JButton fancyJButton3;
   private JButton fancyJButton4;
   private JButton fancyJButton5;
   private JButton fancyJButton6;
   private JButton fancyJButton7;
   private JButton fancyJButton8;
   private JButton fancyJButton9;
   private JButton fancyJButton10;
   private JButton fancyJButton11;
   private JButton fancyJButton12;
   private JButton fancyJButton13;
   private JButton fancyJButton14;
   private JButton fancyJButton15;
   private JButton fancyJButton16;
   private JButton fancyJButton17;
   private JButton fancyJButton18;
   private JButton fancyJButton19;
   private JButton fancyJButton20;

   
   // ButtonFrame adds JButtons to JFrame
   public ButtonFrame()
   {
      super( "Testing Buttons" );
      setLayout( new FlowLayout() ); // set frame layout

      Icon apple = new ImageIcon( getClass().getResource( "apple.png" ) );
      Icon kiwi = new ImageIcon( getClass().getResource( "kiwi.png" ) );
      Icon banana = new ImageIcon( getClass().getResource( "banana.png" ) );
      Icon soup = new ImageIcon( getClass().getResource( "soup.png" ) );
      Icon strawberry = new ImageIcon( getClass().getResource( "strawberry.png" ) );
      Icon pizza = new ImageIcon( getClass().getResource( "pizza.png" ) );
      Icon burger = new ImageIcon( getClass().getResource( "burger.png" ) );
      Icon chicken = new ImageIcon( getClass().getResource( "chicken.png" ) );
      Icon lemon = new ImageIcon( getClass().getResource( "lemon.png" ) );
      Icon tomato = new ImageIcon( getClass().getResource( "tomato.png" ) );
      Icon cherry = new ImageIcon( getClass().getResource( "cherry.png" ) );
      Icon mushroom = new ImageIcon( getClass().getResource( "mushroom.png" ) );
      Icon carrot = new ImageIcon( getClass().getResource( "carrot.png" ) );
      Icon cake = new ImageIcon( getClass().getResource( "cake.png" ) );
      Icon radish = new ImageIcon( getClass().getResource( "radish.png" ) );
      Icon onion = new ImageIcon( getClass().getResource( "onion.png" ) );
      Icon corn = new ImageIcon( getClass().getResource( "corn.png" ) );
      Icon broccoli = new ImageIcon( getClass().getResource( "broccoli.png" ) );
      Icon mango = new ImageIcon( getClass().getResource( "mango.png" ) );
      Icon cucumber = new ImageIcon( getClass().getResource( "cucumber.png" ) );
      Icon backp = new ImageIcon( getClass().getResource( "backp.png" ) );
      fancyJButton1 = new JButton( backp ); // set image
      fancyJButton2 = new JButton( backp ); // set image
      fancyJButton3 = new JButton( backp ); // set image
      fancyJButton4 = new JButton( backp ); // set image
      fancyJButton5 = new JButton( backp ); // set image
      fancyJButton6 = new JButton( backp ); // set image
      fancyJButton7 = new JButton( backp ); // set image
      fancyJButton8 = new JButton( backp ); // set image
      fancyJButton9 = new JButton( backp ); // set image
      fancyJButton10 = new JButton( backp ); // set image
      fancyJButton11 = new JButton( backp ); // set image
      fancyJButton12 = new JButton( backp ); // set image
      fancyJButton13 = new JButton( backp ); // set image
      fancyJButton14 = new JButton( backp ); // set image
      fancyJButton15 = new JButton( backp ); // set image
      fancyJButton16 = new JButton( backp ); // set image
      fancyJButton17 = new JButton( backp ); // set image
      fancyJButton18 = new JButton( backp ); // set image
      fancyJButton19 = new JButton( backp ); // set image
      fancyJButton20 = new JButton( backp ); // set image
      
      
//      fancyJButton1 = new JButton( apple ); // set image
//      fancyJButton2 = new JButton( kiwi ); // set image
//      fancyJButton3 = new JButton( banana ); // set image
//      fancyJButton4 = new JButton( soup ); // set image
//      fancyJButton5 = new JButton( strawberry ); // set image
//      fancyJButton6 = new JButton( pizza ); // set image
//      fancyJButton7 = new JButton( burger ); // set image
//      fancyJButton8 = new JButton( chicken ); // set image
//      fancyJButton9 = new JButton( lemon ); // set image
//      fancyJButton10 = new JButton( tomato ); // set image
//      fancyJButton11 = new JButton( cherry ); // set image
//      fancyJButton12 = new JButton( mushroom ); // set image
//      fancyJButton13 = new JButton( carrot ); // set image
//      fancyJButton14 = new JButton( cake ); // set image
//      fancyJButton15 = new JButton( radish ); // set image
//      fancyJButton16 = new JButton( onion ); // set image
//      fancyJButton17 = new JButton( corn ); // set image
//      fancyJButton18 = new JButton( broccoli ); // set image
//      fancyJButton19 = new JButton( mango ); // set image
//      fancyJButton20 = new JButton( cucumber ); // set image
      //fancyJButton21 = new JButton( backp ); // set image
      
      
      fancyJButton1.setRolloverIcon( apple ); // set rollover image
      fancyJButton2.setRolloverIcon( kiwi ); // set rollover image
      fancyJButton3.setRolloverIcon( banana ); // set rollover image
      fancyJButton4.setRolloverIcon( soup ); // set rollover image
      fancyJButton5.setRolloverIcon( strawberry ); // set rollover image
      fancyJButton6.setRolloverIcon( pizza ); // set rollover image
      fancyJButton7.setRolloverIcon( burger ); // set rollover image
      fancyJButton8.setRolloverIcon( chicken ); // set rollover image
      fancyJButton9.setRolloverIcon( lemon ); // set rollover image
      fancyJButton10.setRolloverIcon( tomato ); // set rollover image
      fancyJButton11.setRolloverIcon( cherry ); // set rollover image
      fancyJButton12.setRolloverIcon( mushroom ); // set rollover image
      fancyJButton13.setRolloverIcon( carrot ); // set rollover image
      fancyJButton14.setRolloverIcon( cake ); // set rollover image
      fancyJButton15.setRolloverIcon( radish ); // set rollover image
      fancyJButton16.setRolloverIcon( onion ); // set rollover image
      fancyJButton17.setRolloverIcon( corn ); // set rollover image
      fancyJButton18.setRolloverIcon( broccoli ); // set rollover image
      fancyJButton19.setRolloverIcon( mango ); // set rollover image
      fancyJButton20.setRolloverIcon( cucumber ); // set rollover image
//      
      
      add( fancyJButton1 );
      add( fancyJButton2 );
      add( fancyJButton3 );
      add( fancyJButton4 );
      add( fancyJButton5 );
      add( fancyJButton6 );
      add( fancyJButton7 );
      add( fancyJButton8 );
      add( fancyJButton9 );
      add( fancyJButton10 );
      add( fancyJButton11 );
      add( fancyJButton12 );
      add( fancyJButton13 );
      add( fancyJButton14 );
      add( fancyJButton15 );
      add( fancyJButton16 );
      add( fancyJButton17 );
      add( fancyJButton18 );
      add( fancyJButton19 );
      add( fancyJButton20 );// add fancyJButton to JFrame

      // create new ButtonHandler for button event handling 
      ButtonHandler handler = new ButtonHandler();
      //fancyJButton1.addActionListener( handler );
//      fancyJButton2.addActionListener( handler );
//      fancyJButton3.addActionListener( handler );
//      fancyJButton4.addActionListener( handler );
//      fancyJButton5.addActionListener( handler );
//      fancyJButton6.addActionListener( handler );
//      fancyJButton7.addActionListener( handler );
//      fancyJButton8.addActionListener( handler );
//      fancyJButton9.addActionListener( handler );
//      fancyJButton10.addActionListener( handler );
//      fancyJButton11.addActionListener( handler );
//      fancyJButton12.addActionListener( handler );
//      fancyJButton13.addActionListener( handler );
//      fancyJButton14.addActionListener( handler );
//      fancyJButton15.addActionListener( handler );
//      fancyJButton16.addActionListener( handler );
//      fancyJButton17.addActionListener( handler );
//      fancyJButton18.addActionListener( handler );
//      fancyJButton19.addActionListener( handler );
//      fancyJButton20.addActionListener( handler );
      
      //plainJButton.addActionListener( handler );
   } // end ButtonFrame constructor

   // inner class for button event handling
   private class ButtonHandler implements ActionListener 
   {
      // handle button event
      public void actionPerformed( ActionEvent event )
      {
         JOptionPane.showMessageDialog( ButtonFrame.this, String.format(
            "You pressed: %s", event.getActionCommand() ) );
      } // end method actionPerformed
   } // end private inner class ButtonHandler
} // end class ButtonFrame




