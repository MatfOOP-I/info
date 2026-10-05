# Zadatak — Pametni ormarić

[← Nedelja 9](README.md)

Potrebno je napraviti generičku klasu:

```java
public class Ormaric<T>
```

Ormarić ima:

- broj ormarića;
- sadržaj tipa `T`.

Treba da omogući:

```java
smesti(T predmet)
T preuzmi()
boolean jePrazan()
```

U jedan ormarić može da se smesti samo jedan predmet.

## Demonstracija

Napraviti klase:

```text
Ranac
Laptop
```

i zatim:

```java
Ormaric<Ranac>
Ormaric<Laptop>
```

Pokazati da:

```java
Ormaric<Laptop>
```

ne dozvoljava da se u njega smesti `Ranac`.

---

# Dodatak — ograničenje tipa

Definisati interfejs:

```java
public interface ImaMasu {
    double masa();
}
```

Neka ga implementiraju:

```text
Ranac
Laptop
```

Zatim napraviti:

```java
public class OrmaricSaVagom<T extends ImaMasu>
```

koji pored standardnih operacija može da vrati:

```java
double trenutnaMasa()
```

Razmisliti:

1. Zašto običan `Ormaric<T>` ne može da pozove `masa()`?
2. Šta kompajler zna kada napišemo `<T extends ImaMasu>`?
3. Zašto je ovo bolje od kastovanja na `ImaMasu` unutar klase?

## Precizan ugovor

`null` nije dozvoljen predmet. Smeštanje u zauzet ormarić baca `IllegalStateException` i ne menja sadržaj. Smeštanje `null` baca `IllegalArgumentException`. Preuzimanje iz praznog ormarića vraća `null`. Masa praznog ormarića je 0; masa predmeta mora biti nenegativna. Kratku sintaksu bacanja izuzetka koristimo kao ugovor, a obradu detaljno radimo u nedelji 11.

## Samostalni deo — Dve vrednosti

Potrebno je čuvati par vrednosti različitih tipova i čitati svaku bez kastovanja. Sami oblikujte API.

**Kriterijum provere:** Pokazati par String/Integer i par String/String. Dodavanje broja na mesto teksta treba da bude greška kompajliranja; objasniti politiku prema null.

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
