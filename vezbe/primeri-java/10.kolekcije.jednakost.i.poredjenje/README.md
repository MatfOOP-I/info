# Недеља 10 — Колекције, једнакост и поређење

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje) · [преузми пројекат (ZIP)](../10.kolekcije.jednakost.i.poredjenje.zip) · [задатак за самостални рад](ZADATAK.md)

Ове недеље спајамо неколико тема које су тесно повезане:

- `List`;
- `Set`;
- `Map`;
- `equals` и `hashCode`;
- `Comparable`;
- `Comparator`.

Главни домен су **песме и плејлисте**.

Идеја није да напамет научимо велики број класа из Java библиотеке, већ да научимо да поставимо питање:

> Какву колекцију података заправо желим да моделујем?

---

## Циљеви

После вежби студент треба да уме да:

- објасни основну разлику између `List`, `Set` и `Map`;
- изабере одговарајућу колекцију према семантици проблема;
- користи `ArrayList`, `HashSet` и `HashMap`;
- објасни зашто `HashSet` и `HashMap` зависе од `equals` и `hashCode`;
- разликује идентитет објекта од семантичке једнакости;
- правилно имплементира уговор `equals/hashCode`;
- дефинише природни поредак помоћу `Comparable`;
- дефинише алтернативне поретке помоћу `Comparator`;
- препозна `Comparator` као практичан пример Strategy обрасца;
- користи `enum` као природан тип за коначан скуп вредности.

---

## `enum Zanr`

У примерима користимо:

```java
public enum Zanr {
    POP,
    ROCK,
    JAZZ,
    KLASICNA,
    ELEKTRONSKA,
    OSTALO
}
```

`enum` користимо када имамо **коначан, познат скуп вредности**.

То је боље од:

```java
String zanr;
```

јер компајлер може да спречи вредности попут:

```text
"rok"
"Rock"
"ROCKK"
```

`enum` је прави Java тип и може:

- да се користи као тип поља;
- да се прослеђује методама;
- да буде кључ у колекцијама;
- да се пореди са `==`.

---

## Редослед примера

### [`primer01_lista`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer01_lista)

Правимо плејлисту помоћу:

```java
List<Pesma> plejlista = new ArrayList<>();
```

`List` користимо када су важни:

- редослед;
- позиција елемента;
- могућност да исти елемент постоји више пута.

У плејлисти дупликати могу да постоје.

То није грешка `List`-е, већ њена семантика.

Важно је приметити и стил:

```java
List<Pesma> plejlista = new ArrayList<>();
```

Променљива је типа интерфејса `List`, а конкретна имплементација је `ArrayList`.

Ово је иста идеја програмирања према уговору коју смо већ видели код сопствених интерфејса.

### [`primer02_skup_bez_jednakosti`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer02_skup_bez_jednakosti)

Желимо колекцију омиљених песама без дупликата.

Природно покушавамо:

```java
Set<Pesma> omiljene = new HashSet<>();
```

Додамо два различита Java објекта који представљају исту песму.

Без редефинисаног `equals/hashCode`, `HashSet` их сматра различитим.

Зашто?

Подразумевана једнакост објеката се практично ослања на њихов идентитет.

Домен, међутим, можда каже:

> песме са истим извођачем и насловом сматрамо истом песмом.

### [`primer03_equals_i_hashcode`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer03_equals_i_hashcode)

Имплементирамо семантичку једнакост:

```java
@Override
public boolean equals(Object objekat)
```

и повезани:

```java
@Override
public int hashCode()
```

Важан уговор:

> Ако су два објекта једнака по `equals`, морају имати исти `hashCode`.

Обрнуто не мора да важи.

Два различита објекта могу имати исти hash код.

### [`primer04_mapa`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer04_mapa)

Користимо:

```java
Map<String, Pesma>
```

за каталог у коме је кључ јединствена шифра песме.

`Map` моделује везу:

```text
ključ → vrednost
```

Кључ је јединствен.

Позив:

```java
mapa.put(istiKljuc, novaVrednost)
```

замењује претходну вредност за тај кључ.

Типични случајеви:

- шифра производа → производ;
- корисничко име → корисник;
- регистарска ознака → возило;
- индекс → студент.

### [`primer05_comparable`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer05_comparable)

Неким објектима желимо да дамо један **природан поредак**.

`Pesma` имплементира:

```java
Comparable<Pesma>
```

и дефинише:

```java
compareTo(...)
```

У примеру природни поредак је:

1. наслов;
2. извођач.

То омогућава:

```java
Collections.sort(pesme);
```

и коришћење уређених колекција попут:

```java
TreeSet<Pesma>
```

Важно:

Природни поредак треба бирати само када постоји један разуман подразумевани поредак.

### [`primer06_comparator`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer06_comparator)

Један природни поредак није довољан.

Исту плејлисту некад желимо да сортирамо:

- по трајању;
- по извођачу;
- по наслову.

Не желимо да мењамо класу `Pesma` сваки пут.

Зато користимо:

```java
Comparator<Pesma>
```

и конкретне имплементације:

```text
PoredjenjePoTrajanju
PoredjenjePoIzvodjacu
```

Ово је одличан пример Strategy обрасца из стандардне Java библиотеке:

```text
Comparator<Pesma> = strategija poređenja
```

Алгоритам сортирања остаје исти, а начин поређења мењамо.

### [`primer07_lambda`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer07_lambda)

Исти `Comparator` пишемо на три начина: именованом класом, анонимном класом и ламбдом. Објашњење је у одељку [Мост до JavaFX-a](#мост-до-javafx-a).

### [`primer08_ugovori_skupova`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer08_ugovori_skupova)

Показује шта се дешава када `Comparator` и `equals` не говоре исто о томе које су две песме „исте“. Објашњење је у одељку [Једнакост и поредак морају да се размотре заједно](#једнакост-и-поредак-морају-да-се-размотре-заједно).

---

## List, Set или Map?

### `List`

Користимо када је важан уређени низ елемената:

```text
red pesama
lista obaveza
istorija poruka
```

Дозвољава дупликате.

### `Set`

Користимо када желимо колекцију јединствених елемената:

```text
omiljene pesme
prisutni studenti
posećene države
```

Питање "шта значи јединствен?" води нас до `equals/hashCode`.

### `Map`

Користимо када податак природно проналазимо по кључу:

```text
indeks → student
šifra → proizvod
korisničko ime → nalog
```

`Map` није "листа са два податка".

Кључ има посебну семантику.

---

## Зашто су `equals` и `hashCode` ООП тема?

Зато што класа сама треба да зна:

> Када два моја објекта представљају исту ствар у домену?

На пример:

```text
Pesma("Numb", "Linkin Park")
Pesma("Numb", "Linkin Park")
```

То су два различита Java објекта.

Али можемо одлучити да представљају исту песму.

То је одлука модела, не одлука `HashSet` класе.

---

## `==` и `equals`

За објекте:

```java
a == b
```

пита да ли обе референце показују на исти објекат.

```java
a.equals(b)
```

пита да ли их класа сматра семантички једнаким.

Ове две ствари не треба мешати.

---

## Уговор `equals/hashCode`

Најважнија практична правила:

1. Ако `a.equals(b)` враћа `true`, онда `a.hashCode()` и `b.hashCode()` морају бити исти.
2. Поља која учествују у `equals` треба доследно да учествују и у `hashCode`.
3. Не треба мењати поља која одређују једнакост док је објекат кључ у hash колекцији.

Трећа тачка је напреднија, али је корисно поменути зашто су непроменљиви идентификациони подаци често добра идеја.

---

## `Comparable` или `Comparator`?

### Comparable

Класа каже:

> Ово је мој природни поредак.

```java
class Pesma implements Comparable<Pesma>
```

### Comparator

Спољни објекат каже:

> Ево једног могућег начина поређења две песме.

```java
class PoredjenjePoTrajanju implements Comparator<Pesma>
```

Користимо Comparator када:

- имамо више смислених поредака;
- не желимо да мењамо саму класу;
- правило поређења припада конкретном случају употребе.

---

## Питања за дискусију

1. Зашто плејлиста природно треба да буде `List`, а не `Set`?
2. Да ли `List` гарантује јединственост елемената?
3. Зашто `HashSet` у другом примеру дозвољава две "исте" песме?
4. Која је разлика између `==` и `equals`?
5. Ко треба да дефинише семантичку једнакост класе `Pesma`?
6. Зашто уз `equals` имплементирамо и `hashCode`?
7. Да ли исти `hashCode` значи да су објекти једнаки?
8. Шта се дешава када `Map.put` добије кључ који већ постоји?
9. Зашто декларисати `List<Pesma>`, а правити `new ArrayList<>()`?
10. Који поредак би требало да буде природни поредак песме?
11. Зашто трајање није нужно добар природни поредак?
12. Како `Comparator` личи на Strategy из недеље 7?
13. Зашто `TreeSet` мора да зна како да пореди елементе?
14. Када бисте изабрали `Set`, а када `Map`?

---

## Мини задатак

У `ZADATAK.md` налази се модел личне библиотеке књига.

Студент треба да употреби:

- `List`;
- `Set`;
- `Map`;
- `equals/hashCode`;
- `Comparable`;
- најмање два `Comparator` објекта;
- `enum`.

Тиме у једном задатку повезује све теме ове недеље.

## Једнакост и поредак морају да се размотре заједно

Код класе `Pesma` једнакост и природни поредак користе наслов и извођача; трајање је
изостављено из једнакости по одлуци овог поједностављеног домена. Ту одлуку
задржавамо и у примеру са `Comparator`-ом.

`TreeSet` сматра два елемента истим ако поређење даје 0. Comparator који пореди
само трајање добар је за сортирање листе, али не за скуп свих различитих песама.
То демонстрира [`primer08_ugovori_skupova`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer08_ugovori_skupova). HashSet/HashMap не обећавају редослед
обиласка. Не мењати поља која одређују једнакост док је објекат у hash колекцији.

За обилазак мапе користити `entrySet()`. Брисање током обиласка радити преко
Iterator.remove или, после увода у ламбда изразе, removeIf; не мењати листу обичним
remove позивом усред enhanced-for петље. Колекције и итераторе шире пратити уз предавања.

## Мост до JavaFX-a

У [`primer07_lambda`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/10.kolekcije.jednakost.i.poredjenje/src/primer07_lambda) исти Comparator пишемо именованом класом, анонимном класом и
ламбдом. Функционални интерфејс има једну апстрактну операцију (уз правила о Object
методама). У JavaFX-u handler је callback: региструјемо понашање које ће се позвати
касније, када се деси догађај. Детаљан Stream API није предуслов овог низа вежби.
