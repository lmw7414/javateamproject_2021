public class Person {
   private String name;
   private int score;
   private long second;

   public Person() {
      this.name = null;
      this.score = 0;
      this.second = 0;
   }

   void setPerson(String name) {
      this.name = name;
      this.score = 0;
      this.second = 0;
   }
   
   void setPersonScore(int score) {
      this.score += score;
   }
   
   void setPersonSecond(long second) {
	   this.second += second;
   }

   void clonePerson(String name, int score, long second) {
      this.name = name;
      this.score = score;
      this.second = second;
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

}