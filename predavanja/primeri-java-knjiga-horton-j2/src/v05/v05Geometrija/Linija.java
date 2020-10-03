package v05.v05Geometrija;

class Linija
{
	Tacka pocetak;
	Tacka kraj;

	Linija(final Tacka pocetak, final Tacka kraj)
	{
		this.pocetak = new Tacka(pocetak);
		this.kraj = new Tacka(kraj);
	}

	Linija(double xStart, double yStart, double xKraj, double yKraj)
	{
		pocetak = new Tacka(xStart, yStart); // Create the start point
		kraj = new Tacka(xKraj, yKraj); // Create the end point
	}

	double duzina()
	{
		return pocetak.rastojanje(kraj); // Use the method from the Point class
	}

	public String toString()
	{
		return "(" + pocetak + "):(" + kraj + ")"; 
	} 

	Tacka presek(final Linija prava)
	{
		Tacka presecnaTacka = new Tacka(0, 0);

		double num =
			(this.kraj.y - this.pocetak.y) * (this.pocetak.x - prava.pocetak.x)
				- (this.kraj.x - this.pocetak.x) * (this.pocetak.y - prava.pocetak.y);

		double denom =
			(this.kraj.y - this.pocetak.y) * (prava.kraj.x - prava.pocetak.x)
				- (this.kraj.x - this.pocetak.x) * (prava.kraj.y - prava.pocetak.y);

		presecnaTacka.x =
			prava.pocetak.x + (prava.kraj.x - prava.pocetak.x) * num / denom;
		presecnaTacka.y =
			prava.pocetak.y + (prava.kraj.y - prava.pocetak.y) * num / denom;

		return presecnaTacka;
	}
}
