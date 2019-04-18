import java.util.Scanner;

public class Prompt {

	private static final String YEAR_PROMPT = "Calendar_Year > ";
	private static final String MONTH_PROMPT = "Calendar_Month > ";

	public static void PromptRun() {

		Scanner scanner = new Scanner(System.in);
		My_Calendar calendar = new My_Calendar();
		int month, year;
		String weekday ;

		while (true) {
			System.out.println("출력을 원하는 년도를 입력하세요(Exit : -1)");
			System.out.print(YEAR_PROMPT);
			year = scanner.nextInt();

			if(year==-1) {
				break;
			}

			System.out.println("출력을 원하는 달을 입력하세요");
			System.out.print(MONTH_PROMPT);
			month = scanner.nextInt();
			
			if (month < 0 || month > 12) {
				continue;
			}

			calendar.printcalendar(year,month);
		}

		scanner.close();

	}

	public static void main(String[] args) {

		Prompt prompt = new Prompt() ;
		prompt.PromptRun();
	}
}
