package Aufgabe_2;

public class Encryption
{
    //festgelegte Array mit allen Buchstaben als Inhalt
    private static char[] chars = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '!', '@',
            '#', '$', '%', '^', '&', '(', ')', '+',
            '-', '*', '/', '[', ']', '{', '}', '=',
            '<', '>', '?', '_', '"', '.', ',', ' '
    };


    public static String encrypt(String encrypt, int offset)
    {   //Übergabe des zu verschlüsselden Wertes und Speicherung in ein Array
        char[] plain = encrypt.toCharArray();

        //length = Länge des Arrays
        for (int i = 0; i < plain.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                //Wenn j kleiner Größe des Arrays char (also oben) - Offset
                //bspw. 88 (Größe des Arrays) - 5 (Offset)
                // Addition zu dem jeweiligen Wert im char Array das Offset
                if (j <= chars.length - offset)
                {
                    if (plain[i] == chars[j])
                    {
                        plain[i] = chars[j + offset];
                        break;
                    }
                }
                else if (plain[i] == chars[j]) {
                    plain[i] = chars[j - (chars.length - offset + 1)];
                }
            }
        }
        return String.valueOf(plain);
    }

    public static String decrypt(String decrypt, int offset)
    {
        char[] cipher = decrypt.toCharArray();
        for (int i = 0; i < cipher.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (j >= offset && cipher[i] == chars[j]) {
                    cipher[i] = chars[j - offset];
                    break;
                }
                if (cipher[i] == chars[j] && j < offset) {
                    cipher[i] = chars[(chars.length - offset +1) + j];
                    break;
                }
            }
        }
        return String.valueOf(cipher);
    }
}

