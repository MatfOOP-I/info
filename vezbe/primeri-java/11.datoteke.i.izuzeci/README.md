# Nedelja 11 — Datoteke i izuzeci

[Pokretanje](POKRETANJE.md) · [Plan za 90 minuta](KORACI_ZA_CAS.md) · [Zadatak](ZADATAK.md)

**Na času biramo obavezne primere iz plana; ostali su dodatni materijal.**

Ove nedelje spajamo dve teme koje prirodno pripadaju zajedno:

- rad sa datotekama;
- obradu grešaka pomoću izuzetaka.

Umesto da `try/catch` učimo na veštačkim primerima, koristimo realan problem:

> učitati podatke iz datoteke, proveriti ih i odlučiti šta raditi kada nešto nije ispravno.

Glavni domen je spisak rezervacija putovanja.

Jedan red fajla izgleda ovako:

```text
ime,prezime,godine,destinacija
```

Na primer:

```text
Ana,Jovanovic,22,Rim
Marko,Petrovic,abc,Pariz
Milica,Ilic,31,Atina
```

Drugi red sadrži grešku: `abc` nije broj godina.

---

# Ciljevi

Posle vežbi student treba da ume da:

- čita tekstualnu datoteku red po red;
- razume zašto rad sa fajlovima može da proizvede greške koje ne možemo unapred sprečiti;
- koristi `try/catch`;
- razume razliku između hvatanja i prosleđivanja izuzetka;
- koristi `throws`;
- napravi sopstveni izuzetak za grešku domena;
- koristi `try-with-resources`;
- razume zašto resurs poput fajla treba pouzdano zatvoriti;
- razlikuje tehničku grešku od greške u sadržaju podataka;
- donese odluku da li neispravan red treba preskočiti ili prekinuti ceo proces.

---

# Redosled primera

## `primer01_citanje_fajla`

Prvo samo čitamo fajl:

```java
BufferedReader
FileReader
readLine()
```

Cilj nije da učimo celu `java.io` biblioteku.

Dovoljno je razumeti:

```text
otvori fajl
čitaj red po red
zatvori fajl
```

Odmah se pojavljuje pitanje:

> Šta ako fajl ne postoji?

## `primer02_try_catch`

Otvaranje i čitanje fajla može da baci `IOException`.

Koristimo:

```java
try {
    ...
} catch (IOException e) {
    ...
}
```

Poenta nije "uhvati sve".

Poenta je:

> Ovaj deo programa zna kako da reaguje na konkretnu grešku.

## `primer03_parsiranje_i_vise_gresaka`

Sada čitamo CSV red i pretvaramo:

```text
godine
```

u `int`.

Možemo dobiti različite probleme:

- `IOException` — problem sa fajlom;
- `NumberFormatException` — podatak nije broj;
- pogrešan broj polja — loš format reda.

To su različite greške i ne moraju sve da se tretiraju isto.

## `primer04_sopstveni_izuzetak`

Uvodi se:

```java
NeispravanRedException
```

Zašto?

Zato što želimo da kod koji parsira rezervaciju kaže:

> Ovaj red ne predstavlja ispravnu rezervaciju.

To je preciznije od generičkog `Exception`.

Metoda:

```java
Rezervacija parsiraj(String red)
```

može da ima:

```java
throws NeispravanRedException
```

Time jasno komunicira deo svog ugovora.

## `primer05_try_with_resources`

Ručno zatvaranje:

```java
reader.close();
```

je lako zaboraviti, naročito ako se između otvaranja i zatvaranja desi izuzetak.

Zato koristimo:

```java
try (BufferedReader reader = ...) {
    ...
}
```

Resurs se zatvara automatski.

Ovo je preferirani način za resurse koji implementiraju `AutoCloseable`.

## `primer06_odgovornost_za_gresku`

Najvažniji primer.

Metoda koja parsira jedan red:

```java
parsira red
```

ne mora da odlučuje:

```text
da li da prekine ceo program
da li da preskoči red
da li da prikaže upozorenje
```

To je odluka višeg nivoa.

Na primer:

```java
UcitajRezervacije
```

može da odluči:

> neispravan red preskačemo, ali nastavljamo sa ostatkom fajla.

Ovde se lepo vidi razdvajanje odgovornosti.

---

# Tehničke i domenske greške

Koristan mentalni model:

## Tehnička greška

Primeri:

```text
fajl ne postoji
nema dozvole za čitanje
disk problem
```

Tipično dolaze iz biblioteke, npr. `IOException`.

## Domenska greška

Primeri:

```text
godine su negativne
nedostaje destinacija
red nema očekivani broj kolona
```

To su pravila našeg programa.

Za njih često ima smisla sopstveni izuzetak:

```java
NeispravanRedException
```

---

# `throw` i `throws`

## `throw`

Zaista bacamo objekat izuzetka:

```java
throw new NeispravanRedException("...");
```

## `throws`

U potpisu metode najavljujemo da metoda može da prosledi određeni izuzetak:

```java
public static Rezervacija parsiraj(String red)
        throws NeispravanRedException
```

Ove dve stvari ne treba mešati.

---

# Checked i unchecked izuzeci

Java razlikuje dve velike grupe.

## Checked

Primer:

```java
IOException
```

Kompajler zahteva da ga:

- uhvatimo;
- ili prosledimo pomoću `throws`.

## Unchecked

Primer:

```java
NumberFormatException
IllegalArgumentException
NullPointerException
```

Kompajler nas ne tera da ih navedemo u potpisu.

Za ovaj kurs nije cilj da pamtimo čitavu hijerarhiju izuzetaka.

Važno je razumeti:

> ko može da popravi problem i na kom nivou ga treba obraditi.

---

# Zašto ne `catch (Exception e)` svuda?

Zato što takav `catch` često sakrije razliku između potpuno različitih problema.

Bolje je da kod jasno govori:

```java
catch (IOException e)
```

ili:

```java
catch (NeispravanRedException e)
```

kada zaista znamo šta sa tim problemom treba uraditi.

Široki `catch (Exception e)` ponekad ima smisla na granicama aplikacije, ali nije dobar podrazumevani stil za poslovnu logiku.

---

# `finally`

`finally` treba objasniti jer je deo jezika:

```java
try {
    ...
} finally {
    ...
}
```

Kod iz `finally` bloka se izvršava bez obzira na to da li je došlo do izuzetka.

Ali za zatvaranje fajlova danas ćemo uglavnom koristiti:

```java
try-with-resources
```

jer je bezbednije i čitljivije.

---

# Pitanja za diskusiju

1. Zašto metoda za čitanje fajla može da ne uspe iako je naš kod ispravan?
2. Koja je razlika između `throw` i `throws`?
3. Kada ima smisla da metoda uhvati izuzetak, a kada da ga prosledi?
4. Zašto `NumberFormatException` ne moramo da navedemo u `throws`?
5. Zašto sopstveni `NeispravanRedException` može biti bolji od običnog `Exception`?
6. Da li parser jednog reda treba da odlučuje da li se prekida ceo program?
7. Ko treba da odluči da li se neispravan red preskače?
8. Zašto je `try-with-resources` bolji od ručnog `close()`?
9. Šta se dešava sa resursom ako se izuzetak desi usred `try` bloka?
10. Zašto nije dobro svuda koristiti `catch (Exception e)`?
11. Da li svaka neispravna vrednost mora da se modeluje izuzetkom?
12. Kada je običan `if` bolji od bacanja izuzetka?

---

# Šta namerno NE radimo detaljno

Zbog ograničenja kursa ne ulazimo duboko u:

- `FileInputStream` i binarne fajlove;
- serijalizaciju Java objekata;
- `ObjectInputStream`;
- `RandomAccessFile`;
- celu hijerarhiju `java.nio`;
- kompleksne strategije retry mehanizama.

Student treba da izađe sa jasnim modelom:

```text
fajl je resurs
čitanje može da ne uspe
greške imaju tip
odgovornost za obradu greške pripada odgovarajućem nivou programa
```

---

# Mini zadatak

U `ZADATAK.md` nalazi se učitavanje spiska prijavljenih studenata iz fajla.

Zadatak kombinuje:

- čitanje fajla;
- parsiranje;
- sopstveni izuzetak;
- preskakanje loših redova;
- kolekciju iz prethodne nedelje.

## Dopune: upis, format i assert

`primer07_pisanje` odvaja učitavanje od pisanja tekstualnog izveštaja. Radni
direktorijum je folder projekta, ne folder klase. Ulaz i izlaz koriste UTF-8.
Završni parser zadržava sve provere iz prethodnog primera. `split(",", -1)`
čuva završna prazna polja; ovo nije pun CSV parser (nema quoting/escaping podrške).

`primer08_assert` pokazuje internu tvrdnju i pokretanje sa `-ea`. Tvrdnje nisu
zamena za validaciju javnih argumenata jer mogu biti isključene. Eksplicitno bačen
AssertionError u proverama iz nedelje 13 ne zavisi od tog prekidača.
