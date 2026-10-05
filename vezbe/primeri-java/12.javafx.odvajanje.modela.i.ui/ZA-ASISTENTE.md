# Nedelja 12 — napomene za asistente

[← Nedelja 12](README.md)

## Predlog toka jednog dvočasa

### Prvih 45 minuta

#### 0–15 min

[`primer01_osnove`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer01_osnove)

- `Application`;
- `Stage`;
- `Scene`;
- layout;
- kontrole;
- događaj.

#### 15–30 min

[`primer02_sve_u_ui`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer02_sve_u_ui)

Napraviti planer koji radi.

Zatim pitati:

> Šta je sve odgovornost ove jedne klase?

#### 30–45 min

Početi izdvajanje modela.

Pokazati `Zadatak` i `ListaZadataka`.

Pokrenuti model iz običnog `Main`.

### Drugih 45 minuta

#### 0–15 min

[`primer04_kontroler`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer04_kontroler)

Objasniti:

```text
prikaz → kontroler → model
```

bez insistiranja na terminologiji design patterna.

#### 15–35 min

[`primer05_zavrsna_aplikacija`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer05_zavrsna_aplikacija)

Spojiti JavaFX prikaz sa kontrolerom.

Dodavanje, završavanje i brisanje zadatka.

#### 35–45 min

Diskusija/refaktorisanje.

Pitanja:

- gde bi išao novi filter?
- gde bi išla boja visokog prioriteta?
- gde bi išlo pravilo "opis mora imati bar 3 znaka"?
- gde bi išlo čuvanje u datoteku?

## Priprema i granice modela

Pre časa otvoriti Maven projekat i pokrenuti prvi prozor. Ponoviti lambda callback
iz nedelje 10. Na času studenti povezuju jednu akciju, ne kucaju ceo UI od nule.

`List.copyOf` štiti strukturu vraćene liste, ali ne pravi duboke kopije mutabilnih
Zadatak objekata. U ovom jednostavnom modelu Zadatak sam dopušta zavrsi(), pa se
njegova invarijanta ne krši. Ako sve izmene moraju ići kroz servis, potreban je
read-only prikaz podataka ili drugačija granica pristupa.

Indeksi su bezbedni ovde samo zato što prikaz prati isti redosled kao model.
Samostalni zadatak sa filtriranjem zahteva stabilan ID ili izabrani objekat.
Kontroler nezavisan od JavaFX-a je izbor ovog nastavnog modela, ne univerzalno
pravilo za svaki JavaFX kontroler.
