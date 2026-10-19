# Недеља 11 — Датотеке и изузеци

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci) · [преузми пројекат (ZIP)](../11.datoteke.i.izuzeci.zip) · [задатак за самостални рад](ZADATAK.md)

Ове недеље спајамо две теме које природно припадају заједно:

- рад са датотекама;
- обраду грешака помоћу изузетака.

Уместо да `try/catch` учимо на вештачким примерима, користимо реалан проблем:

> учитати податке из датотеке, проверити их и одлучити шта радити када нешто није исправно.

Главни домен је списак резервација путовања.

Један ред фајла изгледа овако:

```text
ime,prezime,godine,destinacija
```

На пример:

```text
Ana,Jovanovic,22,Rim
Marko,Petrovic,abc,Pariz
Milica,Ilic,31,Atina
```

Други ред садржи грешку: `abc` није број година.

---

## Циљеви

После вежби студент треба да уме да:

- чита текстуалну датотеку ред по ред;
- разуме зашто рад са фајловима може да произведе грешке које не можемо унапред спречити;
- користи `try/catch`;
- разуме разлику између хватања и прослеђивања изузетка;
- користи `throws`;
- направи сопствени изузетак за грешку домена;
- користи `try-with-resources`;
- разуме зашто ресурс попут фајла треба поуздано затворити;
- разликује техничку грешку од грешке у садржају података;
- донесе одлуку да ли неисправан ред треба прескочити или прекинути цео процес.

---

## Редослед примера

### [`primer01_citanje_fajla`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer01_citanje_fajla)

Прво само читамо фајл:

```java
BufferedReader
FileReader
readLine()
```

Циљ није да учимо целу `java.io` библиотеку.

Довољно је разумети:

```text
otvori fajl
čitaj red po red
zatvori fajl
```

Одмах се појављује питање:

> Шта ако фајл не постоји?

### [`primer02_try_catch`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer02_try_catch)

Отварање и читање фајла може да баци `IOException`.

Користимо:

```java
try {
    ...
} catch (IOException e) {
    ...
}
```

Поента није "ухвати све".

Поента је:

> Овај део програма зна како да реагује на конкретну грешку.

### [`primer03_parsiranje_i_vise_gresaka`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer03_parsiranje_i_vise_gresaka)

Сада читамо CSV ред и претварамо:

```text
godine
```

у `int`.

Можемо добити различите проблеме:

- `IOException` — проблем са фајлом;
- `NumberFormatException` — податак није број;
- погрешан број поља — лош формат реда.

То су различите грешке и не морају све да се третирају исто.

### [`primer04_sopstveni_izuzetak`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer04_sopstveni_izuzetak)

Уводи се:

```java
NeispravanRedException
```

Зашто?

Зато што желимо да код који парсира резервацију каже:

> Овај ред не представља исправну резервацију.

То је прецизније од генеричког `Exception`.

Метода:

```java
Rezervacija parsiraj(String red)
```

може да има:

```java
throws NeispravanRedException
```

Тиме јасно комуницира део свог уговора.

### [`primer05_try_with_resources`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer05_try_with_resources)

Ручно затварање:

```java
reader.close();
```

је лако заборавити, нарочито ако се између отварања и затварања деси изузетак.

Зато користимо:

```java
try (BufferedReader reader = ...) {
    ...
}
```

Ресурс се затвара аутоматски.

Ово је преферирани начин за ресурсе који имплементирају `AutoCloseable`.

### [`primer06_odgovornost_za_gresku`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer06_odgovornost_za_gresku)

Најважнији пример.

Метода која парсира један ред:

```java
parsira red
```

не мора да одлучује:

```text
da li da prekine ceo program
da li da preskoči red
da li da prikaže upozorenje
```

То је одлука вишег нивоа.

На пример:

```java
UcitajRezervacije
```

може да одлучи:

> неисправан ред прескачемо, али настављамо са остатком фајла.

Овде се лепо види раздвајање одговорности.

---

## Техничке и доменске грешке

Користан ментални модел:

### Техничка грешка

Примери:

```text
fajl ne postoji
nema dozvole za čitanje
disk problem
```

Типично долазе из библиотеке, нпр. `IOException`.

### Доменска грешка

Примери:

```text
godine su negativne
nedostaje destinacija
red nema očekivani broj kolona
```

То су правила нашег програма.

За њих често има смисла сопствени изузетак:

```java
NeispravanRedException
```

---

## `throw` и `throws`

### `throw`

Заиста бацамо објекат изузетка:

```java
throw new NeispravanRedException("...");
```

### `throws`

У потпису методе најављујемо да метода може да проследи одређени изузетак:

```java
public static Rezervacija parsiraj(String red)
        throws NeispravanRedException
```

Ове две ствари не треба мешати.

---

## Checked и unchecked изузеци

Java разликује две велике групе.

### Checked

Пример:

```java
IOException
```

Компајлер захтева да га:

- ухватимо;
- или проследимо помоћу `throws`.

### Unchecked

Пример:

```java
NumberFormatException
IllegalArgumentException
NullPointerException
```

Компајлер нас не тера да их наведемо у потпису.

За овај курс није циљ да памтимо читаву хијерархију изузетака.

Важно је разумети:

> ко може да поправи проблем и на ком нивоу га треба обрадити.

---

## Зашто не `catch (Exception e)` свуда?

Зато што такав `catch` често сакрије разлику између потпуно различитих проблема.

Боље је да код јасно говори:

```java
catch (IOException e)
```

или:

```java
catch (NeispravanRedException e)
```

када заиста знамо шта са тим проблемом треба урадити.

Широки `catch (Exception e)` понекад има смисла на границама апликације, али није добар подразумевани стил за пословну логику.

---

## `finally`

`finally` треба објаснити јер је део језика:

```java
try {
    ...
} finally {
    ...
}
```

Код из `finally` блока се извршава без обзира на то да ли је дошло до изузетка.

Али за затварање фајлова данас ћемо углавном користити:

```java
try-with-resources
```

јер је безбедније и читљивије.

---

## Питања за дискусију

1. Зашто метода за читање фајла може да не успе иако је наш код исправан?
2. Која је разлика између `throw` и `throws`?
3. Када има смисла да метода ухвати изузетак, а када да га проследи?
4. Зашто `NumberFormatException` не морамо да наведемо у `throws`?
5. Зашто сопствени `NeispravanRedException` може бити бољи од обичног `Exception`?
6. Да ли парсер једног реда треба да одлучује да ли се прекида цео програм?
7. Ко треба да одлучи да ли се неисправан ред прескаче?
8. Зашто је `try-with-resources` бољи од ручног `close()`?
9. Шта се дешава са ресурсом ако се изузетак деси усред `try` блока?
10. Зашто није добро свуда користити `catch (Exception e)`?
11. Да ли свака неисправна вредност мора да се моделује изузетком?
12. Када је обичан `if` бољи од бацања изузетка?

---

## Мини задатак

У `ZADATAK.md` налази се учитавање списка пријављених студената из фајла.

Задатак комбинује:

- читање фајла;
- парсирање;
- сопствени изузетак;
- прескакање лоших редова;
- колекцију из претходне недеље.

## Допуне: упис, формат и assert

[`primer07_pisanje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer07_pisanje) одваја учитавање од писања текстуалног извештаја. Радни
директоријум је фолдер пројекта, не фолдер класе. Улаз и излаз користе UTF-8.
Завршни парсер задржава све провере из претходног примера. `split(",", -1)`
чува завршна празна поља; ово није пун CSV парсер (нема quoting/escaping подршке).

[`primer08_assert`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/11.datoteke.i.izuzeci/src/primer08_assert) показује интерну тврдњу и покретање са `-ea`. Тврдње нису
замена за валидацију јавних аргумената јер могу бити искључене. Експлицитно бачен
AssertionError у проверама из недеље 13 не зависи од тог прекидача.
