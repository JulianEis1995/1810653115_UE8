package Aufgabe_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static Aufgabe_2.Encryption.encrypt;

public class FensterRegister implements ActionListener
{
    private JButton cancelButton, registerButton;
    private JTextField userText;
    private JPasswordField passwordText;
    private JFrame frame;
    public FensterRegister()
    {
        frame = new JFrame("Register-Aufgabe_1.Fenster");
        frame.setSize(290, 150);
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("User");
        userLabel.setBounds(10, 10, 80, 25);
        frame.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 10, 160, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 40, 80, 25);
        frame.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 40, 160, 25);
        frame.add(passwordText);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 80, 80, 25);
        frame.add(cancelButton);
        cancelButton.addActionListener(this);


        registerButton = new JButton("Register");
        registerButton.setBounds(10, 80, 90, 25);
        frame.add(registerButton);
        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

        if(e.getSource() == this.registerButton)
        {
            //Writer
            BufferedWriter bw = null;
            try
            {
                bw = new BufferedWriter(new FileWriter("C:/temp/user.txt", true));
                String pass = String.valueOf(passwordText.getPassword());

                String dec = encrypt(pass, 10);

                String content = System.getProperty("line.separator") + userText.getText() + ";" + dec;
                bw.write(content);

                //Aufgabe_1.Login-Aufgabe_1.Fenster wieder aufrufen
                Fenster fenster = new Fenster();
                frame.dispose();
            }
            catch (IOException e1)
            {
                e1.printStackTrace();
            }
            finally
            {
                if(bw != null)
                {
                    try
                    {
                        bw.close();
                    }
                    catch (IOException ie)
                    {
                        ie.printStackTrace();
                    }
                }
            }
        }
        else if(e.getSource() == this.cancelButton)
        {
            frame.dispose();
        }
    }
}

