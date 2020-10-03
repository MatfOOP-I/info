// Пример илуструје употребу витичастих заграда за дефинисање опсега важења променљиивих.

class PokretanjePromenljiveOpsegVazenja {
    int x; //promenljiva klase

    public static void main(String[] args) {
        int x = 5; //lokalna promenljiva main metode - nije u sukobu sa promenljivom klase
        {
            //int x = 13;
            // nije dozvoljeno kreirati novu promenljivu sa istim imenom ako je ona u opsegu vazenja prethodne promenljive
            int y = 10;
            System.out.println(x); //5
            System.out.println(y); //10
        }
        System.out.println(x); //5
        //System.out.println(y);
        // y nije u opsegu vazenja
        {
            int y = 14; //dve istoiemne promenljive u dva nepreklapajuca opsega su dozvoljene
            System.out.println(y); //14
            x=10;
        }
        System.out.println(x); //10
    }
}
