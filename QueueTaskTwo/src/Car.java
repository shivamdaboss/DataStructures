
public class Car implements Comparable<Car>{
	private int country;
	private int a;
	private int mpg;
	private int horse;
	private int engine;
	private int weight;
	private int cylinders;
	private int carID; 
	public Car(int carId, int mpg, int engine, int horse, int weight, int a, int country, int cylinders) {
		this.a = a;
		this.mpg = mpg;
		this.horse = horse;
		this.engine = engine;
		this.weight = weight;
		this.cylinders = cylinders;
		this.country = country;
		this.carID = carId; 
	}
	@Override
	public int compareTo(Car o) {
		
		//acceleration
		if(this.a > o.getA()) {
			return -1;
		}
		else if (this.a < o.getA()) {
			return 1;
		}
		else {
			
			//miles per gallon 
			if(this.mpg > o.getMpg()) {
				return -1;
			}
			else if(this.mpg < o.getMpg()) {
				return 1;
			}
			else {
				
				//horsepower
				if(this.horse > o.getHorse()) {
					return -1;
				}
				else if(this.horse < o.getHorse()) {
					return 1;
				}
				else {
					
					//Engine Size
					if(this.engine > o.getEngine()) {
						return -1;
					}
					else if (this.engine < o.getEngine()) {
						return 1;
					}
					else {
						
						//weight
						if(this.weight > o.getWeight()) {
							return -1;
						}
						else if(this.weight < o.getWeight()) {
							return 1;
						}
						else {
							
							//cylinders
							if(this.cylinders > o.getCylinders()) {
								return -1;
							}
							else if(this.cylinders < o.getWeight()) {
								return 1;
							}
							else {
								
								//carID
								if(this.carID > o.getCarID()) {
									return -1;
								}
								else if(this.carID < o.getCarID()) {
									return 1;
								}
								else {
									return 0;
								}
							}
						}
					}
				}
				
			}
		}
	}
	
	
	public int getEngine() {
		return engine;
	}
	public void setEngine(int engine) {
		this.engine = engine;
	}
	public int getCountry() {
		return country;
	}
	public int getA() {
		return a;
	}
	public int getMpg() {
		return mpg;
	}
	public int getHorse() {
		return horse;
	}
	public int getWeight() {
		return weight;
	}
	public int getCylinders() {
		return cylinders;
	}
	public int getCarID() {
		return carID;
	}
	
	public String toString() {
		return this.a  + "\t" + this.mpg  + "\t" + this.horse  + "\t" + this.engine  + "\t" + this.weight  + "\t" + this.cylinders  + "\t" + this.carID  + "\t";	
	}
	

}
