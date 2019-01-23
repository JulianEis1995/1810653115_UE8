package Aufgabe_5;

import javax.swing.*;

public class Aufruf
{
    public static void main(String[] args)
    {
        NumberFindOuter nfo = new NumberFindOuter();
        nfo.fillFile();

        int input = Integer.parseInt(JOptionPane.showInputDialog("Nummer eingeben:"));

        JOptionPane.showMessageDialog(null, "Die Zahl " + input + " kommt vor: " + nfo.counter(input));
    }
}
