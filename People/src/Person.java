
public class Person {
	private String name;
	private String job;
	private int hitPoint;
	private int maxDamage;
	private int defenseAbility;
	
	public Person(String name, String job, int hitPoint, int maxDamage, int defenseAbility) {
		this.name = name;
		this.job = job;
		this.defenseAbility = defenseAbility;
		this.hitPoint = hitPoint;
		this.maxDamage = maxDamage;
	}
	public String getName() {
		return name;
	}
	public String getJob() {
		return job;
	}
	public int getHitPoint() {
		return hitPoint;
	}
	public int getMaxDamage() {
		return maxDamage;
	}
	public int getDefenseAbility() {
		return defenseAbility;
	}
	public String toString() {
		return name + " " + job;
	}
	public void hpReduction(int x) {
		hitPoint -= x;
	}
}
