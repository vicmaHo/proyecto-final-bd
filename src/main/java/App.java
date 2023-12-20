
import com.formdev.flatlaf.FlatLightLaf;

import controller.Controlador;
import model.Modelo;
import view.VistaClientes;
import view.VistaColegios;
import view.VistaEncargos;
import view.VistaInformes;
import view.VistaLogin;
import view.VistaMateriales;
import view.VistaPrendas;
import view.VistaPrincipalAdmin;
import view.VistaPrincipalVendedor;
import view.VistaProveedores;
import view.VistaRegistroEncargos;
import view.VistaRegistroUsuarios;
import view.VistaUniformes;







/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        FlatLightLaf.setup(); // Sett del look and feel


        VistaLogin login = new VistaLogin();
        VistaPrincipalAdmin vistaPrincipalAdmin = new VistaPrincipalAdmin();
        VistaPrincipalVendedor vistaPrincipalVendedor = new VistaPrincipalVendedor();
        VistaRegistroEncargos vistaRegistroEncargos = new VistaRegistroEncargos();
        VistaEncargos menuEncargos = new VistaEncargos();
        VistaClientes menuClientes = new VistaClientes();
        VistaPrendas menuPrendas = new VistaPrendas();
        VistaUniformes menuUniformes = new VistaUniformes();
        VistaColegios menuColegios = new VistaColegios();
        VistaProveedores menuProveedores = new VistaProveedores();
        VistaMateriales menuMateriales = new VistaMateriales();
        VistaInformes menuInformes = new VistaInformes();
        VistaRegistroUsuarios menuRegistroUsuarios = new VistaRegistroUsuarios();
        Modelo modelo = new Modelo();

        Controlador controlador = new Controlador( login,  vistaPrincipalAdmin,  vistaPrincipalVendedor,
                    vistaRegistroEncargos,  menuEncargos,  menuClientes,
         menuPrendas,  menuUniformes,  menuColegios,
         menuProveedores,  menuMateriales,  menuInformes,
         menuRegistroUsuarios,  modelo);

        controlador.iniciar();
        


        
    }
}
