// Програм илуструје валидно и препоручено именовање идентификатора. 

class PokretanjeIdentifikatori {

    public static void main(String[] args) {
        int NekiIdentifikator; // identifikator može početi velikim slovom
        int nekiIdentifikator; // ili malim slovom
        int _nekiIdentifikator; // ili donjom crtom
        int $nekiIdentifikator; // ili znakom za dolar

        // int 4nijeIndetifikator;
        // ne može početi brojem ili nekim drugim znakom
        // int nije Identifikator;
        // ne može imati prazno mesto, crticu, ampersend,
        // zarez, tačku, itd.

        int indetifikator4; // broj na ovoj poziciji jeste dozvoljen
        int iDenTIfikator; // dozvoljene su kombinacije malih i velikih slova

        // Java je osetljiva na veličinu slova, pa Identifikator, identifikator i
        // iDenTIfikator nisu ista promenljiva
        int НијеПрепоручљивииденТификатор;
        // i ne-ASCII karakteri su dozvoljeni, ali se ne preporučuju!
        int NijePreporucljiviIdentifikator;
        // nije preporučljivo da identifikator počinje velikim slovom
        int nijepreporucljiviidentifikator;
        // preporučljivo je početna slova svake naredne reči napisati velikim slovom
        int jestePreporucljiviIdentifikator;
        // zbog čitljivosti koda
        int xyz123;
        // nije preporučljivo ovako imenovati identikator, jer ne govori ništa o
        // njegovoj upotrebi
        int precnik, obim; // ovako je bolje

    }
}
