package v14.v01UseJavaUtil;
import java.util.GregorianCalendar;
import java.text.DateFormatSymbols;

class Kalendar
{
	public static void main(String[] args)
	{
		FormatizovaniUlaz ulaz = new FormatizovaniUlaz();

		// Get the date of birth from the keyboard
		System.out.println("Unesi svoj datum rodjenja kao dd mm yyyy: ");
		int dan = ulaz.citajCeoBroj();
		int mesec = ulaz.citajCeoBroj();
		int godina = ulaz.citajCeoBroj();

		// Create birth date calendar – month is 0 to 11
		GregorianCalendar rodjenje = new GregorianCalendar(godina, mesec - 1, dan);
		GregorianCalendar danas = new GregorianCalendar(); // Today's date

		// Create this year's birthday
		GregorianCalendar rodjendan =
			new GregorianCalendar(
				danas.get(danas.YEAR),
				rodjenje.get(rodjenje.MONTH),
				rodjenje.get(rodjenje.DATE));

		int uzrast = danas.get(danas.YEAR) - rodjenje.get(rodjenje.YEAR);

		String[] weekdays = new DateFormatSymbols().getWeekdays(); // Get day names

		System.out.println(
			"Rodjeni ste na dan " + weekdays[rodjenje.get(rodjenje.DAY_OF_WEEK)]);
		System.out.println(
			"Ove godine vi "
				+ (rodjendan.after(danas) ? "cete imati " : "imate ")
				+ uzrast
				+ " godina.");
		System.out.println(
			"Ove godine vas rodjendan "
				+ (danas.before(rodjendan) ? "ce pasti na " : "je bio u ")
				+ weekdays[rodjendan.get(rodjendan.DAY_OF_WEEK)]);
	}
}
