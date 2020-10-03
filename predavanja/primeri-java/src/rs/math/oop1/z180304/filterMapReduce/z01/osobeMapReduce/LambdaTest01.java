package rs.math.oop1.z180304.filterMapReduce.z01.osobeMapReduce;

public class LambdaTest01 {

    public static void main(String[] args) {
        System.out.println(System.lineSeparator() + "0.---");
        Person.LJUDI.stream().forEach(p -> p.printPerson());

        System.out.println(System.lineSeparator() + "1.---");
        Person.LJUDI.stream().filter(p -> {
            return p.gender == Person.Sex.FEMALE && p.emailAddress.indexOf("disney") >= 0;
        }).forEach(p -> p.printPerson());

        System.out.println(System.lineSeparator() + "2.---");
        Person.LJUDI.stream().filter(x -> (x.gender == Person.Sex.MALE))
                .map(y -> y.ime.length())
                .forEach(i -> System.out.print(i + " "));

        System.out.println(System.lineSeparator() + "3.---");
        Person.LJUDI.stream().filter(p -> p.gender == Person.Sex.MALE)
                .map(p -> p.getAge() - 50)
                .forEach(x -> System.out.println(x * x));

        System.out.println(System.lineSeparator() + "4.---");
        long sumaGodina = Person.LJUDI.stream()
                .filter(p ->
                        p.gender == Person.Sex.MALE
                                && p.emailAddress.indexOf("wb") >= 0)
                .mapToLong(p -> p.getAge())
                .sum();
        System.out.println(sumaGodina);

        System.out.println(System.lineSeparator() + "5.---");
        long sumaGodina2 = Person.LJUDI.stream()
                .filter(p -> {
                    return p.gender == Person.Sex.MALE
                            && p.emailAddress.indexOf("wb") >= 0;
                })
                .map(p -> p.getAge())
                .reduce(0L, (x, y) -> {
                    return x + y;
                });
        System.out.println(sumaGodina2);

        System.out.println(System.lineSeparator() + "6.---");
        double proizvodGodina2 = Person.LJUDI.stream()
                .filter(
                        p -> p.gender == Person.Sex.MALE
                                && p.emailAddress.indexOf("wb") >= 0)
                .map(p -> p.getAge())
                .reduce(1L, (x, y) -> x * y);
        System.out.println(proizvodGodina2);

        System.out.println(System.lineSeparator() + "7.---");
        long minGodina = Person.LJUDI.stream()
                .filter(p -> {
                    return p.gender == Person.Sex.MALE
                            && p.emailAddress.indexOf("disney") >= 0;
                })
                .map(p -> p.getAge())
                .reduce(Long.MAX_VALUE, (x, y) -> (x < y) ? x : y);
        System.out.println(minGodina);
    }

}
