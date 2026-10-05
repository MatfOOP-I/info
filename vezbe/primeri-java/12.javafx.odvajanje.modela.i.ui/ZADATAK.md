# Zadatak — Lista za kupovinu

[← Nedelja 12](README.md)

Napraviti malu JavaFX aplikaciju za listu za kupovinu.

Aplikacija treba da omogući:

- dodavanje proizvoda;
- izbor kategorije;
- prikaz svih proizvoda;
- označavanje proizvoda kao kupljenog;
- uklanjanje proizvoda.

## Model

Napraviti paket:

```text
model
```

i klase:

```text
Proizvod
ListaZaKupovinu
Kategorija
```

`Kategorija` treba da bude `enum`, na primer:

```java
HRANA,
PICE,
HIGIJENA,
DOMACINSTVO,
OSTALO
```

`Proizvod` ima:

- naziv;
- kategoriju;
- informaciju da li je kupljen.

Model **ne sme** da importuje ništa iz:

```text
javafx.*
```

---

## Kontroler

Napraviti paket:

```text
kontroler
```

i klasu:

```text
KontrolerKupovine
```

Kontroler treba da omogući operacije:

```java
dodajProizvod(...)
oznaciKaoKupljen(...)
ukloniProizvod(...)
getProizvodi()
```

Ni kontroler ne treba da koristi JavaFX tipove.

---

## Prikaz

Napraviti paket:

```text
prikaz
```

JavaFX interfejs treba da sadrži najmanje:

```text
TextField
ChoiceBox<Kategorija>
Button
ListView
Label
```

i neki od layout kontejnera:

```text
VBox
HBox
BorderPane
```

UI treba da:

1. pročita unos;
2. pozove kontroler;
3. osveži prikaz.

Ne treba direktno da menja internu kolekciju modela.

---

## Važan zahtev

Ovo ne treba da postoji u klasi `Proizvod`:

```java
private Button dugme;
private Label nazivLabela;
```

Niti u klasi `ListaZaKupovinu`:

```java
ObservableList<Proizvod>
```

Model treba da bude obična Java.

---

## Dodatak

Dodati filter:

```text
SVI
NEKUPLJENI
KUPLJENI
```

Razmisliti:

- da li je filter deo modela ili prikaza;
- ko treba da odluči koji proizvodi se trenutno prikazuju;
- da li izbor boje za kupljeni proizvod pripada modelu.

## Samostalni deo — Filter bez pogrešnog indeksa

Na listu za kupovinu dodati prikaz samo nekupljenih proizvoda. Definisati kako UI identifikuje izabrani proizvod kad je lista filtrirana.

**Kriterijum provere:** Posle filtriranja označiti drugi vidljivi proizvod i proveriti da je promenjen pravi objekat modela. Indeks filtriranog prikaza nije nužno indeks u modelu; koristiti stabilan ID ili odgovarajući izabrani objekat.

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
