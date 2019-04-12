
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class My_Calendar {

	private static final int[] Max_Days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static int GetMaxDaysOfMonth(int month) {

		return (Max_Days[month - 1]);

	}

	public static void printcalendar() {

		System.out.println("  일      월      화      수      목      금      토");
		System.out.println("--------------------------");
		System.out.println(" 1   2   3   4   5   6   7");
		System.out.println(" 8   9  10  11  12  13  14");
		System.out.println("15  16  17  18  19  20  21");
		System.out.println("22  23  24  25  26  27  28");
	}

	public static void main(String[] args) {

		System.out.println("전체 날수를 구하고 싶은 년도와 월을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		My_Calendar calendar = new My_Calendar();

		int month = scanner.nextInt();
		scanner.close();

		int days = GetMaxDaysOfMonth(month) ;

		System.out.printf("입력된 %d월의 날수는 %d 입니다. \n", month, calendar.GetMaxDaysOfMonth(month));

		calendar.printcalendar();

//		System.out.println("전체 날수를 구하고 싶은 년도와 월을 입력하세요");
//		Scanner scanner = new Scanner(System.in);
//		int Year = scanner.nextInt() ;
//		int Month = scanner.nextInt() ;
//        scanner.close();

//        int Month ;
//        int day = 1 ;
//        int daysofmonth ;
             
//        if (str2 == 1) {
//        	Month = Calendar.JANUARY ;
//        }
//        else if (str2 == 2) {
//        	Month = Calendar.FEBRUARY ;
//        }
//        else if (str2 == 3) {
//        	Month = Calendar.MARCH ;
//        }
//        else if (str2 == 4) {
//        	Month = Calendar.APRIL ;
//        }
//        else if (str2 == 5) {
//        	Month = Calendar.MAY ;
//        }
//        else if (str2 == 6) {
//        	Month = Calendar.JUNE ;
//        }
//        else if (str2 == 7) {
//        	Month = Calendar.JULY ;
//        }
//        else if (str2 == 8) {
//        	Month = Calendar.AUGUST ;
//        }
//        else if (str2 == 9) {
//        	Month = Calendar.SEPTEMBER ;
//        }
//        else if (str2 == 10) {
//        	Month = Calendar.OCTOBER ;
//        }
//        else if (str2 == 11) {
//        	Month = Calendar.NOVEMBER ;
//        }
//        else {
//        	Month = Calendar.DECEMBER ;
//        }

//        Calendar calendar = new GregorianCalendar (Year, Month-1, day) ;
//        
//        daysofmonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) ;
//        
//        System.out.printf("%d 년도 %d 월의 일수는 %d 입니다",Year, Month, daysofmonth) ;
	}

}
