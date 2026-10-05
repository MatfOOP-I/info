# Završni zadatak — Refaktorisanje sistema dostave

[← Nedelja 13](README.md)

Ovaj zadatak je namenjen za samostalno povezivanje gradiva.

Imamo sistem dostave paketa.

Početna implementacija čuva:

```text
vrsta dostave: "STANDARDNA", "EKSPRESNA"
status: "KREIRANA", "PREUZETA", "ISPORUCENA", "OTKAZANA"
tip paketa: "OBICAN", "LOMLJIV"
```

i koristi veliki broj:

```java
if
switch
```

provera.

Potrebno je osmisliti bolji OOP model.

Početni kod je `src/zadatak_pocetni/Dostava.java`. Pokrenuti ga, zabeležiti očekivanja,
pa refaktorisati u sopstvenom paketu. Original sačuvati radi poređenja.

Cena standardne dostave je 200 + 50 dinara za svaki započeti kilogram;
ekspresna je dvostruka standardna cena. Masa je celobrojni broj grama, 1–50000.
Za 1500 g cene su 300 i 600. Otkazivanje je dozvoljeno samo iz KREIRANA;
isporuka samo iz PREUZETA. Završena i otkazana pošiljka ne prihvataju nove operacije.

LOMLJIV je za sada samo oznaka i ne menja cenu ili tranzicije. To je namerno:
ne treba praviti podklasu bez razlike u ponašanju. U završnom modelu dodati registar
koji odbija duple identifikacione brojeve, umesto da prepiše staru pošiljku.

---

## Zahtevi

### Paket

Svaki paket ima:

- identifikacioni broj;
- masu;
- pošiljaoca;
- primaoca.

Razmisliti da li:

```text
ObicanPaket
LomljivPaket
```

zaista treba da budu podklase.

Ako imaju različito ponašanje, objasniti koje.

Ako nemaju, nemojte uvoditi nasleđivanje samo zbog naziva.

---

### Obračun dostave

Podržati:

```text
StandardniObracun
EkspresniObracun
```

bez velikog `if` grananja u klasi `Posiljka`.

---

### Životni ciklus

Posiljka prolazi kroz:

```text
KREIRANA
PREUZETA
ISPORUCENA
OTKAZANA
```

Operacije:

```text
preuzmi
isporuci
otkazi
```

Nisu sve dozvoljene u svakom stanju.

---

### Kolekcije

Sistem treba da:

- brzo pronađe pošiljku po identifikacionom broju;
- vrati listu svih pošiljki.

Izabrati odgovarajuće kolekcije i obrazložiti izbor.

---

### Greške

Razmisliti kako predstaviti:

```text
nepostojeća pošiljka
nedozvoljena tranzicija
neispravna masa
```

Ne mora svaka greška biti checked exception.

Obrazložiti odluku.

---

## Testovi

Napisati najmanje tri mala testa:

1. cena standardne dostave;
2. ispravna tranzicija `KREIRANA → PREUZETA`;
3. pokušaj da se otkazana pošiljka isporuči.

Testovi ne treba da zavise od GUI-ja.

---

## Najvažnije

Nije cilj da rešenje ima što više klasa.

Za svaku uvedenu apstrakciju treba moći odgovoriti:

> Koji konkretan problem ova apstrakcija rešava?

## Samostalni deo — Promena zahteva

Sistemu iznajmljivanja dodati električni trotinet i vikend obračun sa popustom 20%. Pravilo izbora vikend obračuna određuje pozivalac; ne uvoditi kalendar.

**Kriterijum provere:** Trotinet ima depozit 1000. Za cenu 5000/dan i dva dana vikend cena je 8000. Dodati test; postojeće testove sačuvati. Napisati koji fajlovi su se promenili i zašto.

Predati mali `Main` sa demonstracijom i kratko obrazloženje odluka. U ovom delu
nisu zadati nazivi klasa ili obavezni obrasci; obrazloženo jednostavnije rešenje
je prihvatljivo. Najpre definisati ugovor i očekivani rezultat, pa implementirati.
