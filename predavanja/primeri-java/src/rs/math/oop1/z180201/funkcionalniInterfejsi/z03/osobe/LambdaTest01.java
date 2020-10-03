package rs.math.oop1.z180201.funkcionalniInterfejsi.z03.osobe;

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
        System.out.println("1.---");
        printPersons(Person.LJUDI, (Person p) ->
                {
                    if (p.getAge() >= 80)
                        return true;
                    else
                        return false;
                }
        );
        System.out.println("---");

        printPersons(Person.LJUDI, p -> {
            return (p.getAge() >= 80 && p.getAge() <= 85);
        });
        System.out.println("---");

        printPersons(Person.LJUDI, p -> p.emailAddress.indexOf("disney") >= 0);
        System.out.println("---");

        printPersons(Person.LJUDI, p -> p.gender == Person.Sex.FEMALE
                && p.emailAddress.indexOf("disney") >= 0);

    }

}
