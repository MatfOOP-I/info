# Nedelja 7 — Kompozicija i Strategy obrazac

> **Kod:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy) · [preuzmi projekat (ZIP)](../07.kompozicija.i.strategy.zip) · [zadatak za samostalni rad](ZADATAK.md)

Do sada smo naučili:

- klase i objekte;
- enkapsulaciju;
- nasleđivanje i polimorfizam;
- interfejse kao ugovore;
- kompoziciju i delegiranje.

Sada prvi put te ideje koristimo da rešimo **problem dizajna**.

Glavni primer je inspirisan open-world igrama poput GTA serijala. Ne pokušavamo da modelujemo stvarnu arhitekturu neke konkretne igre. Primer služi samo da intuitivno pokaže problem:

> isti lik može da hoda, vozi, pliva i da različito reaguje na opasnost.

## Ciljevi

Posle vežbi student treba da ume da:

- prepozna kada nasleđivanje počinje da proizvodi previše klasa;
- razlikuje **vrstu objekta** od **ponašanja objekta**;
- prepozna više nezavisnih osa ponašanja;
- izdvoji promenljivo ponašanje iza interfejsa;
- koristi kompoziciju i delegiranje za sastavljanje ponašanja;
- menja ponašanje objekta tokom izvršavanja programa;
- razume osnovnu ideju Strategy obrasca;
- objasni zašto Strategy koristi polimorfizam, iako ne mora da koristi novu hijerarhiju domena.

## Redosled primera

### [`primer01_naivno_nasledjivanje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer01_naivno_nasledjivanje)

Počinjemo sa:

```text
Lik
├── HodajuciLik
└── VozeciLik
```

Na početku ovo ne izgleda loše.

To je namerno.

Važna lekcija je da loš dizajn često ne izgleda loše dok je sistem mali.

### [`primer02_eksplozija_hijerarhije`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer02_eksplozija_hijerarhije)

Dodajemo drugu osobinu:

```text
agresivan
bezeci
```

Dobijamo:

```text
HodajuciAgresivniLik
HodajuciBezeciLik
VozeciAgresivniLik
VozeciBezeciLik
```

Zatim razmatramo:

```text
hodanje / vožnja / plivanje
×
borba / bekstvo / ignorisanje
```

Već imamo 9 potencijalnih kombinacija.

Ako dodamo još jednu nezavisnu osobinu, broj kombinacija počinje da se množi.

Ključno pitanje:

> Da li je `HodajuciAgresivniLik` zaista nova VRSTA lika, ili smo samo spojili dva ponašanja?

### [`primer03_izdvajanje_kretanja`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer03_izdvajanje_kretanja)

Prvo izdvajamo samo jednu osu ponašanja:

```java
public interface PonasanjeKretanja {
    void kreciSe(String ime);
}
```

Implementacije:

```text
Hodanje
Voznja
Plivanje
```

`Lik` sada:

```text
HAS-A PonasanjeKretanja
```

i delegira:

```java
ponasanjeKretanja.kreciSe(ime);
```

### [`primer04_vise_strategija`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer04_vise_strategija)

Dodajemo novu nezavisnu osu:

```java
PonasanjeReakcije
```

sa implementacijama:

```text
BoriSe
Bezi
Ignorisi
```

Lik sada može da se sastavi:

```text
Lucija
  kretanje = Hodanje
  reakcija = BoriSe
```

Drugi lik može imati drugu kombinaciju, bez nove klase.

### [`primer05_promena_ponasanja`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer05_promena_ponasanja)

Najvažniji primer.

Isti objekat:

```java
Lik lucija = ...
```

prvo hoda:

```java
lucija.kreciSe();
```

zatim ulazi u vozilo:

```java
lucija.postaviPonasanjeKretanja(new Voznja());
```

zatim pliva:

```java
lucija.postaviPonasanjeKretanja(new Plivanje());
```

**Identitet objekta ostaje isti. Ponašanje se menja.**

To je teško elegantno modelovati hijerarhijom podklasa.

### [`primer06_strategy`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer06_strategy)

Tek sada dajemo ime ideji.

#### Strategy

Strategy obrazac koristimo kada:

- postoji više varijanti nekog ponašanja;
- želimo da ih međusobno zamenjujemo;
- objekat koji koristi ponašanje ne treba da zna detalje implementacije;
- želimo da dodamo novu varijantu bez menjanja korisnika tog ponašanja.

U našem primeru:

```text
PonasanjeKretanja = strategija
Hodanje           = konkretna strategija
Voznja            = konkretna strategija
Plivanje           = konkretna strategija
Lik                = objekat koji koristi strategiju
```

## Zašto ovo nije samo "još jedan interfejs"?

Prethodne nedelje smo interfejs učili kao ugovor.

Sada isti jezički mehanizam koristimo za **dizajnersku ideju**.

Nije poenta samo:

```java
implements PonasanjeKretanja
```

Poenta je:

> ponašanje smo izdvojili iz klase i pretvorili u zamenljiv objekat.

## Kompozicija i delegiranje

Strategy ovde funkcioniše zato što `Lik` **ima** objekat koji predstavlja ponašanje:

```java
private PonasanjeKretanja ponasanjeKretanja;
```

To je kompozicija.

Kada napišemo:

```java
public void kreciSe() {
    ponasanjeKretanja.kreciSe(ime);
}
```

to je delegiranje.

`Lik` ne zna kako se hoda ili vozi.

On samo zna **kome da prosledi posao**.

## Da li je nasleđivanje sada loše?

Ne.

To nije poruka ove nedelje.

Nasleđivanje i dalje koristimo kada zaista modelujemo:

```text
B IS-A A
```

Problem nastaje kada pokušavamo da svaku kombinaciju promenljivih ponašanja modelujemo novom podklasom.

Dobro pitanje je:

> Da li uvodim novi tip objekta ili samo novu varijantu njegovog ponašanja?

## Dependency injection — samo ideja

Pogledati konstruktor:

```java
public Lik(
        String ime,
        PonasanjeKretanja ponasanjeKretanja,
        PonasanjeReakcije ponasanjeReakcije
) {
    ...
}
```

`Lik` ne radi:

```java
this.ponasanjeKretanja = new Hodanje();
```

nego dobija zavisnost spolja.

Za sada je dovoljno zapamtiti:

> objekat dobija saradnike koje koristi, umesto da ih uvek sam hardkoduje.

Ne uvodimo frameworke niti dodatnu terminologiju.

## Pitanja za diskusiju

1. Zašto početni dizajn sa `HodajuciLik` i `VozeciLik` ne izgleda odmah loše?
2. Šta se menja kada dodamo drugu nezavisnu osobinu?
3. Zašto broj kombinovanih podklasa raste množenjem?
4. Da li je "hodanje" prirodna vrsta lika ili ponašanje?
5. Gde u dobrom rešenju vidimo kompoziciju?
6. Gde vidimo delegiranje?
7. Gde se koristi polimorfizam?
8. Zašto `Lik` ima polje interfejsnog tipa?
9. Šta treba promeniti ako želimo da dodamo `VoziBicikl`?
10. Da li treba menjati klasu `Lik` kada dodajemo novu strategiju kretanja?
11. Zašto `postaviPonasanjeKretanja(...)` ima smisla u ovom domenu?
12. Koja je razlika između identiteta lika i njegovog trenutnog ponašanja?
13. Da li je svaka upotreba interfejsa automatski Strategy pattern?
14. Kada biste ipak izabrali nasleđivanje umesto Strategy-ja?

## Mini zadatak

U fajlu `ZADATAK.md` nalazi se sistem navigacije.

Ideja je namerno drugačija od gaming primera:

- navigacija može da bira automobilsku, pešačku ili biciklističku rutu;
- korisnik tokom rada aplikacije može da promeni način rutiranja;
- `Navigacija` ne treba da zna detalje svakog algoritma.

Cilj je da student prepozna isti dizajnerski princip bez kopiranja naziva iz glavnog primera.

### Od demonstracije do ponašanja koje vraća rezultat

Ispis u primerima je svedena demonstracija delegiranja. U samostalnom zadatku
strategija računa broj minuta; prikaz rezultata ostaje pozivaocu. Ne treba koristiti
Strategy za svaku kratku uslovnu naredbu. Merilo je nezavisna promenljivost ponašanja.
