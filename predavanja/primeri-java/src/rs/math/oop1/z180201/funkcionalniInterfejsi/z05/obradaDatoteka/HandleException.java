package rs.math.oop1.z180201.funkcionalniInterfejsi.z05.obradaDatoteka;

import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;

public class HandleException {
  public static void main(String[] args) throws IOException {
    Stream.of("/usr", "/tmp")
          .map(path -> {
            try {
             return new File(path).getCanonicalPath();             
            } catch(IOException ex) {
             return ex.getMessage();
            }
           }) 
          .forEach(System.out::println);    
  }
}
