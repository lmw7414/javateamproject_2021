public class Card {
   private String cardName;
   private Status state;
   
   
   
   public Card(String cardName, Status state) {
      this.cardName = cardName;
      this.state = state;
   }
   
   void setCardWord(String cardName) {
      this.cardName = cardName;
   }
   void setCardState(Status state) {
      this.state = state;
   }
   
   public String getCardWord() {
      return this.cardName;
   }
   
   public Status getCardState() {
      return this.state;
   }
   @Override
   public String toString()
   {
	   return this.cardName;
   }
}