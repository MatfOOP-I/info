# Zadatak — Navigacija i izbor rute

[← Nedelja 7](README.md)

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

## Samostalni deo — Procena trajanja puta

Navigacija bira procenu trajanja za pešačenje, bicikl i automobil. Za pozitivan broj kilometara koristiti brzine 5, 15 i 60 km/h, a rezultat zaokružiti naviše na cele minute. Nije potrebno računati put kroz graf.

**Kriterijum provere:** Za 10 km očekivati 120, 40 i 10 minuta. Isti objekat navigacije menja način procene. Obrazložiti zašto strategija vraća rezultat umesto da ga samo ispisuje.

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
