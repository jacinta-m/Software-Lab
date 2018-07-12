import java.util.Calendar;

public class HeartRates {
	private String firstName;
	private String lastName;
	private int birthMonth;
	private int birthDay; 
	private int birthYear; 
//Constructor
	public HeartRates(String firstName, String lastName, int birthMonth, int birthDay, int birthYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.birthYear = birthYear;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	public void setBirthday(int birthDay) {
		this.birthDay = birthDay;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getBirthMonth() {
		return birthMonth;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public int getBirthYear() {
		return birthYear;
	}
//method to calculate Age
	public int getAge() {
		Calendar dateToday = Calendar.getInstance();
		int age = dateToday.get(Calendar.YEAR) - birthYear; 
		if (birthMonth > dateToday.get(Calendar.MONTH)+1 ) {
			return --age;
		}
		else if (birthMonth == dateToday.get(Calendar.MONTH)+1 && birthDay > dateToday.get(Calendar.DATE)) {
			return --age;
		}
		else return age;
	}
	
//method to calculate Maximum Heart Rate
	public int getMaxHeartRate() {
		return 220 - getAge();
	}
	
//method to calculate target Heart Rate  
	public double getMinTargetRate() {
		return 0.5 * getMaxHeartRate();
	}
	public double getMaxTargetRate() {
		return 0.85 *  getMaxHeartRate();
	}	
}

