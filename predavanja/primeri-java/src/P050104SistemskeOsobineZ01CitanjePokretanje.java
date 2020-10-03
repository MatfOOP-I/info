public class P050104SistemskeOsobineZ01CitanjePokretanje {
    public static void main(String[] args) {

        System.out.println("korisnicki direktorijum: " + System.getProperty("user.dir"));

        System.out.println("operativni sistem: " + System.getProperty("os.ime"));

        System.out.println("verzija jave: " + System.getProperty("java.runtime.version"));

        System.out.println("putanja do klasa: " + System.getProperty("java.class.path"));

        String lineSeparator = System.getProperty("line.separator");
        System.out.println("zavrsetak linije: " + lineSeparator);
    }
}
