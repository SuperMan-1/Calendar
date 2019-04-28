
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class My_Calendar {

	private static final int[] Max_Days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] Max_Leap_Days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	private HashMap <Date,String> planMap;
	
	public My_Calendar () {
		planMap = new HashMap<Date, String>();
	}

	/*
	 * return 0 ~ 6 (0:sunday, 1:monday, 2:tuesday, 3:wednesday, 4: thursday, 5:friday, 6:saturday)
	 */
	
	public void filewrite(String strDate, String Plan) {

		try {
			File file = new File("C:\\Javastuding\\workspace\\FileIO\\"+strDate+".txt");
			FileWriter filewriter = new FileWriter(file, true);
//			BufferedWriter bufferedwrite = new BufferedWriter(new FileWriter(file));
			BufferedWriter bufferedwrite = new BufferedWriter(filewriter);

			if(file.isFile() && file.canWrite()) {
				bufferedwrite.write(Plan);
				bufferedwrite.newLine();
				bufferedwrite.close();
			}
		}catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void regiesterPlan(String strDate, String Plan) {
		
		PlanItem planitem = new PlanItem(strDate,Plan);
		planMap.put(planitem.getDate(), planitem.getplan());
		
		filewrite(strDate,Plan);
	}

	public String searchPlan(String strDate) {
//		Date date = PlanItem.getDatefromString(strDate);
		String return_str = "";

		try {
			File file= new File("C:\\Javastuding\\workspace\\FileIO\\"+strDate+".txt");
			Scanner scan = new Scanner(file);
			
			while(scan.hasNextLine()) {
				return_str = return_str + scan.nextLine();
				if(return_str != null) {
					return_str = return_str + "\r\n";
				}
			}

			scan.close();

		}catch(FileNotFoundException e) {
			System.out.println("File Not Found!");
		}

		return return_str;
	}
	
	public int weekday (String weekday) {

		int weeknum=0;
		
		switch(weekday) {
			case "SU":
				weeknum = 0;
				break;
			case "MO":
				weeknum = 1;
				break;
			case "TU":
				weeknum = 2;
				break;
			case "WE":
				weeknum = 3;
				break;
			case "TH":	
				weeknum = 4;
				break;
			case "FR":
				weeknum = 5;
				break;
			case "SA":	
				weeknum = 6;
				break;
			default:
				weeknum = 0;
				break;
		}
		
		return weeknum;
	}

	public boolean leapyear_check(int year) {

		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			return true;
		}else {
			return false;
		}

	}

	public int GetMaxDaysOfMonth(int year,int month) {

		if(leapyear_check(year)) {
			return (Max_Leap_Days[month - 1]);
		}else {
			return (Max_Days[month - 1]);
		}

	}

	public void printcalendar(int year, int month) {

		System.out.printf("<<%4d년 %2d월>> \n",year,month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("--------------------------");

		int daysofmonth = GetMaxDaysOfMonth(year,month);
		
		/*
		 * Calendar 는 추상(abstract) class여서 바로 사용할 수는 없다.
           GregorianCalendar class가 Calendar를 상속받아서 Calendar의 method를 구현하고있다.
           Calendar 를 사용하기위해서 우선 아래와 같이 Calendar를 선언한다
           Calendar cal = Calendar.getInstance();
           cal.set(Calendar.DAY_OF_MONTH,1) => DAY_OF_MONTH를 1로 설정 (월의 첫날)
           cal.get(Calendar.DAY_OF_WEEK)    => 그 주의 요일 반환 (일요일 : 1 ~ 토요일 : 7)
		   Calendar cal = new GregorianCalendar();
		   cal.set(cal.YEAR, year);
           cal.set(cal.MONTH, month-1);
		   cal.set(Calendar.DAY_OF_MONTH,1);
		   int weeknum = cal.get(Calendar.DAY_OF_WEEK) - 1;
		 */

		int weeknum = getweekday(year, month, 1) ;

		for (int i = 1; i <= daysofmonth+weeknum; i++) {

			if(i<=weeknum) {
				System.out.printf("%3s", " ");
			}else {
				System.out.printf("%3d", i-weeknum);
				if (i % 7 == 0) {
					System.out.println();
				}
			}
		}
		
		System.out.println();
	}

	private int getweekday(int year, int month, int days) {

		int standard_year = 1970 ;
		int TotalCnt = 0;

		for(int i=standard_year;i<year;i++) {
			if(leapyear_check(i)) {
				TotalCnt = TotalCnt + 366;
			}else {
				TotalCnt = TotalCnt + 365;
			}
		}

		for(int i=1;i<month;i++) {
			TotalCnt = TotalCnt + GetMaxDaysOfMonth(year,i);
		}
		
		TotalCnt = TotalCnt + days - 1;
		TotalCnt = (TotalCnt + 4) % 7;

		return TotalCnt;
	}

	public static void main(String[] args) {

//=========================================================================================================
//		1.반복회수 만큼 일수 구하기
//		Scanner scanner = new Scanner(System.in) ;
//		System.out.println("반복 회수를 입력하세요") ;
//		int Trynum = scanner.nextInt() ;
//		int month;
//		My_Calendar calendar = new My_Calendar() ;
//		for (int i = 1; i <= Trynum; i++) {
//			System.out.println("날수를 구하고자 하는 달을 입력하세요");
//			month = scanner.nextInt();
//			System.out.printf("입력된 %d월의 날수는 %d 입니다. \n", month, calendar.GetMaxDaysOfMonth(month));
//		}
//		System.out.println("Bye ~~") ;
//		scanner.close() ;
//=========================================================================================================

//=========================================================================================================
//		2. Prompt 출력 및 -1 입력 시 종료하기
//		Scanner scanner = new Scanner(System.in);
//		My_Calendar calendar = new My_Calendar();
//		int month;
//		String Prompt = "Cal > ";
//		while (true) {
//			System.out.println("날수를 구하고자 하는 달을 입력하세요");
//			System.out.print(Prompt);
//			month = scanner.nextInt();
//			if (month == -1) {
//				break;
//			} else if (month > 12) {
//				continue;
//			}
//
//			System.out.printf("입력된 %d월의 날수는 %d 입니다. \n", month, calendar.GetMaxDaysOfMonth(2019, month));
//		}
//		System.out.println("Bye ~~");
//		scanner.close();
//=========================================================================================================

//=========================================================================================================
//		3. 년도와 달을 입력받아 해당 월의 일수 구하기	
//		System.out.println("전체 날수를 구하고 싶은 년도와 월을 입력하세요");
//		Scanner scanner = new Scanner(System.in);
//		int Year = scanner.nextInt();
//		int Month = scanner.nextInt();
//		scanner.close();
//		int day = 1;
//		int daysofmonth;
//		Calendar calendar = new GregorianCalendar(Year, Month - 1, day);
//		daysofmonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
//		System.out.printf("%d 년도 %d 월의 일수는 %d 입니다", Year, Month, daysofmonth);
//=========================================================================================================
		
//=========================================================================================================
//		4. 년도와 달을 입력받아 윤년 구하기	
		System.out.println("전체 날수를 구하고 싶은 년도와 월을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		int Year = scanner.nextInt();
		int Month = scanner.nextInt();
		scanner.close();
		GregorianCalendar leapyear = new GregorianCalendar();
		if (leapyear.isLeapYear(Year)) {
			System.out.println(Year + "년은 윤년");
		} else {
			System.out.println(Year + "년은 평년");
		}
//=========================================================================================================

	}

}
