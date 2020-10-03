package rs.math.oop1.z180200.lambdaIzrazi.z02.osobe;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    public enum Sex {
        MALE, FEMALE
    }

    String ime;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public static List<Person> LJUDI;

    static {
        LJUDI = new ArrayList<>();
        LJUDI.add(new Person("Miki Maus",
                LocalDate.of(1928, 5, 7), Sex.MALE,
                "mickey.mouse@disney.com"));
        LJUDI.add(new Person("Paja Patak", LocalDate.of(1932, 5, 17), Sex.MALE,
                "donald.duck@disney.com"));
        LJUDI.add(new Person("Dusko Dugousko", LocalDate.of(1956, 7, 7), Sex.MALE,
                "bugs.buney@wb.com"));
        LJUDI.add(new Person("Mini Maus", LocalDate.of(1929, 5, 7), Sex.FEMALE,
                "miney.mouse@disney.com"));
        LJUDI.add(new Person("Silja", LocalDate.of(1940, 5, 7), Sex.MALE,
                "guffy@disney.com"));
        LJUDI.add(new Person("Patak Daca", LocalDate.of(1945, 5, 7), Sex.MALE,
                "duffy.duck@wb.com"));
        LJUDI.add(new Person("Hromi Daba", LocalDate.of(1940, 5, 7), Sex.MALE,
                "hromi.daba@disney.com"));
    }

    public static List<Person> CRTANI;

    static {
        Person[] crtani = {
                new Person("Miki Maus", LocalDate.of(1928, 5, 7), Sex.MALE,
                        "mickey.mouse@disney.com"),
                new Person("Paja Patak", LocalDate.of(1932, 5, 17), Sex.MALE,
                        "donald.duck@disney.com"),
                new Person("Dusko Dugousko", LocalDate.of(1956, 7, 7), Sex.MALE,
                        "bugs.buney@wb.com"),
                new Person("Mini Maus", LocalDate.of(1929, 5, 7), Sex.FEMALE,
                        "miney.mouse@disney.com"),
                new Person("Silja", LocalDate.of(1940, 5, 7), Sex.MALE,
                        "guffy@disney.com"),
                new Person("Patak Daca", LocalDate.of(1945, 5, 7), Sex.MALE,
                        "duffy.duck@wb.com"),
                new Person("Hromi Daba", LocalDate.of(1940, 5, 7), Sex.MALE,
                        "hromi.daba@disney.com")};
        CRTANI = Arrays.asList(crtani);
    }

    public Person(String ime, LocalDate birthday, Sex gender,
                  String emailAddress) {
        this.ime = ime;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public long getAge() {
        return birthday.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    @Override
    public String toString() {
        return ime + " " + gender + " " + birthday + " " + getAge() + " " + emailAddress;
    }

    public void printPerson() {
        System.out.println(this);
    }
}
