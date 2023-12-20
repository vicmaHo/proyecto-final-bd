package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

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


    //Metodos de consultas
    


    
}
