# Zadatak — Sistem obaveštavanja

Potrebno je modelovati jednostavan sistem za slanje podsetnika.

Podsetnik ima:

- tekst poruke;
- primaoca;
- kanal preko koga se poruka šalje.

Definisati interfejs:

```java
public interface KanalObavestavanja {
    boolean posalji(String primalac, String poruka);
}
```

Napraviti najmanje sledeće implementacije:

- `SmsKanal`;
- `ImejlKanal`;
- `AplikacijaKanal`.

Za potrebe zadatka nije potrebno stvarno slati SMS ili imejl. Dovoljno je da metoda ispiše šta bi bilo poslato i vrati `true`.

## Klasa `Podsetnik`

`Podsetnik` treba da **ima** polje:

```java
private KanalObavestavanja kanal;
```

i da slanje delegira tom objektu.

Na primer:

```java
podsetnik.posalji();
```

ne treba da sadrži grananje:

```java
if (tipKanala == ...) {
    ...
}
```

## Zahtevi

1. `Podsetnik` ne sme da zavisi od konkretnih klasa `SmsKanal`, `ImejlKanal` ili `AplikacijaKanal`.
2. Kanal se prosleđuje kroz konstruktor.
3. Omogućiti promenu kanala nakon kreiranja podsetnika.
4. U `Main` poslati istu poruku preko najmanje dva različita kanala.
5. Dodati novu implementaciju `StampanoPismoKanal` bez izmene klase `Podsetnik`.

## Dodatak

Definisati još jedan interfejs:

```java
public interface ZahtevaInternet {
    boolean imaInternet();
}
```

Neka ga implementiraju samo kanali kojima je internet zaista potreban.

Razmisliti:

- zašto `SmsKanal` i `ImejlKanal` ne moraju da imaju zajedničku baznu klasu samo zato što oba šalju poruke;
- zašto je korisno da `Podsetnik` zna samo za `KanalObavestavanja`;
- koliko se menja postojeći kod kada dodamo potpuno novi kanal.
