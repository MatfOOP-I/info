package PrimerIspita;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;

public class MaxFinder<T> implements GenericMax<T>{
    private Comparator<T> comparator;

    // Konstruktor sa podrškom za Comparator
    public MaxFinder(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public MaxFinder(){}

    // Metoda za pronalaženje maksimuma uz podršku za Comparator
    public Optional<T> findMax(Collection<T> collection, Comparator<T> customComparator) {
        if (collection == null || collection.isEmpty()) {
            return Optional.empty();
        }

        if (customComparator != null) {
            return findMaxWithComparator(collection, customComparator);
        }

        return Optional.empty();
    }

    public Optional<T> findMax(Collection<T> collection){
        return findMax(collection, comparator);
    }

    private Optional<T> findMaxWithComparator(Collection<T> collection, Comparator<T> comparator) {
        Iterator<T> iterator = collection.iterator();
        T max = iterator.next();

        while (iterator.hasNext()) {
            T current = iterator.next();
            if (comparator.compare(current, max) > 0) {
                max = current;
            }
        }
        return Optional.ofNullable(max);
    }
}

