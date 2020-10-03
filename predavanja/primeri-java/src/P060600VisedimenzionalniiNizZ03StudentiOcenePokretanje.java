/*
 
 Написати Јава програм који за низ оцена студената одређује њихове просечне оцене
 по смеру и по предмету.
 
 Низ садржи оцене, а индекси су редом: ознака смера (0-7 кодира смер М Н В Р Л И АА АФ), 
 број индекса, година уписа (умањена за 2000) и ознака предмета (тј. редни број 
 предмета у списку предмета).
 
 Оцене су у опсегу 5-10. Уколико дати студент није полагао дати предмет, онада ће члан 
 низа индексиран четворком смер-година-индекс-предмет бити -1.
 
*/

// Програм илуструје рад са вишедимензионалним низовима

class PokretanjeVisedimenzionalniiNizStudentiOcene {

    public static void main(String[] args) {
        int[][][][] ocene = new int[7][200][30][15];
        // inicijalizacija ocena
        for (int i = 0; i < ocene.length; i++)
            for (int j = 0; j < ocene[i].length; j++)
                for (int k = 0; k < ocene[i][j].length; k++)
                    for (int m = 0; m < ocene[i][j][k].length; m++)
                        ocene[i][j][k][m] = -1;
        // postavljanje vrednosti za ocene studenata:
        // student M smera, indeks 17/2011 je iz predmeta 4 dobio ocenu 6
        ocene[0][17][11][4] = 6;
        // student N smera, indeks 17/2012 je iz predmeta 4 dobio ocenu 7
        ocene[1][17][12][4] = 7;
        // student N smera, indeks 17/2012 je iz predmeta 5 dobio ocenu 9
        ocene[1][17][12][5] = 9;
        // student V smera, indeks 117/2011 je iz predmeta 1 dobio ocenu 8
        ocene[2][17][11][1] = 6;
        // student R smera, indeks 25/2012 je iz predmeta 3 dobio ocenu 7
        ocene[3][25][12][3] = 7;
        // student R smera, indeks 25/2012 je iz predmeta 5 dobio ocenu 8
        ocene[3][25][12][5] = 8;
        // student R smera, indeks 25/2012 je iz predmeta 1 dobio ocenu 6
        ocene[3][25][12][1] = 6;
        // student R smera, indeks 11/2013 je iz predmeta 5 dobio ocenu 9
        ocene[3][11][13][5] = 9;
        System.out.println("Prikaz svih ocena:");
        for (int[][][] poSmeru : ocene) {
            System.out.println("============");
            for (int[][] poSmeruIndeksu : poSmeru)
                for (int[] poSmeruIndeksuGodini : poSmeruIndeksu) {
                    boolean imaOcena = false;
                    for (int ocena : poSmeruIndeksuGodini)
                        if (ocena != -1) {
                            imaOcena = true;
                            System.out.printf("%3d", ocena);
                        }
                    if (imaOcena)
                        System.out.println();
                }
        }
        System.out.println("Prikaz proseka po predmetu:");
        for (int predmet = 0; predmet < ocene[0][0][0].length; predmet++) {
            System.out.printf("Predmet %d: ", predmet);
            int brojOcena = 0;
            double sumaOcena = 0;
            for (int i = 0; i < ocene.length; i++)
                for (int j = 0; j < ocene[i].length; j++)
                    for (int k = 0; k < ocene[i][j].length; k++)
                        if (ocene[i][j][k][predmet] != -1) {
                            sumaOcena += ocene[i][j][k][predmet];
                            brojOcena++;
                        }
            if (brojOcena > 0)
                System.out.printf("prosecna ocena je %8.2f\n",
                        sumaOcena / brojOcena);
            else
                System.out.println(
                        " nema unesenih ocena za ovaj predmet");
        }
        System.out.println("Prikaz proseka po smeru:");
        for (int smer = 0; smer < ocene.length; smer++) {
            System.out.printf("Smer %d: ", smer);
            int brojOcena = 0;
            double sumaOcena = 0;
            int[][][] poSmeru = ocene[smer];
            for (int[][] poSmeruIndeksu : poSmeru)
                for (int[] poSmeruIndeksuGodini : poSmeruIndeksu)
                    for (int ocena : poSmeruIndeksuGodini)
                        if (ocena != -1) {
                            sumaOcena += ocena;
                            brojOcena++;
                        }
            if (brojOcena > 0)
                System.out.printf("prosecna ocena je %8.2f\n",
                        sumaOcena / brojOcena);
            else
                System.out.println(
                        " nema unesenih ocena za studente ovog smera");
        }
    }

}
