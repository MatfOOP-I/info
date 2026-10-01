# Zadatak — Lična biblioteka

Napraviti model za jednostavnu ličnu biblioteku.

## `ZanrKnjige`

Definisati:

```java
public enum ZanrKnjige {
    ROMAN,
    FANTASTIKA,
    ISTORIJA,
    NAUKA,
    BIOGRAFIJA,
    OSTALO
}
```

## `Knjiga`

Knjiga ima:

- ISBN;
- naslov;
- autora;
- broj strana;
- godinu izdanja;
- žanr.

Dve knjige smatramo jednakim ako imaju isti ISBN.

Zato pravilno implementirati:

```java
equals
hashCode
```

## Kolekcije

Napraviti:

### Listu za čitanje

```java
List<Knjiga>
```

Redosled je važan.

### Kolekciju knjiga koje posedujemo

```java
Set<Knjiga>
```

Ista knjiga ne treba da se pojavi dva puta.

### Katalog po ISBN-u

```java
Map<String, Knjiga>
```

Knjigu treba brzo pronaći preko ISBN-a.

## Prirodni poredak

Neka `Knjiga` implementira:

```java
Comparable<Knjiga>
```

Prirodni poredak neka bude:

Po ISBN-u, kako bi `compareTo(...) == 0` odgovaralo jednakosti po ISBN-u.

Za sortiranje po naslovu, zatim autoru i ISBN-u, napraviti poseban `Comparator`.
ISBN čuvati kao nepromenljiv podatak. Proveriti dva objekta sa istim ISBN-om
i različitim naslovom: `HashSet` i `TreeSet` sa prirodnim poretkom treba oba
da imaju jedan element. U aplikaciji bi neslaganje podataka o istom ISBN-u
bilo dodatno pravilo validacije kataloga.

## Alternativna poređenja

Napraviti:

```java
PoredjenjePoBrojuStrana
PoredjenjePoGodiniIzdanja
```

koji implementiraju:

```java
Comparator<Knjiga>
```

## Demonstracija

U `Main`:

1. napraviti najmanje pet knjiga;
2. dodati ih u listu;
3. pokušati da isti ISBN dva puta dodate u `Set`;
4. napraviti katalog pomoću `Map`;
5. pronaći knjigu po ISBN-u;
6. sortirati kopiju liste prirodnim poretkom;
7. sortirati po broju strana;
8. sortirati po godini izdanja.

## Pitanja

1. Zašto ISBN ima smisla za `equals/hashCode`?
2. Zašto naslov sam nije dovoljan?
3. Zašto lista za čitanje nije `Set`?
4. Zašto katalog prirodno koristi `Map`?
5. Koja je razlika između prirodnog poretka i poređenja po broju strana?

## Samostalni deo — Evidencija prijava

Čuvamo redosled prijavljivanja, jedinstvene indekse studenata i brzo pronalaženje prijave po indeksu. Izabrati strukture i definisati ponašanje pri duplom indeksu.

**Kriterijum provere:** Za dve prijave istog indeksa jasno pokazati odbijanje ili zamenu. Prikaz po imenu ne sme da promeni originalni red prijavljivanja.

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
