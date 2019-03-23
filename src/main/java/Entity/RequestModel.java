package Entity;

public class RequestModel{
	private int req_id;
	private int c_number;
	private int c_id;
	private String location;
	private String destination;
	private int distance;
	private double fare;
	
	
	public RequestModel()
	{
		this(0,0,0,"here","herelogin",0,0.0);
	}


	public RequestModel(int req_id, int c_number, int c_id, String location, String destination, int distance,
			double fare) {
		super();
		this.req_id = req_id;
		this.c_number = c_number;
		this.c_id = c_id;
		this.location = location;
		this.destination = destination;
		this.distance = distance;
		this.fare = fare;
	}


	public int getReq_id() {
		return req_id;
	}


	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}


	public int getC_number() {
		return c_number;
	}


	public void setC_number(int c_number) {
		this.c_number = c_number;
	}


	public int getC_id() {
		return c_id;
	}


	public void setC_id(int c_id) {
		this.c_id = c_id;
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


	public double getFare() {
		return fare;
	}


	public void setFare(double fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "RequestModel [req_id=" + req_id + ", c_number=" + c_number + ", c_id=" + c_id + ", location=" + location
				+ ", destination=" + destination + ", distance=" + distance + ", fare=" + fare + "]";
	}		
	
	
	
	
}
