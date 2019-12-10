/**
 * 207 Traveling Salesman Project.
 * 11/14/2019
 * Pears Algorithm
 * 
 * 
 * @author Alex Juan
 * @author Lucas Balangero
 * 
 */
public class Pairs {
	private int cityA;
	private int cityB;
	private int cityDistance;
	
	/**
	 * Default Constructor
	 */
	public Pairs() {
		this(0, 0, 0);
	}
	
	/**
	 * Makes the two cities and distances frm each dependent upon the parameter
	 * @param cityA the starting city
	 * @param cityB the desired city to travel to
	 * @param cityDistance the distance from cityA to cityB
	 */
	public Pairs(int cityA, int cityB, int cityDistance) {
		this.cityA = cityA;
		this.cityB = cityB;
		this.cityDistance = cityDistance;
	}
	
	/**
	 * Getter Method - get the distance from two cities
	 * @return the distance from two cities
	 */
	public int getCityDistance() {
		return this.cityDistance;
	}
	
	/**
	 * Setter Method - set the distances from two cities
	 * @param cityDistance the distance from two cities
	 */
	public void setCityDistance(int cityDistance) {
		this.cityDistance = cityDistance;
	}
	
	/**
	 * Getter Method - get the starting city
	 * @return the starting city
	 */
	public int getCityA() {
		return this.cityA;
	}
	
	/**
	 * Getter Method - get the desired city
	 * @return the desired city
	 */
	public int getCityB() {
		return this.cityB;
	}
	
	/**
	 * A String representation of the Pairs
	 */
	public String toString() {
		String temp = cityA +" " +cityB +" " +cityDistance +", ";
		return temp;
	}
}
