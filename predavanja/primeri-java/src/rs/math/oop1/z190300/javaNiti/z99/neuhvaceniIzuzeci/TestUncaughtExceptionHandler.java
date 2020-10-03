package rs.math.oop1.z190300.javaNiti.z99.neuhvaceniIzuzeci;

import java.lang.Thread.UncaughtExceptionHandler;

public class TestUncaughtExceptionHandler {

	public static void main(String[] args) {
		
		// podrazumevani (globalni) handler koji ce se pozivati ukoliko za nit nije postavljen sopstveni handler
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Default handler: Nit " + t.getName() + " je dovela do izbacivanja RuntimeException: " + e);
			}
		});
		
		// drugi argument konstruktora je ime niti
		Thread t1 = new Thread(new Nit(" 123"), "* 123*");
		t1.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("t1 handler: Nit "  + t.getName() + " je dovela do izbacivanja RuntimeException: " + e);
			}
		});
		t1.start();
		
		new Thread(new Nit(" 234"), "* 234*").start();
		new Thread(new Nit("345"), "*345*").start();
	}
}
