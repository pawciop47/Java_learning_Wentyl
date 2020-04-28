import java.util.Scanner;
class liczba_naturalna{
	private int K;
	private int L;
	private int suma_cyfr;
	private int najwieksza_cyfra;
	
	public void licz_sume_cyfr() 
	{	
//System.out.println("     WCHODZE DO PETLI, K = " + K);
		int pomoc = K;
		for (int i=10; pomoc != 0; )
		{
			suma_cyfr+=pomoc%i;
			if(pomoc%i>najwieksza_cyfra)
				najwieksza_cyfra=pomoc%i;
			pomoc = pomoc/i;

		}

	}
	public int zwroc_sume_liczb()
	{
		return suma_cyfr;
	}
	public int zwroc_najwieksza_cyfra()
	{
		return najwieksza_cyfra;
	}
	public liczba_naturalna(int start, int start_2)	
	{
		K = start;
		L = start_2;
		suma_cyfr=0;
//	System.out.println("stworzono " + K);
	}	
	public boolean czy_liczba_pierwsza()
	{	
		int licznik = 0;
		for (int i=1; i<=K; i++)
		{
			if((K/i)*i==K)
			{
				licznik++;
//				System.out.println(i + " jest dzielnikiem ");
			}
				
		}
		if (licznik == 1 || licznik == 2)
			return true;
			else return false;
	}
	public int najwiekszy_wspolny_dzielnik()
	{	
		int najwieksz_dzielnik = 0;
		int mniejsza;
		int wieksza;
		if (K>L)
		{
			mniejsza = L;
			wieksza = K;
		}else 
			{
				mniejsza = K;
				wieksza = L;
			}	
		for (int i=1; i<=mniejsza; i++)
		{
			if((mniejsza/i)*i==mniejsza)
			{
				if((wieksza/i)*i==wieksza)
				{
					najwieksz_dzielnik = i;
			//		System.out.println(i + " jest wspolnym wspolnym dzielnikiem ");
				}
			}
		} 
	//	System.out.println(najwieksz_dzielnik + " jest najwiekszym wspolnym dzielnikiem ");
		return najwieksz_dzielnik;
	}
	public int najwiekszy_wspolny_dzielnik_euklides()
	{	
		int pomoc = 1;
		int mniejsza;
		int wieksza;
		if (K>L)
		{
			mniejsza = L;
			wieksza = K;
		}else 
			{
				mniejsza = K;
				wieksza = L;
			}	
		while (pomoc!=0)
		{
			pomoc = wieksza%mniejsza;
			wieksza = mniejsza;
			mniejsza = pomoc;
		}
		return wieksza;
	}
	public int najwiekszy_wspolny_dzielnik_euklides_odejmowanie()
	{	
		int pomoc = 1;
		int mniejsza=K;
		int wieksza=L;
		while(mniejsza!=wieksza)
		{
			if (mniejsza>wieksza)
			{
				pomoc = mniejsza;
				mniejsza = wieksza;
				wieksza = pomoc;
			}
			pomoc = wieksza - mniejsza;
			wieksza = mniejsza;
			mniejsza = pomoc;
		}
		return wieksza;
	}
}

public class I2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Wprowadz dwie liczby naturalne (druga do szukania wspolnego dzielnika)");
		liczba_naturalna K = new liczba_naturalna(scan.nextInt(), scan.nextInt());
		K.licz_sume_cyfr();
		System.out.println("Suma cyfr pierwszej liczby wynosi " +K.zwroc_sume_liczb());
		System.out.println("najwieksza cyfra pierwszej liczby " +K.zwroc_najwieksza_cyfra());
		System.out.println("czy liczba pierwsza " + K.czy_liczba_pierwsza());
		System.out.println("najwiekszy wspolny dzielnik " + K.najwiekszy_wspolny_dzielnik());
		System.out.println("najwiekszy wspolny dzielnik " + K.najwiekszy_wspolny_dzielnik_euklides());
		System.out.println("najwiekszy wspolny dzielnik " + K.najwiekszy_wspolny_dzielnik_euklides_odejmowanie());
	}

}
