package PrimerIspita;

import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public interface GenericMax<T> {
    Optional<T> findMax(Collection<T> collection, Comparator<T> comparator);
}
