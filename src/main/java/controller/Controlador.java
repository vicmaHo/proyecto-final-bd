
package controller;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

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
    Boolean isAdmin; // detecto si el usuario es administrador o vendedor


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

    //agrego los listeners a los componentes necesarios
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


        //Registro de usuarios
        menuRegistroUsuarios.btnAgregar.addActionListener(this);
        menuRegistroUsuarios.btnEliminarUsuario.addActionListener(this);
        menuRegistroUsuarios.btnModificarUsuario.addActionListener(this);

        // Registro de encargos
        vistaRegistroEncargos.btnFinalizar.addActionListener(this);

    }
    
    //METODO DE LOGIN
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

    // MEtodo para iniciar/actualiza COmboBoxes
    private void actualizarComboBoxes(){
        vistaRegistroEncargos.cbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(modelo.obtenerDocumentosClientes()));
        vistaRegistroEncargos.cbNombreColegio.setModel(new javax.swing.DefaultComboBoxModel<>(modelo.obtenerNombresColegios()));
        // menuLista.lsLista.setModel(new javax.swing.DefaultComboBoxModel<>(model.getNombresDulces()));
    }


    // Metodos del menu Registro Encargos


    //METODOS DEL MENU USUARIO

    // Limpiar los campos
    public void limpiarCamposUsuarios(){
        menuRegistroUsuarios.txtNombreUsuario.setText("");
        menuRegistroUsuarios.txtContrasenaUsuario.setText("");
        menuRegistroUsuarios.bgRol.clearSelection();
    }



    // Actualizar La lista de los usuarios
    public void actualizarListaUsuarios(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn(menuRegistroUsuarios.tblUsuarios.getColumnName(0));
        tableModel.addColumn(menuRegistroUsuarios.tblUsuarios.getColumnName(1));
        tableModel.addColumn(menuRegistroUsuarios.tblUsuarios.getColumnName(2));
        tableModel.addColumn(menuRegistroUsuarios.tblUsuarios.getColumnName(3));

        
        for (Usuario usuario : modelo.obtenerListaUsuarios()) {
            Object[] fila = { usuario.getId(), usuario.getNombre(), usuario.getContrasena(), usuario.getTipo() };
            tableModel.addRow(fila);
        }

        menuRegistroUsuarios.tblUsuarios.setModel(tableModel);
    }

    // Registrar un usuario
    public void registrarUsuario(){
        String nombre = menuRegistroUsuarios.txtNombreUsuario.getText();
        String contrasena = menuRegistroUsuarios.txtContrasenaUsuario.getText();
        String tipo = menuRegistroUsuarios.btnAdmin.isSelected() ? "administrador" : "vendedor";

        modelo.insertarUsuario(new Usuario(nombre, contrasena, tipo));
        JOptionPane.showMessageDialog(null, "Usuario registrado");
    }

    // Eliminar Un usuario
    public void eliminarUsuario(){
        DefaultTableModel tableModelo = (DefaultTableModel) menuRegistroUsuarios.tblUsuarios.getModel();

        int filaSeleccionada = menuRegistroUsuarios.tblUsuarios.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila");
            return;
        }
        int codigo = (int) tableModelo.getValueAt(filaSeleccionada, 0);
        String nombre = (String) tableModelo.getValueAt(filaSeleccionada, 1);
        String contrasena = (String) tableModelo.getValueAt(filaSeleccionada, 2);
        String tipo = (String) tableModelo.getValueAt(filaSeleccionada, 3);

        // Crear el objeto Usuario con esos valores
        Usuario usuarioEliminar = new Usuario(codigo, nombre, contrasena, tipo);

        // Llamar al método actualizarUsuario
        modelo.eliminarUsuario(usuarioEliminar);
        JOptionPane.showMessageDialog(null, "Usuario "+usuarioEliminar.getNombre() +" eliminado");
        actualizarListaUsuarios();
    }
    
    // Modificar los datos de un usuario
    public void modificarDatosUsuario(){
        // Obtener la fila seleccionada
        int filaSeleccionada = menuRegistroUsuarios.tblUsuarios.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila");
            return;
        }

        // Obtener los nuevos valores de los campos
        int codigo = (int) menuRegistroUsuarios.tblUsuarios.getValueAt(filaSeleccionada, 0); // el id no cambia, los demas pueden cambiar
        String nombre = (String) menuRegistroUsuarios.tblUsuarios.getValueAt(filaSeleccionada, 1);
        String contrasena = (String) menuRegistroUsuarios.tblUsuarios.getValueAt(filaSeleccionada, 2);
        String tipo = (String) menuRegistroUsuarios.tblUsuarios.getValueAt(filaSeleccionada, 3);

        // Crear el objeto Usuario con esos valores
        Usuario usuarioModificar = new Usuario(codigo, nombre, contrasena, tipo);
        modelo.actualizarUsuario(usuarioModificar);
        JOptionPane.showMessageDialog(null, "Usuario #"+usuarioModificar.getId() +" modificado");
        actualizarListaUsuarios();
    }

    // Metodo para iniciar la apliacion
    public void iniciar(){
        agregarListeners();
        login.setVisible(true);
        login.txtUsername.setText("admin");
        login.txtPassword.setText("admin");
    }


    //METODOS DE LISTENERS PARA LOS BOTONES NECESARIOS
    @Override
    public void actionPerformed(ActionEvent e) {
        // USUARIOS
        if (e.getSource()==menuRegistroUsuarios.btnAgregar) {
            if (menuRegistroUsuarios.txtNombreUsuario.getText().isEmpty() || menuRegistroUsuarios.txtContrasenaUsuario.getText().isEmpty()
                || !menuRegistroUsuarios.btnAdmin.isSelected() && !menuRegistroUsuarios.btnVendedor.isSelected()) {
                JOptionPane.showMessageDialog(null, "Por favor llene todos los campos");
            }else{
                registrarUsuario();
                limpiarCamposUsuarios();
                actualizarListaUsuarios();
            }
        }if (e.getSource()==menuRegistroUsuarios.btnEliminarUsuario) {
            eliminarUsuario();
        }if (e.getSource()==menuRegistroUsuarios.btnModificarUsuario) {
            modificarDatosUsuario();
        }

        //PRODUCTOS...
       
    }

    // METODO PARA CAMBIAR ENTRE JPANELES
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


    // EVENTOS DE LOS LABELS PARA CAMBIAR PANELES Y TITULO
    @Override
    public void mouseClicked(MouseEvent e) {
        //parte de login
        if (e.getSource()==login.btnLoginLB) {
            login(login.txtUsername.getText(), login.txtPassword.getText()); 
        }
        //CAMBIO ENTRE PANELES
        if(isAdmin){
            if (e.getSource()==vistaPrincipalAdmin.btnRegistroEntregas) {
                agregarJPanel(vistaRegistroEncargos, "REGISTRO DE ENCARGOS");
                actualizarComboBoxes();
                
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
                limpiarCamposUsuarios();
                actualizarListaUsuarios();
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
