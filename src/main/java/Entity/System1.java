package Entity;

public class System1 {

	private int id;
	private String location;
	private String destination;
	private int distance;
	private double price;

	public System1()
	{
		this(0,"right here","over there",0,0.0);
	}

	public System1(int id, String location, String destination, int distance, double price) {
		super();
		this.id = id;
		this.location = location;
		this.destination = destination;
		this.distance = distance;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "System1 [id=" + id + ", location=" + location + ", destination=" + destination + ", distance=" + distance
				+ ", price=" + price + "]";
	}

	

}
