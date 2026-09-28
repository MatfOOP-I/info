# Zadatak — Rezervacija bioskopske karte

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
