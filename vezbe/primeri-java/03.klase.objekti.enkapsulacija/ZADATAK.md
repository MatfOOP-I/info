# Zadatak — Poklon kartica

Napraviti klasu `PoklonKartica` koja predstavlja poklon karticu neke prodavnice.

Svaka kartica ima:

- jedinstveni celobrojni ID;
- naziv prodavnice;
- trenutno stanje u dinarima.

## Pravila

1. Nova kartica ima stanje 0 dinara.
2. Na karticu je moguće dopuniti samo pozitivan iznos.
3. Kupovina je moguća samo za pozitivan iznos koji nije veći od trenutnog stanja.
4. Stanje kartice nikada ne sme da bude negativno.
5. ID i naziv prodavnice se ne menjaju nakon kreiranja kartice.
6. Treba omogućiti da se sazna koliko je ukupno kartica kreirano.

## Predloženi javni interfejs klase

Nazivi metoda mogu biti drugačiji ako smisleno opisuju operaciju.

```java
PoklonKartica kartica = new PoklonKartica("Knjižara");

kartica.dopuni(3000);
kartica.kupi(1200);

System.out.println(kartica.getStanje());
System.out.println(kartica.opis());
```

## Razmisliti pre kodiranja

- Koja polja treba da budu `private`?
- Koja polja imaju smisla kao `final`?
- Koji podatak treba da bude `static`?
- Da li treba da postoji `setStanje`?
- Ko je odgovoran za proveru da li kupovina može da se izvrši?
- Koja je invarijanta klase `PoklonKartica`?

## Dodatak

Napisati program koji pravi dve kartice, izvršava nekoliko uspešnih i neuspešnih operacija i na kraju ispisuje obe kartice i ukupan broj kreiranih kartica.

## Granice i ugovor

`dopuni` i `kupi` vraćaju `boolean`. Neuspeh ne menja stanje. Odbiti i uplatu koja bi prešla `Integer.MAX_VALUE`; dovoljno je proveriti `iznos > Integer.MAX_VALUE - stanje` pre sabiranja. `opis()` vraća čitljiv tekst; standardni `toString()` upoznajemo u nedelji 5.

## Samostalni deo — Rezervoar

Rezervoar ima zadat kapacitet i trenutno količinu 0. Dozvoljeni su dopuna i potrošnja pozitivne količine. Nemoguća operacija se odbija bez delimične promene. Samostalno odrediti javni API.

**Kriterijum provere:** Kapacitet 10: dopuna 8 uspeva; dopuna 3 ne uspeva i ostaje 8; potrošnja 8 uspeva i ostaje 0. Koja polja su final?

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
