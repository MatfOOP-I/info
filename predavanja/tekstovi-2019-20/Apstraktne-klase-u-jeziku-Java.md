# Објектно орјентисано

# програмирање

## Владимир Филиповић

## vladaf@matf.bg.ac.rs

## Александар Картељ

## kartelj@matf.bg.ac.rs


# Апстрактне класе и

# интерфејси

## Владимир Филиповић

## vladaf@matf.bg.ac.rs

## Александар Картељ

## kartelj@matf.bg.ac.rs


Математички факултет (^) {vladafvladaf@matf.bg.ac.,kartelj}@matf.bg.ac.rs rs 3 / 23

######  Како се крећемо уз хијерархију наслеђивања, класе постају све

###### општије и све апстрактније.

######  У неком тренутку наткласа постаје у тој мери општа да више

###### представља основу за друге класе него класу чије конкретне

###### примерке желимо да користимо.

###### Пример:

######  Проширење хијерархије класа за запослене и студенте.

######  Иако свака особа има опис,

###### ипак тај опис зависи од тога шта и

###### како дата особа ради.

## Апстрактне класе


Математички факултет (^) {vladafvladaf@matf.bg.ac.,kartelj}@matf.bg.ac.rs rs 4 / 23

- Апстрактне класе и методе карактерише кључна реч abstract.
- Класа мора бити апстрактна ако садржи бар један апстрактни метод.
- Класа може бити апстрактна чак иако не садржи ни један

###### апстрактни метод.

public abstract class Person **{**
private String jmbg **;**
void checkJMBG **(){**
System**.** out**.** println **(** "JMBG checking" **);
}**
abstract void doMedicalTreatment **();
}**

## Апстрактне класе (2)


Математички факултет (^) {vladafvladaf@matf.bg.ac.,kartelj}@matf.bg.ac.rs rs 5 / 23

- Примерак конкретне класе може да користи неапстрактне методе

###### апстрактне наткласе.

public class Student **extends** Person **{**
private String index **;**
@Override void doMedicalTreatment **() {**
System**.** out**.** println **(** "Going to student clinic" **);**
checkJMBG **();**
checkIndex **();
}**
void checkIndex **(){**
System**.** out**.** println **(** "Checking index" **);
}
}**

## Апстрактне класе (3)


Математички факултет (^) {vladafvladaf@matf.bg.ac.,kartelj}@matf.bg.ac.rs rs 6 / 23

- Тај примерак може бити декларисан као инстанца апстрактне класе.
- Он може бити креиран само помоћу конструктора конкретне класе.
- Апстрактна класа може да има конструктор којим дефинише

###### сопствена поља, а тај контруктор се потом позива од стране

###### конструктора конкретне поткласе.

public abstract class Person **{
...**
public Person **(** String jmbg **) { this.** jmbg **=** jmbg **; }**
...
**}**
public class Student **extends** Person **{**
...
public Student **(** String jmbg **,** String index **) {
super(** jmbg **);
this.** index **=** index **;
}**
public static void main **(** String **[]** args **) {**
Person s **=new** Student **(** "xxxxxxxxxxxxx" **,** "yyyyy" **);
}
}**

## Апстрактне класе (4)


Математички факултет (^) {vladafvladaf@matf.bg.ac.,kartelj}@matf.bg.ac.rs rs 7 / 23

######  У развоју софтвера је често важно да се различите групе

###### програмера договоре око „уговора“ о интеракцији софтвера.

######  Свака од тих група треба да буде у могућности да напише

###### свој део кода, а да при томе нема информације како је писан

###### код друге стране.

######  У језику Јава, интерфејс је референтни тип, сличан класи, али

###### може садржати само константе и потписе метода.

######  Интерфејс не може да садржи тела метода (изузетак су

###### подразумевани методи, почев од Јава 8).

######  Није могуће директно правити примерак интерфејса:

```
 он само може да буде имплементиран од стране класе
 или наслеђен од стране другог интерфејса
```
## Захвалница

##### Велики део материјала који је укључен у ову презентацију је

##### преузет из презентације коју је раније (у време када је он

##### држао курс Објектно орјентисано програмирање) направио

##### проф. др Душан Тошић.

##### Хвала проф. Тошићу што се сагласио са укључивањем тог

##### материјала у садашњу презентацији, као и на помоћи коју ми

##### је пружио током конципцирања и реализације курса.

