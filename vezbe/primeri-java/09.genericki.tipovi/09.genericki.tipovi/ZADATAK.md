# Zadatak — Pametni ormarić

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
