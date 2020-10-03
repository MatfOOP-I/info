package f_dodatno_stringovi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JShell {
    public static final String prompt = "( ⌁ ): ";

    public static void main(String[] args) /* ignorisemo za sad */ throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        // U StringBuilder cemo smestati rezultat izvrsavanja 'shell' naredbi.
        StringBuilder cmdResult = new StringBuilder();

        showPrompt();
        String cmd = sc.nextLine();
        while (! isEnd(cmd)) {
            cmdResult = executeUserCommand(cmdResult, cmd);
            System.out.println(cmdResult);

            // Cistimo sadrzaj StringBuilder-a
            cmdResult.setLength(0);
            cmd = sc.nextLine();
            showPrompt();
        }

        System.out.println("MatfJShell successfully exited..");
        sc.close();
    }

    private static StringBuilder executeUserCommand(StringBuilder cmdResult, String cmd) throws IOException, InterruptedException {
        // Deo koji koristi Process i BufferedReader ignorisemo za sad takodje :)
        Process p = Runtime.getRuntime().exec(cmd);
        p.waitFor();
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine())!= null) {
            cmdResult.append(line + "\n");
        }
        return cmdResult;
    }

    private static void showPrompt() {
        System.out.print(prompt);
    }

    private static boolean isEnd(String cmd) {
        return cmd.equalsIgnoreCase("exit");
    }
}
