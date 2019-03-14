package Entity;

public class Report{

	private String reportType;
	
	public Report() {
		
	}
	
	public String getReportType() 
	{
		return reportType;
	}
	
	public void setReportType(String reportType) 
	{
		this.reportType = reportType;
	}

	@Override
	public String toString() {
		return "Report [reportType=" + reportType + "]";
	}
	
}
