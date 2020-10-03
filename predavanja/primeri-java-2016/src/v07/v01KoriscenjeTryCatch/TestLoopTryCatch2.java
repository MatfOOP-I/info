package v07.v01KoriscenjeTryCatch;
public class TestLoopTryCatch2 {
  public static void main(String[] args) {
    int i = 12; 

    try {
      System.out.println("Try block entered.");
      for(int j=3 ;j>=-1 ; j--) {
        System.out.println("Loop entered " + "i = "+ i + " j = "+j);
        System.out.println(i/j);         // Divide by 0 - exception thrown
      }
      System.out.println("Ending try block");

    } catch(ArithmeticException e) {    // Catch the exception
      System.out.println("Arithmetic exception caught");
    }
  }
}
