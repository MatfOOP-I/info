package rs.math.oop1.z180202.predefinisaniFunkcionalniInterfejsi.z01.osobePredicate;

import java.util.List;
import java.util.function.Predicate;

public class LambdaTest01 {
    static void printPersons(List<Person> roster, Predicate<Person> filter) {
        for (Person p : roster) {
            if (filter.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(System.lineSeparator() + "1.---");
        printPersons(Person.LJUDI, (Person p) -> {
                    return true;
                }
        );

        System.out.println(System.lineSeparator() + "2.---");
        printPersons(Person.LJUDI, (Person p) ->
                {
                    if (p.getAge() >= 79)
                        return true;
                    else
                        return false;
                }
        );

        System.out.println(System.lineSeparator() + "3.---");
        printPersons(Person.LJUDI, p -> {
            return (p.getAge() >= 80 && p.getAge() <= 85);
        });

        System.out.println(System.lineSeparator() + "4.---");
        printPersons(Person.LJUDI, p -> p.emailAddress.indexOf("disney") >= 0);

        System.out.println(System.lineSeparator() + "5.---");
        Predicate<Person> uslov = (x -> x.getAge() >= 81);
        printPersons(Person.LJUDI, uslov);

        System.out.println(System.lineSeparator() + "6.---");
        uslov = uslov.and(p -> p.emailAddress.indexOf("disney") >= 0);
        printPersons(Person.LJUDI, uslov);

        System.out.println(System.lineSeparator() + "7.---");
        uslov = uslov.or(p -> p.emailAddress.indexOf("wb") >= 0);
        printPersons(Person.LJUDI, uslov);

        System.out.println(System.lineSeparator() + "8.---");
        uslov = uslov.negate();
        printPersons(Person.LJUDI, uslov);

        System.out.println(System.lineSeparator() + "9.---");
        Predicate<Person>  uslov2 = (x -> x.getAge() >= 81);
        uslov2 = uslov2.and( x-> x.ime.startsWith("M"))
                .or(y->y.emailAddress.endsWith("wb.com"))
                .negate();
        printPersons(Person.LJUDI, uslov);
    }

}
