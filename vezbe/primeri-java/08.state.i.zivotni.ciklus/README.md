# Недеља 8 — State и животни циклус објекта

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/08.state.i.zivotni.ciklus) · [преузми пројекат (ZIP)](../08.state.i.zivotni.ciklus.zip) · [задатак за самостални рад](ZADATAK.md)

Претходне недеље смо видели Strategy:

> објекат користи заменљиво понашање које можемо да променимо.

Сада разматрамо другачији проблем:

> понашање објекта зависи од његовог тренутног стања.

Главни пример је поруџбина.

Поруџбина пролази кроз животни циклус:

```text
NOVA → PLACENA → POSLATA → ISPORUCENA
  \        \
   \        → OTKAZANA
    → OTKAZANA
```

Нису све операције дозвољене у сваком стању.

На пример:

- нова поруџбина може да се плати;
- плаћена може да се пошаље;
- послата може да се означи као испоручена;
- испоручена не може поново да се плати;
- отказана више не може да настави нормалан ток.

## Циљеви

После вежби студент треба да уме да:

- разликује **идентитет објекта** од његовог тренутног стања;
- препозна проблем када подкласе представљају пролазна стања истог објекта;
- објасни зашто `if/switch` над стањем може да постане проблем када понашање расте;
- моделује стање као посебан објекат;
- делегира операције тренутном state објекту;
- разуме основну идеју State обрасца;
- упореди State и Strategy;
- разуме да State није аутоматски бољи од једноставног `enum + switch` решења.

---

## Редослед примера

### [`primer01_stanje_kao_podklasa`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/08.state.i.zivotni.ciklus/src/primer01_stanje_kao_podklasa)

Прво покушавамо да моделујемо:

```text
Porudzbina
├── NovaPorudzbina
├── PlacenaPorudzbina
└── PoslataPorudzbina
```

То на први поглед изгледа разумно.

Проблем се јавља када поруџбина пређе из једног стања у друго.

Ако:

```java
NovaPorudzbina
```

после плаћања треба да постане:

```java
PlacenaPorudzbina
```

морамо да направимо **нов објекат**.

То отвара питање:

> Да ли се променила поруџбина или само њено стање?

### [`primer02_problem_identiteta`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/08.state.i.zivotni.ciklus/src/primer02_problem_identiteta)

Демонстрирамо проблем са референцама.

Један део програма чува референцу на стару `NovaPorudzbina`, док други добије нову `PlacenaPorudzbina`.

Домен каже:

> то је иста поруџбина.

Али наш модел каже:

> то су два различита Java објекта.

То је сигнал да можда моделујемо стање на погрешном месту.

### [`primer03_enum_i_switch`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/08.state.i.zivotni.ciklus/src/primer03_enum_i_switch)

Уводи се једноставније решење:

```java
enum StatusPorudzbine {
    NOVA,
    PLACENA,
    POSLATA,
    OTKAZANA
}
```

и методе:

```java
plati()
posalji()
otkazi()
```

са проверама стања.

Ово решење је потпуно легитимно за мали систем.

Важна порука:

> State pattern није обавезан чим постоји enum.

### [`primer04_rast_switch_logike`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/08.state.i.zivotni.ciklus/src/primer04_rast_switch_logike)

Када се правила повећају, исте провере стања почињу да се понављају кроз више метода.

Тада се понашање везано за стање расипа кроз једну велику класу.

Ту се јавља разлог да покушамо другачији дизајн.

### [`primer05_state_objekti`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/08.state.i.zivotni.ciklus/src/primer05_state_objekti)

Уводимо интерфејс:

```java
public interface StanjePorudzbine {
    void plati(Porudzbina porudzbina);
    void posalji(Porudzbina porudzbina);
    void otkazi(Porudzbina porudzbina);

    String naziv();
}
```

Метода `naziv()` враћа име стања; `Porudzbina.trenutnoStanje()` је само прослеђује.

Конкретна стања:

```text
NovoStanje
PlacenoStanje
PoslatoStanje
OtkazanoStanje
```

`Porudzbina` сада:

```text
HAS-A StanjePorudzbine
```

и делегира:

```java
stanje.plati(this);
```

### [`primer06_tranzicije`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/08.state.i.zivotni.ciklus/src/primer06_tranzicije)

Конкретно стање може да одреди следеће стање.

На пример:

```java
NovoStanje.plati(...)
```

после успешног плаћања ради:

```java
porudzbina.postaviStanje(new PlacenoStanje());
```

Тако правило транзиције живи уз понашање стања коме припада.

---

## State образац

State користимо када:

- објекат пролази кроз јасна стања;
- дозвољене операције зависе од тренутног стања;
- понашање у тим стањима постаје довољно велико;
- желимо да правила појединачних стања издвојимо из главне класе.

Важно:

> циљ није "избацити сваки switch".

Ако имамо три стања и две једноставне провере, `enum + switch` може бити читљивији.

State има смисла када животни циклус и понашање постану довољно сложени.

---

## State и Strategy — сличности и разлике

Технички могу изгледати слично:

```text
interfejs
više implementacija
kompozicija
delegiranje
polimorfizam
```

Али намера је другачија.

### Strategy

Питање је:

> Који начин извршавања желимо да користимо?

Пример:

```text
Hodanje
Voznja
Plivanje
```

Спољни код често бира стратегију.

### State

Питање је:

> У ком стању је објекат и шта је сада дозвољено?

Пример:

```text
NOVA
PLACENA
POSLATA
```

Сама стања често управљају прелазима.

---

## Важна идеја: идентитет != стање

Поруџбина са бројем:

```text
#1042
```

остаје поруџбина `#1042` и када је:

```text
NOVA
PLACENA
POSLATA
ISPORUCENA
```

Мења се њено стање, не њен идентитет.

Зато је природније да:

```java
class Porudzbina {
    private final int broj;
    private StanjePorudzbine stanje;
}
```

него да за сваку транзицију правимо нови објекат поруџбине.

---

## Питања за дискусију

1. Зашто `PlacenaPorudzbina extends Porudzbina` на први поглед изгледа логично?
2. Да ли "плаћена" описује врсту поруџбине или тренутно стање?
3. Шта се дешава са старим референцама ако транзицију моделујемо прављењем новог објекта?
4. Када је `enum + switch` сасвим добро решење?
5. Када велики број провера статуса постаје знак проблема?
6. Где се у State решењу налази композиција?
7. Где се дешава делегирање?
8. Ко одлучује о следећем стању?
9. Зашто је `postaviStanje(...)` у примеру намерно ограничена/package-private метода?
10. Која је главна разлика између Strategy и State?
11. Да ли State значи да више никада не треба користити `enum`?
12. Како бисте додали стање `ISPORUCENA`?

---

## Мини задатак

У фајлу `ZADATAK.md` налази се модел **резервације биоскопске карте**.

Резервација пролази кроз:

```text
KREIRANA → PLACENA → ISKORISCENA
   \            \
    → OTKAZANA   → OTKAZANA
```

Циљ је да студент самостално примени State без копирања поруџбине.

### Табела прелаза поруџбине (пример06)

Пре имплементације задатка корисно је видети како изгледа табела прелаза за поруџбину из `primer06_tranzicije`. За резервацију карте треба направити сличну табелу.

| Стање | plati | posalji | isporuci | otkazi |
|---|---|---|---|---|
| NOVA | PLACENA | одбиј | одбиј | OTKAZANA |
| PLACENA | одбиј | POSLATA | одбиј | OTKAZANA |
| POSLATA | одбиј | одбиј | ISPORUCENA | одбиј |
| ISPORUCENA | одбиј | одбиј | одбиј | одбиј |
| OTKAZANA | одбиј | одбиј | одбиј | одбиј |

У овим малим примерима одбијање исписује поруку и не мења стање. У завршном
моделу из недеље 13 користи се изузетак. Package-private setter у овој недељи је
наставни корак: сав код истог пакета је сарадник од поверења. Приватне угњеждене
имплементације у недељи 13 додатно сужавају тај приступ.
