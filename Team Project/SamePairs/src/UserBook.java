
public class UserBook {
	static int userCount = 0;
	Person userbook[] = new Person[100];
	
	public UserBook()
	{
		
	}
	
	public void addUser(Person p)
	{
		userbook[userCount] = p;
		userCount++;
	}
	
	
	public int getUserCount()
	{
		return userCount;
	}
	
	
	public void showRanking() {
	      int j;
	      System.out.println("USER RANKING TOP 10");
	      if (userCount > 10)
	         j = 10;
	      else
	         j = userCount;

	      System.out.printf("%20s %20s %20s\n", "NAME", "SCORE", "SECOND");
	      for (int i = 0; i < j; i++) {
	         System.out.printf("%d. %-18s %19d %19d %19d\n", i + 1, userbook[i].getPersonName(), userbook[i].getPersonScore(),
	               userbook[i].getPersonSecond());

	      }
	   }
}
