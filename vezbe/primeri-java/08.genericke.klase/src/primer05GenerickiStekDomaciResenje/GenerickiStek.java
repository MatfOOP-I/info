package primer05GenerickiStekDomaciResenje;

import java.util.Optional;

// Setite se da smo ranije na vezbama pravili stek koji je radio sa brojevima.
// Dosao je svecani trenutak da napravimo genericki stek!
public interface GenerickiStek<T>
{
    // Vraca element sa vrha steka.
    Optional<T> peek();

    // Skida element sa vrha stek i vraca ga.
    Optional<T> pop();

    // Smesta t na vrh steka.
    void push(T v);
}
