
import com.formdev.flatlaf.FlatLightLaf;
import model.Modelo;
import view.VistaLogin;
import view.VistaPrincipalAdmin;
import view.VistaPrincipalVendedor;







/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        FlatLightLaf.setup(); // Sett del look and feel

        VistaLogin vista = new VistaLogin();
        VistaPrincipalAdmin vista2 = new VistaPrincipalAdmin();
        VistaPrincipalVendedor vistaVendedor = new VistaPrincipalVendedor();
      
        //vistaVendedor.setVisible(true);
        vista2.setVisible(true);

        
    }
}
