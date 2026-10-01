# Nedelja 6 — Interfejsi i ugovori

[Pokretanje](POKRETANJE.md) · [Plan za 90 minuta](KORACI_ZA_CAS.md) · [Zadatak](ZADATAK.md)

**Na času biramo obavezne primere iz plana; ostali su dodatni materijal.**

Prethodne nedelje smo videli da nasleđivanje koristimo kada modelujemo odnos **IS-A**:

```text
Taksi IS-A Prevoz
Voz   IS-A Prevoz
```

Sada uvodimo drugi način apstrakcije.

Često nas ne zanima **šta objekat jeste**, već samo:

> Koju sposobnost objekat garantuje da ima?

Glavni primer ove nedelje je plaćanje. Kasir ili kupovina ne treba da znaju da li korisnik plaća gotovinom, karticom ili digitalnim novčanikom. Njima je dovoljan ugovor:

```java
interface NacinPlacanja {
    boolean plati(int iznos);
}
```

## Ciljevi

Posle vežbi student treba da ume da objasni:

- šta je interfejs i zašto predstavlja **ugovor**;
- razliku između `extends` i `implements`;
- zašto promenljiva interfejsnog tipa može da pokazuje na različite konkretne objekte;
- kako se polimorfizam koristi i preko interfejsa;
- zašto klasa često treba da zavisi od interfejsa, a ne od konkretne implementacije;
- da jedna klasa može da implementira više nezavisnih interfejsa;
- kada nam više odgovara apstraktna klasa, a kada interfejs;
- da se nasleđivanje, interfejsi i kompozicija mogu koristiti zajedno.

## Važna ideja

Interfejs ne treba posmatrati samo kao:

> "Klasa u kojoj metode nemaju implementaciju."

Mnogo korisniji mentalni model je:

> **Interfejs opisuje šta korisnik nekog objekta sme da očekuje od njega.**

Ako `Kasa` radi sa tipom `NacinPlacanja`, ona zna da postoji metoda:

```java
boolean plati(int iznos)
```

ali ne mora da zna **kako** se konkretno plaćanje izvršava.

## Redosled primera

### `primer01_prvi_interfejs`

Uvodimo:

```java
NacinPlacanja
```

i dve implementacije:

```text
PlacanjeGotovinom
PlacanjeKarticom
```

Prvi put koristimo `implements`.

Važno je primetiti da promenljiva tipa `NacinPlacanja` može da pokazuje na objekat bilo koje klase koja poštuje taj ugovor.

### `primer02_kasa_zavisi_od_ugovora`

Pravimo klasu `Kasa`.

Lošiji dizajn bi bio:

```java
private PlacanjeKarticom placanje;
```

jer bi kasa tada bila vezana baš za jednu konkretnu implementaciju.

Umesto toga:

```java
private NacinPlacanja nacinPlacanja;
```

Kasa zavisi od **ugovora**, a ne od konkretne klase.

Ovde ponovo koristimo kompoziciju i delegiranje:

```text
Kasa HAS-A NacinPlacanja
```

i:

```java
nacinPlacanja.plati(iznos);
```

### `primer03_vise_interfejsa`

Uvodimo drugu, nezavisnu sposobnost:

```java
Dopunjiv
```

`DigitalniNovcanik` je istovremeno:

```text
NacinPlacanja
Dopunjiv
```

Ovo je važna razlika u odnosu na nasleđivanje.

Objekat može da poštuje više različitih ugovora koji opisuju različite njegove sposobnosti.

### `primer04_podrazumevana_metoda`

Pokazujemo `default` metodu na malom primeru.

Interfejs može da ponudi zajedničko ponašanje koje implementacije mogu da koriste, ali centralna ideja interfejsa i dalje ostaje **ugovor**, a ne deljenje stanja.

### `primer05_apstraktna_klasa_i_interfejs`

Spajamo gradivo prethodne i ove nedelje.

Imamo:

```text
DebitnaKartica IS-A PlatnaKartica
DebitnaKartica IMPLEMENTS NacinPlacanja
```

Apstraktna klasa `PlatnaKartica` čuva zajedničko **stanje i identitet** kartica.

Interfejs `NacinPlacanja` opisuje **sposobnost** koju kartica nudi ostatku programa.

To nisu konkurentski mehanizmi. Odgovaraju na različita pitanja.

### `primer06_promena_nacina_placanja`

Završni primer ponovo koristi `Kasa`, ali sada način plaćanja možemo da promenimo tokom rada programa.

```java
kasa.postaviNacinPlacanja(new PlacanjeGotovinom(...));
kasa.naplati(...);

kasa.postaviNacinPlacanja(new DigitalniNovcanik(...));
kasa.naplati(...);
```

Za sada ovo posmatramo samo kao prirodnu posledicu rada preko interfejsa.

Sledeće nedelje ćemo videti situaciju u kojoj će **zamenljiva ponašanja** postati centralna ideja dizajna.

## Interfejs ili apstraktna klasa?

Nema pravila koje se može svesti samo na sintaksu.

Dobro početno pitanje je:

### Da li modelujemo zajedničku vrstu objekta?

Na primer:

```text
DebitnaKartica IS-A PlatnaKartica
```

Tu apstraktna klasa može imati smisla, posebno ako postoje zajednička polja i implementacija.

### Ili modelujemo sposobnost/ugovor?

Na primer:

```text
DigitalniNovcanik može da plaća.
DebitnaKartica može da plaća.
PoklonKartica može da plaća.
```

Ovi objekti ne moraju da pripadaju istoj prirodnoj hijerarhiji.

Ali svi mogu da implementiraju:

```java
NacinPlacanja
```

## Centralne poruke

### Programiramo prema ugovoru

Klasa koja koristi plaćanje ne treba da zna sve konkretne vrste plaćanja.

Želimo:

```java
private NacinPlacanja nacinPlacanja;
```

umesto:

```java
private PlacanjeKarticom placanjeKarticom;
```

ako nam je jedino važno da objekat ume da izvrši plaćanje.

### Interfejs omogućava polimorfizam

Isto kao kod bazne klase, poziv:

```java
nacinPlacanja.plati(iznos);
```

završava u konkretnoj implementaciji objekta.

### Jedna klasa može imati više sposobnosti

Nasleđivanje gradi jednu hijerarhiju tipova.

Interfejsi omogućavaju da jedan objekat poštuje više nezavisnih ugovora.

## Pitanja za diskusiju

1. Da li se može napraviti `new NacinPlacanja()`?
2. Šta klasa obećava kada napiše `implements NacinPlacanja`?
3. Ko određuje koja će se implementacija `plati` pozvati?
4. Zašto `Kasa` ima polje tipa `NacinPlacanja`, a ne `PlacanjeKarticom`?
5. Šta bismo morali da promenimo u `Kasa` klasi ako dodamo potpuno novi način plaćanja?
6. Da li `DigitalniNovcanik IS-A NacinPlacanja` opisuje istu vrstu odnosa kao `Taksi IS-A Prevoz`?
7. Zašto jedan objekat može da implementira i `NacinPlacanja` i `Dopunjiv`?
8. Kada bi zajedničko stanje bilo razlog da uvedemo apstraktnu klasu?
9. Može li klasa istovremeno da nasledi jednu klasu i implementira interfejs?
10. Kako završni primer priprema teren za zamenljiva ponašanja?

## Mali zadatak

U fajlu `ZADATAK.md` nalazi se sistem obaveštavanja. Zadatak traži da različiti kanali obaveštavanja poštuju isti ugovor, a da klasa `Podsetnik` ne zavisi ni od jedne konkretne implementacije.

## Precizan ugovor i ugnježdeni tipovi

Za sve načine plaćanja u primerima: iznos mora biti pozitivan; `false` znači da
plaćanje nije izvršeno i da sredstva ostaju ista; `true` znači da je iznos oduzet.
Interfejs treba dokumentovati kroz ova obećanja, ne samo kroz potpis metode.

`primer07_ugnjezdene_klase` poredi static nested, inner, lokalnu i anonimnu klasu.
Na času je obavezna razlika static/inner, a ostale pročitati pre nedelje 10.
Ovo znanje se vraća u nedelji 13: privatne ugnježdene klase skrivaju detalje State-a.
