package primer03_enum_i_switch;

public class Main {
    public static void main(String[] args) {
        Porudzbina porudzbina = new Porudzbina(1042);

        porudzbina.posalji();
        porudzbina.plati();
        porudzbina.posalji();

        System.out.println(porudzbina.getStatus());
    }
}
