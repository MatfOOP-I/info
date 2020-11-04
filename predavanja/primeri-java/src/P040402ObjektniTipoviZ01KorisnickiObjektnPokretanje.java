// ObjektniTip je korisnicki definisani referentni tip koji je implicitni 
// potomak tipa Object
class ObjektniTip {

    int vrednost; // ovo je celobrojna promeljiva pridružena tipu ObjektniTip

}

class PokretanjeObjektniTip {

    public static void main(String[] args) {
        /*
         * ključna reč new pronalazi i rezerviše memoriju na kojoj će biti zapisan
         * sadržaj ovog tipa podataka. za promeljivu referentnog tipa se interno vezuje
         * adresa u kojoj se on nalazi u memoriji, nešto poput pokazivačke promenljive u
         * programskom jeziku C
         */

        // ovo je referentni (objektni) tip koji nije ugrađen u Javi, već smo ga mi
        // definisali
        ObjektniTip objektniTip = new ObjektniTip();
        objektniTip.vrednost = 4; // putem tačka notacije, može se pristupiti unutrašnjoj promenljivoj koja se
                                  // zove vrednost
        System.out.println(objektniTip.vrednost);

    }
}
