import java.util.Scanner;
class liczba_naturalna{
	private int K;
	private int suma_cyfr;
	
	public void licz_sume_cyfr() 
	{	
//System.out.println("     WCHODZE DO PETLI, K = " + K);
		int pomoc = K;
		for (int i=10; pomoc != 0; )
		{
//	System.out.println("i = " + i);
//System.out.println("PRZED MODULO pomoc = " + pomoc  + " suma_cyfr " + suma_cyfr);
			suma_cyfr+=pomoc%i;
//System.out.println("w modulo dodam " + pomoc%i);
//System.out.println("PO MODULO PRZED DZIELENIEM pomoc = " + pomoc  + " suma_cyfr " + suma_cyfr);
			pomoc = pomoc/i;
//System.out.println("PO DZIELENIU pomoc = " + pomoc  + " suma_cyfr " + suma_cyfr);
		}
//System.out.println("      PO PETLI pomoc = " + pomoc  + " suma_cyfr " + suma_cyfr);
	}
	public int zwroc_sume_liczb()
	{
		return suma_cyfr;
	}
	public liczba_naturalna(int start)	
	{
		K = start;
		suma_cyfr=0;
		System.out.println("stworzono " + K);
	}	
}

public class I2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Wprowadz liczbę naturalna");
		liczba_naturalna K = new liczba_naturalna(scan.nextInt());
		K.licz_sume_cyfr();
		System.out.println("Suma cyfr wynosi " +K.zwroc_sume_liczb());
		
		

	}

}
