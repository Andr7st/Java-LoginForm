package andr7st.forms.login;

// andr7st.forms.login.PanelFuncionLogin

import javax.swing.*;

public class PanelFuncionLogin extends JPanel { private static final long serialVersionUID = 1L;

    //// Coordenadas y tamaño de este panel.
    private final int PANEL_LOGIN_ANCHO = 300; 
    private final int PANEL_LOGIN_ALTO  = 240;
    private final int PANEL_LOGIN_POSICION_X =  30; 
    private final int PANEL_LOGIN_POSICION_Y = 260;

    //// labels alto y ancho.
    private int labelW = 200;
    private int labelH  = 24;
    
    //// Campos de usuario y contraseña. Para accederlos con eventListener.
    public static JTextField campoUsername;
    public static JPasswordField campoPassword;
    public static JButton botonLogin;

    public PanelFuncionLogin() {

        ///// Campo de texto y label para nombre de usuario:
        JLabel labelUsername = new JLabel("Usuario:");
        labelUsername.setForeground(andr7st.forms.login.FrameLogin.COLOR_2);
        labelUsername.setBounds(50, 20, labelW, labelH);
        
        campoUsername = new JTextField();
        campoUsername.setBounds(50, 50, labelW, labelH);
        
        ///// Campo de texto y label para nombre de contraseña:
        JLabel labelPassword = new JLabel("contraseña:");
        labelPassword.setBounds(50, 90, labelW, labelH);
        labelPassword.setForeground(andr7st.forms.login.FrameLogin.COLOR_2);

        campoPassword = new JPasswordField();
        campoPassword.setBounds(50, 120, labelW, labelH);


        botonLogin = new JButton("Ingresar");
        botonLogin.setBounds(50, 174, labelW, 28);
        botonLogin.addActionListener(new AccionBotonLogin());



        ////////////////////////////////////////////////////////////////////
        this.setBackground(andr7st.forms.login.FrameLogin.COLOR_1);
        this.setBounds(PANEL_LOGIN_POSICION_X, PANEL_LOGIN_POSICION_Y, PANEL_LOGIN_ANCHO, PANEL_LOGIN_ALTO);
        this.setLayout(null);

        this.add(labelUsername);
        this.add(campoUsername);
        this.add(labelPassword);
        this.add(campoPassword);
        this.add(botonLogin);
    }
}