package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.Driver;
import org.postgresql.shaded.com.ongres.stringprep.StringPrep;

import model.dao.ClienteDAO;
import model.dao.ColegioDAO;
import model.dao.EncargoDAO;
import model.dao.MateriasPrimasDAO;
import model.dao.PrendaDAO;
import model.dao.ProveedorDAO;
import model.dao.SuministroDAO;
import model.dao.TelefonoDAO;
import model.dao.UniformeDAO;
import model.dao.UsanDAO;
import model.dao.UsuarioDAO;
import model.dao.implementaciones.ClienteDAOImpl;
import model.dao.implementaciones.ColegioDAOImpl;
import model.dao.implementaciones.EncargoDAOImpl;
import model.dao.implementaciones.MateriasPrimasDAOImpl;
import model.dao.implementaciones.PrendaDAOImpl;
import model.dao.implementaciones.ProveedorDAOImpl;
import model.dao.implementaciones.SuministroDAOImpl;
import model.dao.implementaciones.TelefonoDAOImpl;
import model.dao.implementaciones.UniformeDAOImpl;
import model.dao.implementaciones.UsanDAOImpl;
import model.dao.implementaciones.UsuarioDaoImpl;

public class Modelo {
    // Atributos son los DAO y la conexion a la base de datos
    private String URL = "jdbc:postgresql://localhost:5432/bd_proyecto";
    private String USER = "postgres";
    private String PASS = "admin";
    
    //Agregar los dao
    ClienteDAO clienteDAO;
    ColegioDAO colegioDAO;
    EncargoDAO encargoDAO;
    UniformeDAO uniformeDAO;
    MateriasPrimasDAO materiasPrimasDAO;
    PrendaDAO prendaDAO;
    ProveedorDAO proveedorDAO;
    SuministroDAO suministroDAO;
    TelefonoDAO telefonoDAO;
    UsanDAO usanDAO;
    UsuarioDAO usuarioDAO;
    
    //Conexion
    private Connection conn;



    public Modelo() {
        configurarConexion(URL, USER, PASS);
        this.clienteDAO = new ClienteDAOImpl(conn);
        this.colegioDAO = new ColegioDAOImpl(conn);
        this.encargoDAO = new EncargoDAOImpl(conn);
        this.uniformeDAO = new UniformeDAOImpl(conn);
        this.materiasPrimasDAO = new MateriasPrimasDAOImpl(conn);
        this.prendaDAO = new PrendaDAOImpl(conn);
        this.proveedorDAO = new ProveedorDAOImpl(conn);
        this.suministroDAO = new SuministroDAOImpl(conn);
        this.telefonoDAO = new TelefonoDAOImpl(conn);
        this.usanDAO = new UsanDAOImpl(conn);
        this.usuarioDAO = new UsuarioDaoImpl(conn);

        
    }

    //Metodo para hacer la conexion
    public void configurarConexion(String url, String user, String pass) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            this.conn = conn;
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Metodos especiales
    public String[] obtenerDocumentosClientes(){
        List<Cliente> clientes = clienteDAO.obtenerTodos();

        // Crear un array de strings para almacenar los documentos
        String[] documentos = new String[clientes.size()];

        // Llenar el array con los documentos de los clientes
        for (int i = 0; i < clientes.size(); i++) {
            documentos[i] = clientes.get(i).getDocumento();
        }

        return documentos;
    }

    public String[] obtenerNombresColegios(){
        List<Colegio> colegios = colegioDAO.obtenerTodos();
        String[] nombres = new String[colegios.size()];

        for (int i = 0; i < colegios.size(); i++) {
            nombres[i] = colegios.get(i).getNombre();
        }

        return nombres;
    }

    //Metodos de consultas

    // Usuario
    public void insertarUsuario(Usuario usuario){
        usuarioDAO.insertar(usuario);
    }

    public Usuario obtenerUsuario(int id){
        return usuarioDAO.getById(id);
    }

    public ArrayList<Usuario> obtenerListaUsuarios(){
        return (ArrayList<Usuario>) usuarioDAO.obtenerTodos();
    }

    public void eliminarUsuario(Usuario usuario){
        usuarioDAO.eliminar(usuario);
    }

    public void actualizarUsuario(Usuario usuario){
        usuarioDAO.modificar(usuario);
    }


    // Lo de edgar

    //Prenda
     public void insertarPrenda(Prenda prenda) {
        prendaDAO.insertar(prenda);
    }
     public void eliminarPrenda(Prenda prenda) {
        prendaDAO.eliminar(prenda);
    }

    public void modificarPrenda(Prenda prenda) {
        prendaDAO.modificar(prenda);
    }

    public ArrayList<Prenda> obtenerTodasprendas() {
        return (ArrayList<Prenda>) prendaDAO.obtenerTodos();
    }
    
    public Prenda obtenerPrendaPorId(int id) {
        return prendaDAO.getById(id);
    }
    //suministro
    
    public void insertarSuministro(Suministro suministro) {
        suministroDAO.insertar(suministro);
    }
    public void eliminarSuministro(Suministro suministro) {
        suministroDAO.eliminar(suministro);
    }
    public void modificarSuministro(Suministro suministroNuevo, Suministro suministroViejo) {
        suministroDAO.modificar(suministroNuevo, suministroViejo);
    }
    public ArrayList<Suministro> obtenerTodosSuministros() {
        return (ArrayList<Suministro>) suministroDAO.obtenerTodos();
    }

    public Suministro obtenerSuministroPorIdCompuesto(String NIT, int codPri) {
        return suministroDAO.getByIdCompuesto(NIT,codPri);
    }
    
    //telefono

    public void insertarTelefono(Telefono telefono) {
        telefonoDAO.insertar(telefono);
    }
    public void eliminarTelefono(Telefono telefono) {
        telefonoDAO.eliminar(telefono);
    }
    public void modificarTelefono(Telefono telefono) {
        telefonoDAO.modificar(telefono);
    }
    public List<Telefono> obtenerTodosTelefono() {
        return (ArrayList<Telefono>) telefonoDAO.obtenerTodos();
    }
    
    public Telefono obtenerTelefonoPorDocumento(int Documento) {
        return telefonoDAO.getById(Documento);
    }

    //Uniforme
    
    public void insertarUniforme(Uniforme uniforme) {
        uniformeDAO.insertar(uniforme);
    }
    public void eliminarUniforme(Uniforme uniforme) {
        uniformeDAO.eliminar(uniforme);
    }
    public void modificarUniforme(Uniforme uniforme) {
        uniformeDAO.modificar(uniforme);
    }
    public List<Uniforme> obtenerTodosUniforme() {
        return (ArrayList<Uniforme>) uniformeDAO.obtenerTodos();
    }
    public Telefono obtenerUniformePorId(int id) {
        return telefonoDAO.getById(id);
    }

    //Usan
    
    public void insertarUsan(Usan usan) {
        usanDAO.insertar(usan);
    }
    public void eliminarUsan(Usan usan) {
        usanDAO.eliminar(usan);
    }
    public void modificarUsan(Usan usan) {
        usanDAO.modificar(usan);
    }
    public List<Usan> obtenerTodasUsan() {
        return (ArrayList<Usan>) usanDAO.obtenerTodos();
    }
    public Usan obtenerUsanPorIdCompuesto(int idPrenda, int codPri) {
        return usanDAO.getByIdCompuesto(idPrenda,codPri);
    }


  //PARTE CLIENTES
    public ArrayList<Cliente> obtenerClientes() {
        return (ArrayList<Cliente>) clienteDAO.obtenerTodos();
    }
    public Cliente obtenerClientePorID(String id) {
        return clienteDAO.getByIdDocumento(id);
    }
    public void agregarCliente(Cliente nuevoCliente) {
        clienteDAO.insertar(nuevoCliente);
    }
    public void eliminarCliente(Cliente cliente) {
        clienteDAO.eliminar(cliente);
    }
    public void modificarCliente(Cliente cliente) {
        clienteDAO.modificar(cliente);
    }


    //PARTE COLEGIO
    public ArrayList<Colegio> obtenerColegios() {
        return (ArrayList<Colegio>) colegioDAO.obtenerTodos();
    }

    public Colegio obtenerColegioPorID(int id) {
        return colegioDAO.getById(id);
    }

    public void agregarColegio(Colegio nuevoColegio) {
        colegioDAO.insertar(nuevoColegio);
    }

    public void eliminarColegio(Colegio colegio) {
        colegioDAO.eliminar(colegio);
    }

    public void modificarColegio(Colegio colegio) {
        colegioDAO.modificar(colegio);
    }


    //PARTE ENCARGOS
    public ArrayList<Encargo> obtenerEncargos() {
        return (ArrayList<Encargo>) encargoDAO.obtenerTodos();
    }

    public Encargo obtenerEncargoPorID(int id) {
        return encargoDAO.getById(id);
    }

    public void agregarEncargo(Encargo nuevoEncargo) {
        encargoDAO.insertar(nuevoEncargo);
    }

    public void eliminarEncargo(Encargo encargo) {
        encargoDAO.eliminar(encargo);
    }

    public void modificarEncargo(Encargo encargo) {
        encargoDAO.modificar(encargo);
    }


    //PARTE MATERIAS PRIMAS
    public ArrayList<MateriasPrimas> obtenerMateriasPrimas() {
        return (ArrayList<MateriasPrimas>) materiasPrimasDAO.obtenerTodos();
    }

    public MateriasPrimas obtenerMateriasPrimasPorID(int id) {
        return materiasPrimasDAO.getById(id);
    }

    public void agregarMateriasPrimas(MateriasPrimas nuevaMateriaPrima) {
        materiasPrimasDAO.insertar(nuevaMateriaPrima);
    }

    public void eliminarMateriasPrimas(MateriasPrimas materiaPrima) {
        materiasPrimasDAO.eliminar(materiaPrima);
    }

    public void modificarMateriasPrimas(MateriasPrimas materiaPrima) {
        materiasPrimasDAO.modificar(materiaPrima);
    }


    //PARTE MATERIASPRIMAS
    public ArrayList<Proveedor> obtenerProveedores() {
        return (ArrayList<Proveedor>) proveedorDAO.obtenerTodos();
    }

    public Proveedor obtenerProveedorPorNit(String NIT) {
        return proveedorDAO.getByNit(NIT);
    }

    public void agregarProveedor(Proveedor nuevoProveedor) {
        proveedorDAO.insertar(nuevoProveedor);
    }

    public void eliminarProveedor(Proveedor proveedor) {
        proveedorDAO.eliminar(proveedor);
    }

    public void modificarProveedor(Proveedor proveedor) {
        proveedorDAO.modificar(proveedor);
    }


    
}
