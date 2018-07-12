//This program is a Tortoise and Hare Race
//Jacinta Moore, EMPLID- 23535382

import java.util.Scanner; 
import java.util.InputMismatchException;

public class TH_Game {
// method to ask user whether to change the length of the race
	public static int race_check(int race_size) {
		boolean c_test = true;
		String choice = "";
		Scanner input = new Scanner(System.in);
		do {	
			try {
				System.out.println("Please enter Yes or No:");
				choice = input.nextLine();
				if (choice.equals("Yes")){
					race_size = race_length(race_size);
					c_test = false;
				}
				else if (choice.equals("No")) {
					c_test=false;
				}
				else {
					throw new IllegalArgumentException();
				}
			}catch(IllegalArgumentException exception) {
				System.out.printf("Please try again.%n%n");
			}			
		}while(c_test);
		return race_size;
	}
//method to change the length of the race
	public static int race_length(int race_size) {
		boolean input_test = true;
		Scanner input = new Scanner(System.in);
		do {	
			try {
				System.out.print("Please enter a integer value for the race length: ");
				race_size = input.nextInt();
				input_test = false;
				if ( race_size <= 1) {
					 throw new IllegalArgumentException();
				}
			}
			catch (InputMismatchException inputMismatchException)
			{
				System.err.printf("%nException: %s%n", inputMismatchException);
				input.nextLine(); // discard input so user can try again
				System.out.printf("You must enter integers. Please try again.%n%n");
			}
			catch(IllegalArgumentException exception) {
				System.err.printf("%nException: You must enter a value greater than 1%n" );
				input.nextLine(); // discard input so user can try again
				System.out.printf("Please try again.%n%n");
				input_test=true;
			}
		}while(input_test);
		return race_size;
	}
// method to ask user whether to restart a new game or quit program	
	public static boolean continue_game() {
		Scanner input = new Scanner(System.in);
		boolean check = true; 
		boolean loop = true;
		do {
			try {
				System.out.printf("%nEnter 1 to play another game...%n");
				System.out.println("Enter 2 to quit game::");
				int choose = input.nextInt();
				if (choose == 2) {
					check = false;
					loop = false;
				}
				if (choose == 1) {
					check = true;
					loop = false;
				}
				if(choose > 2 || choose <1 ) {
					throw new Exception();
				}
			}
			catch (InputMismatchException inputMismatchException){
				System.err.printf("%nException: %s%n", inputMismatchException);
				input.nextLine(); // discard input so user can try again
				System.out.printf("You must enter integers. Please try again.%n%n");
			}
			catch(Exception exception) {
				System.err.printf("%nError: value must be either 1 or 2%n");
				input.nextLine(); // discard input so user can try again
			}
		}while(loop);		
		return check;
	}
	
	public static void main(String[] args) {
		boolean game_end = true;
		do { 
			int array_size = 85; 
			int race_size = 70; 
			System.out.print("Welcome to the Tortoise and Hare Race!!");
			System.out.println();
			System.out.println("Race length is 70, would you like to change it?");
			race_size = race_check(race_size);
			array_size = race_size+15;
			String race[] = new String [array_size];
			TH_Race game = new TH_Race(array_size, race);
			int clock_counter=0;
			System.out.printf("BANG !!!!!%nAND THEY'RE OFF !!!!!%n");
			boolean g_status = false; 
			while (!g_status) {
				game.setArray_size(array_size);
				++clock_counter;
				if(clock_counter==1) {
					System.out.printf("After %d second:%n", clock_counter);	
				}	
				else {
					System.out.printf("After %d seconds:%n", clock_counter);
				}
				game.setTortoise();
				game.setHare();
				game.setRace_track(race_size, clock_counter);
				game.display_track(race_size);
				g_status= game.gameStatus(race_size, g_status);
			}
			game_end = continue_game();
		}while (game_end);
	}
}
