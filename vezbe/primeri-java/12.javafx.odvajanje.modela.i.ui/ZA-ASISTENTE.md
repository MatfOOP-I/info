# Недеља 12 — напомене за асистенте

[← Недеља 12](README.md)

## Предлог тока једног двочаса

### Првих 45 минута

#### 0–15 мин

[`primer01_osnove`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer01_osnove)

- `Application`;
- `Stage`;
- `Scene`;
- layout;
- контроле;
- догађај.

#### 15–30 мин

[`primer02_sve_u_ui`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer02_sve_u_ui)

Направити планер који ради.

Затим питати:

> Шта је све одговорност ове једне класе?

#### 30–45 мин

Почети издвајање модела.

Показати `Zadatak` и `ListaZadataka`.

Покренути модел из обичног `Main`.

### Других 45 минута

#### 0–15 мин

[`primer04_kontroler`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer04_kontroler)

Објаснити:

```text
prikaz → kontroler → model
```

без инсистирања на терминологији design patterna.

#### 15–35 мин

[`primer05_zavrsna_aplikacija`](https://github.com/MatfOOP-I/info/tree/main/vezbe/primeri-java/12.javafx.odvajanje.modela.i.ui/src/primer05_zavrsna_aplikacija)

Спојити JavaFX приказ са контролером.

Додавање, завршавање и брисање задатка.

#### 35–45 мин

Дискусија/рефакторисање.

Питања:

- где би ишао нови филтер?
- где би ишла боја високог приоритета?
- где би ишло правило "опис мора имати бар 3 знака"?
- где би ишло чување у датотеку?

## Припрема и границе модела

Пре часа отворити Maven пројекат и покренути први прозор. Поновити ламбда callback
из недеље 10. На часу студенти повезују једну акцију, не куцају цео UI од нуле.

`List.copyOf` штити структуру враћене листе, али не прави дубоке копије мутабилних
Задатак објеката. У овом једноставном моделу Задатак сам допушта zavrsi(), па се
његова инваријанта не крши. Ако све измене морају ићи кроз сервис, потребан је
read-only приказ података или другачија граница приступа.

Индекси су безбедни овде само зато што приказ прати исти редослед као модел.
Самостални задатак са филтрирањем захтева стабилан ID или изабрани објекат.
Контролер независан од JavaFX-a је избор овог наставног модела, не универзално
правило за сваки JavaFX контролер.
