package Entity;


public class Cab 
{
	private int c_id;
	private int trn;
	private int year;
	private String model;
	private String name;
	private boolean available;
	private double fare;
	private int distance;

	public Cab()
	{
		this(0,0,0,"civic","John Jones",false,0.0,0);
	}

		
	public Cab(int c_id, int trn, int year, String model, String name, boolean available, double fare, int distance) {
		super();
		this.c_id = c_id;
		this.trn = trn;
		this.year = year;
		this.model = model;
		this.name = name;
		this.available = available;
		this.fare = fare;
		this.distance = distance;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}
	

	public int getTrn() {
		return trn;
	}

	public void setTrn(int trn) {
		this.trn = trn;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public int getDistance() 
	{
		return distance;
	}


	public void setDistance(int distance) 
	{
		this.distance = distance;
	}


	@Override
	public String toString() 
	{
		return "Cab [c_id=" + c_id + ", trn=" + trn + ", year=" + year + ", model=" + model
				+ ", name=" + name + ", available=" + available + ", fare=" + fare + ", distance=" + distance + "]";
	}



}


