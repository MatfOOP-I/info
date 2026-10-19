# Недеља 9 — Генерички типови

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/09.genericki.tipovi) · [преузми пројекат (ZIP)](../09.genericki.tipovi.zip) · [задатак за самостални рад](ZADATAK.md)

До сада смо правили класе које раде са унапред познатим типовима.

На пример:

```java
class PaketTelefona {
    private Telefon sadrzaj;
}
```

Али шта ако је понашање класе потпуно исто без обзира на то да ли пакет садржи:

- телефон;
- књигу;
- патике;
- неки наш објекат?

Једна могућност је да користимо `Object`.

То ради, али губимо информацију о типу.

Генерици нам омогућавају да напишемо једну апстракцију која ради за различите типове, а да компајлер и даље проверава исправност типова.

## Главна идеја

Генерици нису првенствено начин да пишемо необичне изразе са:

```text
<T>
<K, V>
<? extends T>
```

Њихов главни циљ у овом курсу је:

> **поновна употреба кода без губитка type safety-ja.**

---

## Циљеви

После вежби студент треба да уме да:

- објасни проблем чувања вредности као `Object`;
- направи генеричку класу;
- користи генерички тип са различитим аргументима типа;
- објасни да `Paket<Telefon>` и `Paket<Knjiga>` нису исти тип;
- напише једноставну генеричку методу;
- направи генерички интерфејс;
- користи ограничење типа, нпр. `<T extends Procenjiv>`;
- разуме основну мотивацију за wildcard `?`;
- препозна генерике у стандардним колекцијама које ћемо радити следеће недеље.

---

## Редослед примера

### [`primer01_problem_sa_object`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/09.genericki.tipovi/src/primer01_problem_sa_object)

Правимо класу:

```java
Paket
```

која чува:

```java
private Object sadrzaj;
```

Можемо ставити било који објекат.

Проблем настаје приликом читања:

```java
Telefon telefon = (Telefon) paket.getSadrzaj();
```

Потребно је експлицитно кастовање.

Још горе:

```java
Knjiga knjiga = (Knjiga) paket.getSadrzaj();
```

компајлер то дозвољава, а грешку добијамо тек током извршавања.

### [`primer02_genericka_klasa`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/09.genericki.tipovi/src/primer02_genericka_klasa)

Уводимо:

```java
public class Paket<T>
```

Сада:

```java
Paket<Telefon>
Paket<Knjiga>
```

користе исту имплементацију класе, али компајлер зна шта се налази у конкретном пакету.

Добијамо:

```java
Telefon telefon = paketTelefona.getSadrzaj();
```

без кастовања.

А ово више не може да се компајлира:

```java
Paket<Telefon> paket = new Paket<>(...);
paket.postaviSadrzaj(new Knjiga(...));
```

Грешка се открива **при компајлирању**, а не код корисника програма.

### [`primer03_genericka_metoda`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/09.genericki.tipovi/src/primer03_genericka_metoda)

Није обавезно да цела класа буде генеричка.

Можемо направити само једну генеричку методу:

```java
public static <T> void prebaci(
        Paket<T> izvor,
        Paket<T> odrediste
)
```

Тип `T` се закључује из аргумената.

Иста метода ради за `Paket<String>`, `Paket<Integer>` и пакет било ког другог типа, без дуплирања имплементације.

### [`primer04_genericki_interfejs`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/09.genericki.tipovi/src/primer04_genericki_interfejs)

Интерфејс такође може бити генерички:

```java
public interface Skladiste<T>
```

Његов уговор каже:

```java
void smesti(T predmet);
T preuzmi();
boolean jePrazno();
```

Имплементација:

```java
JednomesnoSkladiste<T>
```

не мора унапред да зна који ће конкретан тип чувати.

Ово је важна припрема за:

```java
List<T>
Set<T>
Map<K, V>
```

из стандардне библиотеке.

### [`primer05_ogranicenje_tipa`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/09.genericki.tipovi/src/primer05_ogranicenje_tipa)

Понекад није довољно рећи:

```java
<T>
```

јер желимо да над `T` можемо да позовемо одређену операцију.

Дефинишемо:

```java
public interface Procenjiv {
    int proceniVrednost();
}
```

и затим:

```java
public class OsiguraniPaket<T extends Procenjiv>
```

Сада компајлер зна да сваки `T` има:

```java
proceniVrednost()
```

Зато `OsiguraniPaket` може без кастовања да израчуна цену осигурања.

### [`primer06_wildcard`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/09.genericki.tipovi/src/primer06_wildcard)

Овај пример је намерно краћи.

Генерички типови у Јави су **инваријантни**.

То значи да, иако:

```text
Telefon IS-A Procenjiv
```

не следи:

```text
Paket<Telefon> IS-A Paket<Procenjiv>
```

Када желимо методу која само чита различите пакете процењивих предмета, можемо користити:

```java
Paket<? extends Procenjiv>
```

За ову недељу је довољно разумети мотивацију.

Детаљне комбинације `extends` и `super` нису циљ курса.

---

## Зашто не само `Object`?

Без генерика:

```java
Object sadrzaj = ...
```

компајлер губи прецизну информацију о типу.

Онда корисник мора да зна шта је стварно унутра и да кастује.

Са генериком:

```java
Paket<Telefon>
```

информација о типу постаје део потписа.

Компајлер може да провери код пре извршавања.

---

## Генерици и ООП

Генерици нису замена за полиморфизам.

На пример:

```java
List<NacinPlacanja>
```

може да садржи различите имплементације интерфејса `NacinPlacanja`.

Овде истовремено користимо:

- генерике да кажемо који тип елемената колекција прихвата;
- полиморфизам да различити конкретни објекти могу бити посматрани кроз заједнички интерфејс.

Ове две идеје се веома често користе заједно.

---

## Type erasure — само напомена

Java генерици су имплементирани помоћу механизма који се зове **type erasure**.

За овај курс није потребно детаљно проучавати његову имплементацију.

Важно је само знати да због тога постоје нека ограничења, на пример не можемо једноставно писати:

```java
new T()
```

или:

```java
new T[10]
```

Немојте памтити листу ограничења напамет. Када наиђемо на конкретан случај, објаснићемо га.

---

## Питања за дискусију

1. Шта губимо када вредност чувамо као `Object`?
2. Када се грешка погрешног кастовања открива?
3. Шта значи `T` у `Paket<T>`?
4. Да ли је `T` посебна Java кључна реч?
5. Да ли су `Paket<Telefon>` и `Paket<Knjiga>` исти тип?
6. Зашто нам код генеричке класе више није потребан cast?
7. Која је разлика између генеричке класе и генеричке методе?
8. Зашто интерфејс `Skladiste<T>` има смисла?
9. Зашто `OsiguraniPaket<T>` није довољан ако жели да позива `proceniVrednost()`?
10. Шта нам гарантује `<T extends Procenjiv>`?
11. Зашто `Paket<Telefon>` није аутоматски `Paket<Procenjiv>`?
12. Где ћемо следеће недеље видети генерике у стандардној библиотеци?

---

## Мини задатак

У `ZADATAK.md` налази се пример **паметног ормарића**.

Студент треба да направи генерички `Ormaric<T>` и затим ограничену генеричку класу за предмете који имају масу.

### Уговор складишта (пример04)

`null` означава празно складиште, па га није дозвољено сместити као предмет.
Покушај смештања у заузето складиште баца `IllegalStateException`, без промене
постојећег садржаја. `preuzmi()` из празног складишта враћа null. Политика је
експлицитна да позивалац не нагађа да ли је операција успела.
