
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
    VistaInformes menuInformes;
    VistaRegistroUsuarios menuRegistroUsuarios;
    Modelo modelo;

    Boolean isAdmin;


    //Constructor
    public Controlador(VistaLogin login, VistaPrincipalAdmin vistaPrincipalAdmin, VistaPrincipalVendedor vistaPrincipalVendedor,
            VistaRegistroEncargos vistaRegistroEncargos, VistaEncargos menuEncargos, VistaClientes menuClientes,
            VistaPrendas menuPrendas, VistaUniformes menuUniformes, VistaColegios menuColegios,
            VistaProveedores menuProveedores, VistaMateriales menuMateriales, VistaInformes menuInformes,
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
        this.menuInformes = menuInformes;
        this.menuRegistroUsuarios = menuRegistroUsuarios;
        this.modelo = modelo;
    }

    public void agregarListeners(){

        //Login
        login.btnLoginLB.addMouseListener(this);
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
        //parte de login
        if (e.getSource()==login.btnLoginLB) {
            login(login.txtUsername.getText(), login.txtPassword.getText());
            
        }

        //cambio entre paneles
        
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
