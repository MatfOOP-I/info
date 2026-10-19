# Недеља 5 — Наслеђивање, апстрактне класе и полиморфизам

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam) · [преузми пројекат (ZIP)](../05.nasledjivanje.apstrakcija.polimorfizam.zip) · [задатак за самостални рад](ZADATAK.md)

Претходне недеље смо видели да се објекти веома често повезују односом **HAS-A**. Сада уводимо други важан однос:

> Када за један објекат има смисла рећи да **ЈЕСТЕ** посебна врста другог објекта?

Главни пример је избор начина превоза за путовање. Аутобус, воз и такси имају заједничке особине, али исту операцију — рачунање цене — могу да извршавају различито.

## Циљеви

После вежби студент треба да уме да објасни:

- шта значи однос **IS-A**;
- основну синтаксу `extends`;
- шта се наслеђује од базне класе;
- чему служи `super(...)`;
- шта значи редефинисање (`@Override`) методе;
- зашто референца базног типа може да показује на објекат изведене класе;
- шта је динамичко везивање позива методе;
- чему служе апстрактна класа и апстрактна метода;
- како полиморфизам уклања потребу за гранањем по конкретном типу објекта;
- да се наслеђивање и композиција често користе заједно.

## Важна идеја

Наслеђивање не користимо зато што две класе "имају нека иста поља".

Питање је:

> Да ли објекат изведене класе стварно може да се користи свуда где очекујемо објекат базне класе?

У нашем примеру:

```text
Autobus IS-A Prevoz
Voz     IS-A Prevoz
Taksi   IS-A Prevoz
```

Али:

```text
RezervacijaPrevoza HAS-A Prevoz
```

## Редослед примера

### [`primer01_osnovno_nasledjivanje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam/src/primer01_osnovno_nasledjivanje)

Уводимо базну класу `Prevoz` и класе `Autobus` и `Voz`.

Заједничке податке (`naziv`, `prosecnaBrzina`) држимо у базној класи. Изведене класе користе конструктор базне класе помоћу `super(...)`.

### [`primer02_redefinisanje_metoda`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam/src/primer02_redefinisanje_metoda)

Различите врсте превоза различито рачунају цену путовања.

Све класе имају методу истог потписа:

```java
int izracunajCenu(int udaljenostKm)
```

али је имплементација различита.

### [`primer03_apstraktna_klasa`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam/src/primer03_apstraktna_klasa)

Примећујемо да нема много смисла правити "неки општи Превоз" ако не знамо како му се рачуна цена.

`Prevoz` зато постаје `abstract`, а `izracunajCenu` апстрактна метода.

### [`primer04_polimorfizam`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam/src/primer04_polimorfizam)

Правимо низ:

```java
Prevoz[] opcije
```

у коме се налазе `Autobus`, `Voz` и `Taksi`.

У петљи позивамо:

```java
opcije[i].izracunajCenu(udaljenostKm)
```

без питања које је конкретне класе објекат.

### [`primer05_bez_grananja_po_tipu`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam/src/primer05_bez_grananja_po_tipu)

Показујемо како изгледа код у коме не постоји гранање облика:

```java
if (prevoz instanceof Autobus) { ... }
else if (prevoz instanceof Voz) { ... }
else if (prevoz instanceof Taksi) { ... }
```

Такав ланац често значи да нисмо искористили полиморфизам. Метода `Ponuda.ispisi` прима само `Prevoz` и не зна које конкретне класе постоје.

Додавање нове врсте превоза не треба да захтева мењање сваког места у програму које рачуна цену.

### [`primer06_rezervacija_prevoza`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam/src/primer06_rezervacija_prevoza)

Овај пример спаја претходне две недеље:

```text
Autobus IS-A Prevoz
Taksi   IS-A Prevoz

RezervacijaPrevoza HAS-A Putnik
RezervacijaPrevoza HAS-A Relacija
RezervacijaPrevoza HAS-A Prevoz
```

Ово је важна порука: **композиција и наслеђивање нису конкурентске технике**. У реалном моделу често постоје истовремено.

### [`primer07_overload_override`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/05.nasledjivanje.apstrakcija.polimorfizam/src/primer07_overload_override)

Последњи пример разликује overloading и overriding, и показује зашто је `toString()` посебна метода. Објашњење је у одељку [Overloading, overriding и toString](#overloading-overriding-и-tostring).

## Централне поруке

### Наслеђивање моделује тип, не само поновну употребу кода

Лош разлог:

> "Обе класе имају назив и цену, хајде да једна наследи другу."

Боље питање:

> "Да ли је објекат изведене класе стварно једна посебна врста базног појма?"

### Полиморфизам је кориснији од проверавања типа

Желимо:

```java
int cena = prevoz.izracunajCenu(udaljenostKm);
```

уместо да остатак програма зна све конкретне класе које постоје.

### Базни тип представља заједнички уговор понашања

Ако метода прима `Prevoz`, она може да ради са било којом постојећом или будућом врстом превоза која поштује тај уговор.

## Питања за дискусију

1. Да ли је `Autobus` посебна врста `Prevoz`?
2. Да ли би `Putnik extends Prevoz` имао смисла само зато што путник користи превоз?
3. Зашто конструктор изведене класе позива `super(...)`?
4. Која имплементација методе се позива ако променљива има тип `Prevoz`, а објекат је `Taksi`?
5. Да ли конкретан тип референце или конкретан тип објекта одређује редефинисану методу која ће бити позвана?
6. Зашто `Prevoz` може да буде апстрактна класа?
7. Може ли се направити `new Prevoz(...)` ако је `Prevoz` апстрактан?
8. Шта добијамо тиме што метода прима `Prevoz`, уместо посебно `Autobus`, `Voz` и `Taksi`?
9. Зашто велики `instanceof` ланац често представља сигнал за другачији дизајн?
10. Како завршни пример истовремено користи и IS-A и HAS-A?

## Мали задатак

У фајлу `ZADATAK.md` налази се модел улазница за догађај. Задатак тражи легитимну хијерархију, редефинисање обрачуна цене и полиморфну обраду више различитих врста улазница.

## Overloading, overriding и toString

Покрените `primer07_overload_override.Main`. Различити потписи исте методе дају
overloading; избор се заснива на типовима израза при компајлирању. Override исте
инстанце методе бира имплементацију према стварном објекту при извршавању.
`protected` у примеру допушта подкласи у другом пакету да позове наслеђену методу;
не чини је јавном свим клијентима. Правила приступа кроз референце у другом пакету
имају додатна ограничења и нису исто што и public.

`toString()` је метода Object-а. `println(objekat)` користи њен текст; наше раније
`opis()` методе биле су обичне доменске методе, без тог аутоматског повезивања.
