# Објектно орјентисано

# програмирање

## Владимир Филиповић

## vladaf@matf.bg.ac.rs

## Александар Картељ

## kartelj@matf.bg.ac.rs


# Енумерисани и генерички

# типови

## Владимир Филиповић

## vladaf@matf.bg.ac.rs

## Александар Картељ

## kartelj@matf.bg.ac.rs



```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 9 / 35
```
- Генерички тип омогућује да при дефинисању класа, интерфејса

##### и метода сами типови (тј. класе и интерфејси) буду параметри.

- Дакле, генерички типови се понашају слично као формални

##### параметри при дефинисању метода.

- Програмирање коришћењем генеричких типова има следеће

##### предности:

##### 1. Строжија контрола типа приликом превођења Јава

##### програма.

##### 2. Елиминација експлицитне конверзије типа (кастовања).

##### 3. Омогућавање да се имплементирају генерички алгоритми.

## Појам генеричког типа


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 10 / 35
```
##### Код старог приступа

##### експлицитна конверзија

##### једосадна али

##### суштински неопходна!

## Предности генеричког типа

List stones = new LinkedList();
stones.add(new Stone(RED));
stones.add(new Stone(GREEN));
stones.add(new Stone(RED));
Stone first = (Stone) stones.get( 0 );

public int countStones(Color color) {
int tally = 0 ;
Iterator it = stones.iterator();
while (it.hasNext()) {
Stone stone = (Stone) it.next();
if (stone.getColor() == color)
tally++;
}
return tally;
}


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 11 / 35
```
##### У новом приступу

##### интерфејс Listје

##### генерички интерфејс

##### коме тип елемента

##### листе представља

##### параметар.

## Предности генеричког типа (2)

```
List<Stone> stones = new LinkedList<Stone>();
stones.add(new Stone(RED));
stones.add(new Stone(GREEN));
stones.add(new Stone(RED));
Stone first = /*no cast*/ stones.get( 0 );
```
```
public int countStones(Color color) {
int tally = 0 ; /*no temporary*/
for (Stone stone : stones) {
/*no temporary, no cast*/
if (stone.getColor() == color)
tally++;
}
return tally;
}
```

```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 12 / 35
```
##### стари

##### начин

##### нови

##### начин

##### Нема провере

##### Грешка при извршавању

##### Runtime error

##### Провера при

##### превођењу

##### Извршење је без

##### проблема

## Предности генеричког типа ( 3 )

```
List stones = new LinkedList();
stones.add(“ovo nije kamen”);
...
Stone stone = (Stone) stones.get( 0 );
```
```
List<Stone> stones = new LinkedList<Stone>();
stones.add(“ovo nije kamen”);
...
Stone stone = stones.get( 0 );
```

Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 13 / 35

##### Стари начин

##### Нови начин:

##### Дефинише се

##### генерички

##### интерфејс

##### који има тип

##### као

##### параметар

## Стек као генерички интерфејс

```
public interface StackInterface {
public boolean isEmpty();
public int size();
public void push(Object item);
public Object top();
public void pop();
}
```
```
public interface StackInterface<E> {
public boolean isEmpty();
public int size();
public void push(E item);
public E top();
public void pop();
}
```

```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 14 / 35
```
- Генерички тип је уствари генеричка класа или интерфејс са

##### параметризованим типовима.

##### Пример.

- Следећа класа, названа Box, ће бити модификована тако да опише

##### концепт генеричког типа. На почетку се ради о обичној класи.

```
public class Box {
private Object object;
```
```
public void set(Object object) {
this.object = object;
}
```
```
public Object get() {
return object;
}
}
```
## Дефинисање генеричког типа


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 15 / 35
```
- Генеричка класа се дефинише на следећи начин:

```
class name<T1, T2, ..., Tn> { /* ... */ }
```
- Секција са параметрима који представљају типове, ограничена са

##### знацима <и > следи непосредно иза имена класе.

- У тој секцији се специфицирају параметри који представљају

##### типове T1, T2, ..., и Tn.

- Сада класа Boxима следећу структуру:

```
public class Box<T> {
// T je oznaka tipa
private T t;
```
```
public void set(T t) {
this.t = t;
}
```
```
public T get() {
return t;
}
}
```
## Дефинисање генеричког типа (2)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 16 / 35
```
- Конвенције за именовање параметара који представљају тип код

##### генеричких типова, интерфејса и метода:

- По конвенцији, параметри су означени једним великим словом.
- Најчешће се користе следеће ознаке:
- E - Елеменат (енг. Element -њега ексклузивно користи Java

##### Collections Framework)

- K – Кључ (енг. Key)
- N – Број (енг. Number)
- T – Тип (енг. Type)
- V – Вредност (енг. Value)
- S,U,W итд. – други, трећи, четврти итд. тип

## Дефинисање генеричког типа (3)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 17 / 35
```
- Да би се из програмског кода реферисало на генеричку класу

#### Box, потребно је извршити генерички позив типа.

- То подразумева замену параметра Tконкретном вредношћу.

```
Box<Integer> integerBox;
```
- Генерички позив типа се може посматрати слично обичном

##### позиву метода, само се уместо вредности аргумента прослеђује

##### тип (у овом случају тип Integer).

- Позивање генеричког типа се обично означава као

#### параметарски тип.

- За креирње примерка класе користи се кључна реч new, али се

##### између имена класе и заграда поставља <Integer>:

```
Box<Integer> integerBox = new Box<Integer>();
```
## Генерички позив типа


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 18 / 35
```
- Програмски језик Јава допушта да се у конструктору примерка

##### генерички тип изостави ако преводилац може на основу

##### контекста да одреди ког типа треба да буду аргументи. Нпр.

###### Box<Integer> integerBox = new Box<>();

- Аргумент који представља тип се може приликом генеричког

##### позива заменити са:

- конкретним типом

##### (нпр. са Integerили са Student)

- али се може заменити и са параметризованим типом

##### (нпр. са Box<Double>или саList<String>).

## Генерички позив типа (2)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 19 / 35
```
- Генерички методи су они методи са параметрима који

##### представљају типове.

- Они су слични генеричким типовима, али је опсег параметара

##### ограничен на метод у ком су ти параметри декларисани.

- Синтакса за генерички метод садржи (пре повратног типа)

##### параметре који представљају тип између знака < и >.

- **Пример.** Класа Utilсадржи генерички метод compareза поређење

##### два примерка генеричке класе Pair:

public class Util {

public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2){
return p1.getKey().equals(p2.getKey()) &&
p1.getValue().equals(p2.getValue());
}
}

## Генерички метод


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 20 / 35
```
- **Пример (наставак):** Сама класа Pairима следећу структуру:

```
public class Pair<K, V> {
private K key;
private V value;
```
```
// Generički konstruktor
public Pair(K key, V value) {
this.key = key;
this.value = value;
}
```
```
// Generičke metode
public void setKey(K key) { this.key = key; }
public void setValue(V value) { this.value = value; }
public K getKey() { return key; }
public V getValue() { return value; }
}
```
## Генерички метод (2)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 21 / 35
```
- **Пример (наставак):** Синтакса за позив метода који пореди

##### примерке класе Pairје следећа:

```
Pair<Integer, String> p1 = new Pair<>( 1 , "apple");
Pair<Integer, String> p2 = new Pair<>( 2 , "pear");
boolean same = Util.<Integer, String>compare(p1, p2);
```
## Генерички метод ( 3 )


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 22 / 35
```
- Понекад је потребно да генеричка класа или генерички метод

##### постави ограничење на променљиве типа.

- **Пример:** Треба одредити најмањи елеменат низа:

```
class ArrayAlg {
public static <T> T min(T[] a){
if (a == null || a.length == 0 )
return null;
T smallest = a[ 0 ];
for (int i = 1 ; i < a.length; i++)
if (smallest.compareTo(a[i]) > 0 )
smallest = a[i];
return smallest;
}
}
```
- Променљива smallest је типа T, што значи да она може бити

##### примерак ма које класе. Одмах се поставља питање: како можемо

##### знати да класа T садржи метод compareTo?

## Ограничења за типове


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 23 / 35
```
- Решење је да се ограничи параметар типа T само на оне класе које

##### имплементирају интерфејс Comparable.

- Ово се постиже постављањем ограничења на променљиву типа T:

```
public static <T extends Comparable> T min(T[] a)
```
- У овом случају, интерфејс Comparableје и сам генерички тип.
- Сада се генерички метод minможе позивати само над низовима

##### примерака класа које имплементирају интерфејс Comparable, као

##### што су String, Dateитд.

- Позив овог метода над низом објеката неке класе која не

##### имплементира интерфејс Comparableдоводи до грешке у

##### превођењу.

## Ограничења за типове (2)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 24 / 35
```
- Поставља се питање: зашто се у претходном случају користи

##### кључна реч extends, а не нпр. implements– на крају крајева,

##### Comparable је интрефејс, а не класа.

- Нотација <T extends TipKojiOgranicava>изражава да параметарски

##### тип Tтреба да буде подтип типа који ограничава.

- При томе, и параметарски тип Tи тип који ограничава могу бити

##### и класе и интерфејси.

- Кључна реч extendsнајбоље описује такав однос међу њима, тј.

##### концепт подтипова - узевши у обзир да дизајнери Јаве нису

##### желели да додају нову кључну реч (нпр. sub) у језик.

## Ограничења за типове (3)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 25 / 35
```
- Параметар типа може имати више ограничења. На пример:

```
T extends Comparable & Serializable
```
- Типови који ограничавају су одвојени знаком & зато што се знак

##### зарез користи за раздвајање променљивих типа.

- Исто као и код Јава наслеђивања, могуће је имати више

##### интерфејса који ограничавају параметар типа, али само једно

##### ограничење може да се односи на класу.

- Ако класа представља ограничење ѕа тип, назив класе се мора

##### навести пре назива интерфејса.

##### Пример. Метод minmax, који одређује минимум и максимум низа, је

##### направљен тако да буде генерички:

## Ограничења за типове (4)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 26 / 35
```
##### Пример (наставак).

```
import java.util.*;
```
public class PairTest2 {

public static void main(String[] args) {
GregorianCalendar[] birthdays = {
new GregorianCalendar( 1906 , Calendar.DECEMBER, 9 ),
new GregorianCalendar( 1815 , Calendar.DECEMBER, 10 ),
new GregorianCalendar( 1903 , Calendar.DECEMBER, 3 ),
new GregorianCalendar( 1910 , Calendar.JUNE, 22 ),
};
Pair<GregorianCalendar> mm = ArrayAlg.minmax(birthdays);
System.out.println("min = " + mm.getFirst().getTime());
System.out.println("max = " + mm.getSecond().getTime());
}
}

## Ограничења за типове (5)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 27 / 35
```
##### Пример (наставак).

class ArrayAlg {
public static <T extends Comparable> Pair<T> minmax(T[] a) {
if (a == null || a.length == 0 )
return null;
T min = a[ 0 ];
T max = a[ 0 ];
for (int i = 1 ; i < a.length; i++) {
if (min.compareTo(a[i]) > 0 )
min = a[i];
if (max.compareTo(a[i]) < 0 )
max = a[i];
}
return new Pair<T>(min, max);
}
}

## Ограничења за типове (6)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 28 / 35
```
#####  Кад год се дефинише генерички тип, аутоматски бива обезбеђен

##### одговоарајући сирови (енг. raw) тип.

#####  Име сировог типа је исто као име генеричког типа, само што су

##### уколоњени параметри који представљају типове.

#####  Променљиве које представљају типове су просто замењене са

##### типовима који их ограничавају или са Object типом (ако за те

##### променљиве није било ограничења).

## Генерици и виртуелна машина


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 29 / 35
```
##### Пример.

##### Сирови тип за Pair<T> има следећи облик:

public class Pair {
private Object first;
private Object second;

```
public Pair(Object first, Object second) {
this.first = first;
this.second = second;
}
```
public Object getFirst() { return first; }
public Object getSecond() { return second; }
public void setFirst(Object newValue) { first = newValue; }
public void setSecond(Object newValue) { second = newValue; }
}

## Генерици и виртуелна машина (2)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 30 / 35
```
- У претходном примеру параметар T није био ограничен, па је

##### стога он једноставно замењен са класом тј. типом Object.

- Мада програм може садржати различите врсте парова, као што су

##### Pair<String>или Pair<GregorianCalendar>, током превођења сви они

##### буду преведени у сирове Pairтипове.

- **Пример.** Претпоставимо да је донекле другачије дефинисан тип:

```
public class Interval<T extends Comparable & Serializable>
implements Serializable {
private T lower;
private T upper;
```
```
public Interval(T first, T second) {
if (first.compareTo(second) <= 0 ) {
lower = first;
upper = second;
} else {
lower = second;
upper = first;
}
}
}
```
## Генерици и виртуелна машина (3)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 31 / 35
```
- **Пример (наставак).** Тада сировиInterval тип има следећи облик:

public class Interval implements Serializable {
private Comparable lower;
private Comparable upper;

public Interval(Comparable first, Comparable second) {
if (first.compareTo(second) <= 0 ) {
lower = first;
upper = second;
} else {
lower = second;
upper = first;
}
}
}

- Ако се промени редослед граница у дефиницији класе Interval:

###### class Interval<T extends Serializable& Comparable>

##### тада се код сировог типа Tзамењује са Serializableи преводилац

##### убацује конверзије у Comparableгде год је то неопходно.

## Генерици и виртуелна машина (4)


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 32 / 35
```
- Уопштено говорећи, не постоји веза између Pair<S>и Pair<T>, без

##### обзира на то како су Sи Tповезани.

- У Јави је класа Manager подкласа клаее Employee само ако

##### интерфејси поткласе укључују све интерфејсе надкласе.

- Међутим, направљени генерици обично имају различите

##### интерфејсе па не може бити наслеђивања.

## Генерици и наслеђивање


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 33 / 35
```
##### Грешка при

##### превођењу јер

##### конверзија није

##### безбедна за тип!

## Генерици и наслеђивање (2)

- У примеру који следи, преводилац спречава превођење кода са

##### операцијама које нису безбедне за тип – није могуће са листом

##### ниски радити као са листом објеката, без обзира на то што је

##### класа Stringизведена из класе Object.

```
List<String> ls = new ArrayList<String>();
List<Object> lo = ls;
```
```
lo.add( 0 , new Object()); // legalno?!
ls.get( 0 ); // Nije string?!
```

```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 34 / 35
```
- Као закључак, потребно је водити рачуна о следећим

##### чињеницама када се ради са Јава генерицима:

##### 1. У раду Јава виртуелне машине не постоје генерици,

##### већ само обичне класе и методи.

##### 2. Сви типовни параматри бивају замењени са својим

##### границама.

##### 3. Преводилац генерише методе-мостове и на тај начин

##### задржава полиморфно понашање.

##### 4. Да би се обезбедила безбедност типова, преводилац тамо

##### где је потребно убацује наредбе за експлицитну

##### конверзију типова.

## Закључак


```
Математички факултет {vladaf, vladaf@matf.bg.ac.kartelj}@matf.bg.ac.rsrs 35 / 35
```
## Захвалница

### Велики део материјала који је укључен у ову презентацију је

### преузет из презентације коју је раније (у време када је он

### држао курс Објектно орјентисано програмирање) направио

### проф. др Душан Тошић.

### Хвала проф. Тошићу што се сагласио са укључивањем тог

### материјала у садашњу презентацији, као и на помоћи коју ми

### је пружио током конципцирања и реализације курса.

### Надаље, један део материјала је преузет од колегинице

### Марије Милановић.

### Хвала Марији Милановић на помоћи у реализацији ове

### презентације.


