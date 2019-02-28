
public class BadGuy extends SuperHero{
	private String evilLaugh;
	public BadGuy(String name, String job, int hitPoint, int maxDamage, int defenseAbility, String[] superPower, boolean cape, int powerLevel, String heroName, String evilLaugh) {
		super(name, job, hitPoint,  maxDamage,  defenseAbility, superPower, cape, powerLevel, heroName);
		this.evilLaugh = evilLaugh;
	}
	public String getEvilLaugh() {
		return evilLaugh;
	}
	
	
}
