package rs.math.ispit201905.zadatakDodatni;

import java.util.*;

public class AlterirajuciIterabilni<T> implements Iterable<T> {

    private List<Iterable<T>> sadrzaj;

    public AlterirajuciIterabilni(Iterable<T>... grupe) {
        sadrzaj = Arrays.asList(grupe);
    }

    /*
    public AlterirajuciIterabilni(Iterable<T> grupa1, Iterable<T> grupa2, Iterable<T> grupa3) {
        this.sadrzaj = new ArrayList<Iterable<T>>(3);
        this.sadrzaj.add(grupa1);
        this.sadrzaj.add(grupa2);
        this.sadrzaj.add(grupa3);
    }

    public AlterirajuciIterabilni(Iterable<T> grupa1, Iterable<T> grupa2) {
        this.sadrzaj = new ArrayList<Iterable<T>>(3);
        this.sadrzaj.add(grupa1);
        this.sadrzaj.add(grupa2);
    }

    public AlterirajuciIterabilni(Iterable<T> grupa1) {
        this.sadrzaj = new ArrayList<Iterable<T>>(3);
        this.sadrzaj.add(grupa1);
    }
     */

    @Override
    public Iterator<T> iterator() {
        return new AlternirajuciIterator();
    }

    private class AlternirajuciIterator implements Iterator<T> {
        private int indeksListeIteratora = -1;
        private List<Iterator<T>> listaIteratora;

        public AlternirajuciIterator() {
            listaIteratora = new ArrayList<>(sadrzaj.size());
            for (Iterable<T> iterable : sadrzaj) {
                listaIteratora.add(iterable.iterator());
            }
        }

        @Override
        public boolean hasNext() {
            for (Iterator<T> it : listaIteratora) {
                if (it.hasNext()) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T result;
                while (true) {
                    indeksListeIteratora = (indeksListeIteratora + 1) % listaIteratora.size();
                    if (listaIteratora.get(indeksListeIteratora).hasNext()) {
                        result = listaIteratora.get(indeksListeIteratora).next();
                        break;
                    }
                }
                return result;
            } else {
                throw new NoSuchElementException();
            }
        }

    }

}
