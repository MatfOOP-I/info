// Програм илуструје запис целобројних литерала у различитим бројевним основама. 

class PokretanjeCeoBrojZapis {

    public static void main(String[] args) {
        int dekadniBroj = 2_000_000_000;
        // podrazumevana osnova broja je dekadna
        // ali je broj moguće zapisati i binarno, oktalno ili hehsadekadno
        int binarniBroj = 0b0001_0111; // binarni broj 10111
        int oktalniBroj = 0363; // oktalni broj
        int heksadekadniBroj = 0xF_fA; // heksadekadni broj

        // podrazumevani ispis je u dekadnoj osnovi, tako da je rezultat ispisa broj 23
        System.out.println(binarniBroj);
        // međutim, moguće je broj zapisati i u heksadekadnoj ili oktalnoj osnovi
        // npr. u heksadekdanoj
        System.out.println(String.format("%x", dekadniBroj));
        // ili u oktalnoj
        System.out.println(String.format("%o", heksadekadniBroj));
    }
}
