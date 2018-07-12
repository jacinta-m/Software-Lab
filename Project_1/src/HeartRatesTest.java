//import java.util.Scanner; 
import javax.swing.JOptionPane;

public class HeartRatesTest {
//method to check for integers in String input
	public static boolean isValidText(String name) {
		int i=0;
		while(i <name.length()) {
			if(Character.isDigit(name.charAt(i)))
				break;
			++i;
		}
		if(i==name.length()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		
		boolean StrCheck = false;
		String firstName = JOptionPane.showInputDialog("Please enter your first name");
		do{
			StrCheck = isValidText(firstName);
			if(!StrCheck) {
				JOptionPane.showMessageDialog(null,"Please enter your first name with no integer values", "Error",JOptionPane.ERROR_MESSAGE );
				firstName = JOptionPane.showInputDialog("Please enter your first name");
			}
		}while(!StrCheck);
		
		boolean StrLastCheck = false;
		String lastName = JOptionPane.showInputDialog("Please enter your last name");
		do{
			StrLastCheck = isValidText(lastName);
			if(!StrLastCheck) {
				JOptionPane.showMessageDialog(null,"Please enter your last name with no integer values", "Error",JOptionPane.ERROR_MESSAGE );
				lastName = JOptionPane.showInputDialog("Please enter your last name");
			}
		}while(!StrLastCheck);
		
		boolean MonthCheck = false;
		String bMonth = JOptionPane.showInputDialog("Please enter your birth month as a number");
		int birthMonth = Integer.parseInt(bMonth);
		do{
			if(birthMonth<13) {
				MonthCheck = true;
			};
			if(!MonthCheck) {
				JOptionPane.showMessageDialog(null,"Please enter a correct month of birth (1-12)", "Error",JOptionPane.ERROR_MESSAGE );
				bMonth = JOptionPane.showInputDialog("Please enter your birth month as a number");
				birthMonth = Integer.parseInt(bMonth);
			}
		}while(!MonthCheck);

		boolean DayCheck = false;
		String bDay = JOptionPane.showInputDialog("Please enter your day of birth");
		int birthDay = Integer.parseInt(bDay);
		do{
			if(birthDay<32) {
				DayCheck = true;
			};
			if(!DayCheck) {
				JOptionPane.showMessageDialog(null,"Please enter a correct day", "Error",JOptionPane.ERROR_MESSAGE );
				 bDay = JOptionPane.showInputDialog("Please enter your day of birth");
				 birthDay = Integer.parseInt(bDay);
			}
		}while(!DayCheck);
		
		String bYear = JOptionPane.showInputDialog("Please enter your year of birth");
		int birthYear = Integer.parseInt(bYear);
		
		HeartRates myHeartRates = new HeartRates(firstName, lastName, birthMonth, birthDay, birthYear);
		myHeartRates.setFirstName(firstName);
		myHeartRates.setLastName(lastName);
		myHeartRates.setBirthMonth(birthMonth);
		myHeartRates.setBirthday(birthDay);
		myHeartRates.setBirthYear(birthYear);

		String personal_message = String.format( "%s %s %nYour date of birth is: %d - %d - %d%n", myHeartRates.getFirstName(), myHeartRates.getLastName(), myHeartRates.getBirthMonth(), myHeartRates.getBirthDay(), myHeartRates.getBirthYear());
		String results_message = String.format("Your age is: %d%nYour Maximum Heart Rate is: %d%nYour Target Heart Rate Range is [%.2f - %.2f]", myHeartRates.getAge(),  myHeartRates.getMaxHeartRate(), myHeartRates.getMinTargetRate(), myHeartRates.getMaxTargetRate());
		JOptionPane.showMessageDialog(null, personal_message + results_message);
	}		
}

