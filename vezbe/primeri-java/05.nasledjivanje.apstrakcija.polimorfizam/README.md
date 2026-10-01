# Nedelja 5 — Nasleđivanje, apstraktne klase i polimorfizam

[Pokretanje](POKRETANJE.md) · [Plan za 90 minuta](KORACI_ZA_CAS.md) · [Zadatak](ZADATAK.md)

**Na času biramo obavezne primere iz plana; ostali su dodatni materijal.**

Prethodne nedelje smo videli da se objekti veoma često povezuju odnosom **HAS-A**. Sada uvodimo drugi važan odnos:

> Kada za jedan objekat ima smisla reći da **JESTE** posebna vrsta drugog objekta?

Glavni primer je izbor načina prevoza za putovanje. Autobus, voz i taksi imaju zajedničke osobine, ali istu operaciju — računanje cene — mogu da izvršavaju različito.

## Ciljevi

Posle vežbi student treba da ume da objasni:

- šta znači odnos **IS-A**;
- osnovnu sintaksu `extends`;
- šta se nasleđuje od bazne klase;
- čemu služi `super(...)`;
- šta znači redefinisanje (`@Override`) metode;
- zašto referenca baznog tipa može da pokazuje na objekat izvedene klase;
- šta je dinamičko vezivanje poziva metode;
- čemu služe apstraktna klasa i apstraktna metoda;
- kako polimorfizam uklanja potrebu za grananjem po konkretnom tipu objekta;
- da se nasleđivanje i kompozicija često koriste zajedno.

## Važna ideja

Nasleđivanje ne koristimo zato što dve klase "imaju neka ista polja".

Pitanje je:

> Da li objekat izvedene klase stvarno može da se koristi svuda gde očekujemo objekat bazne klase?

U našem primeru:

```text
Autobus IS-A Prevoz
Voz     IS-A Prevoz
Taksi   IS-A Prevoz
```

Ali:

```text
RezervacijaPrevoza HAS-A Prevoz
```

## Redosled primera

### `primer01_osnovno_nasledjivanje`

Uvodimo baznu klasu `Prevoz` i klase `Autobus` i `Voz`.

Zajedničke podatke (`naziv`, `prosecnaBrzina`) držimo u baznoj klasi. Izvedene klase koriste konstruktor bazne klase pomoću `super(...)`.

### `primer02_redefinisanje_metoda`

Različite vrste prevoza različito računaju cenu putovanja.

Sve klase imaju metodu istog potpisa:

```java
int izracunajCenu(int udaljenostKm)
```

ali je implementacija različita.

### `primer03_apstraktna_klasa`

Primećujemo da ne postoji mnogo smisla praviti "neki opšti Prevoz" ako ne znamo kako mu se računa cena.

`Prevoz` zato postaje `abstract`, a `izracunajCenu` apstraktna metoda.

### `primer04_polimorfizam`

Pravimo niz:

```java
Prevoz[] opcije
```

u kome se nalaze `Autobus`, `Voz` i `Taksi`.

U petlji pozivamo:

```java
opcije[i].izracunajCenu(udaljenostKm)
```

bez pitanja koje je konkretne klase objekat.

### `primer05_bez_grananja_po_tipu`

Namerno pokazujemo zašto kod tipa:

```java
if (prevoz instanceof Autobus) { ... }
else if (prevoz instanceof Voz) { ... }
else if (prevoz instanceof Taksi) { ... }
```

često znači da nismo iskoristili polimorfizam.

Dodavanje nove vrste prevoza ne treba da zahteva menjanje svakog mesta u programu koje računa cenu.

### `primer06_rezervacija_prevoza`

Završni primer spaja prethodne dve nedelje:

```text
Autobus IS-A Prevoz
Taksi   IS-A Prevoz

RezervacijaPrevoza HAS-A Putnik
RezervacijaPrevoza HAS-A Relacija
RezervacijaPrevoza HAS-A Prevoz
```

Ovo je važna poruka: **kompozicija i nasleđivanje nisu konkurentske tehnike**. U realnom modelu često postoje istovremeno.

## Centralne poruke

### Nasleđivanje modeluje tip, ne samo ponovnu upotrebu koda

Loš razlog:

> "Obe klase imaju naziv i cenu, hajde da jedna nasledi drugu."

Bolje pitanje:

> "Da li je objekat izvedene klase stvarno jedna posebna vrsta baznog pojma?"

### Polimorfizam je korisniji od proveravanja tipa

Želimo:

```java
int cena = prevoz.izracunajCenu(udaljenostKm);
```

umesto da ostatak programa zna sve konkretne klase koje postoje.

### Bazni tip predstavlja zajednički ugovor ponašanja

Ako metoda prima `Prevoz`, ona može da radi sa bilo kojom postojećom ili budućom vrstom prevoza koja poštuje taj ugovor.

## Pitanja za diskusiju

1. Da li je `Autobus` posebna vrsta `Prevoz`?
2. Da li bi `Putnik extends Prevoz` imao smisla samo zato što putnik koristi prevoz?
3. Zašto konstruktor izvedene klase poziva `super(...)`?
4. Koja implementacija metode se poziva ako promenljiva ima tip `Prevoz`, a objekat je `Taksi`?
5. Da li konkretan tip reference ili konkretan tip objekta određuje redefinisanu metodu koja će biti pozvana?
6. Zašto `Prevoz` može da bude apstraktna klasa?
7. Može li se napraviti `new Prevoz(...)` ako je `Prevoz` apstraktan?
8. Šta dobijamo time što metoda prima `Prevoz`, umesto posebno `Autobus`, `Voz` i `Taksi`?
9. Zašto veliki `instanceof` lanac često predstavlja signal za drugačiji dizajn?
10. Kako završni primer istovremeno koristi i IS-A i HAS-A?

## Mali zadatak

U fajlu `ZADATAK.md` nalazi se model ulaznica za događaj. Zadatak traži legitimnu hijerarhiju, redefinisanje obračuna cene i polimorfnu obradu više različitih vrsta ulaznica.

## Overloading, overriding i toString

Pokrenuti `primer07_overload_override.Main`. Različiti potpisi iste metode daju
overloading; izbor se zasniva na tipovima izraza pri kompajliranju. Override iste
instance metode bira implementaciju prema stvarnom objektu pri izvršavanju.
`protected` u primeru dopušta podklasi u drugom paketu da pozove nasleđenu metodu;
ne čini je javnom svim klijentima. Pravila pristupa kroz reference u drugom paketu
imaju dodatna ograničenja i nisu isto što i public.

`toString()` je metoda Object-a. `println(objekat)` koristi njen tekst; naše ranije
`opis()` metode bile su obične domenske metode, bez tog automatskog povezivanja.
