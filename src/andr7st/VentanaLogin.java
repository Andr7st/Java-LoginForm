package andr7st;
/**
 * @author Andrés Segura
 * 
 * Ejercicio: Crear una ventana de login
 */


import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
//import java.awt.Component;
import java.awt.Dimension;

public class VentanaLogin extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 9155571621262263447L;

    private final int VENTANA_ALTO = 620;
    private final int VENTANA_ANCHO = 400;
    public ImageIcon icono = new ImageIcon("img/icono.png");
    public ImageIcon IMAGEN = new ImageIcon("img/LoginIcon.png"); 

    public final Color COLOR_1 = new Color(45,45,45); //(124, 45, 82);
    public final Color COLOR_2 = new Color(240,240,240);

    public VentanaLogin() {

        this.setTitle("Login | Andr7st");
        this.setSize(VENTANA_ANCHO, VENTANA_ALTO);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setIconImage(icono.getImage());
        //this.getContentPane().setBackground(COLOR_1);
        this.add(new LaminaPrincipal());
        this.setVisible(true);

    }

    public class LaminaPrincipal extends JPanel { private static final long serialVersionUID = 1L;

        public LaminaPrincipal() {

            this.setBackground(COLOR_1);
            this.setLayout(null);
            this.add(new LaminaImagen());
            this.add(new LaminaLogin());

        }

        public class LaminaLogin extends JPanel { private static final long serialVersionUID = 1L;

            int CAMPO_ANCHO = 200;
            int CAMPO_ALTO  = 24;

            public JTextField campoUsername;
            public JPasswordField campoPassword;

            public LaminaLogin() {

                // Campo de texto y label para nombre de usuario:
                JLabel labelUsername = new JLabel("Usuario:");
                labelUsername.setForeground(COLOR_2);
                labelUsername.setBounds(50, 20, CAMPO_ANCHO, CAMPO_ALTO);
                
                campoUsername = new JTextField("Username");
                campoUsername.setBounds(50, 50, CAMPO_ANCHO, CAMPO_ALTO);
                
                // Campo de texto y label para nombre de contraseña:
                JLabel labelPassword = new JLabel("contraseña:");
                labelPassword.setBounds(50, 90, CAMPO_ANCHO, CAMPO_ALTO);
                labelPassword.setForeground(COLOR_2);

                campoPassword = new JPasswordField("************");
                campoPassword.setBounds(50, 120, CAMPO_ANCHO, CAMPO_ALTO);


                JButton boton = new JButton("Ingresar");
                boton.setBounds(50, 174, CAMPO_ANCHO, 28);


                ////////////////////////////////////////////////////////////////////
                this.setBackground(COLOR_1);
                this.setBounds(50, 260, 300, 240);
                this.setLayout(null);

                this.add(labelUsername);
                this.add(campoUsername);
                this.add(labelPassword);
                this.add(campoPassword);
                this.add(boton);
            }

        }

        public class LaminaImagen extends JPanel { private static final long serialVersionUID = 1L;

            /// Aquí sólo se dibuja el icono de login
            // https://www.clipartkey.com/view/TbJihh_user-icon-login-logo/

            public LaminaImagen() {

                int ancho = 160;
                int alto = 180;
                int posicionX = 120;
                int posicionY = 40;
                //
                // this.setBackground(Color.YELLOW);
                this.setBounds(posicionX, posicionY, ancho, alto);
            }
    
            public void paint(Graphics g) {
                
                Dimension DIMENSION = getSize();
                g.drawImage(IMAGEN.getImage(), 0, 0, DIMENSION.width, DIMENSION.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }
            
        }

    }  
}