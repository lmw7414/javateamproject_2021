public class Person {
   private String name;
   private int score;
   private int second;

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
   
   void setPersonSecond(int second) {
	   this.second = second;
   }

   void clonePerson(String name, int score, int second) {
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

   public int getPersonSecond() {
      return this.second;
   }

}