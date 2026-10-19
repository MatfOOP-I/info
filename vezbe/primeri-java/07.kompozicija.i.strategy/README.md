# Недеља 7 — Композиција и Strategy образац

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy) · [преузми пројекат (ZIP)](../07.kompozicija.i.strategy.zip) · [задатак за самостални рад](ZADATAK.md)

До сада смо научили:

- класе и објекте;
- енкапсулацију;
- наслеђивање и полиморфизам;
- интерфејсе као уговоре;
- композицију и делегирање.

Сада први пут те идеје користимо да решимо **проблем дизајна**.

Главни пример је инспирисан open-world играма попут GTA серијала. Не покушавамо да моделујемо стварну архитектуру неке конкретне игре. Пример служи само да интуитивно покаже проблем:

> исти лик може да хода, вози, плива и да различито реагује на опасност.

## Циљеви

После вежби студент треба да уме да:

- препозна када наслеђивање почиње да производи превише класа;
- разликује **врсту објекта** од **понашања објекта**;
- препозна више независних оса понашања;
- издвоји променљиво понашање иза интерфејса;
- користи композицију и делегирање за састављање понашања;
- мења понашање објекта током извршавања програма;
- разуме основну идеју Strategy обрасца;
- објасни зашто Strategy користи полиморфизам, иако не мора да користи нову хијерархију домена.

## Редослед примера

### [`primer01_naivno_nasledjivanje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer01_naivno_nasledjivanje)

Почињемо са:

```text
Lik
├── HodajuciLik
└── VozeciLik
```

На почетку ово не изгледа лоше.

То је намерно.

Важна лекција је да лош дизајн често не изгледа лоше док је систем мали.

### [`primer02_eksplozija_hijerarhije`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer02_eksplozija_hijerarhije)

Додајемо другу особину:

```text
agresivan
bezeci
```

Добијамо:

```text
HodajuciAgresivniLik
HodajuciBezeciLik
VozeciAgresivniLik
VozeciBezeciLik
```

Затим разматрамо:

```text
hodanje / vožnja / plivanje
×
borba / bekstvo / ignorisanje
```

Већ имамо 9 потенцијалних комбинација.

Ако додамо још једну независну особину, број комбинација почиње да се множи.

Кључно питање:

> Да ли је `HodajuciAgresivniLik` заиста нова ВРСТА лика, или смо само спојили два понашања?

### [`primer03_izdvajanje_kretanja`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer03_izdvajanje_kretanja)

Прво издвајамо само једну осу понашања:

```java
public interface PonasanjeKretanja {
    void kreciSe(String ime);
}
```

Имплементације:

```text
Hodanje
Voznja
Plivanje
```

`Lik` сада:

```text
HAS-A PonasanjeKretanja
```

и делегира:

```java
ponasanjeKretanja.kreciSe(ime);
```

### [`primer04_vise_strategija`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer04_vise_strategija)

Додајемо нову независну осу:

```java
PonasanjeReakcije
```

са имплементацијама:

```text
BoriSe
Bezi
Ignorisi
```

Лик сада може да се састави:

```text
Lucija
  kretanje = Hodanje
  reakcija = BoriSe
```

Други лик може имати другу комбинацију, без нове класе.

### [`primer05_promena_ponasanja`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer05_promena_ponasanja)

Најважнији пример.

Исти објекат:

```java
Lik lucija = ...
```

прво хода:

```java
lucija.kreciSe();
```

затим улази у возило:

```java
lucija.postaviPonasanjeKretanja(new Voznja());
```

затим плива:

```java
lucija.postaviPonasanjeKretanja(new Plivanje());
```

**Идентитет објекта остаје исти. Понашање се мења.**

То је тешко елегантно моделовати хијерархијом подкласа.

### [`primer06_strategy`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/07.kompozicija.i.strategy/src/primer06_strategy)

Тек сада дајемо име идеји.

#### Strategy

Strategy образац користимо када:

- постоји више варијанти неког понашања;
- желимо да их међусобно замењујемо;
- објекат који користи понашање не треба да зна детаље имплементације;
- желимо да додамо нову варијанту без мењања корисника тог понашања.

У нашем примеру:

```text
PonasanjeKretanja = strategija
Hodanje           = konkretna strategija
Voznja            = konkretna strategija
Plivanje           = konkretna strategija
Lik                = objekat koji koristi strategiju
```

## Зашто ово није само "још један интерфејс"?

Претходне недеље смо интерфејс учили као уговор.

Сада исти језички механизам користимо за **дизајнерску идеју**.

Није поента само:

```java
implements PonasanjeKretanja
```

Поента је:

> понашање смо издвојили из класе и претворили у заменљив објекат.

## Композиција и делегирање

Strategy овде функционише зато што `Lik` **има** објекат који представља понашање:

```java
private PonasanjeKretanja ponasanjeKretanja;
```

То је композиција.

Када напишемо:

```java
public void kreciSe() {
    ponasanjeKretanja.kreciSe(ime);
}
```

то је делегирање.

`Lik` не зна како се хода или вози.

Он само зна **коме да проследи посао**.

## Да ли је наслеђивање сада лоше?

Не.

То није порука ове недеље.

Наслеђивање и даље користимо када заиста моделујемо:

```text
B IS-A A
```

Проблем настаје када покушавамо да сваку комбинацију променљивих понашања моделујемо новом подкласом.

Добро питање је:

> Да ли уводим нови тип објекта или само нову варијанту његовог понашања?

## Dependency injection — само идеја

Погледати конструктор:

```java
public Lik(
        String ime,
        PonasanjeKretanja ponasanjeKretanja,
        PonasanjeReakcije ponasanjeReakcije
) {
    ...
}
```

`Lik` не ради:

```java
this.ponasanjeKretanja = new Hodanje();
```

него добија зависност споља.

За сада је довољно запамтити:

> објекат добија сараднике које користи, уместо да их увек сам хардкодује.

Не уводимо frameworke нити додатну терминологију.

## Питања за дискусију

1. Зашто почетни дизајн са `HodajuciLik` и `VozeciLik` не изгледа одмах лоше?
2. Шта се мења када додамо другу независну особину?
3. Зашто број комбинованих подкласа расте множењем?
4. Да ли је "ходање" природна врста лика или понашање?
5. Где у добром решењу видимо композицију?
6. Где видимо делегирање?
7. Где се користи полиморфизам?
8. Зашто `Lik` има поље интерфејсног типа?
9. Шта треба променити ако желимо да додамо `VoziBicikl`?
10. Да ли треба мењати класу `Lik` када додајемо нову стратегију кретања?
11. Зашто `postaviPonasanjeKretanja(...)` има смисла у овом домену?
12. Која је разлика између идентитета лика и његовог тренутног понашања?
13. Да ли је свака употреба интерфејса аутоматски Strategy pattern?
14. Када бисте ипак изабрали наслеђивање уместо Strategy-ja?

## Мини задатак

У фајлу `ZADATAK.md` налази се систем навигације.

Идеја је намерно другачија од гаминг примера:

- навигација може да бира аутомобилску, пешачку или бициклистичку руту;
- корисник током рада апликације може да промени начин рутирања;
- `Navigacija` не треба да зна детаље сваког алгоритма.

Циљ је да студент препозна исти дизајнерски принцип без копирања назива из главног примера.

### Од демонстрације до понашања које враћа резултат

Испис у примерима је сведена демонстрација делегирања. У самосталном задатку
стратегија рачуна број минута; приказ резултата остаје позиваоцу. Не треба користити
Strategy за сваку кратку условну наредбу. Мерило је независна променљивост понашања.
