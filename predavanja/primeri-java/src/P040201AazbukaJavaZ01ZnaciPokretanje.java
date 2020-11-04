// Програм илуструје валидну азбуку језика Јава. 

class PokretanjeJavaAzbuka {

    public static void main(String[] args) {
        // brojevi su validni elementi azbuke Java jezika
        int n = 2353;

        /*
         * dozvoljena je upotreba UNICODE slova kako u nazivima promenljivih tako i u
         * njihovim vrednostima, komentarima, itd.
         */
        String rečenica = "Ipak, ne-ASCII slova nisu poželjna u nazivima promenljivih.";
        System.out.println(rečenica);
        String реченица = "Ovako nešto je još gore! Тј. зависи од УГЛА ГЛЕДАЊА";
        System.out.println(реченица);
        String recenica = "Ovako je bolje.";
        System.out.println(recenica);
        String kombinovanaPisma = "Могу се mešati različita pisma, односно алфабети."
                + "Ово је нпр. нешто на тајландском: บางสิ่งบางอย่าง.";
        System.out.println(kombinovanaPisma);
        String บางสิ่งบางอย่าง = "AAA";
        System.out.println(บางสิ่งบางอย่าง);
    }
}
