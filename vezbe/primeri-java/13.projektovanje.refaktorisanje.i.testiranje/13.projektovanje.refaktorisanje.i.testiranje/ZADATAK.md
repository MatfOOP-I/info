# Završni zadatak — Refaktorisanje sistema dostave

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

---

# Zahtevi

## Paket

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

## Obračun dostave

Podržati:

```text
StandardniObracun
EkspresniObracun
```

bez velikog `if` grananja u klasi `Posiljka`.

---

## Životni ciklus

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

## Kolekcije

Sistem treba da:

- brzo pronađe pošiljku po identifikacionom broju;
- vrati listu svih pošiljki.

Izabrati odgovarajuće kolekcije i obrazložiti izbor.

---

## Greške

Razmisliti kako predstaviti:

```text
nepostojeća pošiljka
nedozvoljena tranzicija
neispravna masa
```

Ne mora svaka greška biti checked exception.

Obrazložiti odluku.

---

# Testovi

Napisati najmanje tri mala testa:

1. cena standardne dostave;
2. ispravna tranzicija `KREIRANA → PREUZETA`;
3. pokušaj da se otkazana pošiljka isporuči.

Testovi ne treba da zavise od GUI-ja.

---

# Najvažnije

Nije cilj da rešenje ima što više klasa.

Za svaku uvedenu apstrakciju treba moći odgovoriti:

> Koji konkretan problem ova apstrakcija rešava?
