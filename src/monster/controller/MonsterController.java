package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController {

private MonsterDisplay popup;

public MonsterController(){
	popup = new MonsterDisplay();
}

	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
	//	System.out.println(basic);
		popup.displayText(basic.toString());
		MarshmallowMonster fred = new MarshmallowMonster("Silly Fred Monster", 7, 8, 6.7, true);
	//	System.out.println(fred);
		popup.displayText(fred.toString());
	//	System.out.println("I am feeling hungry, I am going to eat one of fred's arms");
		popup.displayText("I am feeling hungry, I am going to eat one of fred's arms");
		fred.setArmCount(fred.getArmCount() - 1);
	//	System.out.println(fred);
		popup.displayText(fred.toString());
		
		interactWithMonster(fred);
	}
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		// System.out.println(currentMonster.getName()+" wants to know how many eyes you want to eat, please type in how many");
		int consumed = 0;
		String response  = popup.getResponse(currentMonster.getName() + " wants to know how many eyes you want to eat, please type in how many");
		
		if (isValidInteger(response))
		{
			consumed = Integer.parseInt(response);
		}
		
	//	int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		int armEat = myScanner.nextInt();
		
		System.out.println("How many arms are you interested in eating?, I have " + currentMonster.getArmCount());
		//consumed = myScanner.nextInt();
		
		if(armEat == 0)
		{
			System.out.println("Not hungry? oh so sad...");
		}
		else if (armEat<0) 
		{
			System.out.println("Reality is hard for you - it is impossible to eat a negative amount");
		}
		else if (armEat - currentMonster.getArmCount() < 0) {
			System.out.println("You are not allowed to eat more than exists on me :/");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArmCount()- armEat);
			System.out.println("OK, now I have this many arms" + currentMonster.getArmCount());
		
			System.out.println("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
			
			
			double food = myScanner.nextDouble();
			String tentacleResponse = popup.getResponse("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
			if(isValidDouble(tentacleResponse))
			{
				food = Double.parseDouble(tentacleResponse);
			}
			if(food == currentMonster.getTentacleAmount()) 
			{
				System.out.println("You ate all my tentacles!!!");
			}
			else 
			{
				System.out.println("More Likely");
			}
		
		popup.displayText("Hi there ready to play???");
		String answer = popup.getResponse("What is the air speed of a coconut laden swallow");
		System.out.println();
			
		}
		myScanner.close();
		

		
	}
	//Helper methods
	private boolean isValidInteger(String sample) {
		boolean valid=false;
		try
		{
			Integer.parseInt(sample);
			valid=true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input an int, " + sample + "is not valid.");
		}
		return valid;
	}
	
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid=true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to type in a double - " + sampleDouble + " is not a valid answer.");
		}
		return valid;
	}
		
		private boolean isValidBoolean(String sampleBoolean)
		{
			boolean valid = false;
			
			try 
			{
				Boolean.parseBoolean(sampleBoolean);
				valid = true;
			}
			catch(NumberFormatException error) {
				popup.displayText("Type in a boolean value" + sampleBoolean + " does not count.");
			}
			return valid;
		}
	}