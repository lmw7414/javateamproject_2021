public class Card {
   
   private int word;
   private Status state;
   
   
   
   public Card(int word, Status state) {
      this.word = word;
      this.state = state;
   }
   
   void setCardWord(int word) {
      this.word = word;
   }
   void setCardState(Status state) {
      this.state = state;
   }
   
   public int getCardWord() {
      return this.word;
   }
   
   public Status getCardState() {
      return this.state;
   }
}