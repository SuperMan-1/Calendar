import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	
	public Date PlanDate;
	public String detail;
	public String Peoples;

	public static Date getDatefromString(String str_Date) {

		Date date = null;

		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(str_Date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public PlanItem(String str_Date, String detail) {
		
		this.PlanDate = getDatefromString(str_Date);
		this.detail = detail;
		Peoples = "";

	}
	
	public Date getDate() {
		return PlanDate;
	}
	
	public String getplan() {
		return detail;
	}
	
	public void AddPeople(String attendee) {
		Peoples = Peoples + attendee + ",";
	}

}
