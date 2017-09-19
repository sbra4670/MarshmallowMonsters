package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController
{
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
		System.out.println(basic);
		MarshmallowMonster fred = new MarshmallowMonster("Silly Fred Monster", 7, 8, 6.7, true);
		System.out.println(fred);
		System.out.println("I am feeling hungry, I am going to eat one of fred's arms");
		fred.setArmCount(fred.getArmCount() - 1);
		System.out.println(fred);

		interactWithMonster(fred);
	}
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName()+" wants to know how many eyes you want to eat, please type in how many");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		System.out.println("How many arms are you interested in eating?, I have " + currentMonster.getArmCount());
		//consumed = myScanner.nextInt();
		int armEat = myScanner.nextInt();
		
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
			
			if(food == currentMonster.getTentacleAmount()) 
			{
				System.out.println("You ate all my tentacles!!!");
			}
			else 
			{
				System.out.println("More Likely");
			}
		}
		myScanner.close();
	}
}
