package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import model.Cliente;
import model.dao.ClienteDAO;

public class ClienteDAOImpl implements ClienteDAO {

    private final String INSERT = "INSERT INTO Cliente (Documento, NombreCompleto) VALUES (?,?);";
    private final String UPDATE = "UPDATE Cliente SET NombreCompleto = ? WHERE Documento = ?;";
    private final String DELETE = "DELETE FROM Cliente WHERE Documento = ?;";
    private final String GETALL = "SELECT * FROM Cliente;";
    private final String GETONE = "SELECT * FROM Cliente WHERE Documento = ?;"; 

    private Connection conn = null;

    public ClienteDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Cliente cliente) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setString(1, cliente.getDocumento());
            stat.setString(2, cliente.getNombreCompleto());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Cliente cliente) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setString(1, cliente.getNombreCompleto());
            stat.setString(2, cliente.getDocumento());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override   
    public void eliminar(Cliente cliente) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setString(1, cliente.getDocumento());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Cliente> obtenerTodos() {
        List<Cliente> clientes = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                clientes.add(convertir(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    //OTRA MONDA DE ERROR
    @Override
    public Cliente getById(int documento) {
//        Cliente cliente = null;
//        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
//            stat.setString(1, documento);
//            try (ResultSet rs = stat.executeQuery()) {
//                if (rs.next()) {
//                    cliente = convertir(rs);
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return cliente;
        return new Cliente("nulls");
    }

    private Cliente convertir(ResultSet rs) throws SQLException {
        String documento = rs.getString("Documento");
        String nombreCompleto = rs.getString("NombreCompleto");

        return new Cliente(documento, nombreCompleto);
    }

    @Override
    public Cliente getByIdDocumento(String documento) {
        Cliente cliente = null;
        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
            stat.setString(1, documento);
            try (ResultSet rs = stat.executeQuery()) {
                if (rs.next()) {
                    cliente = convertir(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cliente;
    }

    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/bd_proyecto";
        String USER = "postgres";
        String PASS = "admin";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            ClienteDAO dao = new ClienteDAOImpl(conn);


            Cliente cliente = new Cliente("11123123123", "Juan Alberto");
            
            dao.insertar(cliente);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

