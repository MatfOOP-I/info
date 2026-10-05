---
permalink: "/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/"
title: "Недеља 10"
parent: "Вежбе"
nav_order: 10
nav_exclude: false
---

# Nedelja 10 — Kolekcije, jednakost i poređenje

Ove nedelje spajamo nekoliko tema koje su tesno povezane:

- `List`;
- `Set`;
- `Map`;
- `equals` i `hashCode`;
- `Comparable`;
- `Comparator`.

Glavni domen su **pesme i playliste**.

Ideja nije da napamet naučimo veliki broj klasa iz Java biblioteke, već da naučimo da postavimo pitanje:

> Kakvu kolekciju podataka zapravo želim da modelujem?

---

# Ciljevi

Posle vežbi student treba da ume da:

- objasni osnovnu razliku između `List`, `Set` i `Map`;
- izabere odgovarajuću kolekciju prema semantici problema;
- koristi `ArrayList`, `HashSet` i `HashMap`;
- objasni zašto `HashSet` i `HashMap` zavise od `equals` i `hashCode`;
- razlikuje identitet objekta od semantičke jednakosti;
- pravilno implementira ugovor `equals/hashCode`;
- definiše prirodni poredak pomoću `Comparable`;
- definiše alternativne poretke pomoću `Comparator`;
- prepozna `Comparator` kao praktičan primer Strategy obrasca;
- koristi `enum` kao prirodan tip za konačan skup vrednosti.

---

# `enum Zanr`

U primerima koristimo:

```java
public enum Zanr {
    POP,
    ROCK,
    JAZZ,
    KLASICNA,
    ELEKTRONSKA,
    OSTALO
}
```

`enum` koristimo kada imamo **konačan, poznat skup vrednosti**.

To je bolje od:

```java
String zanr;
```

jer kompajler može da spreči vrednosti poput:

```text
"rok"
"Rock"
"ROCKK"
```

`enum` je pravi Java tip i može:

- da se koristi kao tip polja;
- da se prosleđuje metodama;
- da bude ključ u kolekcijama;
- da se poredi sa `==`.

---

# Redosled primera

## `primer01_lista`

Pravimo playlistu pomoću:

```java
List<Pesma> plejlista = new ArrayList<>();
```

`List` koristimo kada su važni:

- redosled;
- pozicija elementa;
- mogućnost da isti element postoji više puta.

U playlisti duplikati mogu da postoje.

To nije greška `List`-e, već njena semantika.

Važno je primetiti i stil:

```java
List<Pesma> plejlista = new ArrayList<>();
```

Promenljiva je tipa interfejsa `List`, a konkretna implementacija je `ArrayList`.

Ovo je ista ideja programiranja prema ugovoru koju smo već videli kod sopstvenih interfejsa.

## `primer02_skup_bez_jednakosti`

Želimo kolekciju omiljenih pesama bez duplikata.

Prirodno pokušavamo:

```java
Set<Pesma> omiljene = new HashSet<>();
```

Dodamo dva različita Java objekta koji predstavljaju istu pesmu.

Bez redefinisanog `equals/hashCode`, `HashSet` ih smatra različitim.

Zašto?

Podrazumevana jednakost objekata se praktično oslanja na njihov identitet.

Domen, međutim, možda kaže:

> pesme sa istim izvođačem i naslovom smatramo istom pesmom.

## `primer03_equals_i_hashcode`

Implementiramo semantičku jednakost:

```java
@Override
public boolean equals(Object objekat)
```

i povezani:

```java
@Override
public int hashCode()
```

Važan ugovor:

> Ako su dva objekta jednaka po `equals`, moraju imati isti `hashCode`.

Obrnuto ne mora da važi.

Dva različita objekta mogu imati isti hash kod.

## `primer04_mapa`

Koristimo:

```java
Map<String, Pesma>
```

za katalog u kome je ključ jedinstvena šifra pesme.

`Map` modeluje vezu:

```text
ključ → vrednost
```

Ključ je jedinstven.

Poziv:

```java
mapa.put(istiKljuc, novaVrednost)
```

zamenjuje prethodnu vrednost za taj ključ.

Tipični slučajevi:

- šifra proizvoda → proizvod;
- korisničko ime → korisnik;
- registarska oznaka → vozilo;
- indeks → student.

## `primer05_comparable`

Nekim objektima želimo da damo jedan **prirodan poredak**.

`Pesma` implementira:

```java
Comparable<Pesma>
```

i definiše:

```java
compareTo(...)
```

U primeru prirodni poredak je:

1. naslov;
2. izvođač.

To omogućava:

```java
Collections.sort(pesme);
```

i korišćenje uređenih kolekcija poput:

```java
TreeSet<Pesma>
```

Važno:

Prirodni poredak treba birati samo kada postoji jedan razuman podrazumevani poredak.

## `primer06_comparator`

Jedan prirodni poredak nije dovoljan.

Istu playlistu nekad želimo da sortiramo:

- po trajanju;
- po izvođaču;
- po naslovu.

Ne želimo da menjamo klasu `Pesma` svaki put.

Zato koristimo:

```java
Comparator<Pesma>
```

i konkretne implementacije:

```text
PoredjenjePoTrajanju
PoredjenjePoIzvodjacu
```

Ovo je odličan primer Strategy obrasca iz standardne Java biblioteke:

```text
Comparator<Pesma> = strategija poređenja
```

Algoritam sortiranja ostaje isti, a način poređenja menjamo.

---

# List, Set ili Map?

## `List`

Koristimo kada je važan uređeni niz elemenata:

```text
red pesama
lista obaveza
istorija poruka
```

Dozvoljava duplikate.

## `Set`

Koristimo kada želimo kolekciju jedinstvenih elemenata:

```text
omiljene pesme
prisutni studenti
posećene države
```

Pitanje "šta znači jedinstven?" vodi nas do `equals/hashCode`.

## `Map`

Koristimo kada podatak prirodno pronalazimo po ključu:

```text
indeks → student
šifra → proizvod
korisničko ime → nalog
```

`Map` nije "lista sa dva podatka".

Ključ ima posebnu semantiku.

---

# Zašto su `equals` i `hashCode` OOP tema?

Zato što klasa sama treba da zna:

> Kada dva moja objekta predstavljaju istu stvar u domenu?

Na primer:

```text
Pesma("Numb", "Linkin Park")
Pesma("Numb", "Linkin Park")
```

To su dva različita Java objekta.

Ali možemo odlučiti da predstavljaju istu pesmu.

To je odluka modela, ne odluka `HashSet` klase.

---

# `==` i `equals`

Za objekte:

```java
a == b
```

pita da li obe reference pokazuju na isti objekat.

```java
a.equals(b)
```

pita da li ih klasa smatra semantički jednakim.

Ove dve stvari ne treba mešati.

---

# Ugovor `equals/hashCode`

Najvažnija praktična pravila:

1. Ako `a.equals(b)` vraća `true`, onda `a.hashCode()` i `b.hashCode()` moraju biti isti.
2. Polja koja učestvuju u `equals` treba dosledno da učestvuju i u `hashCode`.
3. Ne treba menjati polja koja određuju jednakost dok je objekat ključ u hash kolekciji.

Treća tačka je naprednija, ali je korisno pomenuti zašto su nepromenljivi identifikacioni podaci često dobra ideja.

---

# `Comparable` ili `Comparator`?

## Comparable

Klasa kaže:

> Ovo je moj prirodni poredak.

```java
class Pesma implements Comparable<Pesma>
```

## Comparator

Spoljni objekat kaže:

> Evo jednog mogućeg načina poređenja dve pesme.

```java
class PoredjenjePoTrajanju implements Comparator<Pesma>
```

Koristimo Comparator kada:

- imamo više smislenih poredaka;
- ne želimo da menjamo samu klasu;
- pravilo poređenja pripada konkretnom slučaju upotrebe.

---

# Pitanja za diskusiju

1. Zašto plejlista prirodno treba da bude `List`, a ne `Set`?
2. Da li `List` garantuje jedinstvenost elemenata?
3. Zašto `HashSet` u drugom primeru dozvoljava dve "iste" pesme?
4. Koja je razlika između `==` i `equals`?
5. Ko treba da definiše semantičku jednakost klase `Pesma`?
6. Zašto uz `equals` implementiramo i `hashCode`?
7. Da li isti `hashCode` znači da su objekti jednaki?
8. Šta se dešava kada `Map.put` dobije ključ koji već postoji?
9. Zašto deklarisati `List<Pesma>`, a praviti `new ArrayList<>()`?
10. Koji poredak bi trebalo da bude prirodni poredak pesme?
11. Zašto trajanje nije nužno dobar prirodni poredak?
12. Kako `Comparator` liči na Strategy iz nedelje 7?
13. Zašto `TreeSet` mora da zna kako da poredi elemente?
14. Kada biste izabrali `Set`, a kada `Map`?

---

# Šta namerno NE radimo detaljno

Zbog ograničenja na 13 nedelja ne pravimo katalog svih implementacija:

```text
ArrayList
LinkedList
HashSet
TreeSet
LinkedHashSet
HashMap
TreeMap
LinkedHashMap
...
```

Student treba da zna glavne apstrakcije:

```text
List
Set
Map
```

i nekoliko najčešćih implementacija.

Ostale može da nauči kada mu konkretan problem zahteva drugačije osobine.

Isto tako, ne ulazimo duboko u internu implementaciju hash tabela.

Dovoljno je razumeti ugovor koji kolekcija očekuje od naših objekata.

---

# Mini zadatak

U `ZADATAK.md` nalazi se model lične biblioteke knjiga.

Student treba da upotrebi:

- `List`;
- `Set`;
- `Map`;
- `equals/hashCode`;
- `Comparable`;
- najmanje dva `Comparator` objekta;
- `enum`.

Time u jednom zadatku povezuje sve teme ove nedelje.

## Jednakost i poredak moraju da se razmotre zajedno

Kod Pesma jednakost i prirodni poredak koriste naslov i izvođača; trajanje je
izostavljeno iz jednakosti po odluci ovog pojednostavljenog domena. Tu odluku
zadržavamo i u primeru sa Comparator-om.

`TreeSet` smatra dva elementa istim ako poređenje daje 0. Comparator koji poredi
samo trajanje dobar je za sortiranje liste, ali ne za skup svih različitih pesama.
To demonstrira `primer08_ugovori_skupova`. HashSet/HashMap ne obećavaju redosled
obilaska. Ne menjati polja koja određuju jednakost dok je objekat u hash kolekciji.

Za obilazak mape koristiti `entrySet()`. Brisanje tokom obilaska raditi preko
Iterator.remove ili, posle uvoda u lambda izraze, removeIf; ne menjati listu običnim
remove pozivom usred enhanced-for petlje. Kolekcije i iteratore šire pratiti uz predavanja.

## Most do JavaFX-a

U `primer07_lambda` isti Comparator pišemo imenovanom klasom, anonimnom klasom i
lambdom. Funkcionalni interfejs ima jednu apstraktnu operaciju (uz pravila o Object
metodama). U JavaFX-u handler je callback: registrujemo ponašanje koje će se pozvati
kasnije, kada se desi događaj. Detaljan Stream API nije preduslov ovog niza vežbi.
