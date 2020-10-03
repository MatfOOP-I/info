package rs.math.oop1.z190500.katanci.z04.saVisestrukimUlazom;

public class ListWriter implements Runnable{
    
	private Data myData;
 
    public ListWriter(Data myData){
        this.myData = myData;
    }
 
    public void run(){
        for (int i = 0; i < 10; i++){
            myData.add(Thread.currentThread().getName() + " : " + i);
        }
    }
}