
public class Pointer {	//odwo�ania

	int id;		//nr odwo�ania
	Process parent;		//proces, ktory je wywo�a�
	
	public Pointer(int id, Process parent){
		this.id = id;
		this.parent = parent;
	}
}
