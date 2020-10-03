/*
  
Написати Јава програм који омогућује да се оформи низ дате димензије, 
да сви чланови низа добију унаред задату вредност 
и да се потом применом колекцијског for циклуса прикажу вредности свих 
чланова низа. 
  
*/

// Програм илуструје алокацију низа, постављање вредности за елементе низа,
// очитавање вредности за елементе низа и колекцијску for петљу. 



class PokretanjeKolekcijskiForiNizPrikazSuma {

    public static void main(String[] args) {
        double[] niz = {1, 2, 3.5, 4.4, -2.7, 1.53e-1};
        double s = 0;
        for (double d : niz) {
            System.out.printf("%8.3f ", d);
            s += d;
        }
        System.out.printf("\nSuma elemenata niza: %8.3f ", s);
    }
}
