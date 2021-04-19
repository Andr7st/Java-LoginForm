package andr7st;
/**
 * @author Andrés Segura.
 */
import java.awt.EventQueue;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {

                new andr7st.forms.login.FrameLogin().setVisible(true);;
            }
        });
    }
}