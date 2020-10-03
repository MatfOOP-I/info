package rs.math.ispit201907.zadatakDodatni.zadatakDodatni;

public interface Stek<E> {
    void push(E elemenat);

    E pop();

    boolean isEmpty();

}
