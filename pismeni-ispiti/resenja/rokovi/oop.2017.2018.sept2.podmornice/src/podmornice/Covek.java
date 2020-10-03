package podmornice;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Covek extends Igrac {


    @Override
    public boolean inicijalizuj() {
        Path path = Paths.get("podmornice.txt");

        try (Scanner sc = new Scanner(path)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] tokens = line.split(",");
                Polje k = new Polje(Integer.parseInt(tokens[0].trim()), Integer.parseInt(tokens[1].trim()));
                Podmornica p = new Podmornica(k, tokens[2].trim().charAt(0), Integer.parseInt(tokens[3].trim()));
                this.dodajPodmornicu(p);
            }

            return true;
        } catch (IOException e) {
            return false;
        }

    }
}
