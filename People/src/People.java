import java.util.ArrayList;

public class People {
	public People() {
		String fn[] = {"Shivam", "George", "Ciro", "John", "Noah", "Kane", "Derek", "Jack", "Ethan", "Craig"};
		String ln[] = {"Agrawal", "Miller", "Iovine", "Black", "White", "Brown", "Honig", "Potter", "Drake", "Kent"};
		String jobs[] = {"waiter", "cook", "garbage man", "engineer", "taxi driver", "CEO", "CFO", "doctor" , "cop", "soldier"};// defining first names, last names, and jobs
		String movesGood[] = {"punch", "kick", "shoot with webs", "slap"};
		String movesBad[] = {"punch", "kick", "grab", "throw"};
		ArrayList<Person> dailyPlanetStreet = new ArrayList<Person>();
		int r1 = (int)(Math.random()*50);// index of good guy
		int r2 = (int)(Math.random()*50);//index of bad guy
		for(int i = 0; i < 50; i++) {// filling array
			if (i == r1) {
				dailyPlanetStreet.add(new GoodGuy("Peter Parker", "Student", 1000, 500, 200, movesGood, false, 5000, "Spiderman", "My spidey sense is tingling. " ));
			}
			else if (i == r2) {
				dailyPlanetStreet.add((new BadGuy("Otto Octavius", "Scientist", 1000, 500, 200, movesBad, false, 5000, "Dr. Octopus", "Mwuhahahaha")));
			}
			else {
				dailyPlanetStreet.add(new NormalGuy(fn[(int)(Math.random() * 10)] + " " + ln[(int)(Math.random() * 10)], jobs[(int)(Math.random() * 10)], 100, 5, 20));
			}
		}
		//simulation start
		ArrayList<Person> safetyLand = new ArrayList<Person>();// safe people
		ArrayList<Person> dead = new ArrayList<Person>();// dead people
		while(dailyPlanetStreet.size() > 2) {
			// first i deal with bad guy killings
			if(r2 == dailyPlanetStreet.size() - 1) {
				if (dailyPlanetStreet.get(r2 - 1) instanceof NormalGuy){// handles case for when badguy is at the end of the array list
					System.out.println("Dr. Octopus:  " + ((BadGuy) (dailyPlanetStreet).get(r2)).getEvilLaugh());
					System.out.println(dailyPlanetStreet.get(r2 - 1).getName() + " is dead.");
					dead.add(dailyPlanetStreet.remove(r2 - 1));
				}
			}
			else if(r2 == 0) {//handles case for when bad guy is at front of the array list
				if (dailyPlanetStreet.get(r2 + 1) instanceof NormalGuy){
					System.out.println("Dr. Octopus:  " + ((BadGuy) (dailyPlanetStreet).get(r2)).getEvilLaugh());
					System.out.println(dailyPlanetStreet.get(r2 + 1).getName() + " is dead.");
					dead.add(dailyPlanetStreet.remove(r2 + 1));	
				}
			}
			else {
				if ( dailyPlanetStreet.get(r2 - 1) instanceof NormalGuy && dailyPlanetStreet.get(r2 + 1) instanceof NormalGuy) {// handles case for when people on both sides
					int r3 = (int)((Math.random() * 2) + 1);
					if (r3 == 1) {
						System.out.println("Dr. Octopus:  " + ((BadGuy) (dailyPlanetStreet).get(r2)).getEvilLaugh());
						System.out.println(dailyPlanetStreet.get(r2 - 1).getName() + " is dead.");
						dead.add(dailyPlanetStreet.remove(r2 - 1));
					}
					else if (r3 == 2) {
						System.out.println("Dr. Octopus:  " + ((BadGuy) (dailyPlanetStreet).get(r2)).getEvilLaugh());
						System.out.println(dailyPlanetStreet.get(r2 + 1).getName() + " is dead.");
						dead.add(dailyPlanetStreet.remove(r2 + 1));
					}
				}
				else if (!( dailyPlanetStreet.get(r2 - 1) instanceof NormalGuy) && dailyPlanetStreet.get(r2 + 1) instanceof NormalGuy) {// handles case for when on right side
					System.out.println("Dr. Octopus:  " + ((BadGuy) (dailyPlanetStreet).get(r2)).getEvilLaugh());
					System.out.println(dailyPlanetStreet.get(r2 + 1).getName() + " is dead.");
					dead.add(dailyPlanetStreet.remove(r2 + 1));
				}
				else if ( dailyPlanetStreet.get(r2 - 1) instanceof NormalGuy && !(dailyPlanetStreet.get(r2 + 1) instanceof NormalGuy)) {// handles case for left side
					System.out.println("Dr. Octopus:  " + ((BadGuy) (dailyPlanetStreet).get(r2)).getEvilLaugh());
					System.out.println(dailyPlanetStreet.get(r2 -1 ).getName() + " is dead.");
					dead.add(dailyPlanetStreet.remove(r2 - 1));
				}
				
			}
			System.out.println();
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {// recalculating indexes of good and bad guys
				if (dailyPlanetStreet.get(i) instanceof BadGuy)
					r2 = i;
			}
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {
				if (dailyPlanetStreet.get(i) instanceof GoodGuy)
					r1 = i;
			}
			int r4 = r1;// making a person safe;
			while(!(dailyPlanetStreet.get(r4) instanceof NormalGuy)){
				r4 = (int)(Math.random() * dailyPlanetStreet.size());
			}
			System.out.println("Spiderman:  " + ((GoodGuy) (dailyPlanetStreet).get(r1)).getCatchPhrase());
			System.out.println(dailyPlanetStreet.get(r4).getName() + " is safe.");
			safetyLand.add(dailyPlanetStreet.remove(r4));
			
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {// recalculating indexes of good and bad guys
				if (dailyPlanetStreet.get(i) instanceof BadGuy)
					r2 = i;
			}
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {
				if (dailyPlanetStreet.get(i) instanceof GoodGuy)
					r1 = i;
			}
			//moving hero around 
			dailyPlanetStreet.add((int)(Math.random()*dailyPlanetStreet.size()), dailyPlanetStreet.remove(r1));
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {// recalculating indexes of good and bad guys
				if (dailyPlanetStreet.get(i) instanceof BadGuy)
					r2 = i;
			}
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {
				if (dailyPlanetStreet.get(i) instanceof GoodGuy)
					r1 = i;
			}	
			System.out.println();
		}
		//combat phase
		System.out.println();
		System.out.println("The only two that are left are Spiderman and Dr. Octopus");
		System.out.println("Combat has now begun!!");
		int r5 = (int)(Math.random() * 2);
		int heroAttack;
		int heroDefense;
		int evilAttack;
		int evilDefense;
		while(!(dailyPlanetStreet.get(0).getHitPoint() <= 0) && !(dailyPlanetStreet.get(1).getHitPoint() <= 0)) {
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {// recalculating indexes of good and bad guys
				if (dailyPlanetStreet.get(i) instanceof BadGuy)
					r2 = i;
			}
			for(int i = 0; i < dailyPlanetStreet.size(); i++) {
				if (dailyPlanetStreet.get(i) instanceof GoodGuy)
					r1 = i;
			}
			heroAttack = 0;
			heroDefense = 0;
			evilAttack = 0;
			evilDefense = 0;
			if (!(r5 == r1)) {
				System.out.println("Spiderman is attacking Dr. Octopus");
				heroAttack = (int)((Math.random() * (dailyPlanetStreet.get(r1).getMaxDamage())) + 1);
				evilDefense = (int)((Math.random() * (dailyPlanetStreet.get(r2).getDefenseAbility())) + 1);
				System.out.println("Spiderman uses his " + ((SuperHero)dailyPlanetStreet.get(r1)).getSuperPower()+ " ability, with a damage of " + heroAttack);
				System.out.println("Dr. Octopus tries to block, with a defense of " + evilDefense);
				r5 = r1;
				if(heroAttack > evilDefense) {
					dailyPlanetStreet.get(r2).hpReduction(heroAttack - evilDefense);
				}
				else {
					System.out.println("Dr. Octopus has successfully blocked Spiderman's attack");
				}
			}
			else if (!(r5 == r2)) {
				System.out.println("Dr. Octopus is attacking Spiderman");
				evilAttack = (int)((Math.random() * (dailyPlanetStreet.get(r2).getMaxDamage())) + 1);
				heroDefense = (int)((Math.random() * (dailyPlanetStreet.get(r1).getDefenseAbility())) + 1);
				System.out.println("Dr. Octopus uses his " + ((SuperHero)dailyPlanetStreet.get(r2)).getSuperPower()+ " ability, with a damage of " + evilAttack);
				System.out.println("Spiderman tries to block, with a defense of " + heroDefense);
				r5 = r2;
				if(evilAttack > heroDefense) {
					dailyPlanetStreet.get(r1).hpReduction(evilAttack - heroDefense);
				}
				else {
					System.out.println("Spiderman has successfully blocked Dr.Octopus's attack");
				}
			}
			if(dailyPlanetStreet.get(r1).getHitPoint() > 0 && dailyPlanetStreet.get(r2).getHitPoint()> 0) {
				System.out.println("Spiderman health: " + dailyPlanetStreet.get(r1).getHitPoint() + ", Dr. Octopus health:  " + dailyPlanetStreet.get(r2).getHitPoint());
			}
			else if (dailyPlanetStreet.get(r1).getHitPoint() > 0 && dailyPlanetStreet.get(r2).getHitPoint() <= 0) {
				System.out.println("Spiderman lives to fight another day. The same can not be said for Dr. Octopus");
			}
			else if (dailyPlanetStreet.get(r1).getHitPoint() <= 0 && dailyPlanetStreet.get(r2).getHitPoint() > 0) {
				System.out.println("Dr. Octopus lives to fight another day. The same can not be said for Spiderman");
			}
			System.out.println();
		}
	 
	}
	public static void main(String[] args) {
		People app = new People();
	}
}
