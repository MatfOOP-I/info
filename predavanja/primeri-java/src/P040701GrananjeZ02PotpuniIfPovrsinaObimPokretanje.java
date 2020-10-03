// Пример илуструје употребу потпуног if израза који омогућава разматрање свих могућих вредности посматраног услова.

class PokretanjePopuniIfPovrsinaObim {

    public static void main(String[] args) {
        double obim, povrsina;
        double pi = 3.14159265359;
        char figura = 'k';
        double x = 10;

        if (figura == 'g') {
            obim = 2 * pi * x;
            povrsina = pi * x * x;
        } else if (figura == 't') {
            obim = 4 * x;
            povrsina = x * x;
        } else {
            //izlazimo, nismo predvideli racunanje za bilo sta drugo osim za kvadrat i krug
            return;
        }
        System.out.println("Povrsina " + povrsina + ". Obim " + obim + ".");
    }
}
