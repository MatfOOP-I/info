package rs.math.oop1.z080302.visekriterijumskoUredjenje.z04.geometrija;

import java.awt.Graphics;

public class Cetvorougao extends GeometrijskiObjekat implements Prikaz, Mera
{
	private Tacka a;
	private Tacka b;
	private Tacka c;
	private Tacka d;
	
	public Cetvorougao( String o, Tacka t1, Tacka t2, Tacka t3, Tacka t4 )
	{
		setOznaka(o);
		a = new Tacka(t1);
		b = new Tacka(t2);
		c = new Tacka(t3);
		d = new Tacka(t4);
	}
	
	public Cetvorougao( final Cetvorougao cet )
	{
		this(cet.getOznaka(), cet.a, cet.b, cet.c, cet.d);
	}
	
	public void prikaziSe ()
	{
		System.out.print(getOznaka() + ":[");
		a.prikaziSe();
		System.out.print(";");
		b.prikaziSe();
		System.out.print(";");
		c.prikaziSe();
		System.out.print(";");
		d.prikaziSe();
		System.out.print("]");
	}
	
	public void prikaziSe ( Graphics zaslon )
	{
		a.prikaziSe(zaslon);
		b.prikaziSe(zaslon);
		c.prikaziSe(zaslon);
		d.prikaziSe(zaslon);
		zaslon.drawLine(a.getX(), a.getY(), b.getX(), b.getY());
		zaslon.drawLine(b.getX(), b.getY(), c.getX(), c.getY());
		zaslon.drawLine(c.getX(), c.getY(), d.getX(), d.getY());
		zaslon.drawLine(d.getX(), d.getY(), a.getX(), a.getY());
	}
	
	public double obim ()
	{
		return (a.rastojanje(b) + b.rastojanje(c) + c.rastojanje(d) + d
				.rastojanje(a));
	}
	
	public boolean jeRomb ()
	{
		if (a.rastojanje(b) == a.rastojanje(c)
				&& b.rastojanje(c) == c.rastojanje(d)
				&& c.rastojanje(d) == d.rastojanje(a))
			return true;
		return false;
	}
	
	public double povrsina ()
	{
		Trougao t1 = new Trougao("t1", a, c, b);
		Trougao t2 = new Trougao("t2", a, c, d);
		double p1 = t1.povrsina() + t2.povrsina();
		t1 = new Trougao("t1", b, d, a);
		t2 = new Trougao("t2", b, d, c);
		double p2 = t1.povrsina() + t2.povrsina();
		return (p1 < p2) ? p1 : p2;
	}
	
}
