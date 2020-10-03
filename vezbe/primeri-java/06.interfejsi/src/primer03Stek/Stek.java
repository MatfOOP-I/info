package primer03Stek;

public interface Stek {
	// Skida element sa vrha steka i vraca ga.
    public int pop();
    
    // Postavlja element 'x' na vrh steka.
    public void push(int x);
    
    // Vraca kopiju elementa koji je na vrhu steka.
    public int top();
    
    // Prikazuje sadrzaj steka na standardnom izlazu.
    public void show();
    
    // Vraca broj elemenata na steku. 
    public int size();
}
