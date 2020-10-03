package rs.math.oop1.z190500.katanci.z04.saVisestrukimUlazom;

public class ReadWriteLockTest{
    public final static int THREADS = 4;
 
    public static void main(String[] args){
        ListReader[] readers = new ListReader[THREADS];
        ListWriter[] writers = new ListWriter[THREADS];
        Data data = new Data();
        Thread[] threads = new Thread[THREADS * 2];
        for (int i = 0; i < THREADS; i++){
            readers[i] = new ListReader(data);
            writers[i] = new ListWriter(data);
            threads[i] = new Thread(readers[i], "" + i);
            threads[i + THREADS] = new Thread(writers[i], "" + i);
        }
 
        for (int i = 0; i < THREADS * 2; i++){
            threads[i].start();
        }
 
        for (int i = 0; i < THREADS * 2; i++){
            try{
                threads[i].join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
 
    }
}