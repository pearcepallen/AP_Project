package Entity;

public class Customer {

	private String location;
	private String destination;
	private int number;
	private String feedback;
	private Rate rating;
	private boolean confirm_pkup;
	private boolean confirm_cab;

	
	public Customer()
	{
		this("nowhere","nowhere",0, "lovely", Rate.ok);
	}
	
	
	public Customer(String location, String destination, int number, String feedback, Rate rating) {
		super();
		this.location = location;
		this.destination = destination;
		this.number = number;
		this.feedback = feedback;
		this.rating = rating;
	}

	public String getLocation() 
	{
		return location;
	}
	
	public void setLocation(String location) 
	{
		this.location = location;
	}
	
	public String getDestination() 
	{
		return destination;
	}
	
	public void setDestination(String destination) 
	{
		this.destination = destination;
	}
	public int getNumber() 
	{
		return number;
	}
	public void setNumber(int number) 
	 {
		this.number = number;
	 }
	
	
	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public Rate getRating() {
		return rating;
	}

	public void setRating(Rate rating) {
		this.rating = rating;
	}


	@Override
	public String toString() {
		return "Customer [location=" + location + ", destination=" + destination + ", number=" + number + ", feedback="
				+ feedback + ", rating=" + rating + "]";
	}


}

