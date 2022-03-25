package misc;

import java.util.Random;
import java.util.Scanner;

//Rock wins against scissors; paper wins against rock; and scissors wins against paper.

public class PaperScissorsRock {

	//code for playing Paper Scissors Rock 
	//user vs computer
	public static void main(String[] args) {

		String arrMasterPSR[] = {"P","S","R"}; //possible values
		String computerSelection = arrMasterPSR[new Random().nextInt(arrMasterPSR.length)]; //Random value from possible values
		
		//take input from user
		Scanner oScanner = new Scanner(System.in);
		
		
		while(true)
		{
			String playerInput;
			
			//Take proper user input
			while(true)
			{
				System.out.println("Enter your move (p, s or r) ...");
				playerInput = oScanner.nextLine();
				if(playerInput.equalsIgnoreCase("P") || playerInput.equalsIgnoreCase("S") || playerInput.equalsIgnoreCase("R"))
					break;
				
				System.out.println(playerInput + " is not a valid move");
			}

			
			System.out.println("Second Player move : "+ computerSelection);

			//compare the moves
			if(computerSelection.equalsIgnoreCase(playerInput))
				System.out.println("Game was a tie!");
			else if(computerSelection.equalsIgnoreCase("R"))
			{
				if(playerInput.equalsIgnoreCase("S"))
					System.out.println("You lost ...");
				if(playerInput.equalsIgnoreCase("P"))
					System.out.println("You Won ! Congratulations!");
			}	
			else if(computerSelection.equalsIgnoreCase("S"))
			{
				if(playerInput.equalsIgnoreCase("P"))
					System.out.println("You lost ...");
				if(playerInput.equalsIgnoreCase("R"))
					System.out.println("You Won ! Congratulations!");
			}
			else if(computerSelection.equalsIgnoreCase("P"))
			{
				if(playerInput.equalsIgnoreCase("R"))
					System.out.println("You lost ...");
				if(playerInput.equalsIgnoreCase("S"))
					System.out.println("You Won ! Congratulations!");
			}
			
			System.out.println("Play again ? (y/n)");
			String playAgainInput = oScanner.next();
			if (playAgainInput.equalsIgnoreCase("N"))
			{
				System.out.println("Thank you!");
				oScanner.close();
				break;
			}
		}
	}	

}
