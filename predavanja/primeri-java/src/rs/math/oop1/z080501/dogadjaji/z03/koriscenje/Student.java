package rs.math.oop1.z080501.dogadjaji.z03.koriscenje;

public class Student extends Covek {
   private boolean naRaspustu;

   public Student(String ime, boolean naRaspustu, int status) {
      super(ime, status);
      this.naRaspustu = naRaspustu;
   }

   public Student(String ime, boolean naRaspustu) {
      this(ime, naRaspustu, Status.SPAVANJE);
   }

   public Student(String ime) {
      this(ime, false, Status.SPAVANJE);
   }

   public boolean isNaRaspustu() {
      return naRaspustu;
   }

   @Override
   public String toString() {
      return String.format("Student '%s' (%s)",
            getIme(), naRaspustu ? "na raspustu" : "studira");
   }

}