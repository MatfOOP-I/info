// Програм илуструје декларисање и иницијализацију и доделу вредности различитим типовима литерала.

class PokretanjeLiterali {

    public static void main(String[] args) {
        // celobrojni literali
        byte ceoByte = 34;
        int ceoInt = -100000;
        // postoje jos 3 celobrojna tipa podataka: byte, short i long

        // realni literali
        float realniFloat = 34.35f;
        double realniDouble = 35.565;

        // logicki literali
        boolean logickiTacno = true;

        // znakovni literali
        char znak1 = 'B';
        System.out.println(znak1);
        char znak2 = '\n';
        System.out.println(znak2);
        char znak3 = '\uu0042';
        System.out.println(znak3);

        // stringovni literali
        String niska = "Ovo je niska-literal.";
        System.out.println(niska);
    }
}
