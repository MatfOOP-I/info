---
permalink: "/vezbe/primeri-java/08.state.i.zivotni.ciklus/"
title: "Недеља 8"
parent: "Вежбе"
nav_order: 8
nav_exclude: false
---

# Nedelja 8 — State i životni ciklus objekta

Prethodne nedelje smo videli Strategy:

> objekat koristi zamenljivo ponašanje koje možemo da promenimo.

Sada razmatramo drugačiji problem:

> ponašanje objekta zavisi od njegovog trenutnog stanja.

Glavni primer je porudžbina.

Porudžbina prolazi kroz životni ciklus:

```text
NOVA → PLACENA → POSLATA → ISPORUCENA
  \        \
   \        → OTKAZANA
    → OTKAZANA
```

Nisu sve operacije dozvoljene u svakom stanju.

Na primer:

- nova porudžbina može da se plati;
- plaćena može da se pošalje;
- poslata može da se označi kao isporučena;
- isporučena ne može ponovo da se plati;
- otkazana više ne može da nastavi normalan tok.

## Ciljevi

Posle vežbi student treba da ume da:

- razlikuje **identitet objekta** od njegovog trenutnog stanja;
- prepozna problem kada podklase predstavljaju prolazna stanja istog objekta;
- objasni zašto `if/switch` nad stanjem može da postane problem kada ponašanje raste;
- modeluje stanje kao poseban objekat;
- delegira operacije trenutnom state objektu;
- razume osnovnu ideju State obrasca;
- uporedi State i Strategy;
- razume da State nije automatski bolji od jednostavnog `enum + switch` rešenja.

---

# Redosled primera

## `primer01_stanje_kao_podklasa`

Prvo pokušavamo da modelujemo:

```text
Porudzbina
├── NovaPorudzbina
├── PlacenaPorudzbina
└── PoslataPorudzbina
```

To na prvi pogled izgleda razumno.

Problem se javlja kada porudžbina pređe iz jednog stanja u drugo.

Ako:

```java
NovaPorudzbina
```

posle plaćanja treba da postane:

```java
PlacenaPorudzbina
```

moramo da napravimo **nov objekat**.

To otvara pitanje:

> Da li se promenila porudžbina ili samo njeno stanje?

## `primer02_problem_identiteta`

Demonstriramo problem sa referencama.

Jedan deo programa čuva referencu na staru `NovaPorudzbina`, dok drugi dobije novu `PlacenaPorudzbina`.

Domen kaže:

> to je ista porudžbina.

Ali naš model kaže:

> to su dva različita Java objekta.

To je signal da možda modelujemo stanje na pogrešnom mestu.

## `primer03_enum_i_switch`

Uvodi se jednostavnije rešenje:

```java
enum StatusPorudzbine {
    NOVA,
    PLACENA,
    POSLATA,
    OTKAZANA
}
```

i metode:

```java
plati()
posalji()
otkazi()
```

sa proverama stanja.

Ovo rešenje je potpuno legitimno za mali sistem.

Važna poruka:

> State pattern nije obavezan čim postoji enum.

## `primer04_rast_switch_logike`

Kada se pravila povećaju, iste provere stanja počinju da se ponavljaju kroz više metoda.

Tada se ponašanje vezano za stanje rasipa kroz jednu veliku klasu.

Tu se javlja razlog da pokušamo drugačiji dizajn.

## `primer05_state_objekti`

Uvodimo interfejs:

```java
public interface StanjePorudzbine {
    void plati(Porudzbina porudzbina);
    void posalji(Porudzbina porudzbina);
    void otkazi(Porudzbina porudzbina);
}
```

Konkretna stanja:

```text
NovoStanje
PlacenoStanje
PoslatoStanje
OtkazanoStanje
```

`Porudzbina` sada:

```text
HAS-A StanjePorudzbine
```

i delegira:

```java
stanje.plati(this);
```

## `primer06_tranzicije`

Konkretno stanje može da odredi sledeće stanje.

Na primer:

```java
NovoStanje.plati(...)
```

posle uspešnog plaćanja radi:

```java
porudzbina.postaviStanje(new PlacenoStanje());
```

Tako pravilo tranzicije živi uz ponašanje stanja kome pripada.

---

# State obrazac

State koristimo kada:

- objekat prolazi kroz jasna stanja;
- dozvoljene operacije zavise od trenutnog stanja;
- ponašanje u tim stanjima postaje dovoljno veliko;
- želimo da pravila pojedinačnih stanja izdvojimo iz glavne klase.

Važno:

> cilj nije "izbaciti svaki switch".

Ako imamo tri stanja i dve jednostavne provere, `enum + switch` može biti čitljiviji.

State ima smisla kada životni ciklus i ponašanje postanu dovoljno složeni.

---

# State i Strategy — sličnosti i razlike

Tehnički mogu izgledati slično:

```text
interfejs
više implementacija
kompozicija
delegiranje
polimorfizam
```

Ali namera je drugačija.

## Strategy

Pitanje je:

> Koji način izvršavanja želimo da koristimo?

Primer:

```text
Hodanje
Voznja
Plivanje
```

Spoljni kod često bira strategiju.

## State

Pitanje je:

> U kom stanju je objekat i šta je sada dozvoljeno?

Primer:

```text
NOVA
PLACENA
POSLATA
```

Sama stanja često upravljaju prelazima.

---

# Važna ideja: identitet != stanje

Porudžbina sa brojem:

```text
#1042
```

ostaje porudžbina `#1042` i kada je:

```text
NOVA
PLACENA
POSLATA
ISPORUCENA
```

Menja se njeno stanje, ne njen identitet.

Zato je prirodnije da:

```java
class Porudzbina {
    private final int broj;
    private StanjePorudzbine stanje;
}
```

nego da za svaku tranziciju pravimo novi objekat porudžbine.

---

# Pitanja za diskusiju

1. Zašto `PlacenaPorudzbina extends Porudzbina` na prvi pogled izgleda logično?
2. Da li "plaćena" opisuje vrstu porudžbine ili trenutno stanje?
3. Šta se dešava sa starim referencama ako tranziciju modelujemo pravljenjem novog objekta?
4. Kada je `enum + switch` sasvim dobro rešenje?
5. Kada veliki broj provera statusa postaje znak problema?
6. Gde se u State rešenju nalazi kompozicija?
7. Gde se dešava delegiranje?
8. Ko odlučuje o sledećem stanju?
9. Zašto je `postaviStanje(...)` u primeru namerno ograničena/package-private metoda?
10. Koja je glavna razlika između Strategy i State?
11. Da li State znači da više nikada ne treba koristiti `enum`?
12. Kako biste dodali stanje `ISPORUCENA`?

---

# Mini zadatak

U fajlu `ZADATAK.md` nalazi se model **rezervacije bioskopske karte**.

Rezervacija prolazi kroz:

```text
KREIRANA → PLACENA → ISKORISCENA
   \            \
    → OTKAZANA   → OTKAZANA
```

Cilj je da student samostalno primeni State bez kopiranja porudžbine.

## Najpre tabela prelaza

| Stanje | plati | posalji | isporuci | otkazi |
|---|---|---|---|---|
| NOVA | PLACENA | odbij | odbij | OTKAZANA |
| PLACENA | odbij | POSLATA | odbij | OTKAZANA |
| POSLATA | odbij | odbij | ISPORUCENA | odbij |
| ISPORUCENA | odbij | odbij | odbij | odbij |
| OTKAZANA | odbij | odbij | odbij | odbij |

U ovim malim primerima odbijanje ispisuje poruku i ne menja stanje. U završnom
modelu iz nedelje 13 koristi se izuzetak. Package-private setter u ovoj nedelji je
nastavni korak: sav kod istog paketa je saradnik od poverenja. Privatne ugnježdene
implementacije u nedelji 13 dodatno sužavaju taj pristup.
