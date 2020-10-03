package rs.math.oop1.z150704.noviKolekcijskiTipovi.z04.performanseSteka;

import java.util.*;


public class StekPrekoPovezaneListe<E> extends AbstractCollection<E>
        implements Stack<E> {
    int indikatorPromeneStrukture = 0;

    private class ElemenatListe {
        private ElemenatListe sledeci; // Refers to next item in the list
        private E vrednost;

        // Constructor
        public ElemenatListe(E item) {
            this.vrednost = item; // Store the item
            sledeci = null; // Set next as end point
        }

        // Return class ime & object
        public String toString() {
            return "Elemenat liste: " + vrednost;
        }

    }

    private ElemenatListe glava = null;

    private class IteratorSteka<E> implements Iterator<E> {
        private int indikatorPromeneStrukture;
        private ElemenatListe tekuci;

        public IteratorSteka(int indikatorPromeneStrukture) {
            this.indikatorPromeneStrukture = indikatorPromeneStrukture;
            tekuci = glava;
        }

        @Override
        public boolean hasNext() {
            if (indikatorPromeneStrukture != StekPrekoPovezaneListe.this.indikatorPromeneStrukture) {
                throw new ConcurrentModificationException();
            }
            return tekuci != null;
        }

        @Override
        public E next() {
            if (indikatorPromeneStrukture != StekPrekoPovezaneListe.this.indikatorPromeneStrukture) {
                throw new ConcurrentModificationException();
            }
            E vrednost = (E) tekuci.vrednost;
            tekuci = tekuci.sledeci;
            return vrednost;
        }
    }

    ;

    private void addItem(E elem) {
        if (glava == null) {
            glava = new ElemenatListe(elem);
            return;
        }
        ElemenatListe e = new ElemenatListe(elem);
        e.sledeci = glava;
        glava = e;
    }

    private E removeItem() throws Exception {
        if (glava == null) {
            throw new Exception("Kolekecija je prazna");
        }
        ElemenatListe e = glava;
        glava = e.sledeci;
        return e.vrednost;
    }

    public boolean empty() {
        return (glava == null);
    }

    public StekPrekoPovezaneListe() {
    }

    public StekPrekoPovezaneListe(Collection<E> c) {
        Iterator<E> it = c.iterator();
        while (it.hasNext()) {
            addItem(it.next());
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorSteka<E>(indikatorPromeneStrukture);
    }

    @Override
    public int size() {
        Iterator<E> it = this.iterator();
        int ret = 0;
        while (it.hasNext()) {
            ret++;
            it.next();
        }
        return ret;
    }

    @Override
    public void push(E elem) {
        addItem(elem);
    }

    @Override
    public E peek() throws EmptyStackException {
        if (glava == null)
            throw new EmptyStackException();
        E ret = null;
        try {
            ret = glava.vrednost;
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }

    @Override
    public E pop() throws EmptyStackException {
        if (glava == null)
            throw new EmptyStackException();
        E ret = null;
        try {
            ret = removeItem();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }

}
