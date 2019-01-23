package Aufgabe_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static Aufgabe_2.Encryption.decrypt;

class Login {

    static boolean authenticate(String username, String password)
    {
        boolean login = false;

        try
        {
            Scanner scan = new Scanner(new File("C:/temp/user.txt"));
            String line;
            while(scan.hasNextLine() && !isBlank(line = scan.nextLine()))
            {
                String[] accounts = line.split(";");
                String user = accounts[0];
                String pass = accounts[1];

                String enc = decrypt(pass, 10);
                if (username.equals(user) && password.equals(enc))
                {
                    login = true;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return login;
    }
    private static boolean isBlank(String s)
    {
        return s == null ||s.isEmpty();
    }
}