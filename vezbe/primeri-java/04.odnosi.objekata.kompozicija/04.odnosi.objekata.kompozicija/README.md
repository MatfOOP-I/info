# Nedelja 4 — Odnosi između objekata i kompozicija

Do sada smo uglavnom posmatrali jedan objekat izolovano. U realnim programima objekti skoro uvek **sarađuju sa drugim objektima**.

Ove nedelje koristimo pojednostavljen sistem za poručivanje hrane. Domen je namerno jednostavan: kupac ima adresu, porudžbina ima stavke, a svaka stavka se odnosi na proizvod. Fokus nije na pravljenju aplikacije za dostavu, već na pitanju:

> Kako raspodeliti podatke i odgovornosti između više objekata?

## Ciljevi

Posle vežbi student treba da ume da objasni:

- da polje objekta može da bude drugog klasnog tipa;
- značenje odnosa **HAS-A**;
- šta predstavlja graf objekata;
- razliku između objekta i reference na objekat;
- da više objekata može da deli isti objekat;
- osnovnu ideju kompozicije;
- šta znači **delegiranje odgovornosti**;
- zašto klasa ne treba da zna detalje koji pripadaju drugom objektu;
- kako mutabilnost i deljenje reference mogu da naprave neočekivane posledice;
- zašto su mali nepromenljivi objekti često jednostavniji za bezbedno deljenje.

## Važna napomena

Ove nedelje **ne uvodimo nasleđivanje**. Želimo da studenti prvo steknu prirodan osećaj da se složen objekat veoma često gradi od drugih objekata.

Kasnije ćemo moći precizno da uporedimo:

- `IS-A` — nasleđivanje;
- `HAS-A` — kompozicija.

## Redosled primera

### `primer01_objekat_kao_polje`

`Kupac` ima `Adresu`.

Prvi put eksplicitno posmatramo jedan objekat kao deo stanja drugog objekta. Diskutujemo šta se zapravo čuva u polju tipa `Adresa`: objekat ili referenca na objekat.

### `primer02_porudzbina_i_stavke`

Gradimo mali graf objekata:

```text
Porudzbina
  |
  +-- Kupac
  |     |
  |     +-- Adresa
  |
  +-- StavkaPorudzbine[]
          |
          +-- Proizvod
```

Pošto kolekcije još nisu obrađene, koristimo niz fiksnog kapaciteta. Tema primera nije `ArrayList`, već odnosi između objekata.

### `primer03_delegiranje`

Pitanje nije samo **koje podatke klasa ima**, već i **ko je odgovoran za koju operaciju**.

`Porudzbina` ne računa cenu pojedinačne stavke tako što zaviruje u sva njena polja. Ona pita stavku:

```java
ukupno += stavka.izracunajCenu();
```

To je jednostavan primer delegiranja odgovornosti.

### `primer04_deljena_promenljiva_adresa`

Namerno pravimo problem. `Kupac` i `Porudzbina` dele isti promenljivi objekat `Adresa`.

Ako kupac promeni adresu, može neočekivano da se promeni i adresa već napravljene porudžbine.

Primer povezuje gradivo ove nedelje sa aliasing-om iz prethodne nedelje.

### `primer05_nepromenljiva_adresa`

`Adresa` postaje mali nepromenljivi objekat: sva polja su `final`, nema settera.

Ako kupac promeni svoju trenutnu adresu, dobija novu `Adresa` referencu. Ranije napravljena porudžbina zadržava staru adresu.

Ovo nije pravilo da svaki objekat treba da bude immutable. Cilj je da student vidi da je mutabilnost **dizajnerska odluka**, a ne podrazumevano stanje svake klase.

#

## `primer06_record_adresa`

Posle klasične nepromenljive `Adresa` klase pokazujemo savremeni Java tip:

```java
public record Adresa(
        String ulica,
        String grad,
        String postanskiBroj
) {
}
```

`record` je i dalje klasa, ali je namenjen pre svega malim objektima čiji je glavni posao da **nose skup podataka kao jednu vrednost**.

Java automatski generiše:

```text
konstruktor
accessor metode
equals
hashCode
toString
```

Accessor metode nemaju klasičan `get` prefiks:

```java
adresa.grad()
```

umesto:

```java
adresa.getGrad()
```

Record komponente ne mogu da se menjaju nakon kreiranja objekta.

Zato je `Adresa` prirodan primer:

```text
Adresa("Glavna 10", "Zemun", "11080")
```

predstavlja jednu vrednost.

Ako se kupac preseli, ne menjamo staru adresu polje po polje. Napravimo novu vrednost:

```java
kupac.preseliSe(
    new Adresa("Nova 5", "Beograd", "11000")
);
```

### Record nije zamena za svaku klasu

Ne treba pretvarati svaku klasu u `record`.

Na primer, `Novcanik`, `Porudzbina` ili `Vozilo` imaju promenljivo stanje i ponašanje koje štiti to stanje. Obična klasa je tu prirodniji model.

Dobro početno pitanje je:

> Da li ovaj tip prvenstveno predstavlja malu nepromenljivu vrednost?

Ako je odgovor da, `record` može biti dobar izbor.

### Record može da ima validaciju i metode

U primeru koristimo kompaktni konstruktor:

```java
public Adresa {
    if (ulica == null || ulica.isBlank()) {
        throw new IllegalArgumentException(...);
    }
}
```

i običnu metodu:

```java
public String punaAdresa()
```

Dakle, `record` nije samo "struct sa automatskim getterima".

# Centralne poruke

### 1. Složen objekat se često gradi od manjih objekata

Umesto jedne ogromne klase:

```text
Porudzbina
- imeKupca
- prezimeKupca
- ulica
- broj
- grad
- nazivProizvoda1
- cenaProizvoda1
- ...
```

želimo objekte sa jasnim odgovornostima:

```text
Porudzbina HAS-A Kupac
Kupac HAS-A Adresa
Porudzbina HAS-A StavkaPorudzbine
StavkaPorudzbine HAS-A Proizvod
```

### 2. Objekat ne mora sve da radi sam

Ako `StavkaPorudzbine` zna proizvod i količinu, ona je prirodno mesto za računanje cene te stavke.

`Porudzbina` samo koordinira objekte koje sadrži.

### 3. Deljenje objekta je važno

Dve reference mogu pokazivati na isti objekat. Zato treba razmišljati:

> Da li želim da se promene ovog objekta vide na svim mestima koja ga koriste?

Ponekad je odgovor da. Ponekad nije.

## Pitanja za diskusiju

1. Da li `Kupac` **jeste** `Adresa` ili **ima** `Adresu`?
2. Šta se fizički nalazi u polju `private Adresa adresa`?
3. Može li isti objekat `Proizvod` da se pojavi u više porudžbina?
4. Koliko objekata postoji ako pet stavki pokazuje na isti `Proizvod`?
5. Ko treba da računa cenu jedne stavke — `Porudzbina` ili `StavkaPorudzbine`?
6. Zašto nije dobro da `Porudzbina` direktno poznaje unutrašnju strukturu svake stavke?
7. Šta se dešava kada dva objekta dele isti promenljivi objekat `Adresa`?
8. Da li je nepromenljiv objekat automatski bolji? Kada jeste koristan?
9. Ako kupac promeni adresu nakon što je porudžbina poslata, da li stara porudžbina treba da promeni adresu isporuke?
10. Koji objekti u ovom primeru imaju jasan identitet, a koji više liče na vrednosti?

## Mali zadatak

U fajlu `ZADATAK.md` nalazi se zadatak sa bioskopskom rezervacijom. Domen je drugačiji, ali student treba sam da prepozna HAS-A odnose, odgovornosti i objekte koji mogu bezbedno da budu nepromenljivi.
