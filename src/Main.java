import java.util.Random;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args)
	{
		int is, dl, n, pom;			// is-ilosc stron, dl-dlugosc ciagu stron, n-ilosc symulacji dla roznej liczby ramek
		Scanner sc = new Scanner(System.in);
		System.out.print("Podaj ilosc symulacji dla roznej liczby ramek: ");
		n=sc.nextInt();
		int[] tabn = new int[n];
		for(int i=1;i<=n;i++)
		{
			System.out.print("Podaj ilosc ramek " + i + ": ");
			tabn[i-1]=sc.nextInt();
		}
		System.out.print("Podaj ilosc stron: ");
		is=sc.nextInt();
		System.out.print("Podaj dlugosc ciagu stron: ");
		dl=sc.nextInt();
		System.out.println();
		int[] tabc = new int[dl];
		sc.close();
		Random g = new Random();
		for(int i=0;i<dl;i++)
		{
			tabc[i]=g.nextInt(is)+1;
		}
		
		Algorytmy alg=new Algorytmy();
		
		System.out.println("Algorytm FIFO:");
		for(int i=1;i<=n;i++)
		{
			pom=alg.FIFO(tabc, tabn[i-1]);
			System.out.println("Ilosc bledow dla " + tabn[i-1] + " ramek: " + pom);
		}
		System.out.println();
		
		System.out.println("Algorytm OPT:");
		for(int i=1;i<=n;i++)
		{
			pom=alg.OPT(tabc, tabn[i-1]);
			System.out.println("Ilosc bledow dla " + tabn[i-1] + " ramek: " + pom);
		}
		System.out.println();
		
		System.out.println("Algorytm LRU:");
		for(int i=1;i<=n;i++)
		{
			pom=alg.LRU(tabc, tabn[i-1]);
			System.out.println("Ilosc bledow dla " + tabn[i-1] + " ramek: " + pom);
		}
		System.out.println();
		
		System.out.println("Algorytm aproksymowany LRU:");
		for(int i=1;i<=n;i++)
		{
			pom=alg.aproksymowany_LRU(tabc, tabn[i-1]);
			System.out.println("Ilosc bledow dla " + tabn[i-1] + " ramek: " + pom);
		}
		System.out.println();
		
		System.out.println("Algorytm RAND:");
		for(int i=1;i<=n;i++)
		{
			pom=alg.RAND(tabc, tabn[i-1]);
			System.out.println("Ilosc bledow dla " + tabn[i-1] + " ramek: " + pom);
		}
		System.out.println();
	}
}
