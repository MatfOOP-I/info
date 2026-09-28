# Zadatak — Učitavanje prijavljenih studenata

Datoteka sadrži podatke u formatu:

```text
indeks,ime,prezime,broj_poena
```

Na primer:

```text
101/2025,Ana,Jovanovic,28
102/2025,Marko,Petrovic,abc
103/2025,Milica,Ilic,31
```

## Klasa `Student`

Student ima:

- indeks;
- ime;
- prezime;
- broj poena.

Broj poena mora biti u opsegu:

```text
0–100
```

## `NeispravanStudentException`

Napraviti sopstveni checked izuzetak:

```java
public class NeispravanStudentException extends Exception
```

## `ParserStudenta`

Napraviti metodu:

```java
public static Student parsiraj(String red)
        throws NeispravanStudentException
```

Metoda treba da proveri:

- da li postoje tačno 4 polja;
- da li je indeks neprazan;
- da li su ime i prezime neprazni;
- da li je broj poena broj;
- da li je broj poena između 0 i 100.

Ako red nije ispravan, baciti:

```java
NeispravanStudentException
```

## `UcitajStudente`

Napraviti metodu:

```java
public static List<Student> ucitaj(String putanja)
        throws IOException
```

Koristiti:

```java
try-with-resources
```

Za svaki red:

- pokušati parsiranje;
- ako je red neispravan, ispisati upozorenje;
- nastaviti sa sledećim redom.

Greška otvaranja/čitanja fajla treba da se prosledi pozivaocu.

## `Main`

`Main` treba da:

- pozove `ucitaj`;
- uhvati `IOException`;
- ispiše uspešno učitane studente.

## Razmisliti

1. Zašto `ParserStudenta` ne hvata sopstveni `NeispravanStudentException`?
2. Zašto `UcitajStudente` hvata grešku pojedinačnog reda?
3. Zašto `UcitajStudente` ne mora nužno da hvata `IOException`?
4. Koji nivo programa zna šta treba uraditi ako fajl uopšte ne postoji?
