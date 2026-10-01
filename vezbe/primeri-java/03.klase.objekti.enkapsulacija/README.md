# Nedelja 3 — Klase, objekti i enkapsulacija

[Pokretanje](POKRETANJE.md) · [Plan za 90 minuta](KORACI_ZA_CAS.md) · [Zadatak](ZADATAK.md)

**Na času biramo obavezne primere iz plana; ostali su dodatni materijal.**

Ove nedelje prvi put prelazimo sa programa koji prvenstveno obrađuje podatke na program u kome **objekti čuvaju stanje i nude operacije nad tim stanjem**.

Glavni primer je jednostavan digitalni novčanik. Novac predstavljamo celim brojem dinara (`int`) da se ne bismo bavili problemima zaokruživanja realnih brojeva — tema primera je objektno-orijentisani dizajn, ne finansijski softver.

## Ciljevi

Posle vežbi student treba da ume da objasni:

- razliku između klase i objekta;
- šta predstavlja stanje objekta;
- zašto javna polja omogućavaju da objekat završi u neispravnom stanju;
- zašto `private` polja + automatski getteri/setteri **nisu sama po sebi dobra enkapsulacija**;
- šta je invarijanta objekta;
- zašto je često bolje ponuditi operaciju (`uplati`, `plati`) nego setter (`setStanje`);
- čemu služe konstruktor i `this`;
- razliku između članova objekta i `static` članova klase;
- osnovnu upotrebu `final` polja;
- da promenljiva klasnog tipa sadrži referencu na objekat;
- da Java argumente uvek prosleđuje po vrednosti — kod objekata se kopira vrednost reference.

## Redosled primera

### `primer01_javna_polja`

Namerno loš početni model. Pokazuje da korisnik klase može direktno da postavi nemoguće stanje, npr. negativan iznos novca.

### `primer02_setter_nije_enkapsulacija`

Polja postaju `private`, ali uvodimo `setStanje`. Problem praktično ostaje isti. Primer služi da razdvojimo pojmove **sakrivanje podataka** i **enkapsulacija**.

### `primer03_invarijante`

Objekat više nema `setStanje`. Stanje se menja kroz smislene operacije `uplati` i `plati`. Klasa sama čuva svoju invarijantu: stanje novčanika nikada nije negativno.

### `primer04_konstruktori_static_final`

Model dobija identitet. Svaki novčanik ima jedinstveni ID koji se dodeljuje pomoću zajedničkog `static` brojača. ID i vlasnik su `final`, dok je stanje promenljivo.

### `primer05_reference`

Dve promenljive mogu pokazivati na isti objekat. Primer takođe demonstrira da promena samog objekta iz metode ostaje vidljiva pozivaocu, ali prevezivanje lokalnog parametra na drugi objekat ne menja promenljivu pozivaoca.

## Centralna poruka

`private` nije cilj sam po sebi.

Dobra klasa treba da odredi **koje operacije imaju smisla nad njenim stanjem** i da spreči da objekat završi u stanju koje nema smisla u domenu problema.

Umesto:

```java
novcanik.setStanje(-5000);
```

želimo API koji govori jezikom problema:

```java
novcanik.uplati(2000);
novcanik.plati(750);
```

## Pitanja za diskusiju

1. Da li klasa sa svim `private` poljima automatski ima dobru enkapsulaciju?
2. Zašto `setStanje` nije dobra operacija za digitalni novčanik?
3. Ko treba da proveri da li na novčaniku ima dovoljno sredstava — pozivalac ili sam `Novcanik`?
4. Da li svaki podatak mora da ima getter?
5. Da li svaki podatak mora da ima setter?
6. Šta bi se desilo kada bi `stanje` bilo `final`?
7. Zašto `sledeciId` treba da bude `static`, a `id` ne treba?
8. Ako dve promenljive pokazuju na isti objekat, koliko objekata postoji?
9. Kada prosledimo `Novcanik` metodi, da li Java prosleđuje objekat „po referenci“?

## Mali zadatak

Na kraju direktorijuma nalazi se `ZADATAK.md`. Zadatak koristi isti skup ideja, ali drugi domen, kako bi student morao sam da prepozna invarijante i smislen API klase.

## Paketi i vidljivost

Pokrenuti `primer06_paketi.Main`. `package` daje puno ime tipu, a `import` skraćuje
pisanje imena. Podpaket nije isti paket: `a` i `a.b` imaju odvojene granice pristupa.
`private` član vidi njegova klasa (uz pravila pristupa ugnježdenih tipova), član bez
modifikatora vidi isti paket, a `public` je javni API. `protected` detaljnije radimo
uz nasleđivanje. `final` referenca ne garantuje da je objekat na koji pokazuje nepromenljiv.

Provera `iznos > Integer.MAX_VALUE - stanje` sprečava prekoračenje pre sabiranja.
Odbijanje operacije ne sme delimično da promeni objekat.
