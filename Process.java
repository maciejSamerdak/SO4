import java.util.Random;

public class Process {	//proces generuj�cy odwo�ania

	Pointer[] tasks;	//generowany ci�g odwo�a�
	int beg;	//indeks pierwszej ramki dla przydzia�u sta�ego
	int end;	//indeks ostatniej ramki dla przydzia�u sta�ego
	int errors;	//braki stron
	int pointers;	//maksymalna ilo�� odwo�a� dla przydzia�u priorytetowego

	public Process(int tasks, int pointers){
		this.tasks = new Pointer[tasks];
		Random rn = new Random();
		for (int i=0; i<tasks; i++)
			this.tasks[i]=new Pointer(rn.nextInt(pointers)+1, this);
		errors=0;
		this.pointers=pointers;
	}
}
