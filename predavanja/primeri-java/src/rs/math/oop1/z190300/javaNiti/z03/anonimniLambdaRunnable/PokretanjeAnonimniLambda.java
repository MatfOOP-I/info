package rs.math.oop1.z190300.javaNiti.z03.anonimniLambdaRunnable;

import static java.lang.Thread.sleep;

public class PokretanjeAnonimniLambda {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                final String PORUKA = "NEMA";
                for (int i = 0; i < 20; i++) {
                    System.out.println(i + " " + PORUKA);
                    try {
                        sleep((long) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
                System.out.println("GOTOVO! " + PORUKA);
            }
        }
        ).start();
        new Thread(
                () -> {
                    final String PORUKA = "PROBLEMA";
                    for (int i = 0; i < 20; i++) {
                        System.out.println(i + " " + PORUKA);
                        try {
                            sleep((long) (Math.random() * 1000));
                        } catch (InterruptedException e) {
                            System.out.println(e);
                        }
                    }
                    System.out.println("GOTOVO! " + PORUKA);
                }
        ).start();
    }
}
