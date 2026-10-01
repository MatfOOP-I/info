package provere;
/** Regresione provere za održavanje materijala, ne novo obavezno gradivo. */
public class Main {
    private static int broj;
    private static void check(boolean uslov, String opis) {
        broj++;
        if (!uslov) throw new AssertionError(opis);
    }
    @FunctionalInterface private interface Akcija { void izvrsi() throws Exception; }
    private static void expect(Class<? extends Throwable> tip, Akcija akcija) throws Exception {
        broj++;
        try { akcija.izvrsi(); }
        catch (Throwable e) {
            if (tip.isInstance(e)) return;
            throw new AssertionError("Pogrešan tip izuzetka", e);
        }
        throw new AssertionError("Očekivan izuzetak: " + tip.getName());
    }
    public static void main(String[] args) throws Exception {
        var a = new primer06_comparator.Pesma("A","Izvođač",100);
        var b = new primer06_comparator.Pesma("A","Izvođač",200);
        check(a.equals(b) && a.hashCode()==b.hashCode() && a.compareTo(b)==0,"Usklađena jednakost i prirodni poredak");
        var hash = new java.util.HashSet<primer06_comparator.Pesma>();
        var tree = new java.util.TreeSet<primer06_comparator.Pesma>();
        hash.add(a);hash.add(b);tree.add(a);tree.add(b);
        check(hash.size()==1 && tree.size()==1,"Oba skupa prepoznaju duplikat");
        primer07_lambda.Main.main(new String[0]);
        System.out.println("NEDELJA 10: " + broj + " provera OK");
    }
}
