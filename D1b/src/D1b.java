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


class D1b {	
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
	return( (Math.sqrt((Math.pow(1-abs(punkt.podajX()), 2) + Math.pow(1-abs(punkt.podajY()), 2)))<=4));
	}
	public static int sprawdz_ktore_kolo(Punkt punkt) {
		int ktore_kolo=0;
		double promien = (Math.sqrt((Math.pow(punkt.podajX(), 2) + Math.pow(punkt.podajY(), 2))));
		if (promien>=0 && promien<=1)
			ktore_kolo=1;	
		if (promien>1 && promien<=2)
			ktore_kolo=2;
		if (promien>2 && promien<=3)
			ktore_kolo=3;
		if (promien>3 && promien<=4)
			ktore_kolo=4;
		return ktore_kolo;
	}
	public static void main(String[] args) {
	Punkt test = new Punkt();
	wczytaj_wspolrzedne(test);
	wypisz_wspolrzedne(test);
	if (sprawdz_czy_w_kole(test))
		{
		System.out.println("Punkt jest w kole ");
		if (sprawdz_ktore_kolo(test)>0)
			System.out.println(" Kolo " + sprawdz_ktore_kolo(test));
		} else System.out.println("Punkt jest poza kolami ");
	}
}