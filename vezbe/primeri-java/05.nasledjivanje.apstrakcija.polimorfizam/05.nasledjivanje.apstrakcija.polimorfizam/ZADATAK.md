# Zadatak — Ulaznice za događaj

Napraviti objektni model za prodaju ulaznica za koncert ili drugi događaj.

Definisati apstraktnu klasu `Ulaznica` koja ima:

- naziv događaja;
- osnovnu cenu;
- jedinstveni ID ulaznice.

Svaka ulaznica mora da ponudi metodu:

```java
public abstract int izracunajCenu();
```

Napraviti najmanje sledeće izvedene klase:

- `StandardnaUlaznica` — plaća punu osnovnu cenu;
- `StudentskaUlaznica` — ima popust od 30%;
- `VipUlaznica` — na osnovnu cenu dodaje fiksnu cenu VIP paketa.

## Zahtevi

1. Zajedničke podatke i ponašanje staviti u baznu klasu.
2. Koristiti `super(...)` u konstruktorima izvedenih klasa.
3. Svaka izvedena klasa treba da redefiniše `izracunajCenu()` kada ima posebno pravilo.
4. U `Main` napraviti niz tipa `Ulaznica[]` i u njega staviti objekte različitih izvedenih klasa.
5. Jednom petljom ispisati opis i konačnu cenu svake ulaznice.
6. U petlji nije dozvoljeno grananje po konkretnom tipu ulaznice.

## Razmisliti

- Da li `StudentskaUlaznica IS-A Ulaznica` ima smisla?
- Zašto je `Ulaznica` dobar kandidat za apstraktnu klasu?
- Šta se dešava kada promenljiva tipa `Ulaznica` pokazuje na `VipUlaznica` objekat?
- Koliko mesta u programu bi trebalo menjati ako kasnije dodamo `DecijaUlaznica`?

## Dodatak

Dodati klasu `KupovinaUlaznice` koja **ima** kupca i ulaznicu.

Time u istom modelu treba da postoje oba odnosa:

```text
VipUlaznica IS-A Ulaznica
KupovinaUlaznice HAS-A Ulaznica
```
