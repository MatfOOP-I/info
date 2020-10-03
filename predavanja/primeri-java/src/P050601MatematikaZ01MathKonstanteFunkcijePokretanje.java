public class P050601MatematikaZ01MathKonstanteFunkcijePokretanje {
   public static void main(String[] args) {


      System.out.printf("Math.E: %f\n", Math.E);
      System.out.printf("Math.PI: %f\n", Math.PI);

      double x = -10.7e-1;
      double y = Math.PI / 4;
      System.out.printf("\nMath.abs(%f): %f\n", x, Math.abs(x));
      System.out.printf("Math.abs(%f): %f\n", y, Math.abs(y));
      System.out.printf("Math.signum(%f): %f\n", x, Math.signum(x));
      System.out.printf("Math.signum(%f): %f\n", y, Math.signum(y));
      System.out.printf("Math.ceil(%f): %f\n", x, Math.ceil(x));
      System.out.printf("Math.ceil(%f): %f\n", y, Math.ceil(y));
      System.out.printf("Math.floor(%f): %f\n", x, Math.floor(x));
      System.out.printf("Math.floor(%f): %f\n", y, Math.floor(y));
      System.out.printf("Math.round(%f): %d\n", x, Math.round(x));
      System.out.printf("Math.round(%f): %d\n", y, Math.round(y));

      double z = 6.25;
      System.out.printf("\nMath.sqrt(%f): %f\n", z, Math.sqrt(z));
      double izlozilac = 2;
      System.out.printf("\nMath.pow(%f,%f): %f\n", z, izlozilac, Math.pow(z, izlozilac));
      izlozilac = 0.5;
      System.out.printf("Math.pow(%f,%f): %f\n", z, izlozilac, Math.pow(z, izlozilac));
      izlozilac = 2.75;
      System.out.printf("Math.pow(%f,%f): %f\n", z, izlozilac, Math.pow(z, izlozilac));

      System.out.printf("\nMath.sin(%f): %f\n", y, Math.sin(y));
      System.out.printf("Math.cos(%f): %f\n", y, Math.cos(y));
      System.out.printf("Math.tan(%f): %f\n", y, Math.tan(y));

      double t = Math.sqrt(2)/2;
      double u = 1;
      System.out.printf("\nMath.asin(%f): %f\n", t, Math.asin(t));
      System.out.printf("Math.acos(%f): %f\n", t, Math.acos(t));
      System.out.printf("Math.atan(%f): %f\n", t, Math.atan(t));
      System.out.printf("Math.atan(%f): %f\n", u, Math.atan(u));

      System.out.printf("\nMath.exp(%f): %f\n", u, Math.exp(u));
      double v = Math.E * Math.E;
      System.out.printf("Math.log(%f): %f\n", v, Math.log(v));
      v = 100.007;
      System.out.printf("Math.log10(%f): %f\n", v, Math.log10(v));

      System.out.printf("\nMath.toDegrees(%f): %f\n", y, Math.toDegrees(y));
      y = 180;
      System.out.printf("Math.toRadians(%f): %f\n", y, Math.toRadians(y));

      System.out.printf("\nMath.max(%f,%f): %f\n", x, y, Math.max(x, y));
      System.out.printf("Math.min(%f,%f): %f\n", x, y, Math.min(x, y));
   }

}
