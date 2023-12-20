
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Modelo;
import model.Usuario;
import view.*;

/**
 *
 * @author Victor
 */
public class Controlador implements ActionListener, MouseListener {
    //Todas las vistas y el modelo

    //faltan las vistas de inicio
    VistaLogin login;
    VistaPrincipalAdmin vistaPrincipalAdmin;
    VistaPrincipalVendedor vistaPrincipalVendedor;
    VistaRegistroEncargos vistaRegistroEncargos;
    VistaEncargos menuEncargos;
    VistaClientes menuClientes;
    VistaPrendas menuPrendas;
    VistaUniformes menuUniformes;
    VistaColegios menuColegios;
    VistaProveedores menuProveedores;
    VistaMateriales menuMateriales;
    VistaSuministro menuSuministros;
    VistaInformes menuInformes;
    VistaRegistroUsuarios menuRegistroUsuarios;
    Modelo modelo;

    Boolean isAdmin;


    //Constructor
    public Controlador(VistaLogin login, VistaPrincipalAdmin vistaPrincipalAdmin, VistaPrincipalVendedor vistaPrincipalVendedor,
            VistaRegistroEncargos vistaRegistroEncargos, VistaEncargos menuEncargos, VistaClientes menuClientes,
            VistaPrendas menuPrendas, VistaUniformes menuUniformes, VistaColegios menuColegios,
            VistaProveedores menuProveedores, VistaMateriales menuMateriales, VistaSuministro menuSuministros ,VistaInformes menuInformes,
            VistaRegistroUsuarios menuRegistroUsuarios, Modelo modelo) {
        this.login = login;
        this.vistaPrincipalAdmin = vistaPrincipalAdmin;
        this.vistaPrincipalVendedor = vistaPrincipalVendedor;
        this.vistaRegistroEncargos = vistaRegistroEncargos;
        this.menuEncargos = menuEncargos;
        this.menuClientes = menuClientes;
        this.menuPrendas = menuPrendas; 
        this.menuUniformes = menuUniformes;
        this.menuColegios = menuColegios;
        this.menuProveedores = menuProveedores;
        this.menuMateriales = menuMateriales;
        this.menuSuministros = menuSuministros;
        this.menuInformes = menuInformes;
        this.menuRegistroUsuarios = menuRegistroUsuarios;
        this.modelo = modelo;
    }

    public void agregarListeners(){

        //Login
        login.btnLoginLB.addMouseListener(this);

        //Vista PrincipalAdmin
        vistaPrincipalAdmin.btnRegistroEntregas.addMouseListener(this);
        vistaPrincipalAdmin.btnEncargos.addMouseListener(this);
        vistaPrincipalAdmin.btnClientes.addMouseListener(this);
        vistaPrincipalAdmin.btnPrendas.addMouseListener(this);
        vistaPrincipalAdmin.btnUniformes.addMouseListener(this);
        vistaPrincipalAdmin.btnColegios.addMouseListener(this);
        vistaPrincipalAdmin.btnProveedores.addMouseListener(this);
        vistaPrincipalAdmin.btnMateriales.addMouseListener(this);
        vistaPrincipalAdmin.btnRegistroMateriales.addMouseListener(this);
        vistaPrincipalAdmin.btnInformes.addMouseListener(this);
        vistaPrincipalAdmin.btnRegistroUsers.addMouseListener(this);

        //vistaPrincipalVendedor
        vistaPrincipalVendedor.btnRegistroEntregas.addMouseListener(this);
        vistaPrincipalVendedor.btnEncargos.addMouseListener(this);
        vistaPrincipalVendedor.btnClientes.addMouseListener(this);
        vistaPrincipalVendedor.btnPrendas.addMouseListener(this);
        vistaPrincipalVendedor.btnUniformes.addMouseListener(this);
        vistaPrincipalVendedor.btnColegios.addMouseListener(this);

    }
    
    public void login(String nombre, String contrasena){
        boolean loginFlag = false;
        for (Usuario usuario : modelo.obtenerListaUsuarios()) {

            if (usuario.getNombre().equals(nombre) && usuario.getContrasena().equals(contrasena)) {
                loginFlag = true;
                if (usuario.getTipo().equals("administrador")) {
                    vistaPrincipalAdmin.setVisible(true);
                    isAdmin = true;
                    vistaPrincipalAdmin.lbBienvenida.setText("Bienvenido/a " + usuario.getNombre());
                } else if (usuario.getTipo().equals("vendedor")) {
                    vistaPrincipalVendedor.setVisible(true);
                    isAdmin = false;
                    vistaPrincipalVendedor.lbBienvenida.setText("Bienvenido/a " + usuario.getNombre());
                    
                }
            }
        }

        if (!loginFlag) {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");    
        }else{
            login.setVisible(false);
        }
        
    }


    public void actualizarCliente(){
        
    }

    public void iniciar(){
        agregarListeners();
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

    private void agregarJPanel(JPanel p, String titulo){
        p.setSize(968, 617);
        p.setLocation(0,0);

        if (isAdmin) {
            vistaPrincipalAdmin.pnContenido.removeAll();
            vistaPrincipalAdmin.pnContenido.add(p, BorderLayout.CENTER);
            vistaPrincipalAdmin.pnContenido.revalidate();
            vistaPrincipalAdmin.pnContenido.repaint();
            
             //Cambio el titulo
            vistaPrincipalAdmin.lbTitulo.setText(titulo);
        }else{
            vistaPrincipalVendedor.pnContenido.removeAll();
            vistaPrincipalVendedor.pnContenido.add(p, BorderLayout.CENTER);
            vistaPrincipalVendedor.pnContenido.revalidate();
            vistaPrincipalVendedor.pnContenido.repaint();

            //cambio el titulo
            vistaPrincipalVendedor.lbTitulo.setText(titulo);
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(isAdmin);
        //parte de login
        if (e.getSource()==login.btnLoginLB) {
            login(login.txtUsername.getText(), login.txtPassword.getText());
            
        }
        //CAMBIO ENTRE PANELES
        if(isAdmin){
            if (e.getSource()==vistaPrincipalAdmin.btnRegistroEntregas) {
                agregarJPanel(vistaRegistroEncargos, "REGISTRO DE ENCARGOS");
                
            }else if (e.getSource()==vistaPrincipalAdmin.btnEncargos) {
                agregarJPanel(menuEncargos, "ADMINISTRACION DE ENCARGOS");

            }else if(e.getSource()==vistaPrincipalAdmin.btnClientes) {
                agregarJPanel(menuClientes, "CLIENTES");
         
            }else if (e.getSource()==vistaPrincipalAdmin.btnPrendas) {
                agregarJPanel(menuPrendas, "PRENDAS");
                
            }else if (e.getSource()==vistaPrincipalAdmin.btnUniformes) {
                agregarJPanel(menuUniformes, "UNIFORMES");
                
            }else if (e.getSource()==vistaPrincipalAdmin.btnColegios) {
                agregarJPanel(menuColegios, "COLEGIOS");
                
            }else if (e.getSource()==vistaPrincipalAdmin.btnProveedores) {
                agregarJPanel(menuProveedores, "PROVEEDORES");
                
            }else if (e.getSource()==vistaPrincipalAdmin.btnMateriales) {
                System.out.println("Entro en materiales");
                agregarJPanel(menuMateriales, "MATERIAS PRIMAS");   
                
            }else if(e.getSource()==vistaPrincipalAdmin.btnRegistroMateriales){
                agregarJPanel(menuSuministros, "REGISTRO DE SUMINISTROS");
            }else if(e.getSource()==vistaPrincipalAdmin.btnInformes){
                agregarJPanel(menuInformes, "INFORMES");
            }else if(e.getSource()==vistaPrincipalAdmin.btnRegistroUsers){
                agregarJPanel(menuRegistroUsuarios, "REGISTRO DE USUARIOS");
            }
        }else{
            if (e.getSource()==vistaPrincipalVendedor.btnRegistroEntregas) {
                agregarJPanel(vistaRegistroEncargos, "REGISTRO DE ENCARGOS");
            }else if(e.getSource()==vistaPrincipalVendedor.btnEncargos){
                agregarJPanel(menuEncargos, "ADMINISTRACION DE ENCARGOS");
            }else if (e.getSource()==vistaPrincipalVendedor.btnClientes) {
                agregarJPanel(menuClientes, "CLIENTES");
            }else if (e.getSource()==vistaPrincipalVendedor.btnPrendas) {
                agregarJPanel(menuPrendas, "PRENDAS");
            }else if (e.getSource()==vistaPrincipalVendedor.btnUniformes) {
                agregarJPanel(menuUniformes, "UNIFORMES");
            }else if (e.getSource()==vistaPrincipalVendedor.btnColegios) {
                agregarJPanel(menuColegios, "COLEGIOS");
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
  
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



    
}
