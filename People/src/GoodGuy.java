
public class GoodGuy extends SuperHero{
	private String catchPhrase;
	public GoodGuy(String name, String job, int hitPoint, int maxDamage, int defenseAbility, String[] superPower, boolean cape, int powerLevel, String heroName, String catchPhrase) {
		super(name, job, hitPoint,  maxDamage,  defenseAbility, superPower, cape, powerLevel, heroName);
		this.catchPhrase = catchPhrase;
	}
	public String getCatchPhrase() {
		return catchPhrase;
	}
	public void powerLevelModification() {
		super.powerLevelModification(getPowerLevel() + (int)((Math.random()* 10) + 1)); 
	}
}
