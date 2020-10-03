package v05.v03Initalizacija;
class V05TryInitializationStatic
{
  static int[] values = new int[10];               // Static array  member

  // Initialization block
//  static
  {
    System.out.println("Running initialization block.");
    for(int i=0; i<values.length; i++)
      values[i] = (int)(100.0*Math.random());
  }
  
  // List values in the array for an object
  void listValues()
  {
    System.out.println();                        // Start a new line
    for(int i=0; i<values.length; i++)
      System.out.print(" " + values[i]);         // Display values

    System.out.println();                        // Start a new line
  }

  public static void main(String[] args)
  {
    V05TryInitializationStatic example = new V05TryInitializationStatic();
    System.out.println("\nFirst object:");
    example.listValues();

    example = new V05TryInitializationStatic();
    System.out.println("\nSecond object:");
    example.listValues();
  }
}
