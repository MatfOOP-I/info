# Nedelja 13 — Projektovanje, refaktorisanje i testiranje

> **Kod:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje) · [preuzmi projekat (ZIP)](../13.projektovanje.refaktorisanje.i.testiranje.zip) · [zadatak za samostalni rad](ZADATAK.md)

## Cilj

Odrediti koji objekat je odgovoran za ponašanje i proveriti da promena dizajna
čuva dogovoreni ugovor. Više klasa samo po sebi nije bolji dizajn.

## Redosled

1. [`primer01_pocetni_kod`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer01_pocetni_kod): radi, ali koristi string oznake i rasutu logiku.
2. [`primer00_karakterizacija`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer00_karakterizacija): zabeležiti cenu i normalan životni ciklus PRE menjanja.
3. [`primer02_refaktorisano_resenje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer02_refaktorisano_resenje): pogledati po jednu izdvojenu odgovornost.
4. Ponovo pokrenuti karakterizaciju: proverava isti scenario na obe verzije.
5. [`primer03_testiranje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer03_testiranje): male provere obračuna, životnog ciklusa i sistema.

Testove za postojeće ispravno ponašanje čuvamo tokom refaktorisanja. Ispravke grešaka
(duple oznake, zaobilaženje tranzicija) zasebno menjaju ugovor i imaju regresione provere.

## Odgovornosti i javni API

- `Vozilo`: identitet, cena po danu, depozit i dostupnost. `rezervisi/oslobodi` su
  package-private operacije modela, nisu deo javnog API-ja aplikacije.
- `Rezervacija`: validira argumente i zatim zauzima vozilo. I direktan konstruktor
  odbija već zauzeto vozilo. Ne treba prethodno ručno pozivati rezervisi().
- `NacinObracunaCene`: Strategy za standardni/članski obračun. U ovom primeru
  strategije su bez promenljivog stanja; primenjuju se na nepromenljivu cenu i broj dana.
- `SistemIznajmljivanja`: registar vozila i rezervacija. Dupla oznaka se odbija;
  neuspešno kreiranje ne menja dostupnost i ne troši broj rezervacije.

## State i stvarna enkapsulacija

`StanjeRezervacije` i četiri implementacije su **privatni ugnježdeni tipovi**
unutar Rezervacija. Implementacije su static nested klase; rezervaciju dobijaju
kao argument. Klijent vidi samo `preuzmi()`, `vrati()`, `otkazi()` i upit o stanju.
Ne postoji javni promeniStanje/postaviStanje. State klase više nisu javni fajlovi
u zasebnom paketu. Paket stanje sadrži samo javni domenski izuzetak.

| Stanje | preuzmi | vrati | otkazi |
|---|---|---|---|
| KREIRANA | AKTIVNA | odbij | OTKAZANA, oslobodi vozilo |
| AKTIVNA | odbij | ZAVRSENA, oslobodi vozilo | odbij |
| ZAVRSENA | odbij | odbij | odbij |
| OTKAZANA | odbij | odbij | odbij |

Odbijanje baca NedozvoljenaOperacijaException bez promene stanja. Jedinstvenost
registracije vozila garantuje jedan sistem; ovo nije model konkurentnih rezervacija,
baze podataka ili rasporeda rezervacija po datumima.

## Testiranje

Prvo očekivanje, zatim akcija i provera. Koristimo mali Provera pomoćnik umesto
uvođenja nove biblioteke. `mvn verify` dodatno izvršava `test/provere/Main.java`:
proverava duplikate, neuspešne zahteve, zauzeto vozilo, terminalna stanja i granice API-ja.
Ove nastavničke provere sadrže i refleksiju; njihova implementacija nije ispitni
preduslov ovog časa. JUnit može biti nastavak istog principa kasnije.

## Promene zahteva

Dodati trotinet (IS-A), vikend obračun (Strategy), ili čuvanje podataka u fajl
(posebna odgovornost). Za svaki izbor tražiti objašnjenje. Za veoma mali životni
ciklus enum može biti dovoljno dobar; cilj je da student razume cenu apstrakcije.
