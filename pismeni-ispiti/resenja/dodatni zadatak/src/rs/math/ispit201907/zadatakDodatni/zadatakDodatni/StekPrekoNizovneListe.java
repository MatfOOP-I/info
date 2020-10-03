package rs.math.ispit201907.zadatakDodatni.zadatakDodatni;

import java.util.*;

public class StekPrekoNizovneListe<E> extends AbstractCollection<E>
        implements Stek<E> {
    private ArrayList<E> sadrzina = new ArrayList<E>();
    private long indikatorPromeneStrukture = 0;

    @Override
    public void push(E elemenat) {
        indikatorPromeneStrukture++;
        sadrzina.add(elemenat);
    }

    @Override
    public E pop() {
        if( isEmpty())
            throw new EmptyStackException();
        indikatorPromeneStrukture++;
        return sadrzina.remove(0);
    }

    private class StekPrekoNizovneListeIterator implements Iterator<E> {
        int indeks = 0;
        long indikatorPromeneStrukture;

        StekPrekoNizovneListeIterator(long indikatorPromeneStrukturePriKreiranju) {
            indikatorPromeneStrukture = indikatorPromeneStrukturePriKreiranju;
        }

        @Override
        public boolean hasNext() {
            if (indikatorPromeneStrukture != StekPrekoNizovneListeIterator.this.indikatorPromeneStrukture)
                throw new ConcurrentModificationException();
            return indeks < sadrzina.size();
        }

        @Override
        public E next() {
            if (indikatorPromeneStrukture != StekPrekoNizovneListeIterator.this.indikatorPromeneStrukture)
                throw new ConcurrentModificationException();
            return sadrzina.get(indeks++);
        }
    }

    public StekPrekoNizovneListe(Collection<E>... kolekcije) {
        for (Collection<E> kolekcija : kolekcije)
            for (E elem : kolekcija)
                this.push(elem);
    }

    @Override
    public boolean add(E elemenat) {
        push(elemenat);
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new StekPrekoNizovneListeIterator(indikatorPromeneStrukture);
    }

    @Override
    public int size() {
        return sadrzina.size();
    }


}
