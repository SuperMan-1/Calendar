import java.util.Scanner;

public class Sum {

	public static void main (String[] args) {
		// 입력 : 키보드로 두수의 입력을 받는다.
		
		Scanner scanner = new Scanner(System.in) ;
		System.out.println("두수를 입려해 주세요.") ;
		String str1 = scanner.next();
		String str2 = scanner.next();
		
		int FirstNum, SecondNum ;
	
		FirstNum = Integer.parseInt(str1) ;
		SecondNum = Integer.parseInt(str2) ;

		// 출력 : 두 수의 합을 화면에 출력한다.
        //System.out.println("두수의 합계는 : " + (FirstNum + SecondNum) + "입니다.") ;
		System.out.printf("%d + %d의 합계는 %d 입니다", FirstNum, SecondNum, FirstNum + SecondNum) ;
		
		scanner.close();
	}
}
