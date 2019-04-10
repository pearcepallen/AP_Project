package Entity;

public class Support {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String type;
	private String date;
	private String time;
	
	
	public Support() {
		this(1,"James","Bond","jbond@gmail.com","tour service","11/09/18","11:00 am"); 
	}


	public Support(int id, String firstName, String lastName, String email, String type, String date, String time) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.date = date;
		this.time = time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	@Override
	public String toString() {
		return "Support [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", type=" + type + ", date=" + date + ", time=" + time + "]";
	}


}