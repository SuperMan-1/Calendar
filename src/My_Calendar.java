
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class My_Calendar {

	private static final int[] Max_Days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int GetMaxDaysOfMonth(int month) {

		return (Max_Days[month - 1]);

	}

	public static void printcalendar(int year, int month) {

		System.out.printf("<<%4d년 %2d월>> \n",year,month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("--------------------------");

		int daysofmonth = GetMaxDaysOfMonth(month);

		for (int i = 1; i <= daysofmonth; i++) {
			System.out.printf("%3d", i);
			if (i % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
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
		Scanner scanner = new Scanner(System.in);
		My_Calendar calendar = new My_Calendar();
		int month;
		String Prompt = "Cal > ";
		while (true) {
			System.out.println("날수를 구하고자 하는 달을 입력하세요");
			System.out.print(Prompt);
			month = scanner.nextInt();
			if (month == -1) {
				break;
			} else if (month > 12) {
				continue;
			}

			System.out.printf("입력된 %d월의 날수는 %d 입니다. \n", month, calendar.GetMaxDaysOfMonth(month));
		}
		System.out.println("Bye ~~");
		scanner.close();
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

	}

}
