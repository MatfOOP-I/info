# Zadatak — Navigacija i izbor rute

Potrebno je napraviti jednostavan model navigacije.

Navigacija treba da podrži različite načine računanja rute:

- automobilom;
- peške;
- biciklom.

Definisati interfejs:

```java
public interface NacinRutiranja {
    void izracunajRutu(String polaziste, String odrediste);
}
```

Napraviti implementacije:

```text
AutomobilskaRuta
PesackaRuta
BiciklistickaRuta
```

Za potrebe zadatka nije potrebno računati pravu rutu.

Dovoljno je da svaka implementacija ispiše drugačiju poruku.

Na primer:

```text
Računam najbržu automobilsku rutu od Beograda do Novog Sada.
```

## Klasa `Navigacija`

Treba da ima:

```java
private NacinRutiranja nacinRutiranja;
```

i da računanje rute delegira tom objektu.

Omogućiti:

```java
postaviNacinRutiranja(...)
```

kako bi korisnik mogao da promeni način rutiranja tokom rada.

## Demonstracija

U `Main`:

1. napraviti navigaciju koja računa automobilsku rutu;
2. izračunati rutu;
3. promeniti strategiju na pešačku;
4. ponovo izračunati rutu;
5. promeniti strategiju na biciklističku.

## Dodatak

Dodati novu strategiju:

```text
RutaJavnimPrevozom
```

bez izmene klase `Navigacija`.

Razmisliti:

- zašto `Navigacija` ne treba da ima veliki `if` ili `switch`;
- šta je ovde strategija;
- šta je konkretna strategija;
- gde je kompozicija;
- gde je delegiranje;
- zašto promena strategije ne menja identitet objekta `Navigacija`.
