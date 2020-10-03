package rs.math.oop1.z100102.rukovanjeIzuzecima.z01.koriscenje;

public class PokretanjeTryFinally {
    public static void main(String[] args) {
        int i = 11;
        int j = 0;

        try {
            System.out.println("Try block entered " + "i = " + i + " j = " + j);
            System.out.println(i / j); // Divide by 0 - exception thrown
            System.out.println("Ending try block");
        } finally {
            System.out.println("U finally bloku smo!");
        }
        System.out.println("After try block");
        return;
    }
}
