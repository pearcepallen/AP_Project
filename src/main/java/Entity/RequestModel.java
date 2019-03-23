package Entity;

public class RequestModel{
	private int req_id;
	private int c_number;
	private int c_id;
	private String location;
	private String destination;
	
	
	public RequestModel()
	{
		this(0,0,0,"here","herelogin");
	}		
	
	
	public RequestModel(int req_id, int c_number, int c_id, String location, String destination) {
		super();
		this.req_id = req_id;
		this.c_number = c_number;
		this.c_id = c_id;
		this.location = location;
		this.destination = destination;
	}


	public int getReq_id() 	{
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
	
	
}
