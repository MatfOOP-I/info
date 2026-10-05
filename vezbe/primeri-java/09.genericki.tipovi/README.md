---
permalink: "/vezbe/primeri-java/09.genericki.tipovi/"
title: "Недеља 9"
parent: "Вежбе"
nav_order: 9
nav_exclude: false
---

# Nedelja 9 — Generički tipovi

Do sada smo pravili klase koje rade sa unapred poznatim tipovima.

Na primer:

```java
class PaketTelefona {
    private Telefon sadrzaj;
}
```

Ali šta ako je ponašanje klase potpuno isto bez obzira na to da li paket sadrži:

- telefon;
- knjigu;
- patike;
- neki naš objekat?

Jedna mogućnost je da koristimo `Object`.

To radi, ali gubimo informaciju o tipu.

Generici nam omogućavaju da napišemo jednu apstrakciju koja radi za različite tipove, a da kompajler i dalje proverava ispravnost tipova.

## Glavna ideja

Generici nisu prvenstveno način da pišemo neobične izraze sa:

```text
<T>
<K, V>
<? extends T>
```

Njihov glavni cilj u ovom kursu je:

> **ponovna upotreba koda bez gubitka type safety-ja.**

---

# Ciljevi

Posle vežbi student treba da ume da:

- objasni problem čuvanja vrednosti kao `Object`;
- napravi generičku klasu;
- koristi generički tip sa različitim argumentima tipa;
- objasni da `Paket<Telefon>` i `Paket<Knjiga>` nisu isti tip;
- napiše jednostavnu generičku metodu;
- napravi generički interfejs;
- koristi ograničenje tipa, npr. `<T extends Procenjiv>`;
- razume osnovnu motivaciju za wildcard `?`;
- prepozna generike u standardnim kolekcijama koje ćemo raditi sledeće nedelje.

---

# Redosled primera

## `primer01_problem_sa_object`

Pravimo klasu:

```java
Paket
```

koja čuva:

```java
private Object sadrzaj;
```

Možemo staviti bilo koji objekat.

Problem nastaje prilikom čitanja:

```java
Telefon telefon = (Telefon) paket.getSadrzaj();
```

Potrebno je eksplicitno kastovanje.

Još gore:

```java
Knjiga knjiga = (Knjiga) paket.getSadrzaj();
```

kompajler to dozvoljava, a grešku dobijamo tek tokom izvršavanja.

## `primer02_genericka_klasa`

Uvodimo:

```java
public class Paket<T>
```

Sada:

```java
Paket<Telefon>
Paket<Knjiga>
```

koriste istu implementaciju klase, ali kompajler zna šta se nalazi u konkretnom paketu.

Dobijamo:

```java
Telefon telefon = paketTelefona.getSadrzaj();
```

bez kastovanja.

A ovo više ne može da se kompajlira:

```java
Paket<Telefon> paket = new Paket<>(...);
paket.postaviSadrzaj(new Knjiga(...));
```

Greška se otkriva **pri kompajliranju**, a ne kod korisnika programa.

## `primer03_genericka_metoda`

Nije obavezno da cela klasa bude generička.

Možemo napraviti samo jednu generičku metodu:

```java
public static <T> void prebaci(
        Paket<T> izvor,
        Paket<T> odrediste
)
```

Tip `T` se zaključuje iz argumenata.

Metoda radi i za telefone i za knjige, bez dupliranja implementacije.

## `primer04_genericki_interfejs`

Interfejs takođe može biti generički:

```java
public interface Skladiste<T>
```

Njegov ugovor kaže:

```java
void smesti(T predmet);
T preuzmi();
```

Implementacija:

```java
JednomesnoSkladiste<T>
```

ne mora unapred da zna koji će konkretan tip čuvati.

Ovo je važna priprema za:

```java
List<T>
Set<T>
Map<K, V>
```

iz standardne biblioteke.

## `primer05_ogranicenje_tipa`

Ponekad nije dovoljno reći:

```java
<T>
```

jer želimo da nad `T` možemo da pozovemo određenu operaciju.

Definišemo:

```java
public interface Procenjiv {
    int proceniVrednost();
}
```

i zatim:

```java
public class OsiguraniPaket<T extends Procenjiv>
```

Sada kompajler zna da svaki `T` ima:

```java
proceniVrednost()
```

Zato `OsiguraniPaket` može bez kastovanja da izračuna cenu osiguranja.

## `primer06_wildcard`

Ovaj primer je namerno kraći.

Generički tipovi u Javi su **invarijantni**.

To znači da, iako:

```text
Telefon IS-A Procenjiv
```

ne sledi:

```text
Paket<Telefon> IS-A Paket<Procenjiv>
```

Kada želimo metodu koja samo čita različite pakete procenjivih predmeta, možemo koristiti:

```java
Paket<? extends Procenjiv>
```

Za ovu nedelju je dovoljno razumeti motivaciju.

Detaljne kombinacije `extends` i `super` nisu cilj kursa.

---

# Zašto ne samo `Object`?

Bez generika:

```java
Object sadrzaj = ...
```

kompajler gubi preciznu informaciju o tipu.

Onda korisnik mora da zna šta je stvarno unutra i da kastuje.

Sa generikom:

```java
Paket<Telefon>
```

informacija o tipu postaje deo potpisa.

Kompajler može da proveri kod pre izvršavanja.

---

# Generici i OOP

Generici nisu zamena za polimorfizam.

Na primer:

```java
List<NacinPlacanja>
```

može da sadrži različite implementacije interfejsa `NacinPlacanja`.

Ovde istovremeno koristimo:

- generike da kažemo koji tip elemenata kolekcija prihvata;
- polimorfizam da različiti konkretni objekti mogu biti posmatrani kroz zajednički interfejs.

Ove dve ideje se veoma često koriste zajedno.

---

# Type erasure — samo napomena

Java generici su implementirani pomoću mehanizma koji se zove **type erasure**.

Za ovaj kurs nije potrebno detaljno proučavati njegovu implementaciju.

Važno je samo znati da zbog toga postoje neka ograničenja, na primer ne možemo jednostavno pisati:

```java
new T()
```

ili:

```java
new T[10]
```

Nemojte pamtiti listu ograničenja napamet. Kada naiđemo na konkretan slučaj, objasnićemo ga.

---

# Pitanja za diskusiju

1. Šta gubimo kada vrednost čuvamo kao `Object`?
2. Kada se greška pogrešnog kastovanja otkriva?
3. Šta znači `T` u `Paket<T>`?
4. Da li je `T` posebna Java ključna reč?
5. Da li su `Paket<Telefon>` i `Paket<Knjiga>` isti tip?
6. Zašto nam kod generičke klase više nije potreban cast?
7. Koja je razlika između generičke klase i generičke metode?
8. Zašto interfejs `Skladiste<T>` ima smisla?
9. Zašto `OsiguraniPaket<T>` nije dovoljan ako želi da poziva `proceniVrednost()`?
10. Šta nam garantuje `<T extends Procenjiv>`?
11. Zašto `Paket<Telefon>` nije automatski `Paket<Procenjiv>`?
12. Gde ćemo sledeće nedelje videti generike u standardnoj biblioteci?

---

# Koliko detaljno raditi wildcard?

Zbog ograničenja kursa od 13 nedelja, preporuka je:

- obavezno objasniti da generici nisu kovarijantni;
- pokazati jedan koristan primer sa `? extends`;
- pomenuti da postoji i `? super`;
- ne trošiti veliki deo dvocasa na PECS i složene potpise.

Student treba da može da **čita** osnovne wildcard potpise iz Java API-ja, ali nije cilj da postane ekspert za Java type system.

---

# Mini zadatak

U `ZADATAK.md` nalazi se primer **pametnog ormarića**.

Student treba da napravi generički `Ormaric<T>` i zatim ograničenu generičku klasu za predmete koji imaju masu.

## Ugovor skladišta

`null` označava prazno skladište, pa ga nije dozvoljeno smestiti kao predmet.
Pokušaj smeštanja u zauzeto skladište baca `IllegalStateException`, bez promene
postojećeg sadržaja. `preuzmi()` iz praznog skladišta vraća null. Politika je
eksplicitna da pozivalac ne nagađa da li je operacija uspela.
