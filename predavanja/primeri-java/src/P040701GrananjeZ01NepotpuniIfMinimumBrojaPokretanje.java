// Пример илуструје употребу непотпуног if израза.

/*
Задатак је пронаћи минимални од 4 понуђена броја.
 */

class PokretanjeMinimum {

    public static void main(String[] args) {
        int x = 10, y = 3, z = -353, w = -13;
        int min;

        min = x;
        if(y<min)
            min=y;
        if(z<min)
            min=z;
        if(w<min)
            min=w;

        System.out.println("Minimalni broj je "+min);
    }
}
