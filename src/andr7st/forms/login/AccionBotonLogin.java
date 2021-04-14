package andr7st.forms.login;

import java.awt.event.*;

import javax.swing.JOptionPane;
import java.awt.Color;

public class AccionBotonLogin implements ActionListener {

    //// Prueva: Nombre de usuario y contraseña exterados.
    public String expectedUserName = "Andr7st";
    public String expectedUserPass = "Andres";

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String userName = andr7st.forms.login.PanelFuncionLogin.campoUsername.getText();
        String userPass = String.valueOf(andr7st.forms.login.PanelFuncionLogin.campoPassword.getPassword());

        // if(userName.equals(expectedUserName) && userPass.equals(expectedUserPass)){
        if (userName.equalsIgnoreCase(expectedUserName) && userPass.equalsIgnoreCase(expectedUserPass)) {
            
            andr7st.forms.login.PanelFuncionLogin.campoUsername.setBackground(new Color(116, 61, 150));
            andr7st.forms.login.PanelFuncionLogin.campoPassword.setBackground(new Color(116, 61, 150));
            andr7st.forms.login.PanelFuncionLogin.botonLogin.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "Cuenta autenticada ! ! !");


            andr7st.forms.login.PanelFuncionLogin.botonLogin.setEnabled(!false);
            andr7st.forms.login.PanelFuncionLogin.campoUsername.setBackground(new Color(255, 255, 255));
            andr7st.forms.login.PanelFuncionLogin.campoPassword.setBackground(new Color(255, 255, 255));
            andr7st.forms.login.PanelFuncionLogin.campoUsername.setText("");
            andr7st.forms.login.PanelFuncionLogin.campoPassword.setText("");
        }

    }
}