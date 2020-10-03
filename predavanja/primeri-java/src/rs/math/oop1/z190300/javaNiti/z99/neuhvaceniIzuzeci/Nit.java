package rs.math.oop1.z190300.javaNiti.z99.neuhvaceniIzuzeci;

/**
 * korisne internet adrese:
 * http://www.javapractices.com/topic/TopicAction.do?Id=229
 * http://www.codingdiary.com/developers/developers/diary/javaapi/java/lang/SampleCode/setUncaughtExceptionHandlerExampleCode.html
 * http://www.javamex.com/tutorials/exceptions/exceptions_uncaught_handler.shtml
 */

public class Nit implements Runnable{

	private String parsirajMe;
	
	public Nit(String parsirajMe){
		this.parsirajMe = parsirajMe;
	}
	
	@Override
	public void run() {
		// Metod Integer.parseInt() moze dovesti do izbacivanja RuntimeException
		// izuzetka (NumberFormatException) u slucaju da se u stringu ne nalazi
		// ispravna string-reprezentacija celog broja
		System.out.println(Integer.parseInt(parsirajMe));
	}
	
}
