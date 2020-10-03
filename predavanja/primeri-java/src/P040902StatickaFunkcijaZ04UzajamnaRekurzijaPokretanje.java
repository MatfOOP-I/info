class PokretanjeUzajamnaRekurzijaParNepar {

    static boolean paran(int n) {
        if (n < 0)
            return paran(-n);
        if (n == 0)
            return true;
        if (n == 1)
            return false;
        return neparan(n - 1);
    }

    static boolean neparan(int n) {
        if (n < 0)
            return neparan(-n);
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        return paran(n - 1);
    }

    public static void main(String[] args) {
        int n = 7;
        if (paran(n))
            System.out.println("broj " + n + " je paran.");
        else
            System.out.println("broj " + n + " nije paran.");
        if (neparan(n))
            System.out.println("broj " + n + " je neparan.");
        else
            System.out.println("broj " + n + " nije neparan.");
    }

}
