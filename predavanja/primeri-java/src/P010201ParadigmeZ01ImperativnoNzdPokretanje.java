/*
  Програм (у виду конзолне апликације) за одређивање највећег заједничког 
  делиоца за три броја.
  Програмски код је организован као монолитна целина, у духу императвног програмирања.
  Коришћена је обележена break наредба за имитирање наредбе безусловног скока.
 */

class PokretanjeImperativnoNzd {

    // улазна тачка програма
    public static void main(String[] args) {
        // бројеви чији се НЗД тражи
        int prviBroj = 48;
        int drugiBroj = 120;
        int treciBroj = 56;

        // приказ бројева чији се НЗД тражи
        System.out.println("Први број је " + prviBroj);
        System.out.println("Други број је " + drugiBroj);
        System.out.println("Трећи број је " + treciBroj);

        // одређивање НЗД за први и други број
        nzdPrviDrugi:
        for (; ; ) {
            if (drugiBroj == 0 || prviBroj==0)
                break nzdPrviDrugi;
            // размени бројеве тако да други број буде већи од првог
            if (prviBroj > drugiBroj) {
                int privremeni = prviBroj;
                prviBroj = drugiBroj;
                drugiBroj = privremeni;
            }
            // нови пар бројева су дотадашњи мањи и разлика између већег и мањег
            drugiBroj = drugiBroj % prviBroj;
        }
        if( prviBroj == 0)
            prviBroj = drugiBroj;
        // одређивање НЗД за НЗД прва два броја и трећи број
        nzdNadPrvaDvaTreci:
        for (; ; ) {
            // ако су бројеви исти, НЗД је ма који од њих
            if (prviBroj == 0 || treciBroj == 0)
                break nzdNadPrvaDvaTreci;
            // размени бројеве тако да трећи број буде већи од првог
            if (prviBroj > treciBroj) {
                int privremeni = prviBroj;
                prviBroj = treciBroj;
            }
            // ако мањи број дели већи број, тада је мањи број НЗД
            if (treciBroj % prviBroj == 0)
                break nzdNadPrvaDvaTreci;
            // "преживљавају" мањи од два броја и остатак при дељењу између већег и мењег
            treciBroj = treciBroj % prviBroj;
        }
        if (prviBroj == 0) 
            prviBroj = treciBroj;
        // приказ резултата
        System.out.println("НЗД ова три броја је " + prviBroj);
    }

}
