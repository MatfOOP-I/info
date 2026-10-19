# Недеља 13 — Пројектовање, рефакторисање и тестирање

> **Код:** [GitHub](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje) · [преузми пројекат (ZIP)](../13.projektovanje.refaktorisanje.i.testiranje.zip) · [задатак за самостални рад](ZADATAK.md)

## Циљ

Одредити који објекат је одговоран за понашање и проверити да промена дизајна
чува договорени уговор. Више класа само по себи није бољи дизајн.

## Редослед

1. [`primer01_pocetni_kod`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer01_pocetni_kod): ради, али користи стринг ознаке и расуту логику.
2. [`primer00_karakterizacija`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer00_karakterizacija): забележити цену и нормалан животни циклус ПРЕ мењања.
3. [`primer02_refaktorisano_resenje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer02_refaktorisano_resenje): погледати по једну издвојену одговорност.
4. Поново покренути карактеризацију: проверава исти сценарио на обе верзије.
5. [`primer03_testiranje`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/13.projektovanje.refaktorisanje.i.testiranje/src/primer03_testiranje): мале провере обрачуна, животног циклуса и система.

Тестове за постојеће исправно понашање чувамо током рефакторисања. Исправке грешака
(дупле ознаке, заобилажење транзиција) засебно мењају уговор и имају регресионе провере.

## Одговорности и јавни API

- `Vozilo`: идентитет, цена по дану, депозит и доступност. `rezervisi/oslobodi` су
  package-private операције модела, нису део јавног API-ја апликације.
- `Rezervacija`: валидира аргументе и затим заузима возило. И директан конструктор
  одбија већ заузето возило. Не треба претходно ручно позивати rezervisi().
- `NacinObracunaCene`: Strategy за стандардни/члански обрачун. У овом примеру
  стратегије су без променљивог стања; примењују се на непроменљиву цену и број дана.
- `SistemIznajmljivanja`: регистар возила и резервација. Дупла ознака се одбија;
  неуспешно креирање не мења доступност и не троши број резервације.

## State и стварна енкапсулација

`StanjeRezervacije` и четири имплементације су **приватни угњеждени типови**
унутар Резервација. Имплементације су static nested класе; резервацију добијају
као аргумент. Клијент види само `preuzmi()`, `vrati()`, `otkazi()` и упит о стању.
Не постоји јавни promeniStanje/postaviStanje. State класе више нису јавни фајлови
у засебном пакету. Пакет стање садржи само јавни доменски изузетак.

| Стање | преузми | врати | откази |
|---|---|---|---|
| KREIRANA | AKTIVNA | одбиј | OTKAZANA, ослободи возило |
| AKTIVNA | одбиј | ZAVRSENA, ослободи возило | одбиј |
| ZAVRSENA | одбиј | одбиј | одбиј |
| OTKAZANA | одбиј | одбиј | одбиј |

Одбијање баца NedozvoljenaOperacijaException без промене стања. Јединственост
регистрације возила гарантује један систем; ово није модел конкурентних резервација,
базе података или распореда резервација по датумима.

## Тестирање

Прво очекивање, затим акција и провера. Користимо мали `Provera` помоћник уместо
увођења нове библиотеке. JUnit може бити наставак истог принципа касније.

## Промене захтева

Додати тротинет (IS-A), викенд обрачун (Strategy) или чување података у фајл
(посебна одговорност). За сваки избор образложити одлуку. За веома мали животни
циклус enum може бити довољно добар; циљ је разумети цену апстракције.
