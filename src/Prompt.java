import java.text.ParseException;
import java.util.Scanner;

public class Prompt {

//	private static final String YEAR_PROMPT = "Calendar_Year > ";
//	private static final String MONTH_PROMPT = "Calendar_Month > ";
	
	private static final String COMMON_PROMPT = "> " ;

	public void cmdPrintmenu() {
		
		System.out.println("+---------------------------------------------+");
		System.out.println("| 1. 일정등록");
		System.out.println("| 2. 일정검색");
		System.out.println("| 3. 달력보기");
		System.out.println("| h. 도움말 q. 종료");
		System.out.println("+---------------------------------------------+");
		
	}
	
	public void PromptRun() throws ParseException {

		Scanner scanner = new Scanner(System.in);
		My_Calendar calendar = new My_Calendar();
		String command;
		boolean isLoop = true;
		
		cmdPrintmenu();

		while (isLoop) {

			System.out.println("명령 (1, 2, 3, h, q)");
			System.out.print(COMMON_PROMPT);

			command = scanner.next() ;

			switch(command) {
				case "1":
					cmdRegister(scanner, calendar);
					break;
				case "2":
					cmdSearch(scanner, calendar);
					break;
				case "3":
					cmdPrintcal(scanner, calendar);
					break;
				case "h":
					cmdPrintmenu();
					break;
				case "q":
					isLoop = false;
					break;
			}
			
		}

		System.out.println("Thank you. Bye~~");
		scanner.close();

	}

	private void cmdPrintcal(Scanner scanner, My_Calendar calendar) {

		int year, month;
		String str_date;
		
		System.out.println("[달력보기] 날자를 입력하세요.");
		System.out.print(COMMON_PROMPT);
		str_date = scanner.next();

		year = Integer.parseInt(str_date.split("-")[0]);
		month = Integer.parseInt(str_date.split("-")[1]);

		if(month < 1 || month > 12) {
			System.out.println("잘못된 입력입니다.");
			return;
		}
		
		calendar.printcalendar(year,month);

	}

	private void cmdSearch(Scanner scanner, My_Calendar calendar){

		String str_Date, str_Schedule="";

		System.out.println("[일정검색] 날자을 입력하세요.");
		System.out.print(COMMON_PROMPT);
		str_Date = scanner.next();
		
		try {
			str_Schedule = calendar.searchPlan(str_Date);
		} catch (ParseException e) {
			e.printStackTrace();
			System.out.println("일정 검색 중 에러가 발생하였습니다.");
		}
		
		System.out.println(str_Schedule);
	}

	private void cmdRegister(Scanner scanner, My_Calendar calendar) throws ParseException {

		String str_date, str_schedule;

		System.out.println("[일정등록] 날자을 입력하세요(yyyy-MM-dd).");
		System.out.print(COMMON_PROMPT);
		str_date = scanner.next();
		scanner.nextLine();
		System.out.println("일정을 입력하세요");
		System.out.print(COMMON_PROMPT);
		str_schedule = scanner.nextLine();
		
		calendar.regiesterPlan(str_date,str_schedule);
	
	}

	public static void main(String[] args) throws ParseException {

		Prompt prompt = new Prompt() ;
		prompt.PromptRun();
	}
}
