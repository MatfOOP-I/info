# Недеља 6 — Интерфејси и уговори

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori) · [преузми пројекат (ZIP)](../06.interfejsi.i.ugovori.zip) · [задатак за самостални рад](ZADATAK.md)

Претходне недеље смо видели да наслеђивање користимо када моделујемо однос **IS-A**:

```text
Taksi IS-A Prevoz
Voz   IS-A Prevoz
```

Сада уводимо други начин апстракције.

Често нас не занима **шта објекат јесте**, већ само:

> Коју способност објекат гарантује да има?

Главни пример ове недеље је плаћање. Касир или куповина не треба да знају да ли корисник плаћа готовином, картицом или дигиталним новчаником. Њима је довољан уговор:

```java
interface NacinPlacanja {
    boolean plati(int iznos);
}
```

## Циљеви

После вежби студент треба да уме да објасни:

- шта је интерфејс и зашто представља **уговор**;
- разлику између `extends` и `implements`;
- зашто променљива интерфејсног типа може да показује на различите конкретне објекте;
- како се полиморфизам користи и преко интерфејса;
- зашто класа често треба да зависи од интерфејса, а не од конкретне имплементације;
- да једна класа може да имплементира више независних интерфејса;
- када нам више одговара апстрактна класа, а када интерфејс;
- да се наслеђивање, интерфејси и композиција могу користити заједно.

## Важна идеја

Интерфејс не треба посматрати само као:

> "Класа у којој методе немају имплементацију."

Много кориснији ментални модел је:

> **Интерфејс описује шта корисник неког објекта сме да очекује од њега.**

Ако `Kasa` ради са типом `NacinPlacanja`, она зна да постоји метода:

```java
boolean plati(int iznos)
```

али не мора да зна **како** се конкретно плаћање извршава.

## Редослед примера

### [`primer01_prvi_interfejs`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori/src/primer01_prvi_interfejs)

Уводимо:

```java
NacinPlacanja
```

и две имплементације:

```text
PlacanjeGotovinom
PlacanjeKarticom
```

Први пут користимо `implements`.

Важно је приметити да променљива типа `NacinPlacanja` може да показује на објекат било које класе која поштује тај уговор.

### [`primer02_kasa_zavisi_od_ugovora`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori/src/primer02_kasa_zavisi_od_ugovora)

Правимо класу `Kasa`.

Лошији дизајн би био:

```java
private PlacanjeKarticom placanje;
```

јер би каса тада била везана баш за једну конкретну имплементацију.

Уместо тога:

```java
private NacinPlacanja nacinPlacanja;
```

Каса зависи од **уговора**, а не од конкретне класе.

Овде поново користимо композицију и делегирање:

```text
Kasa HAS-A NacinPlacanja
```

и:

```java
nacinPlacanja.plati(iznos);
```

### [`primer03_vise_interfejsa`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori/src/primer03_vise_interfejsa)

Уводимо другу, независну способност:

```java
Dopunjiv
```

`DigitalniNovcanik` је истовремено:

```text
NacinPlacanja
Dopunjiv
```

Ово је важна разлика у односу на наслеђивање.

Објекат може да поштује више различитих уговора који описују различите његове способности.

### [`primer04_podrazumevana_metoda`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori/src/primer04_podrazumevana_metoda)

Показујемо `default` методу на малом примеру.

Интерфејс може да понуди заједничко понашање које имплементације могу да користе, али централна идеја интерфејса и даље остаје **уговор**, а не дељење стања.

### [`primer05_apstraktna_klasa_i_interfejs`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori/src/primer05_apstraktna_klasa_i_interfejs)

Спајамо градиво претходне и ове недеље.

Имамо:

```text
DebitnaKartica IS-A PlatnaKartica
DebitnaKartica IMPLEMENTS NacinPlacanja
```

Апстрактна класа `PlatnaKartica` чува заједничко **стање и идентитет** картица.

Интерфејс `NacinPlacanja` описује **способност** коју картица нуди остатку програма.

То нису конкурентски механизми. Одговарају на различита питања.

### [`primer06_promena_nacina_placanja`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori/src/primer06_promena_nacina_placanja)

Овај пример поново користи `Kasa`, али сада начин плаћања можемо да променимо током рада програма.

```java
kasa.postaviNacinPlacanja(new PlacanjeGotovinom(...));
kasa.naplati(...);

kasa.postaviNacinPlacanja(new DigitalniNovcanik(...));
kasa.naplati(...);
```

За сада ово посматрамо само као природну последицу рада преко интерфејса.

Следеће недеље ћемо видети ситуацију у којој ће **заменљива понашања** постати централна идеја дизајна.

### [`primer07_ugnjezdene_klase`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/06.interfejsi.i.ugovori/src/primer07_ugnjezdene_klase)

Поредимо static nested, inner, локалну и анонимну класу. Објашњење је у одељку [Прецизан уговор и угњеждени типови](#прецизан-уговор-и-угњеждени-типови).

## Интерфејс или апстрактна класа?

Нема правила које се може свести само на синтаксу.

Добро почетно питање је:

### Да ли моделујемо заједничку врсту објекта?

На пример:

```text
DebitnaKartica IS-A PlatnaKartica
```

Ту апстрактна класа може имати смисла, посебно ако постоје заједничка поља и имплементација.

### Или моделујемо способност/уговор?

На пример:

```text
DigitalniNovcanik može da plaća.
DebitnaKartica može da plaća.
PoklonKartica može da plaća.
```

Ови објекти не морају да припадају истој природној хијерархији.

Али сви могу да имплементирају:

```java
NacinPlacanja
```

## Централне поруке

### Програмирамо према уговору

Класа која користи плаћање не треба да зна све конкретне врсте плаћања.

Желимо:

```java
private NacinPlacanja nacinPlacanja;
```

уместо:

```java
private PlacanjeKarticom placanjeKarticom;
```

ако нам је једино важно да објекат уме да изврши плаћање.

### Интерфејс омогућава полиморфизам

Исто као код базне класе, позив:

```java
nacinPlacanja.plati(iznos);
```

завршава у конкретној имплементацији објекта.

### Једна класа може имати више способности

Наслеђивање гради једну хијерархију типова.

Интерфејси омогућавају да један објекат поштује више независних уговора.

## Питања за дискусију

1. Да ли се може направити `new NacinPlacanja()`?
2. Шта класа обећава када напише `implements NacinPlacanja`?
3. Ко одређује која ће се имплементација `plati` позвати?
4. Зашто `Kasa` има поље типа `NacinPlacanja`, а не `PlacanjeKarticom`?
5. Шта бисмо морали да променимо у `Kasa` класи ако додамо потпуно нови начин плаћања?
6. Да ли `DigitalniNovcanik IS-A NacinPlacanja` описује исту врсту односа као `Taksi IS-A Prevoz`?
7. Зашто један објекат може да имплементира и `NacinPlacanja` и `Dopunjiv`?
8. Када би заједничко стање било разлог да уведемо апстрактну класу?
9. Може ли класа истовремено да наследи једну класу и имплементира интерфејс?
10. Како пример 06 припрема терен за заменљива понашања?

## Мали задатак

У фајлу `ZADATAK.md` налази се систем обавештавања. Задатак тражи да различити канали обавештавања поштују исти уговор, а да класа `Podsetnik` не зависи ни од једне конкретне имплементације.

## Прецизан уговор и угњеждени типови

За све начине плаћања у примерима: износ мора бити позитиван; `false` значи да
плаћање није извршено и да средства остају иста; `true` значи да је износ одузет.
Интерфејс треба документовати кроз ова обећања, не само кроз потпис методе.

У примеру `primer07_ugnjezdene_klase` упоређене су static nested, inner, локална и анонимна класа.
Обавезно разликовати static nested и inner класе; остале врсте прочитати пре недеље 10.
Ово знање се враћа у недељи 13: приватне угњеждене класе скривају детаље State-а.
