import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class DisplayButton extends JFrame 
{
   private JButton[] fancyJButton = new JButton[41];
   private Icon[] picture = new Icon[21];
   private Card[] cards = new Card[41];
   private int size;
   private int flippedCard = -1;
   private int firstCard = 0, secondCard = 0;
   private boolean matched = true;
   private int score = 0;
   
   
  /* private JButton fancyJButton1; // button with icons
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
   private JButton fancyJButton20;*/ 
   
   // ButtonFrame adds JButtons to JFrame
   public DisplayButton(int n)
   {
      super( "Testing Buttons" );
      size = n;
      setLayout( new FlowLayout() ); // set frame layout
      
      // initionalize array picture 
      picture[0] = new ImageIcon( getClass().getResource( "backp.png" ) );
      picture[1] = new ImageIcon( getClass().getResource( "apple.png" ) );
      picture[2] = new ImageIcon( getClass().getResource( "kiwi.png" ) );
      picture[3] = new ImageIcon( getClass().getResource( "banana.png" ) );
      picture[4] = new ImageIcon( getClass().getResource( "soup.png" ) );
      picture[5] = new ImageIcon( getClass().getResource( "strawberry.png" ) );
      picture[6] = new ImageIcon( getClass().getResource( "pizza.png" ) );
      picture[7] = new ImageIcon( getClass().getResource( "hamburger.png" ) );
      picture[8] = new ImageIcon( getClass().getResource( "chicken.png" ) );
      picture[9] = new ImageIcon( getClass().getResource( "lemon.png" ) );
      picture[10] = new ImageIcon( getClass().getResource( "tomato.png" ) );
      picture[11] = new ImageIcon( getClass().getResource( "cherry.png" ) );
      picture[12] = new ImageIcon( getClass().getResource( "mushroom.png" ) );
      picture[13] = new ImageIcon( getClass().getResource( "carrot.png" ) );
      picture[14] = new ImageIcon( getClass().getResource( "cake.png" ) );
      picture[15] = new ImageIcon( getClass().getResource( "radish.png" ) );
      picture[16] = new ImageIcon( getClass().getResource( "onion.png" ) );
      picture[17] = new ImageIcon( getClass().getResource( "corn.png" ) );
      picture[18] = new ImageIcon( getClass().getResource( "broccoli.png" ) );
      picture[19] = new ImageIcon( getClass().getResource( "mango.png" ) );
      picture[20] = new ImageIcon( getClass().getResource( "cucumber.png" ) );
     
      ButtonHandler handler = new ButtonHandler();
      int[] pic = new int[size/2 + 1];
      
      for(int i = 1 ; i<=size ; i++) {
    	  SecureRandom ri = new SecureRandom(); // random icon
    	  int value = 0;
    	  
    	  boolean overlap = true;
    	  while(overlap){
    		  value = ri.nextInt(size/2) + 1;
    		  if(pic[value] == 2)
    			  continue;
    		  else {
    			  pic[value]++;
    			  overlap = false;
    		  }
    	  }
    	  fancyJButton[i] = new JButton( picture[0] ); // set image
    	  add( fancyJButton[i] );
    	  cards[i] = new Card(" ", Status.back, picture[value]); // match card and button through i
    	  fancyJButton[i].addActionListener( handler );
    	  
      }
      /*fancyJButton2 = new JButton( backp ); // set image
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
      fancyJButton20 = new JButton( backp ); // set image*/

      
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
      
      
      /*fancyJButton1.setRolloverIcon( apple ); // set rollover image
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
      fancyJButton20.setRolloverIcon( cucumber ); // set rollover image*/
   
      
      /*add( fancyJButton1 );
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
      add( fancyJButton20 );// add fancyJButton to JFrame*/

      // create new ButtonHandler for button event handling 
      /*ButtonHandler handler = new ButtonHandler();
      fancyJButton1.addActionListener( handler );
      fancyJButton2.addActionListener( handler );
      fancyJButton3.addActionListener( handler );
      fancyJButton4.addActionListener( handler );
      fancyJButton5.addActionListener( handler );
      fancyJButton6.addActionListener( handler );
      fancyJButton7.addActionListener( handler );
      fancyJButton8.addActionListener( handler );
      fancyJButton9.addActionListener( handler );
      fancyJButton10.addActionListener( handler );
      fancyJButton11.addActionListener( handler );
      fancyJButton12.addActionListener( handler );
      fancyJButton13.addActionListener( handler );
      fancyJButton14.addActionListener( handler );
      fancyJButton15.addActionListener( handler );
      fancyJButton16.addActionListener( handler );
      fancyJButton17.addActionListener( handler );
      fancyJButton18.addActionListener( handler );
      fancyJButton19.addActionListener( handler );
      fancyJButton20.addActionListener( handler );*/
      
      //plainJButton.addActionListener( handler );
   } // end ButtonFrame constructor

   // inner class for button event handling
   private class ButtonHandler implements ActionListener 
   {
	  // handle button event
      public void actionPerformed( ActionEvent event )
      { //fix : change to other class
    	  if(flippedCard == -1) { // first flip
    		  for (int i = 1 ; i<=size ; i++){	
    			  if (event.getSource() == fancyJButton[i]){   				  
    				  if (cards[i].getCardState() != Status.front && cards[i].getCardState() != Status.correct) {
    					  fancyJButton[i].setIcon(cards[i].getCardPicture());	// flip card to frontward
    					  cards[i].setCardState(Status.front);
    					  flippedCard = 1;
    					  firstCard = i;
    				  } 
    			  }
    		  }
    	  }
    	  else if ((flippedCard == 0 || flippedCard == 1)){ // when one card is flipped
    		  for (int i = 1 ; i<=size ; i++){
    			  if (event.getSource() == fancyJButton[i]){
    				  if (cards[i].getCardState() != Status.front && cards[i].getCardState() != Status.correct) {
    					  fancyJButton[i].setIcon(cards[i].getCardPicture());	// flip card to frontward
    					  cards[i].setCardState(Status.front);
    					  flippedCard = 2;
    					  secondCard = i;
    				  }
    			  }
    		  }
    			  if (cards[firstCard].getCardPicture() == cards[secondCard].getCardPicture() && 
    					  firstCard != secondCard) { // if matched
    				  // add TTS
    				  matched = true;
    				  score += 10;
    				  cards[firstCard].setCardState(Status.correct);
    				  cards[secondCard].setCardState(Status.correct);
    			  }
    			  else {
    				  score -= 1;
    				  matched = false;
    			  }
    	  }
    	  else // when two cards are flipped
    		  for (int i = 1 ; i<=size ; i++){ 
    			  if (!matched) {
    				  fancyJButton[firstCard].setIcon(picture[0]);
    				  fancyJButton[secondCard].setIcon(picture[0]);
    				  cards[firstCard].setCardState(Status.back);
    				  cards[secondCard].setCardState(Status.back);
    				  matched = true;
    			  }
    			  flippedCard = 0;
    			  if (event.getSource() == fancyJButton[i]){	
    				  if (cards[i].getCardState() != Status.front && cards[i].getCardState() != Status.correct) {
    					  fancyJButton[i].setIcon(cards[i].getCardPicture());	// flip card to frontward
    					  cards[i].setCardState(Status.front);
    					  flippedCard++;
    					  firstCard = i;
    				  }
    			  } 
    		  }
      	}
        // JOptionPane.showMessageDialog( ButtonFrame.this, String.format(
            //"You pressed: %s", event.getActionCommand() ) );
       // end method actionPerformed
   } // end private inner class ButtonHandler
   
   public int getScore() {
	   return score;
   }
   
} // end class ButtonFrame