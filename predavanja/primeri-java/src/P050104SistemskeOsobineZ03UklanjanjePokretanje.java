public class P050104SistemskeOsobineZ03UklanjanjePokretanje {
    public static void main(String[] args) {
        System.out.println("pre uklanjanja");
        System.out.println("verzija jave: " + System.getProperty("java.runtime.version"));

        System.out.println( System.clearProperty("java.runtime.version") );

        System.out.println("posle uklajanja");
        System.out.println("verzija jave: " + System.getProperty("java.runtime.version"));
    }
}
