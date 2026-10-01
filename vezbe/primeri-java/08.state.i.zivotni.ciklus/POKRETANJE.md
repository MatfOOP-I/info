# Pokretanje — nedelja 8

Potrebni su **JDK 21** i **Maven 3.9.x** (ili Maven ugrađen u IntelliJ IDEA).
Ovaj folder je samostalan projekat: `pom.xml`, `src/`, `test/` i, gde je potrebno, `data/`.
Svaki paket predstavlja zaseban primer; ne spajati sve nedelje u isti source root.

1. U IntelliJ IDEA otvoriti ovaj folder ili njegov `pom.xml` kao Maven projekat.
2. Podesiti Project SDK, Maven importer i Maven runner na JDK 21.
3. Sačekati preuzimanje zavisnosti. Otvoriti klasu sa `main` metodom u `src` i pokrenuti je.
4. Working directory u run konfiguraciji postaviti na ovaj folder, posebno za nedelju 11.

Kompajliranje iz terminala otvorenog U OVOM folderu:

```text
mvn compile
```

Primer bez interaktivnog unosa:

```text
mvn compile exec:java -Dexec.mainClass=primer06_tranzicije.Main
```

Primeri koji koriste `Scanner` najjednostavnije se pokreću direktno iz IDE-a.

Provera materijala za nastavnika:

```text
mvn verify
```

Faza `verify` izvršava `test/provere/Main.java` preko Maven exec dodatka.
Ove provere nisu JUnit testovi i ne izvršavaju se samim `mvn test`.
Neuspešna provera prekida Maven sa greškom. Kod provera može koristiti gradivo
kasnijih nedelja i nije obavezna studentska lekcija.

U zbirnom paketu, `mvn verify` iz roditeljskog foldera `primeri-java` proverava svih 13 nedelja.
`target/` je generisani izlaz i ne šalje se kao izvorni kod.
