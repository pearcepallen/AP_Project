package Entity;

public class CabManager {
 
		private int id;
	    private String email;
	    protected String password;
	 
	    public CabManager()
	    {
	        this(12,"default@gmail.com","123456");	        
	    }
	            
	    public CabManager(int i, String email, String password)
	    {
	    	super();
	    	i = id;
	        this.email = email;
	        this.password = password;
	    }
	   
	   
	public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "CabManager [id=" + id + ", email=" + email + ", password=" + password + "]";
		}

}
