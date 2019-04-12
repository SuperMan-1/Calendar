import java.util.Scanner;

public class Prompt {

	private static final String PROMPT = "Calendar > ";

	public static void PromptRun() {

		Scanner scanner = new Scanner(System.in);
		My_Calendar calendar = new My_Calendar();
		int month, year;

		while (true) {
			System.out.println("출력을 원하는 년도와 달을 입력하세요");
			System.out.print(PROMPT);
			year = scanner.nextInt();
			month = scanner.nextInt();
			
			if (month == -1) {
				break;
			} else if (month > 12) {
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
