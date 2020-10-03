package rs.math.oop1.z160100.radSaTokovima.z01.tekstovneDatoteke;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Zaposleni
{
  private String ime;
  private double plata;
  private Date hireDay;

  public Zaposleni()
  {
  }

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

  public void povecajPlatu(double zaProcenat)
  {
     double iznosPovisice = plata * zaProcenat / 100;
     plata += iznosPovisice;
  }

  public String toString()
  {
     return getClass().getName() + "[ime=" + ime + ",plata=" + plata + ",hireDay=" + hireDay
           + "]";
  }


  public void writeData(PrintWriter out)
  {
     GregorianCalendar calendar = new GregorianCalendar();
     calendar.setTime(hireDay);
     out.println(ime + "|" + plata + "|" + calendar.get(Calendar.YEAR) + "|"
           + (calendar.get(Calendar.MONTH) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
  }

  public void readData(Scanner in)
  {
     String line = in.nextLine();
     String[] tokens = line.split("\\|");
     ime = tokens[0];
     plata = Double.parseDouble(tokens[1]);
     int y = Integer.parseInt(tokens[2]);
     int m = Integer.parseInt(tokens[3]);
     int d = Integer.parseInt(tokens[4]);
     GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
     hireDay = calendar.getTime();
  }
}
