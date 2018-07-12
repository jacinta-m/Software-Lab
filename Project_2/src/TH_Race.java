import java.security.SecureRandom;
import java.util.Arrays;

public class TH_Race {
	private int tortoise; 
	private int hare; 
	private int array_size;
	private String race_track[];
	private static final SecureRandom randomNumbers = new SecureRandom();

//Constructor 	
	TH_Race(int array_size, String[]race_track){
		tortoise = 0;
		hare = 0;
		this.array_size = array_size;
		this.race_track = race_track; 
	}

// Method to set the Tortoise position or index on the race track 
	public int setTortoise() {
//Setting a random number from 1-10 to determine what move that Tortoise makes
		int i = 1+ randomNumbers.nextInt(10); 
		if( i <= 5) {
			tortoise += 3;
			System.out.printf("Tortoise fast plod: 3 squares to the right %n");
		}
		else if(i<=7){
			if(tortoise<=5) {
				tortoise = 0;
				System.out.printf("Tortoise slips%n");
			}
			else {
			tortoise -=6;
			System.out.printf("Tortoise slip: 6 squares to the left %n");
			}
		}
		else {
			++tortoise;
			System.out.printf("Tortoise slow plod: 1 square to the right %n");
		}
		return tortoise;
	}

//Method to set the Hare position or index on the race track
public int setHare() {
	int j = 1+ randomNumbers.nextInt(10); 
	if (j <= 2) {
		hare +=9;
		System.out.printf("Hare big hop: 9 squares to the right %n");
	}
	else if (j==3) {
		if (hare <=11) {
			hare = 0;
			System.out.printf("Hare slips%n");
		}
		else {	
			hare -=12;
			System.out.printf("Hare big slip: 12 squares to the left %n");
		}
	}
	else if(j<=6) {
		++hare;
		System.out.printf("Hare small hop: 1 square to the right %n");
	}
	else if(j<=8) {
		if (hare <=1) {
			hare = 0;
			System.out.printf("Hare slips%n");
		}
		else {
		hare -=2;
		System.out.printf("Hare small slip: 2 squares to the left %n");
		}
	}
	else if (j<=10) {
		System.out.printf("Hare is asleep%n");
	}
	return hare; 
}

	public void setArray_size(int array_size) {
		this.array_size = array_size;
	}
	
	public int getArray_size() {
		return array_size;
	}

//method to create the race track and set the hare and tortoise on it
	public void setRace_track(int race_size, int clock_counter){
		Arrays.fill(race_track, "_");		
		if (hare == tortoise) {
			race_track[tortoise]= "Ouch!!";
		}	
		else if (hare>=race_size) {
			race_track[race_size-1]="H";
			race_track[tortoise]="T";
		}
		else if(tortoise>=race_size) {
			race_track[race_size-1]="T";
			race_track[hare]="H";
		}
		else {
		race_track[hare]= "H";
		race_track[tortoise]="T";
		}
	}

//method to display the track 
	public void display_track(int race_size ) {
		for(int i=0; i< race_size;++i) {
			System.out.printf(race_track[i]); 
		}
		System.out.printf("%n%n");
	}
 
// method to determine if there is a winner
	public boolean gameStatus(int race_size, boolean status) {
		int finish = race_size -1;
		if (hare >= finish ) {
			System.out.println("Hare wins. Yuch. ");
			return status = true;
		}
		else if (tortoise >= finish) {
			System.out.println("TORTOISE WINS!!! YAY!!!");
			return status = true;
		}
		else if (tortoise == finish && hare == finish) {
			System.out.println("Its a draw!!");
			return status = true;
		}
		return status;
		}
}
