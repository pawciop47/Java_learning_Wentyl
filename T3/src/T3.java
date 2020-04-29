import java.util.Scanner;
import java.util.Random;
/*
 * Wspolrzedne punktow na potrzeby zadania beda generowane w zakresie -100; 100 i sa liczbami calkowitymi
 */

class Punkt
{
	private int index;
	private int X;
	private int Y;
	private double distance_from_0;
	private double calculate_distance_from_0()
	{
		return(Math.sqrt((Math.pow(X, 2) + Math.pow(Y, 2))));
	}
	
	int return_index()
	{
		return this.index;
	}
	double return_distance_from_0()
	{
		return this.distance_from_0;
	}
	int return_X()
	{
		return this.X;
	}
	int return_Y()
	{
		return this.Y;
	}
	void print_point_data()
	{
	 System.out.println(this.index + ":	X:" + this.X + "	Y:" + this.Y +  " 	odleglosc od p0: "+ this.distance_from_0);
	}
	
	Punkt(int X, int Y, int index)
	{
		this.X=X;
		this.Y=Y;
		this.distance_from_0 = this.calculate_distance_from_0();
		this.index=index;
	}
	Punkt()
	{
		this.index = 0;
		this.X = 0;
		this.Y = 0;
		this.distance_from_0 = 0;
	}
}

class Tablica_punktow
{
	int ile_punktow;
	Punkt[] tablica_punktow;
	
	void show_all_points()
	{
		for (int i=0; i<ile_punktow; i++)
		{
			tablica_punktow[i].print_point_data();
		}
	}
	void find_farest_point_from_0()
	{
		double wartosc = 0;
		int index = 0;
		for(int i=0; i<ile_punktow; i++)	
		{
			if (tablica_punktow[i].return_distance_from_0()>wartosc)
			{
				wartosc = tablica_punktow[i].return_distance_from_0();
				index = tablica_punktow[i].return_index();
			}
		}
		System.out.println("Najwieksza odleglosc od p0 = " + wartosc + " Punkt: " + index);
	}
	void find_biggest_rectangle_with_all_points()
	{ 
		/*
		 * Wartosci zwiazane z zakresem generowanych liczb - jezeli sie zmieni zakres, liczby tez trzeba zmienic
		 */
		int Xmax = -100;
		int Xmin = 100;
		int Ymax = -100;
		int Ymin = 100;
		for (int i=0; i<ile_punktow; i++)
		{
			if (Xmax<tablica_punktow[i].return_X())
				Xmax=tablica_punktow[i].return_X();
			if (Xmin>tablica_punktow[i].return_X())
				Xmin=tablica_punktow[i].return_X();
			if (Ymax<tablica_punktow[i].return_Y())
				Ymax=tablica_punktow[i].return_Y();
			if (Ymin>tablica_punktow[i].return_Y())
				Ymin=tablica_punktow[i].return_Y();			
		}
		System.out.println("Prostokat obejmujacy punkty:	Xmax = " + Xmax + " Xmin = " + Xmin + " Ymax = " + Ymax + " Ymin = " + Ymin);
		/*
		 * Punkty prostokata, nie sa uzywane dalej (moze jeszcze beda)
		 */
		Punkt prawy_dolny = new Punkt(Xmax, Ymin, 0);
		Punkt lewy_dolny = new Punkt(Xmin, Ymin, 0);
		Punkt prawy_gorny = new Punkt(Xmax, Ymax, 0);
		Punkt lewy_gorny = new Punkt(Xmin, Ymax, 0);
	}
	void sortuj_tablice()
	{
		Punkt pomoc;
		for(int i=0; i<ile_punktow-1; i++)
		{
			if (tablica_punktow[i].return_distance_from_0()>tablica_punktow[i+1].return_distance_from_0())
			{
				pomoc = tablica_punktow[i];
				tablica_punktow[i]=tablica_punktow[i+1];
				tablica_punktow[i+1]=pomoc;
				sortuj_tablice();
			}
		}
		
	}
	Tablica_punktow(int ile)
	{
		this.ile_punktow = ile;
		Random generator = new Random();
		tablica_punktow = new Punkt[ile];
		for (int i=0; i<ile; i++)
			tablica_punktow[i] = new Punkt(generator.nextInt()%100, generator.nextInt()%100, i);
	}
}
//Klasa przechowuje informacje o odleglosci miedzy punktami, oraz oboma indeksami punktow
class Para_punktow
{
	public int indeks_1;
	public int indeks_2;
	public double odleglosc;
	
	Para_punktow(int i, int j, double o)
	{
		indeks_1 = i;
		indeks_2 = j;
		odleglosc = 0;
	}
	Para_punktow()
	{
		indeks_1=0;
		indeks_2=0;
		odleglosc=0;
	}
}
/*
 *  elementy "_z_parami" dotycza klasy "Para_punktow". Do uporzadkowania odleglosci miedyz punktami 
 *  zostala zrobiona osobna tablica
 */

class Tablica_odleglosci
{
	double[][] odleglosc_miedzy_punktami;
	int rozmiar;
	int rozmiar_tablicy_z_parami;
	Para_punktow[] tablica_z_parami;
	void szukaj_najwiekszej_odleglosci()
	{
		double pomoc = 0;
		int indeks_1 = 0; 
		int indeks_2 = 0;

		for(int i=0; i<rozmiar; i++)
			for (int j=0; j<i; j++)
			{
				if(this.odleglosc_miedzy_punktami[i][j]>pomoc)
				{
					pomoc=this.odleglosc_miedzy_punktami[i][j];
					indeks_1=i;
					indeks_2=j;
				}
			}
		System.out.println("Najwieksza odleglosc jest miedzy punktami " + indeks_1 +" i " + indeks_2 +" i wynosi " + pomoc);
	}
	void wpisz_elementy_tablicy_z_parami()
	{
		tablica_z_parami = new Para_punktow[rozmiar_tablicy_z_parami];
		for(int i=0; i<this.rozmiar_tablicy_z_parami; i++) 
		{
			tablica_z_parami[i] = new Para_punktow();
		}
		
		int pomoc=0;
		for(int i=0; i<rozmiar; i++)
			for (int j=0; j<i; j++)
			{
				tablica_z_parami[pomoc].indeks_1=i;
				tablica_z_parami[pomoc].indeks_2=j;
				tablica_z_parami[pomoc].odleglosc=odleglosc_miedzy_punktami[i][j];
				pomoc++;
			}
	}
	void wypisz_elementy_tablicy_z_parami()
	{
		for (int i=0; i<rozmiar_tablicy_z_parami; i++)
		{
//			System.out.println("Odleglosci miedzy punktami:");
			System.out.println(tablica_z_parami[i].indeks_1 + " - " + tablica_z_parami[i].indeks_2  + " = 		" + tablica_z_parami[i].odleglosc);
		}
	}
	void uporzadkuj_elementy_tablicy_z_parami()
	{
		Para_punktow pomoc;
		for(int i=0; i<rozmiar_tablicy_z_parami-1; i++)
		{
			if(tablica_z_parami[i].odleglosc>tablica_z_parami[i+1].odleglosc)
			{
				pomoc = tablica_z_parami[i];
				tablica_z_parami[i] = tablica_z_parami[i+1];
				tablica_z_parami[i+1] = pomoc;
				uporzadkuj_elementy_tablicy_z_parami();
			}
		}
	}
	void wypisz_elementy_tablicy()
	{
		for (int i=0; i<rozmiar; i++)
			for(int j=0; j<i; j++)
			{
	//			System.out.println("Odleglosci miedzy punktami:");
				System.out.println(i + " - " + j + " = 		" + this.odleglosc_miedzy_punktami[i][j]);
			}
				
	}
	Tablica_odleglosci (Tablica_punktow tablica)
	{
		//wykorzystane do porzadkowania odleglosci miedzy punktami
		this.rozmiar_tablicy_z_parami=0;
		//
		this.odleglosc_miedzy_punktami = new double[tablica.ile_punktow][tablica.ile_punktow];
		this.rozmiar = tablica.ile_punktow;
		
		for(int i=0; i<tablica.ile_punktow; i++)
		{
			for(int j=0; j<i; j++)
			{
			this.rozmiar_tablicy_z_parami++;
			this.odleglosc_miedzy_punktami[i][j] = Math.sqrt(
			Math.pow( (tablica.tablica_punktow[i].return_X() - tablica.tablica_punktow[j].return_X() ),  2) +
			Math.pow( (tablica.tablica_punktow[i].return_Y() - tablica.tablica_punktow[j].return_Y() ),  2));
			}
		}
	}

}


public class T3 {

	public static void main(String[] args) 
	{
		/*
		 * domyslnei tworzone jest 6 punktow - w razie ptorzeby wartosc zmienic
		 */
		Tablica_punktow nowa_tablica = new Tablica_punktow(6);
		Tablica_odleglosci odleglosci = new Tablica_odleglosci (nowa_tablica);
		System.out.println(" Wygenerowane punkty: ");
		nowa_tablica.show_all_points();
		System.out.println(" ");
		nowa_tablica.find_farest_point_from_0();
		System.out.println(" ");
		nowa_tablica.find_biggest_rectangle_with_all_points();
		System.out.println(" ");
		odleglosci.wypisz_elementy_tablicy();
		System.out.println(" ");
		odleglosci.szukaj_najwiekszej_odleglosci();
		nowa_tablica.sortuj_tablice();
		System.out.println(" ");
		System.out.println(" Posortowane odleglosci od p0: ");
		nowa_tablica.show_all_points();
		System.out.println(" ");
		odleglosci.wpisz_elementy_tablicy_z_parami();
		System.out.println(" ");
		odleglosci.uporzadkuj_elementy_tablicy_z_parami();
		System.out.println("Uporzadkowane odleglosci miedzy punktami ");
		odleglosci.wypisz_elementy_tablicy_z_parami();
		
	}

}
