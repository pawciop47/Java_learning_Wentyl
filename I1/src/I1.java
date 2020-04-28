import java.util.Scanner;

class ciag_liczb{
	private double[] tablica;
	Scanner scan = new Scanner(System.in);
	ciag_liczb(int a) {
		tablica = new double[a];
	}
	
	public void wpisz_liczby(){
		for (int i=0; i<tablica.length; i++ ) {
	//		System.out.println("Podaj " + (i+1) + " liczbe");
			tablica[i] = scan.nextDouble();
		}
	}
	public void wypisz_liczby(){
		for (int i=0; i<tablica.length; i++ ) {
			System.out.println((i+1) + " liczba");
			System.out.println(tablica[i]);
		}
	}
	public double suma_wszystkich() {
		double suma = 0;
		for (int i=0; i<tablica.length; i++ ) {
			suma += tablica[i];
		}
		return suma;
	}
	public double srednia_dodatnich() {
		double srednia_dodatnich = 0;
		double dzielnik = 0; 
		for (int i=0; i<tablica.length; i++ ) {
			if(tablica[i]>0) {
				srednia_dodatnich += tablica[i];
				dzielnik++;
			}
		}
		if (dzielnik>0)
			return (srednia_dodatnich/dzielnik);
		else return (-999999999);
	}
	public double srednia_po_dodatnich() {
		double srednia_dodatnich = 0;
		double dzielnik = 0; 
		for (int i=1; i<tablica.length; i++ ) {
			if(tablica[i-1]>0) {
				srednia_dodatnich += tablica[i];
				dzielnik++;
			}
		}
		if (dzielnik>0)
			return (srednia_dodatnich/dzielnik);
		else return (-999999999);
	}
}

public class I1 {
	public static void main(String[] args) {
		int ile_liczb;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Podaj ile liczb ma byc w tablicy");
		ile_liczb = scan.nextInt();
		ciag_liczb tablica = new ciag_liczb(ile_liczb);
		tablica.wpisz_liczby();
	//	tablica.wypisz_liczby();
		System.out.println("suma wszystkich " + (tablica.suma_wszystkich()));
		System.out.println("srednia dodatnich " + (tablica.srednia_dodatnich()));
		System.out.println("srednia po dodatnich  " + (tablica.srednia_po_dodatnich()));
	}

}
