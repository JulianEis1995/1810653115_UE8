package Aufgabe_1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenster implements ActionListener {

    private static String secret = "geheimnis0815";
    private JButton loginButton, registerButton;
    private JTextField userText;
    private JPasswordField passwordText;
    private JFrame frame;

    public Fenster()
    {

        //Aufgabe_1.Fenster
        frame = new JFrame("Aufgabe_1.Login-Aufgabe_1.Fenster");
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

        loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        frame.add(loginButton);
        loginButton.addActionListener(this);


        registerButton = new JButton("Register");
        registerButton.setBounds(170, 80, 90, 25);
        frame.add(registerButton);
        registerButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == this.loginButton)
        {
            String user = userText.getText();
            String pass = String.valueOf(passwordText.getPassword());
            if (Login.authenticate(user, pass)) {
                JOptionPane.showMessageDialog(null,"Du wurdest eingeloggt. Das Geheimnis lautet: " + Fenster.secret);

            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "Aufgabe_1.Login", JOptionPane.ERROR_MESSAGE);
                //reset
                userText.setText("");
                passwordText.setText("");

            }        }
        else if(e.getSource() == this.registerButton)
        {
            frame.dispose();
            FensterRegister register = new FensterRegister();
        }
    }
}
