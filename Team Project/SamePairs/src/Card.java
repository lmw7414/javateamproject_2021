import javax.swing.Icon;

public class Card {
   private String cardName;
   private Status state;
   private Icon picture;
   
   public Card(String cardName, Status state, Icon picture) {
      this.cardName = cardName;
      this.state = state;
	  this.picture = picture;
   }
   
   void setCardWord(String cardName) {
      this.cardName = cardName;
   }
   void setCardState(Status state) {
      this.state = state;
   }
   
   void setCardIcon(Icon picture) {
	   this.picture = picture;
   }
   public String getCardWord() {
      return this.cardName;
   }
   
   public Status getCardState() {
      return this.state;
   }  
   
   public Icon getCardPicture() {
	   return this.picture;
   }
  
   @Override
   public String toString()
   {
	   return this.cardName;
   }
}