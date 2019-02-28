
public class SuperHero extends Person{
	private String[] superPower;
	private String heroName;
	private boolean cape;
	private int powerLevel; 
	public SuperHero(String name, String job, int hitPoint, int maxDamage, int defenseAbility, String[] superPower, boolean cape, int powerLevel, String heroName) {
		super(name, job, hitPoint, maxDamage, defenseAbility);
		this.superPower = superPower;
		this.cape = cape; 
		this.powerLevel = powerLevel;
		this.heroName = heroName;
	}
	public boolean getCape() {
		return cape;
	}
	public String getSuperPower() {
		return superPower[(int)(Math.random()*(superPower.length - 1))];
	}
	public int getPowerLevel() {
		return powerLevel;
	}
	public void powerLevelModification(int newLevel) {
		powerLevel = newLevel;
	}
	public String heroName() {
		return heroName; 
	}

}
