import java.util.Random;

public class Algorytmy 
{
	public int FIFO(int[] tab1, int il_ramek)
	{
		int bledy=0;
		int[][] tabr = new int [il_ramek][2];
		int min, indeks_min;
		boolean czy_wystepuje=false;
		
		for(int i=0;i<il_ramek;i++)
		{
			for(int k=0;k<2;k++)
			{
				tabr[i][k]=0;
			}
		}
		
		for(int a=0;a<tab1.length;a++)
		{
			czy_wystepuje=false;
			for(int b=0;b<il_ramek && czy_wystepuje==false;b++)
			{
				if(tab1[a]==tabr[b][0])
				{
					czy_wystepuje=true;
				}
			}
			if(czy_wystepuje==false)
			{
				min=tabr[0][0]; indeks_min=0;
				for(int j=1;j<il_ramek;j++)
				{
					if(min>tabr[j][1])
					{
						min=tabr[j][1]; indeks_min=j;
					}
				}
				tabr[indeks_min][0]=tab1[a]; tabr[indeks_min][1]=a+1;
				bledy++;
			}
			
			/*for(int c=0;c<il_ramek;c++) { System.out.print(tabr[c][0] + " "); } System.out.printf(" uzywana: " + tab1[a])*/
			//System.out.println();
		}
		return bledy;
	}
	
	public int OPT(int[] tab1, int il_ramek)
	{
		int bledy=0;
		int[][] tabr = new int [il_ramek][2];
		int maks, indeks_maks, pom=0;;
		boolean czy_wystepuje=false; 
		boolean zm=false;
		
		for(int i=0;i<il_ramek;i++)
		{
			tabr[i][0]=0; tabr[i][1]=tab1.length+1;
		}
		
		for(int a=0;a<tab1.length;a++)
		{
			czy_wystepuje=false;
			for(int b=0;b<il_ramek && czy_wystepuje==false;b++) // petla sprawdza  czy dana strona znajduje sie wsrod ramek
			{													// (w tym przypadku w tablicy ramek "tabr")
				if(tab1[a]==tabr[b][0]) 
				{
					czy_wystepuje=true; pom=b;
				}
			}
			if(czy_wystepuje==false)							// jesli nie wystepuje - poszukuje najdluzej nieuzywanej ramki
			{													// i wpisuje w jej miejsce stronê z tablicy "tab1" zawierajacej ciag stron
				maks=tabr[0][1]; indeks_maks=0;		
				for(int j=1;j<il_ramek;j++)
				{
					if(maks<tabr[j][1])
					{
						maks=tabr[j][1]; indeks_maks=j;
					}
				}
				tabr[indeks_maks][0]=tab1[a]; bledy++;
				for(int j=a+1;j<tab1.length/*-1*/ && zm==false;j++) 		// szukamy kolejnego wyst¹pienia strony
				{															// 
					if(tab1[a]==tab1[j])
					{
						tabr[indeks_maks][1]=j;
						zm=true;
					}
				}
				if(zm==false)
				{
					tabr[indeks_maks][1]=tab1.length;
				}
			}
			else													// jesli potrzebna strona znajduje sie wsrod ramek
			{														// to poszukujemy jej kolejnego wystapienia by moc zamienic moment wystapienia
				for(int j=a+1;j<tab1.length && zm==false;j++)		// nastepny raz danej strony
				{
					if(tab1[a]==tab1[j])
					{
						tabr[pom][1]=j;
						zm=true;
					}
				}
				if(zm==false)
				{
					tabr[pom][1]=tab1.length;
				}
			}
			zm=false;
			/*for(int c=0;c<il_ramek;c++) { System.out.print(tabr[c][0] + "[" + tabr[c][1] + "]" + " "); } System.out.printf(" uzywana: " + tab1[a]);
			System.out.println();*/
		}
		return bledy;
	}
	
	public int RAND(int[] tab1, int il_ramek)
	{
		int bledy=0;
		int[] tabr = new int [il_ramek];
		Random gg = new Random();
		boolean czy_wystepuje;
		int los;
		
		for(int a=0;a<tab1.length;a++)
		{
			czy_wystepuje=false;
			for(int b=0;b<il_ramek && czy_wystepuje==false;b++)
			{
				if(tab1[a]==tabr[b])
				{
					czy_wystepuje=true;
				}
			}
			if(czy_wystepuje==false)
			{
				los=gg.nextInt(il_ramek);
				tabr[los]=tab1[a];
				bledy++;
			}
			/*for(int c=0;c<il_ramek;c++) { System.out.print(tabr[c] + " "); } System.out.printf(" uzywana: " + tab1[a]);
			System.out.println();*/
		}
		return bledy;
	}
	
	public int LRU (int[] tab1, int il_ramek){
		
		int bledy=0;
		long[][] tabr=new long [il_ramek][2];
		
		for (int i=0; i<il_ramek; i++){
			tabr[i][0]=tab1[i];
			tabr[i][1]=System.nanoTime();
		}
		
		for (int i=il_ramek; i<tab1.length; i++){
			boolean wystepuje=false;
			int n=0;	
			
			while(n<il_ramek && wystepuje==false){
				if(tabr[n][0]==tab1[i]){
					tabr[n][1]=System.nanoTime();
					wystepuje=true;
				}
				n++;
			}
			
			if (wystepuje==false){
				int minIndex=0;
				long min=tabr[0][1];
				
				for (int x=1; x<il_ramek; x++){
					if (tabr[x][1]<min){
						min=tabr[x][1];
						minIndex=1;
					}
				}
				
				tabr [minIndex][0]=tab1[i];
				tabr[minIndex][1]=System.nanoTime();
				bledy++;
			}
		}
		
		return bledy;
	}
	
	public int aproksymowany_LRU(int[] tab1, int il_ramek){
		int bledy=0;
		int[][] tabr=new int[il_ramek][2];
		
		for (int i=0; i<il_ramek; i++){
			tabr[i][0]=tab1[i];
			tabr[i][1]=0;
		}
		
		for (int i=il_ramek; i<tab1.length; i++){
			boolean wystepuje=false;
			int n=0;	
			
			while(n<il_ramek && wystepuje==false){
				if(tabr[n][0]==tab1[i]){
					tabr[n][1]=1;
					wystepuje=true;
				}
				n++;
			}
			
			if (wystepuje==false){
				
				while (tabr[0][1]==1){
					int temp=tabr[0][0];
					for (int x=0; x<il_ramek-1; x++){
						tabr[x][0]=tabr[x+1][0];
						tabr[x][1]=tabr[x+1][1];
					}
					tabr[il_ramek-1][0]=temp;
					tabr[il_ramek-1][1]=0;
				}
				
				tabr[0][0]=tab1[i];
				tabr[0][1]=1;
				bledy++;
			}
		}
		
		return bledy;
	}
}
