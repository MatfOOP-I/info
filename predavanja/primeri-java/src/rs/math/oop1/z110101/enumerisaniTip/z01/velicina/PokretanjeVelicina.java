package rs.math.oop1.z110101.enumerisaniTip.z01.velicina;

enum Velicina {XS, S, M, L, XL, XXL, XXXL}

public class PokretanjeVelicina {
    public static void main(String[] args) {

        Velicina v = Velicina.L;
        System.out.println(v);
        System.out.println(v.ordinal());
        v = Velicina.M;
        System.out.println(v);
        System.out.println(v.ordinal());
    }
}
