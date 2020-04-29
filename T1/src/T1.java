import java.util.Scanner;
import java.util.Random;
/*
 * w trakcie tworzenia pojebalo mi sie parzyste/nieparzyste z ujemne/dodatnie
 * stad niektore nazwy są pomieszane :D
 */
class Tablica
{
	private int[] tablica;
	private int[] dodatnie;
	private int[] ujemne;
	int zakres;
	int liczebnosc;
	Random generator = new Random();
	//pokazuje wsyzstkei elementy tablicy pierwotnej
	public void show_all_elements()
	{
		for (int i=0; i<liczebnosc; i++)
		System.out.println("Tablica pierwotna: wartosc " + tablica[i] + " indeks " + i);
	}
	//pokazuje elementy tablicy pierwotnej w odwroconej kolejnosci
	public void show_all_elements_reverse()
	{
		for (int i=liczebnosc-1; i>=0; i--)
		System.out.println("Element " +(i+1) + " o indeksie tablicy " +i + " wynosi " + tablica[i]);
	}
	public boolean sprawdz_czy_wystepuje(int K, int i)
	{
		boolean help = false;
		for (int n=0; n<=i+1; n++)
		{
			if(	tablica[n] == K)
				help = true;
		}
		return help;
	}
	//wypelnai tablice pierwotna losowymi liczbami
	public void wypelnij_ciag()
	{
		for (int i=0; i<liczebnosc; i++)
		{
			tablica[i]=(Math.abs(generator.nextInt())%zakres)+1;
//			System.out.println("wpisuje do i = " +i + " wartosc " +tablica[i]);
		}
	}
	//wypelnia tablice pierwotna liczbami bez powtorzen
	public void wypelnij_zbior()
	{
		int pomoc;
		for (int i=0; i<liczebnosc; i++)
		{
			pomoc=-1;
			while(!(tablica[i]==pomoc) || (pomoc==0))
			{
				pomoc=Math.abs(generator.nextInt())%zakres;
//				System.out.println("wylosowalo " +pomoc);
				if (!sprawdz_czy_wystepuje(pomoc, i-1))
				{
						tablica[i] = pomoc;
//						System.out.println("wpisuje do i = " +i + " wartosc " +tablica[i] + " pomoc wynosi " + pomoc);
				}
			}
		}
	}
	//zlicza ilosc parzystych elementow w tablicy pierwotnej, wykorzystywane do tworzenia rozmiaru tablicy parzystej
	public int zlicz_dodatnie()
	{
		int licznik = 0;
		for (int i=0; i<liczebnosc; i++)
		{
			if(	tablica[i]%2 == 0)
				licznik++;
		}
//		System.out.println("ilosc dodatnich " +licznik);
		return licznik;
	}	
	//zlicza ilosc nieparzystych elementow w tablicy pierwotnej, wykorzystywane do tworzenia rozmiaru tablicy nieparzystej
	public int zlicz_ujemne()
	{
		int licznik = 0;
		for (int i=0; i<liczebnosc; i++)
		{
			if(	tablica[i]%2 == 1)
				licznik++;
		}
//		System.out.println("ilosc ujemnych " +licznik);
		return licznik;
	}	
	public void tworz_ciag_parzysty()
	{
		dodatnie = new int[zlicz_dodatnie()];
		int indeks_pomoc= 0;
		int wartosc_pomoc = zakres;
		int stop=zlicz_dodatnie();
		
		for(int i=0; i<stop; i++)
		{
			wartosc_pomoc = zakres;
			for (int n=0; n<liczebnosc; n++)
			{
				if (tablica[n]%2==0 && tablica[n]<=wartosc_pomoc && tablica[n]!=0)
				{
					indeks_pomoc = n;
					wartosc_pomoc = tablica[n];
				}
			}
			System.out.println("znalazlem parzysta " +tablica[indeks_pomoc] + " indeks " + indeks_pomoc);
			tablica[indeks_pomoc]=0;
			dodatnie[i]=wartosc_pomoc;
		}
	}
	public void tworz_ciag_nieparzysty()
	{
		ujemne = new int[zlicz_ujemne()];
		int indeks_pomoc= 0;
		int wartosc_pomoc = zakres;
		int stop=zlicz_ujemne();
		
		for(int i=0; i<stop; i++)
		{
			wartosc_pomoc = zakres;
			for (int n=0; n<liczebnosc; n++)
			{
				if (tablica[n]%2==1 && tablica[n]<=wartosc_pomoc)
				{
					indeks_pomoc = n;
					wartosc_pomoc = tablica[n];
				}
			}
			System.out.println("znalazlem nieparzysta " +tablica[indeks_pomoc] + " indeks " + indeks_pomoc);
			tablica[indeks_pomoc]=0;
			ujemne[i]=wartosc_pomoc;
		}
	}
	public void pokaz_parzysty()
	{
		for (int i=0; i<dodatnie.length; i++)
		System.out.println("tablica parzysta indeks " +i + " wartosc " + dodatnie[i]);
	}	
	public void pokaz_nieparzysty()
	{
		for (int i=0; i<ujemne.length; i++)
		System.out.println("Tablica nieparzysta indeks " +i + " wartosc " + ujemne[i]);
	}
	Tablica()
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Podaj zakres generowanych liczb i ilosc liczb w ciagu/zbiorze");
		System.out.println("Pamietaj, ze zakres > liczebniosc zbioru");
		zakres = scan.nextInt();
		liczebnosc = scan.nextInt();
		tablica = new int[liczebnosc];
	}
}


public class T1 {

	public static void main(String[] args)
	{
		Tablica tablica_1 = new Tablica();
		
		tablica_1.wypelnij_ciag();
//		tablica_1.wypelnij_zbior();
		System.out.println(" ");
		tablica_1.show_all_elements();
		System.out.println(" ");
//		tablica_1.show_all_elements_reverse();
		tablica_1.tworz_ciag_parzysty();
		System.out.println(" ");
		tablica_1.tworz_ciag_nieparzysty();
		System.out.println(" ");
		tablica_1.show_all_elements();
		System.out.println(" ");
		tablica_1.pokaz_parzysty();
		System.out.println(" ");
		tablica_1.pokaz_nieparzysty();
		
	}
}
