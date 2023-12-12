
import com.formdev.flatlaf.FlatLightLaf;
import view.VistaLogin;
import view.VistaPrincipal;







/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
      FlatLightLaf.setup(); // Sett del look and feel
      
      VistaLogin vista = new VistaLogin();
      VistaPrincipal vista2 = new VistaPrincipal();
      vista2.setVisible(true);
      
    }
}
