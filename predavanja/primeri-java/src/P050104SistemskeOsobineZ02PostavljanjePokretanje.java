public class P050104SistemskeOsobineZ02PostavljanjePokretanje {
    public static void main(String[] args) {
        System.out.println("pre izmene");
        System.out.println("verzija jave: " + System.getProperty("java.runtime.version"));

        System.setProperty("java.runtime.version", "Java ver. XXX");

        System.out.println("posle izmene");
        System.out.println("verzija jave: " + System.getProperty("java.runtime.version"));
    }
}
