package Entity;

public class Customer {

	private String location;
	private String destination;
	private int number;
	private String feedback;
	private Rate rating;
	private boolean confirm_pk;
	private boolean confirm_arr;
	
	
	public Customer()
	{
		this("nowhere","nowhere",0, "lovely", Rate.ok,false,false);
	}
	
	
	public Customer(String location, String destination, int number, String feedback, Rate rating, boolean confirm_pk, boolean confirm_arr) {
		super();
		this.location = location;
		this.destination = destination;
		this.number = number;
		this.feedback = feedback;
		this.rating = rating;
		this.confirm_pk = confirm_pk;
		this.confirm_arr = confirm_arr;
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

	public boolean isConfirm_pk() {
		return confirm_pk;
	}


	public void setConfirm_pk(boolean confirm_pk) {
		this.confirm_pk = confirm_pk;
	}


	public boolean isConfirm_arr() {
		return confirm_arr;
	}


	public void setConfirm_arr(boolean confirm_arr) {
		this.confirm_arr = confirm_arr;
	}


	@Override
	public String toString() {
		return "Customer [location=" + location + ", destination=" + destination + ", number=" + number + ", feedback="
				+ feedback + ", rating=" + rating + ", confirm_pk=" + confirm_pk + ", confirm_arr=" + confirm_arr + "]";
	}

}

