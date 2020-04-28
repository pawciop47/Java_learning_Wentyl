import java.util.Scanner;
class potega
{	private int wynik;
	private int podstawa;
	private int wykladnik;
	public int poteguj(int A, int B)
	{
		if (B==0)
		  wynik = 1;
		else if (B%2!=0) 
		  wynik = ((A*poteguj(A, (B-1)/2)*poteguj(A, (B-1)/2)));
		else if (B%2==0)
			wynik = poteguj(A, B/2)*poteguj(A, B/2);
		return wynik;
	}
	public void pokaz_wynik()
	{
		System.out.println("wynik wynosi " + wynik);
		
	}
	potega(int A, int B)
	{
		podstawa = A;
		wykladnik = B;	
	}
}
public class I9 {

	public static void main(String[] args)
	{
		int podstawa;
		int wykladnik;
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj dwie liczby, podstawe i wykladnik potegi");
		podstawa = scan.nextInt();
		wykladnik= scan.nextInt();
		potega liczymy=new potega(podstawa, wykladnik);
		liczymy.poteguj(podstawa, wykladnik);
		liczymy.pokaz_wynik();
		
		
	}
}
