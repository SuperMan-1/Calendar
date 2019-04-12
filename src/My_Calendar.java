import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class My_Calendar {
	
	public static void main(String[] args) {
		
		System.out.println("  일      월      화      수      목      금      토") ;
		System.out.println("--------------------------") ;
		System.out.println(" 1   2   3   4   5   6   7") ;
		System.out.println(" 8   9  10  11  12  13  14") ;
		System.out.println("15  16  17  18  19  20  21") ;
		System.out.println("22  23  24  25  26  27  28") ;

		System.out.println("전체 날수를 구하고 싶은 년도와 월을 입력하세요") ;
		Scanner scanner = new Scanner(System.in) ;
		
		int month = scanner.nextInt() ;
		scanner.close() ;
		
		int[] monthofdays = {31,28,31,30,31,30,31,31,30,31,30,31} ;
		
		System.out.printf("입력된 %d월의 날수는 %d 입니다. \n",month, monthofdays[month-1]) ;

//		int Year = scanner.nextInt() ;
//		String str2 = scanner.next() ;
//        scanner.close();
//
//        int Month ;
//        int day = 1 ;
//        int daysofmonth ;
//             
//        if (str2.contains("1")) {
//        	Month = Calendar.JANUARY ;
//        }
//        else if (str2.contains("2")) {
//        	Month = Calendar.FEBRUARY ;
//        }
//        else if (str2.contains("3")) {
//        	Month = Calendar.MARCH ;
//        }
//        else if (str2.contains("4")) {
//        	Month = Calendar.APRIL ;
//        }
//        else if (str2.contains("5")) {
//        	Month = Calendar.MAY ;
//        }
//        else if (str2.contains("6")) {
//        	Month = Calendar.JUNE ;
//        }
//        else if (str2.contains("7")) {
//        	Month = Calendar.JULY ;
//        }
//        else if (str2.contains("8")) {
//        	Month = Calendar.AUGUST ;
//        }
//        else if (str2.contains("9")) {
//        	Month = Calendar.SEPTEMBER ;
//        }
//        else if (str2.contains("10")) {
//        	Month = Calendar.OCTOBER ;
//        }
//        else if (str2.contains("11")) {
//        	Month = Calendar.NOVEMBER ;
//        }
//        else {
//        	Month = Calendar.DECEMBER ;
//        }
//
//        Calendar calendar = new GregorianCalendar (Year, Month, day) ;
//        
//        daysofmonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH) ;
//        
//        System.out.printf("%d 년도 %d 월의 일수는 %d 입니다",Year, (Month + 1), daysofmonth) ;
	}

}
