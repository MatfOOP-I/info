# Nedelja 13 — Projektovanje, refaktorisanje i testiranje

Ovo je završna nedelja kursa.

Ne uvodimo novi veliki Java API niti novi design pattern.

Cilj je da pogledamo program koji **radi**, ali je teško proširiv i testabilan, i da postavimo pitanje:

> Kako bismo ovaj program projektovali sada, posle celog kursa?

Glavni domen je sistem za iznajmljivanje vozila.

Domen je namerno jednostavan:

- postoje korisnici;
- postoje vozila;
- vozilo može da se rezerviše;
- rezervacija se preuzima, vraća ili otkazuje;
- cena može da se računa na različite načine.

---

# Struktura materijala

```text
primer01_pocetni_kod/
    program koji radi, ali ima probleme u dizajnu

primer02_refaktorisano_resenje/
    isti problem nakon postepenog OOP refaktorisanja

primer03_testiranje/
    mali testovi modela bez spoljne biblioteke
```

Uz kod postoje:

```text
KORACI_ZA_CAS.md
ZADATAK.md
```

---

# Važna pravila za ovaj čas

## Nemojte odmah otvoriti gotovo rešenje

Poenta nije da studenti prepišu konačnu arhitekturu.

Prvo pokrenuti `primer01_pocetni_kod`.

Zatim pitati:

> Šta će ovde postati problem ako zahtevamo novu funkcionalnost?

Tek nakon razgovora prelaziti na refaktorisano rešenje.

## Ne tražimo pattern po svaku cenu

Nije pitanje:

> Gde možemo da ubacimo Strategy?

Nego:

> Koji deo ponašanja se menja nezavisno od ostatka sistema?

Ako odgovor prirodno vodi ka Strategy-ju, onda ga koristimo.

Isto važi za State, nasleđivanje i kompoziciju.

---

# Početni zahtev

Sistem podržava:

```text
AUTOMOBIL
BICIKL
```

Cena rezervacije može biti:

```text
STANDARDNA
CLANSKA
```

Rezervacija ima status:

```text
KREIRANA
AKTIVNA
ZAVRSENA
OTKAZANA
```

Početni kod sve ovo predstavlja pomoću `String` vrednosti.

Program radi.

Ali zatim tražimo:

1. dodajte električni trotinet;
2. dodajte novi način obračuna cene;
3. zabranite nedozvoljene tranzicije rezervacije;
4. omogućite testiranje obračuna bez pokretanja celog sistema.

Tu počinju problemi.

---

# Šta treba da prepoznamo u početnom kodu?

## 1. Objekti su uglavnom skup get/set metoda

`Vozilo` ima:

```java
setDostupno(...)
```

Bilo koji deo programa može proizvoljno da promeni stanje vozila.

Bolje pitanje je:

> Koje operacije vozilo zaista treba da dozvoli?

Na primer:

```java
rezervisi()
oslobodi()
```

---

## 2. Vrsta vozila je `String`

Početni kod ima:

```java
if (vozilo.getTip().equals("AUTOMOBIL")) {
    ...
} else if (vozilo.getTip().equals("BICIKL")) {
    ...
}
```

Svaki novi tip vozila zahteva menjanje postojećeg grananja.

U refaktorisanom rešenju koristimo:

```text
Vozilo
├── Automobil
└── Bicikl
```

Ovde odnos ima smisla:

```text
Automobil IS-A Vozilo
Bicikl    IS-A Vozilo
```

Svako vozilo samo zna kako računa svoj depozit.

---

## 3. Način obračuna cene je `String`

Početni kod ima:

```java
if (tipObracuna.equals("STANDARDNI")) {
    ...
} else if (tipObracuna.equals("CLANSKI")) {
    ...
}
```

Ovo ponašanje se menja nezavisno od samog vozila.

U refaktorisanom kodu:

```java
NacinObracunaCene
├── StandardniObracun
└── ClanskiObracun
```

`Rezervacija HAS-A NacinObracunaCene`.

To je Strategy iz nedelje 7.

---

## 4. Status rezervacije je `String`

Početni kod ima provere poput:

```java
if (!rezervacija.getStatus().equals("KREIRANA")) {
    ...
}
```

Kako broj stanja i operacija raste, pravila se rasipaju kroz servis.

U refaktorisanom kodu:

```java
Rezervacija HAS-A StanjeRezervacije
```

sa stanjima:

```text
KreiranoStanje
AktivnoStanje
ZavrsenoStanje
OtkazanoStanje
```

To je State iz nedelje 8.

---

## 5. Jedna klasa zna previše

Početni `SistemIznajmljivanja`:

- pronalazi vozilo;
- računa cenu;
- računa depozit;
- proverava status;
- menja stanje rezervacije;
- menja dostupnost vozila.

Posle refaktorisanja odgovornosti se raspoređuju.

---

# Refaktorisano rešenje

Struktura je:

```text
model/
    Korisnik
    Vozilo
    Automobil
    Bicikl
    Rezervacija

obracun/
    NacinObracunaCene
    StandardniObracun
    ClanskiObracun

stanje/
    StanjeRezervacije
    KreiranoStanje
    AktivnoStanje
    ZavrsenoStanje
    OtkazanoStanje
    NedozvoljenaOperacijaException

servis/
    SistemIznajmljivanja
    RezervacijaException
```

---

# Koje teme kursa se vraćaju?

## Enkapsulacija i invarijante

`Vozilo` više nema:

```java
setDostupno(boolean)
```

nego:

```java
rezervisi()
oslobodi()
```

Objekat čuva svoje stanje.

## IS-A

```text
Automobil IS-A Vozilo
Bicikl IS-A Vozilo
```

## HAS-A

```text
Rezervacija HAS-A Korisnik
Rezervacija HAS-A Vozilo
Rezervacija HAS-A NacinObracunaCene
Rezervacija HAS-A StanjeRezervacije
```

## Polimorfizam

Sistem radi sa:

```java
Vozilo
```

bez pitanja koja je konkretna podklasa.

## Strategy

Cena se delegira:

```java
nacinObracuna.izracunaj(vozilo, brojDana)
```

## State

Rezervacija delegira:

```java
stanje.preuzmi(this)
stanje.vrati(this)
stanje.otkazi(this)
```

## Kolekcije

Sistem koristi:

```java
Map<String, Vozilo>
List<Rezervacija>
```

Map ima smisla jer vozilo pronalazimo preko jedinstvene oznake.

## `equals/hashCode`

`Vozilo` je jednako drugom vozilu sa istom oznakom.

`Korisnik` je jednak korisniku sa istim članskim brojem.

## Izuzeci

Neuspešna rezervacija je domenski problem:

```java
RezervacijaException
```

Nedozvoljena tranzicija stanja je:

```java
NedozvoljenaOperacijaException
```

---

# Testiranje

Treći primer ne uvodi JUnit zavisnost.

Koristimo malu pomoćnu klasu:

```java
Provera
```

i obične Java metode:

```java
testStandardnogObracuna()
testClanskogObracuna()
testZivotnogCiklusa()
testZauzetogVozila()
```

Cilj je da studenti vide strukturu testa:

```text
1. priprema
2. akcija
3. provera
```

Na primer:

```java
Automobil automobil = ...;

int cena = obracun.izracunaj(automobil, 2);

Provera.jednako(10000, cena);
```

U profesionalnom Java projektu isti princip se najčešće piše pomoću biblioteke kao što je JUnit.

Ove nedelje nam je važnija ideja testiranja nego nova biblioteka i njeno podešavanje.

---

# Zašto je testiranje dobar završetak kursa?

Zato što pokazuje praktičnu posledicu dobrog dizajna.

Možemo zasebno testirati:

```text
obračun cene
životni ciklus rezervacije
pravila dostupnosti vozila
```

bez:

- JavaFX-a;
- datoteka;
- korisničkog unosa;
- pokretanja cele aplikacije.

To je direktna posledica odvajanja odgovornosti.

---

# Dobar dizajn nije "više klasa"

Refaktorisano rešenje ima više klasa od početnog.

To samo po sebi nije dokaz da je bolje.

Pitanje je:

> Da li svaka klasa ima jasnu odgovornost i da li promene ostaju lokalizovane?

Na primer, dodavanje:

```text
ElektricniTrotinet
```

ne treba da zahteva promenu `SistemIznajmljivanja`.

Dodavanje:

```text
VikendObracun
```

ne treba da zahteva promenu `Rezervacija`.

---

# Kada NE treba ovako?

Za program od 30 linija možda bi početni dizajn bio sasvim dovoljan.

OOP dizajn ima cenu:

- više tipova;
- više fajlova;
- više apstrakcija.

Apstrakciju treba uvoditi kada rešava konkretan problem promene, odgovornosti ili testabilnosti.

To je važnije od pravila:

> "uvek koristi pattern X".

---

# Predlog toka dvocasa

Detaljan tok je u:

```text
KORACI_ZA_CAS.md
```

Grubo:

## Prvih 45 minuta

- pokrenuti početni kod;
- studenti identifikuju probleme;
- refaktorisati `Vozilo`;
- refaktorisati obračun cene.

## Drugih 45 minuta

- refaktorisati status u State;
- pogledati konačni servis i kolekcije;
- napisati 2–3 mala testa;
- završna diskusija o trade-off-ima.

---

# Završna poruka kursa

Na početku kursa pitanje je bilo:

> Kako se u Javi piše klasa?

Na kraju kursa pitanje treba da bude:

> Koji objekat treba da bude odgovoran za ovo ponašanje?

To je mnogo važnija promena od učenja pojedinačne Java sintakse.
