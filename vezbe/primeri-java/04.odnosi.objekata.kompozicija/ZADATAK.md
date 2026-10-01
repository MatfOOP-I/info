# Zadatak — Rezervacija bioskopske projekcije

Napraviti mali objektni model za rezervaciju mesta u bioskopu.

Potrebne su najmanje sledeće klase:

- `Film` — naslov i trajanje u minutima;
- `Projekcija` — film, naziv sale, cena karte;
- `Sediste` — red i broj sedišta;
- `Gledalac` — ime i prezime;
- `Rezervacija` — gledalac, projekcija i sedište.

## Pravila

1. Jedan `Film` može da se prikazuje u više različitih projekcija.
2. Jedna `Projekcija` se odnosi na tačno jedan film.
3. `Rezervacija` mora da zna za koju projekciju i koje sedište važi.
4. `Sediste` nakon kreiranja ne treba da menja red ili broj.
5. `Film` nakon kreiranja ne treba da menja naslov ili trajanje.
6. `Rezervacija` treba da ima metodu `opis()` koja sastavlja čitljiv opis rezervacije.
7. Nemojte kopirati podatke iz `Film` u `Projekcija` i iz `Projekcija` u `Rezervacija` ako je dovoljno sačuvati referencu na odgovarajući objekat.

Primer korišćenja može da izgleda ovako:

```java
Film film = new Film("Dina", 166);
Projekcija projekcija = new Projekcija(film, "Sala 3", 650);
Sediste sediste = new Sediste(7, 12);
Gledalac gledalac = new Gledalac("Ana", "Jovanovic");

Rezervacija rezervacija = new Rezervacija(
        gledalac,
        projekcija,
        sediste
);

System.out.println(rezervacija.opis());
```

## Razmisliti pre kodiranja

- Koji odnosi su HAS-A?
- Može li isti `Film` objekat da koristi više `Projekcija` objekata?
- Koje klase prirodno mogu da budu nepromenljive?
- Ko je odgovoran za formatiranje podataka o sedištu?
- Da li `Rezervacija` treba direktno da pristupa poljima klase `Film`?
- Koji posao `Rezervacija` može da delegira objektima koje sadrži?

## Dodatak

Dodati klasu `BioskopskaKarta` koja ima:

- rezervaciju;
- jedinstveni ID karte.

Karta treba da ponudi metod `opis()` koristeći postojeće objekte, bez dupliranja njihovih podataka u nova polja.

## Samostalni deo — Pozajmljena oprema

Biblioteka opreme pozajmljuje fotoaparat korisniku. Pozajmica treba da sačuva adresu isporuke u trenutku nastanka, iako korisnik kasnije može da se preseli. Samostalno odrediti tipove.

**Kriterijum provere:** Promena trenutne adrese korisnika ne menja postojeću pozajmicu. Nacrtati reference pre i posle promene; obrazložiti deljenje naspram kopiranja.

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
