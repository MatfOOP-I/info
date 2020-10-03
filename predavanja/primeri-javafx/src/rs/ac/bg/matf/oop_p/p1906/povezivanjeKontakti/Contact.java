package rs.ac.bg.matf.oop_p.p1906.povezivanjeKontakti;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

class Contact
{
	private SimpleStringProperty firstName = new SimpleStringProperty();
	private SimpleStringProperty lastName = new SimpleStringProperty();

	public Contact(String fn, String ln)
	{
		firstName.setValue(fn);
		lastName.setValue(ln);
	}

	public final String getFirstName()
	{
		return firstName.getValue();
	}

	public StringProperty firstNameProperty()
	{
		return firstName;
	}

	public final void setFirstName(String firstName)
	{
		this.firstName.setValue(firstName);
	}

	public final String getLastName()
	{
		return lastName.getValue();
	}

	public StringProperty lastNameProperty()
	{
		return lastName;
	}

	public final void setLastName(String lastName)
	{
		this.lastName.setValue(lastName);
	}
}