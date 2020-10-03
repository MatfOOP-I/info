package v14.v01UseJavaUtil;
import java.util.Observable;

public class DzekilHajd extends Observable
{
	String ime = "Doktor Dzekil";

	public void popijNapitak()
	{
		ime = "Gospodin Hajd";
		setChanged();
		notifyObservers();
	}

	public void prestaloDejstvoNapitka()
	{
		ime = "Doktor Dzekil";
		setChanged();
		notifyObservers();
	}

	public String getIme()
	{
		return ime;
	}
}
