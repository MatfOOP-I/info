package primer02_setter_nije_enkapsulacija;

public class Main {
    public static void main(String[] args) {
        Novcanik novcanik = new Novcanik("Ana");

        novcanik.setStanje(2_000);
        System.out.println(novcanik.getStanje());

        // Polje jeste private, ali problem iz prvog primera nije nestao.
        novcanik.setStanje(-50_000);
        System.out.println(novcanik.getStanje());
    }
}
