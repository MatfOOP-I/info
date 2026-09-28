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
System.out.println(kartica);
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
