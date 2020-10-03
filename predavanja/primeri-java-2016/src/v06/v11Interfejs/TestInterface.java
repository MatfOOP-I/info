package v06.v11Interfejs;
import java.util.Random;

public class TestInterface
{
  public static void main(String[] args)
  {
    PetOutput[] thePets = {
                            new Dog("Rover", "Poodle"),
                            new Cat("Max", "Abyssinian"),
                            new Duck("Daffy","Aylesbury"),
                            new Spaniel("Fido")
                          };

    PetOutput petChoice;

    Random select = new Random();               // Random number generator
    for(int i = 0; i < 5; i++)
    {
      petChoice = thePets[select.nextInt(thePets.length)];
      System.out.println("\nYour choice:\n" + petChoice);
      petChoice.sound();
    }
  }
}
