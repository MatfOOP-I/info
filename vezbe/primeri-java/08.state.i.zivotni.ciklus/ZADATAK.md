# Zadatak — Rezervacija bioskopske karte

[← Nedelja 8](README.md)

Modelovati rezervaciju bioskopske karte.

Rezervacija ima:

- identifikacioni broj;
- naziv filma;
- stanje.

Podržati sledeća stanja:

```text
Kreirana
Placena
Iskoriscena
Otkazana
```

Operacije:

```java
plati()
iskoristi()
otkazi()
```

## Pravila

### Kreirana

- može da se plati;
- može da se otkaže;
- ne može da se iskoristi.

### Placena

- može da se iskoristi;
- može da se otkaže;
- ne može ponovo da se plati.

### Iskoriscena

- više ne dozvoljava nijednu od tri operacije.

### Otkazana

- više ne dozvoljava nijednu od tri operacije.

## Zahtevi

Napraviti interfejs:

```java
public interface StanjeRezervacije {
    void plati(Rezervacija rezervacija);
    void iskoristi(Rezervacija rezervacija);
    void otkazi(Rezervacija rezervacija);
}
```

`Rezervacija` treba da čuva:

```java
private StanjeRezervacije stanje;
```

i da operacije delegira trenutnom stanju.

## Demonstracija

U `Main`:

1. napraviti novu rezervaciju;
2. pokušati `iskoristi()` pre plaćanja;
3. platiti;
4. pokušati ponovo da se plati;
5. iskoristiti rezervaciju;
6. pokušati otkazivanje nakon korišćenja.

## Pitanje

Zašto je ovo bolji kandidat za State nego klasa koja samo ima:

```java
private String stanje;
```

i veliki broj `if` provera?

## Samostalni deo — Da li je State potreban?

Lampica ima samo stanja uključena/isključena i operaciju promeni. Zatim razmotriti uređaj sa stanjima isključen/zagrevanje/spreman/greška i različitim dozvoljenim operacijama.

**Kriterijum provere:** Za oba modela prvo dati tabelu prelaza. Dozvoljeno je enum rešenje. Obrazložiti gde State donosi korist, a gde samo povećava broj klasa.

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
