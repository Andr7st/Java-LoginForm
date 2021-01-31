package andr7st;
/**
 * @author Andrés Segura.
 * 
 * Ejercicio: Crear una ventana de login
 */
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

public class VentanaLogin extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 9155571621262263447L;
    
    public ImageIcon iconoVentana = new ImageIcon("img/icono.png");

    private final int VENTANA_ALTO = 620;
    private final int VENTANA_ANCHO = 360;

    public final Color COLOR_1 = new Color(45,45,45); //(124, 45, 82);
    public final Color COLOR_2 = new Color(240,240,240);

    public VentanaLogin() {

        this.setTitle("Login | Andr7st");
        this.setSize(VENTANA_ANCHO, VENTANA_ALTO);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(iconoVentana.getImage());
        this.add(new PanelPrincipal());
        this.setVisible(true);
        
        //this.getContentPane().setBackground(COLOR_1);
    }

    public class PanelPrincipal extends JPanel { private static final long serialVersionUID = 1L;

        public PanelPrincipal() {

            this.setBackground(COLOR_1);
            this.setLayout(null);
            this.add(new PanelImagen());
            this.add(new PanelLogin());

        }

        public class PanelLogin extends JPanel { private static final long serialVersionUID = 1L;

            //// Prueva: Nombre de usuario y contraseña exterados.
            private String expectedUserName = "Andr7st";
            private String expectedUserPass = "Andres";

            //// Coordenadas y tamaño de este panel.
            private final int PANEL_LOGIN_ANCHO = 300; 
            private final int PANEL_LOGIN_ALTO  = 240;
            private final int PANEL_LOGIN_POSICION_X =  30; 
            private final int PANEL_LOGIN_POSICION_Y = 260;

            //// labels alto y ancho.
            private int labelW = 200;
            private int labelH  = 24;
            
            //// Campos de usuario y contraseña. Para accederlos con eventListener.
            public JTextField campoUsername;
            public JPasswordField campoPassword;
            public JButton botonLogin;

            public PanelLogin() {

                ///// Campo de texto y label para nombre de usuario:
                JLabel labelUsername = new JLabel("Usuario:");
                labelUsername.setForeground(COLOR_2);
                labelUsername.setBounds(50, 20, labelW, labelH);
                
                campoUsername = new JTextField();
                campoUsername.setBounds(50, 50, labelW, labelH);
                
                ///// Campo de texto y label para nombre de contraseña:
                JLabel labelPassword = new JLabel("contraseña:");
                labelPassword.setBounds(50, 90, labelW, labelH);
                labelPassword.setForeground(COLOR_2);

                campoPassword = new JPasswordField();
                campoPassword.setBounds(50, 120, labelW, labelH);


                botonLogin = new JButton("Ingresar");
                botonLogin.setBounds(50, 174, labelW, 28);
                botonLogin.addActionListener(new AccionBotonLogin());



                ////////////////////////////////////////////////////////////////////
                this.setBackground(COLOR_1);
                this.setBounds(PANEL_LOGIN_POSICION_X, PANEL_LOGIN_POSICION_Y, PANEL_LOGIN_ANCHO, PANEL_LOGIN_ALTO);
                this.setLayout(null);

                this.add(labelUsername);
                this.add(campoUsername);
                this.add(labelPassword);
                this.add(campoPassword);
                this.add(botonLogin);
            }

            public class AccionBotonLogin implements ActionListener {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    String userName = campoUsername.getText();
                    String userPass = String.valueOf(campoPassword.getPassword());

                    // if(userName.equals(expectedUserName) && userPass.equals(expectedUserPass)){
                    if (userName.equalsIgnoreCase(expectedUserName) && userPass.equalsIgnoreCase(expectedUserPass)) {
                        
                        campoUsername.setBackground(new Color(116, 61, 150));
                        campoPassword.setBackground(new Color(116, 61, 150));
                        botonLogin.setEnabled(false);
                        
                        JOptionPane.showMessageDialog(null, "Cuenta autenticada ! ! !");


                        botonLogin.setEnabled(!false);
                        campoUsername.setBackground(new Color(255, 255, 255));
                        campoPassword.setBackground(new Color(255, 255, 255));
                        campoUsername.setText("");
                        campoPassword.setText("");
                    }

                }
            }
        }

        public class PanelImagen extends JPanel { private static final long serialVersionUID = 1L;

            /// Aquí sólo se dibuja el icono de login
            // https://www.clipartkey.com/view/TbJihh_user-icon-login-logo/
            private ImageIcon RECURSO_IMAGEN = new ImageIcon("img/LoginIcon.png");

            //// Coordenadas y tamaño de este panel
            private final int PANEL_IMAGEN_ANCHO      = 160;
            private final int PANEL_IMAGEN_ALTO       = 180;
            private final int PANEL_IMAGEN_POSICION_X = 100;
            private final int PANEL_IMAGEN_POSICION_Y =  40;

            public PanelImagen() {

                this.setBackground(Color.YELLOW);
                this.setBounds(PANEL_IMAGEN_POSICION_X, PANEL_IMAGEN_POSICION_Y, PANEL_IMAGEN_ANCHO, PANEL_IMAGEN_ALTO);
            }
    
            public void paint(Graphics g) {
                
                Dimension dimensionPanelImagen = getSize();
                g.drawImage(RECURSO_IMAGEN.getImage(), 0, 0, dimensionPanelImagen.width, dimensionPanelImagen.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
        }
    }  
}