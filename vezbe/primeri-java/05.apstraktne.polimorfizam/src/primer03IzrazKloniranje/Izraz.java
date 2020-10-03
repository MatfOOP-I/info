package primer03IzrazKloniranje;

public abstract class Izraz {
	public abstract double izracunaj();
	
	// Namecemo apstraktan metod koji ce klase hijerarhije
	// 	implementirati tako da vrate referencu na svoju kopiju.
	// Na ovaj nacin resavamo problem da kada imamo referencu na baznu klasu
	//  (iako je u stvari to objekat neke podklase) ipak mozemo izvrsiti kopiranje.
	public abstract Izraz klon();
}
