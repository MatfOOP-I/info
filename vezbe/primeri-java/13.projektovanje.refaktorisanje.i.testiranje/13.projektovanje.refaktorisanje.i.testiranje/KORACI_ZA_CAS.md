# Predlog rada na času — 2 × 45 minuta

Ovaj dokument je namerno napisan kao niz tačaka za diskusiju.

Studenti treba prvo da pokušaju da predlože rešenje.

---

# Prvi blok — 45 minuta

## 0–10 min — pokrenuti početni kod

Otvoriti:

```text
primer01_pocetni_kod
```

Pokrenuti `Main`.

Program radi.

Postaviti pitanje:

> Šta vam ovde smeta, ako išta?

Ne sugerisati odmah pattern.

Zatim najaviti nove zahteve:

1. dodajemo električni trotinet;
2. dodajemo vikend obračun;
3. dodajemo stanje `KASNJENJE`;
4. želimo da testiramo cenu bez pravljenja celog sistema.

Pitati:

> Koje fajlove bismo morali da menjamo?

---

## 10–22 min — Vozilo: od type code-a ka polimorfizmu

Početni kod:

```java
if (vozilo.getTip().equals("AUTOMOBIL")) {
    ...
}
```

Pitanje:

> Da li je automobil samo vrednost polja ili stvarno posebna vrsta vozila?

Preći na:

```text
Vozilo
├── Automobil
└── Bicikl
```

Pokazati:

```java
public abstract int izracunajDepozit();
```

Diskusija:

- IS-A;
- zajedničko stanje u baznoj klasi;
- različito ponašanje u podklasama;
- sistem više ne koristi `if` po tipu.

---

## 22–35 min — obračun cene

Početni kod:

```java
if (tipObracuna.equals("STANDARDNI")) {
    ...
} else if (...) {
    ...
}
```

Pitanje:

> Da li je članski obračun nova vrsta rezervacije?

Ne.

To je promenljiv način ponašanja.

Studenti bi sada već trebalo da prepoznaju:

```java
NacinObracunaCene
```

Povezati sa Strategy nedeljom.

Pokazati kako se dodaje nova strategija bez izmene `Rezervacija`.

---

## 35–45 min — enkapsulacija

Uporediti:

```java
vozilo.setDostupno(false);
```

sa:

```java
vozilo.rezervisi();
```

Pitanje:

> Koji oblik bolje izražava nameru?

Pokazati da model sada štiti invarijantu:

```text
već rezervisano vozilo ne može ponovo da se rezerviše
```

---

# Drugi blok — 45 minuta

## 0–15 min — status i State

Početni kod:

```java
if (!status.equals("KREIRANA")) {
    ...
}
```

Nabrojati operacije:

```text
preuzmi
vrati
otkazi
```

i stanja:

```text
KREIRANA
AKTIVNA
ZAVRSENA
OTKAZANA
```

Nacrtati malu tabelu dozvoljenih operacija.

Pitanje:

> Gde ova pravila treba da žive?

Preći na `StanjeRezervacije`.

Posebno pokazati:

```java
stanje.preuzmi(this);
```

i tranziciju:

```java
rezervacija.postaviStanje(new AktivnoStanje());
```

---

## 15–25 min — SistemIznajmljivanja posle refaktorisanja

Pogledati servis.

Pitati:

> Šta je ostalo njegova odgovornost?

Odgovor približno:

- registracija vozila;
- pronalaženje vozila;
- kreiranje rezervacije;
- čuvanje kolekcije rezervacija.

On više ne treba da zna:

- kako se računa depozit;
- kako se računa cena;
- koje su dozvoljene tranzicije.

---

## 25–38 min — testiranje

Otvoriti:

```text
primer03_testiranje
```

Prvo:

```java
testStandardnogObracuna()
```

Objasniti:

```text
Arrange / priprema
Act / akcija
Assert / provera
```

Zatim životni ciklus rezervacije.

Važna diskusija:

> Zašto nam za ove testove ne treba JavaFX?

Povezati sa nedeljom 12.

---

## 38–45 min — završna diskusija

Postaviti nekoliko pitanja bez kodiranja:

### Zahtev 1

Dodaj:

```text
ElektricniTrotinet
```

Šta menjamo?

### Zahtev 2

Dodaj:

```text
VikendObracun
```

Šta menjamo?

### Zahtev 3

Promeni prikaz cene iz dinara u evre.

Da li treba menjati `Vozilo`?

### Zahtev 4

Čuvaj rezervacije u datoteku.

Da li `Rezervacija` treba sama da otvara fajl?

---

# Završno pitanje

Na tabli napisati:

```text
IS-A
HAS-A
Strategy
State
encapsulation
polymorphism
collections
exceptions
testing
```

i pitati:

> Koji od ovih pojmova ste upotrebili zato što ih je zadatak tražio,
> a koji zato što rešavaju konkretan problem u dizajnu?

Poželjni odgovor:

> Nijedan pattern ne treba koristiti samo zato što ga znamo.
