package v01ch4.PackageTest;
/**
   @version 1.11 2004-02-19
   @author Cay Horstmann
*/

import v01ch4.PackageTest.com.horstmann.corejava.*;


import static java.lang.System.*;

public class PackageTest
{  
   public static void main(String[] args)
   {  
      // because of the import statement, we don't have to
      // use com.horstmann.corejava.Employee here
      Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);

      // raise salary by 5%
      harry.raiseSalary(5);

      // print out information about harry
      // use java.lang.System.out here
      out.println("name=" + harry.getName() + ",salary=" + harry.getSalary());
   }
}

