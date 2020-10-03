package rs.math.oop1.z180201.funkcionalniInterfejsi.z02.osobe;

import java.util.List;

public class LambdaTest01 {
    static void printPersons(List<Person> roster, CheckPerson filter) {
        for (Person p : roster) {
            if (filter.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(System.lineSeparator() + "1.---");
        printPersons(Person.LJUDI, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return true;
            }
        });

        System.out.println(System.lineSeparator() + "2.---");
        printPersons(Person.LJUDI, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                if (p.getAge() >= 80)
                    return true;
                else
                    return false;
            }
        });

        System.out.println(System.lineSeparator() + "3.---");
        printPersons(Person.LJUDI, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return (p.getAge() >= 80 && p.getAge() <= 85);
            }
        });

        System.out.println(System.lineSeparator() + "4.---");
        printPersons(Person.LJUDI, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return (p.emailAddress.indexOf("disney") >= 0);
            }
        });

    }

}
