package Entity;

public class UnfulfilledRequest {
	private int c_id;
	private int c_number;
	
	public UnfulfilledRequest()
	{
		this(0, 0);
	}

	public UnfulfilledRequest(int c_id, int c_number) 
	{
		this.c_id = c_id;
		this.c_number = c_number;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public int getC_number() {
		return c_number;
	}

	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	
	@Override
	public String toString()
	{
		return "Cab [c_id=" + c_id + ", c_number=" + c_number + "]";
		
	}
	
	

}
