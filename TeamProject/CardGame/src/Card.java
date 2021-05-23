
public class Card {
   
   private int word;
   private int state;
   
   private enum Word {apple, kiwi, banana, soup, strawberry, pizza, buger, chichen, lmon, tomato, cherry, 
         mushroom, carrot, cake, radish, onion,corn, broccoli, mango, cucumber} 
   private enum Status {back, front, correct}
   
   public Card(int word, int state) {
      this.word = word;
      this.state = state;
   }
   
   void setCardWord(int word) {
      this.word = word;
   }
   void setCardState(int state) {
      this.state = state;
   }
   
   public int getCardWord() {
      return this.word;
   }
   
   public int getCardState() {
      return this.state;
   }
}