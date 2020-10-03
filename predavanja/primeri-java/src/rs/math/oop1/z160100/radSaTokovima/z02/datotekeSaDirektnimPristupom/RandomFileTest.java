package rs.math.oop1.z160100.radSaTokovima.z02.datotekeSaDirektnimPristupom;

import java.io.*;
import java.util.*;

/**
 * @version 1.11 2004-05-11
 * @author Cay Horstmann
 */
public class RandomFileTest
{  
   public static void main(String[] args)
   {
      Zaposleni[] osoblje = new Zaposleni[3];

      osoblje[0] = new Zaposleni("Janko Jankovic", 75000, 1987, 12, 15);
      osoblje[1] = new Zaposleni("Marko Markovic", 50000, 1989, 10, 1);
      osoblje[2] = new Zaposleni("Tony Tester", 40000, 1990, 3, 15);

      try
      {  
         // save all employee records to the file employee.dat
         DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"));
         for (Zaposleni e : osoblje)
            e.writeData(out);
         out.close();
      
         // retrieve all records into a new array
         RandomAccessFile in = new RandomAccessFile("employee.dat", "r");   
         // compute the array size
         int n = (int)(in.length() / Zaposleni.RECORD_SIZE);
         Zaposleni[] newStaff = new Zaposleni[n];

         // read employees in reverse order
         for (int i = n - 1; i >= 0; i--)
         {  
            newStaff[i] = new Zaposleni();
            in.seek(i * Zaposleni.RECORD_SIZE);
            newStaff[i].readData(in);
         }
         in.close();
         
         // print the newly read employee records
         for (Zaposleni e : newStaff)
            System.out.println(e);
      }
      catch (IOException e)
      {  
         e.printStackTrace(); 
      }
   }
}

class Zaposleni
{
   public Zaposleni() {}

   public Zaposleni(String n, double s, int godina, int mesec, int dan)
   {  
      ime = n;
      plata = s;
      GregorianCalendar calendar = new GregorianCalendar(godina, mesec - 1, dan);
      hireDay = calendar.getTime();
   }

   public String getIme()
   {
      return ime;
   }

   public double getPlata()
   {
      return plata;
   }

   public Date getHireDay()
   {  
      return hireDay;
   }

   /**
      Raises the plata of this employee.
      @zaProcenat the percentage of the iznosPovisice
   */
   public void povecajPlatu(double zaProcenat)
   {  
      double iznosPovisice = plata * zaProcenat / 100;
      plata += iznosPovisice;
   }

   public String toString()
   {  
      return getClass().getName()
         + "[ime=" + ime
         + ",plata=" + plata
         + ",hireDay=" + hireDay
         + "]";
   }

   /**
      Writes employee data to a data output
      @param out the data output
   */
   public void writeData(DataOutput out) throws IOException
   {
      DataIO.writeFixedString(ime, NAME_SIZE, out);
      out.writeDouble(plata);

      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(hireDay);
      out.writeInt(calendar.get(Calendar.YEAR));
      out.writeInt(calendar.get(Calendar.MONTH) + 1);
      out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
   }

   /**
      Reads employee data from a data input
      @param in the data input
   */
   public void readData(DataInput in) throws IOException
   {
      ime = DataIO.readFixedString(NAME_SIZE, in);
      plata = in.readDouble();
      int y = in.readInt();
      int m = in.readInt();
      int d = in.readInt();
      GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
      hireDay = calendar.getTime();
   }

   public static final int NAME_SIZE = 40;
   public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;

   private String ime;
   private double plata;
   private Date hireDay;
}

class DataIO
{
   public static String readFixedString(int size, DataInput in) 
      throws IOException
   {  
      StringBuilder b = new StringBuilder(size);
      int i = 0;
      boolean more = true;
      while (more && i < size)
      {  
         char ch = in.readChar();
         i++;
         if (ch == 0) more = false;
         else b.append(ch);
      }
      in.skipBytes(2 * (size - i));
      return b.toString();
   }

   public static void writeFixedString(String s, int size, DataOutput out) 
      throws IOException
   {
      for (int i = 0; i < size; i++)
      {  
         char ch = 0;
         if (i < s.length()) ch = s.charAt(i);
         out.writeChar(ch);
      }
   }
}
