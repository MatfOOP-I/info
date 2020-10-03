//Пример илуструје употребу switch наредбе када је условна променљива примитивног типа.

/*
Задатак је на основу задате целобројне променљиве извршити одговарајућу математичку функцију и исписати њену вредност.
 */

class PokretanjeSwitchOdabirFunkcije {

    public static void main(String[] args) {
        double f;
        int i = 3;
        double x = 2;

        switch (i) {
            case 0:
                f = Math.sin(x);
                break;
            case 1:
                f = Math.sqrt(x) + Math.cos(x);
                break;
            case 2:
                f = Math.exp(x);
                break;
            case 3:
                f = Math.sin(x);
                break;
            default: //podrazumevana mogucnost ukoliko i nije iz skupa vrednosti {0,1,2,3}
                f = x;
                break;
        }

        System.out.println("Vrednost funkcije je "+f);
    }
}
