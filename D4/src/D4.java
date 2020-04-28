import java.util.Scanner;
import java.lang.Math;
public class D4 {
	public static double A,B,C;
	public static double pomoc;
	public static void wczytaj () {
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj pierwsza liczbe");
		A = scan.nextDouble();
		System.out.println("Podaj druga liczbe");
		B = scan.nextDouble();
		System.out.println("Podaj trzecia liczbe");
		C = scan.nextDouble();
		System.out.println("A = " + A);
		System.out.println("B = " + B);
		System.out.println("C = " + C);
	}
	public static void zamien ( double jeden, double dwa) {
		double pomoc;
		pomoc = jeden;
		jeden = dwa;
		dwa = pomoc;
	}
	public static void wyswietl () {
    
		System.out.println("A = " + A);
		System.out.println("B = " + B);
		System.out.println("C = " + C);
	}
	public static boolean czy_sie_da(double jeden, double dwa, double trzy) {
		return ((jeden+dwa)>trzy);
	}
	public static void jaki_trojkat_a(double jeden, double dwa, double trzy){
		int pomoc;
		//rownoboczny
		if (jeden==dwa && dwa==trzy)
			System.out.println("rownoboczny");
		//rownoramienny
		if (jeden==dwa || dwa==trzy || jeden == trzy)
			System.out.println("rownoramienny");
		//roznoboczny
		if (jeden!=dwa && dwa!=trzy && jeden!=trzy)
			System.out.println("roznoboczny");
	}
	public static void jaki_trojkat_b(double jeden, double dwa, double trzy){
		if((Math.pow(jeden,2) + Math.pow(dwa,2))> Math.pow(trzy,2))
			System.out.println("ostrokatny");
		if((Math.pow(jeden,2) + Math.pow(dwa,2))== Math.pow(trzy,2))
			System.out.println("prostokatny");
		if((Math.pow(jeden,2) + Math.pow(dwa,2))< Math.pow(trzy,2))
			System.out.println("rozwartokatny")	;	
	}
public static void main(String[] args) {
		wczytaj();
		if (A>B) {
		pomoc = A;
		A = B;
		B = pomoc;
		}
		if (A>C) {
			pomoc = A;
			A = C;
			C = pomoc;
			}
		if (B>C) {
			pomoc = B;
			B = C;
			C = pomoc;
			}
		wyswietl();
		if (czy_sie_da(A, B, C)) {
			jaki_trojkat_a(A, B, C);
			jaki_trojkat_b(A, B, C);
		}	
	}
}
