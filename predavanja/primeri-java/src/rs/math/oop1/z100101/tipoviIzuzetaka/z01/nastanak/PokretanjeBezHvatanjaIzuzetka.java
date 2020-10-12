package rs.math.oop1.z100101.tipoviIzuzetaka.z01.nastanak;

public class PokretanjeBezHvatanjaIzuzetka {
    public static void main(String[] args) {
        int i = 11;
        int j = 0;

        System.out.println("Pocetak " + "i = " + i + " j = " + j);
        System.out.println(i / j); // Divide by 0 - exception thrown
        System.out.println("kraj");
        return;
    }
}
