import java.util.Scanner;
import static java.lang.Math.*;

class Punkt {
	double X;
	double Y;
	
	public void wczytaj_wspolrzedne (double wspX, double wspY){
		X = wspX;
		Y = wspY;
	}
	public void wypisz_wspolrzedne () {
		System.out.println("wspolrzedna X:" + this.X);
		System.out.println("wspolrzedna Y:" + this.Y);
	}
	public double podajX() { 
		return X;
	}
	public double podajY() {
		return Y;
	}
}


class D1a {	
	public static void wczytaj_wspolrzedne(Punkt punkt) {
		
		Scanner scan = new Scanner(System.in);
		double a,b;
	
		System.out.println("Podaj wspolrzedna X:");
		 a = scan.nextDouble();
		System.out.println("Podaj wspolrzedna Y:");
		 b = scan.nextDouble();
		 punkt.wczytaj_wspolrzedne(a, b);
	}
	public static void wypisz_wspolrzedne(Punkt punkt) {
		punkt.wypisz_wspolrzedne();
	}
	public static boolean sprawdz_czy_w_kole(Punkt punkt) {
	return( (Math.sqrt((Math.pow(1-abs(punkt.podajX()), 2) + Math.pow(1-abs(punkt.podajY()), 2)))<=1));
	}
	public static int sprawdz_ktora_cwiartka(Punkt punkt) {
		int a=0;
		if (punkt.podajX()>0 && punkt.podajY()>0)
			a=1;	
		if (punkt.podajX()<0 && punkt.podajY()>0)
			a=2;
		if (punkt.podajX()<0 && punkt.podajY()<0)
			a=3;
		if (punkt.podajX()>0 && punkt.podajY()<0)
			a=4;
		return a;
	}
	public static void main(String[] args) {
	Punkt test = new Punkt();
	wczytaj_wspolrzedne(test);
	wypisz_wspolrzedne(test);
	if (sprawdz_czy_w_kole(test))
		{
		System.out.println("Punkt jest w kole ");
		if (sprawdz_ktora_cwiartka(test)>0)
			System.out.println(" Ćwiartka " + sprawdz_ktora_cwiartka(test));
		} else System.out.println("Punkt jest poza kolami ");
	}
}