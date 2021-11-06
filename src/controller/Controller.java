package controller;

import view.LoginForm;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
public class Controller {

    public boolean Check() {
        if (!jtUsername.getText().equals(" ")) {
            if (!jPassword.getText().equals(" ")) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Insert The Password Field");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Insert The Username Field");
        }
    }

}
