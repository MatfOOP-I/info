/*
  
Написати Јава програм који омогућује да се оформи низ дате димензије, 
да сви чланови низа добију унаред задату вредност 
и да се потом применом колекцијског for циклуса прикажу вредности свих 
чланова низа. 
  
*/

// Програм илуструје алокацију низа, постављање вредности за елементе низа,
// очитавање вредности за елементе низа и колекцијску for петљу. 

class PokretanjeKolekcijskiForiNizPrikaz {


    public static void main(String[] args) {
        int n = 0b0000_1101; //binarni broj
        double[] niz = new double[n];
        double x = 23.34e1;
        int znak = 1;
        for (int i = 0; i < niz.length; i++) {
            niz[i] = x + znak * i;
            znak = -znak;
        }
        System.out.printf("Svi elementi niza:\n");
        for (double d : niz)
            System.out.printf("%8.2f ", d);
        System.out.printf("\n");
        System.out.printf("Svi elementi niza manji od 237:\n");
        for (double d : niz) {
            if (d >= 237)
                continue;
            System.out.printf("%8.2f ", d);
        }
        System.out.printf("\n");
        System.out.printf("Elementi niza do pojave veceg od 237:\n");
        for (double d : niz) {
            if (d > 237)
                break;
            System.out.printf("%8.2f ", d);
        }
        System.out.printf("\n");
    }
}
