public class Person {
   private String name;
   private int score;
   private long second;
   private boolean complete;

   public Person() {
      this.name = null;
      this.score = 0;
      this.second = 0;
      this.complete = false;
   }

   void setPerson(String name) {
      this.name = name;
   }
   
   void setPersonScore(int score) {
      this.score += score;
   }
   
   void setPersonSecond(long second) {
	   this.second += second;
   }

   void setPersonComplete(boolean complete) {
	   this.complete = complete;
   }
   
   void clonePerson(String name, int score, long second, boolean complete) {
      this.name = name;
      this.score = score;
      this.second = second;
      this.complete = complete;
   }
   
   public String getPersonName() {
      return this.name;
   }

   public int getPersonScore() {
      return this.score;
   }

   public long getPersonSecond() {
      return this.second;
   }
   
   public boolean getPersonComplete() {
	   return this.complete;
   }

}