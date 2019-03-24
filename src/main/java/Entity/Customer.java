package Entity;

public class Customer {

	private int id;
	private String location;
	private String destination;
	private int number;
	private String feedback;
	private int rating;
	private boolean confirm_pk;
	private boolean confirm_arr;
	
	
	public Customer()
	{
		this(0,"nowhere","nowhere",0, "lovely", 1,false,false);
	}
	
	
	public Customer(int id, String location, String destination, int number, String feedback, int rating, boolean confirm_pk, boolean confirm_arr) {
		super();
		this.id = id;
		this.location = location;
		this.destination = destination;
		this.number = number;
		this.feedback = feedback;
		this.rating = rating;
		this.confirm_pk = confirm_pk;
		this.confirm_arr = confirm_arr;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
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
		return "Customer [id=" + id + ", location=" + location + ", destination=" + destination + ", number=" + number
				+ ", feedback=" + feedback + ", rating=" + rating + ", confirm_pk=" + confirm_pk + ", confirm_arr="
				+ confirm_arr + "]";
	}



}

