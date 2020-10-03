// Пример који илуструје различите намене блокова.

class PokretanjeBlok {
    // telo klase je blok

    public static void main(String[] args) {
        //telo metode je takodje blok

        {   //praznaNaredba suvisnog bloka koji nema nikakvu namenu
            // program bi se isto ponasao i da nema ove viticaste zagrade

            int x; x=5;
            if (x < 10) {
                // blok za if granu
                int y = x++;
                System.out.println(y);
            }
            System.out.println(x);
        }

        {} //jos jedan suvisan blok - java kompajler se ne buni
    }
}

