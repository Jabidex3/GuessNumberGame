import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the Guess the Number Game!");
		boolean runGame = true;
		while(runGame) {
			System.out.println("I am thinking of a Number between 1 & 100 [including 1 & 100]");
			int x = (int)(Math.random()*100+1);
			//System.out.println(x);
			int mostRecentDiff =-1;
			int currDiff = -1;
			String currWarmth ="";
			while(true) {
				System.out.println("What is your guess?");
				try {
					int guess = Integer.parseInt(scan.nextLine());
					if(guess<1 || guess>100) {
						System.out.println("Invalid Guess! Guess is Out of Bounds. The number is between 1 & 100 inclusive!");
					}
					else {
						currDiff = Math.abs(x-guess);
						if(currDiff==0) {
							System.out.println("Congratulations! You have correctly guessed my number!");
							break;
						}
						else if(mostRecentDiff ==-1) {
							mostRecentDiff = currDiff;
							if(Math.abs(x-guess)>10) {
								System.out.println("Cold!");
								currWarmth = "Cold!";
							}
							else {
								System.out.println("Hot!");
								currWarmth = "Hot!";
							}
						}
						else if(currDiff == mostRecentDiff) {
							if(currWarmth.equals("Colder!") || currWarmth.equals("Cold!")) {
								System.out.println("Your Just As Cold As Before!");
								
							}
							else {
								System.out.println("Your Just As Hot As Before!");
							}
						}
						else if(currDiff>mostRecentDiff) {
							System.out.println("Colder!");
							currWarmth = "Colder!";
							mostRecentDiff = currDiff;
						}
						else {
							System.out.println("Hotter!");
							currWarmth = "Hotter!";
							mostRecentDiff = currDiff;
						}
					}
					

				}
				catch(Exception e){
					System.out.println("Invalid Guess! Try Again!");
				}
			}
			
			System.out.println("Would you like to play again? (y/n)");
			while(true) {
				String choice = scan.nextLine();
				if(choice.equals("n")) {
					System.out.println("Thank you for playing! Goodbye!");
					runGame=false;
					break;
				}
				else if(choice.equals("y")) {
					break;
				}
				else {
					System.out.println("Invalid choice. Please enter 'y' or 'n'!");
				}
			}
			
		}
	}

}
