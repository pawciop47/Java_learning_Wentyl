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


class D1c {	
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
	public static boolean sprawdz_czy_w_trojkacie(Punkt punkt) {
	double a, b;
	if (punkt.podajX() < 0)
		a=punkt.podajX()+1;
	else a=punkt.podajX();
	if (punkt.podajY() < 0)
		b=punkt.podajY()+1;
	else b=punkt.podajY();
	System.out.println("wartosc a:" + a);
	System.out.println("wartosc b:" + b);
	
	return (a+b<=1);
	
	}
	public static int sprawdz_ktory_trojkat(Punkt punkt) {
		int ktora_cwiartka=0;
		if (punkt.podajX()>=0 && punkt.podajY()>=0)
			ktora_cwiartka=1;
		if (punkt.podajX()<0 && punkt.podajY()>=0)
			ktora_cwiartka=2;	
		if (punkt.podajX()<0 && punkt.podajY()<0)
			ktora_cwiartka=3;	
		if (punkt.podajX()>=0 && punkt.podajY()<0)
			ktora_cwiartka=4;	
		
		return ktora_cwiartka;
	}
	public static void main(String[] args) {
	Punkt test = new Punkt();
	wczytaj_wspolrzedne(test);
	wypisz_wspolrzedne(test);
	if (sprawdz_czy_w_trojkacie(test))
		{
		System.out.println("Punkt jest w trojkacie ");
		if (sprawdz_ktory_trojkat(test)>0)
			System.out.println(" Cwiartka " + sprawdz_ktory_trojkat(test));
		} else System.out.println("Punkt jest poza trojkatami ");
	}
}