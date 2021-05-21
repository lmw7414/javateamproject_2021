import java.util.Scanner;

public class Person {
	private String name;
	private int score;
	private int second;
	private int highLevel;

	public Person() {
		this.name = null;
		this.score = 0;
		this.second = 0;
		this.highLevel = 0;
	}

	void setPerson(String name) {
		this.name = name;
		this.score = 0;
		this.second = 0;
		this.highLevel = 0;
	}

	void clonePerson(String name, int score, int second, int highLevel) {
		this.name = name;
		this.score = score;
		this.second = second;
		this.highLevel = highLevel;
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

	public int getPersonHighLevel() {
		return this.highLevel;
	}

}
