
/*

Класа за реализацију стека који садржи ниске.

Стек се реализује преко низа. 

Стек може да расте по потреби.
 
 */

package rs.math.oop1.z100102.rukovanjeIzuzecima.z06.stekPrekoNiza;

public class StekNiskiPrekoNizaSamorastuci extends StekNiski {

    private String[] elementi;
    private int vrhSteka;

    // inicijalizacioni blok primerka
    {
        elementi = new String[1];
        vrhSteka = -1;
    }

    public void push(String elem) {
        try {
            elementi[++vrhSteka] = elem;
        } catch (ArrayIndexOutOfBoundsException exp) {
            System.out.println("Nema mesta!" + exp);
            String[] temp = elementi;
            elementi = new String[2 * temp.length];
            for (int i = 0; i < temp.length; i++)
                elementi[i] = temp[i];
            elementi[vrhSteka] = elem;
        }

    }

    public String pop() {
        if (vrhSteka == -1) {
            System.out.println("Greska POP: StekNiski je prazan!");
            return "<nema>";
        }
        return elementi[vrhSteka--];
    }

    public int brojElemenata() {
        return (vrhSteka + 1);
    }
}
