package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Proveedor;
import model.dao.ProveedorDAO;

public class ProveedorDAOImpl implements ProveedorDAO {

    private final String INSERT = "INSERT INTO Proveedor (NIT, Nombre, NombreContacto, ProductoSuministra) VALUES (?,?,?,?);";
    private final String UPDATE = "UPDATE Proveedor SET Nombre = ?, NombreContacto = ?, ProductoSuministra = ? WHERE NIT = ?;";
    private final String DELETE = "DELETE FROM Proveedor WHERE NIT = ?;";
    private final String GETALL = "SELECT * FROM Proveedor;";
    private final String GETONE = "SELECT * FROM Proveedor WHERE NIT = ?;";

    private Connection conn = null;

    public ProveedorDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Proveedor proveedor) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setString(1, proveedor.getNIT());
            stat.setString(2, proveedor.getNombre());
            stat.setString(3, proveedor.getNombreContacto());
            stat.setString(4, proveedor.getProductoSuministra());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Proveedor proveedor) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setString(1, proveedor.getNombre());
            stat.setString(2, proveedor.getNombreContacto());
            stat.setString(3, proveedor.getProductoSuministra());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Proveedor proveedor) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setString(1, proveedor.getNIT());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Proveedor> obtenerTodos() {
        List<Proveedor> proveedores = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                proveedores.add(convertir(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return proveedores;
    }

    //Esta monda da error
    @Override
    public Proveedor getById(int id) {
//        Proveedor proveedor = null;
//        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
//            stat.setString(1, nit);
//            try (ResultSet rs = stat.executeQuery()) {
//                if (rs.next()) {
//                    proveedor = convertir(rs);
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return proveedor;
        return new Proveedor("", "", "");
    }

    private Proveedor convertir(ResultSet rs) throws SQLException {
        String NIT = rs.getString("NIT");
        String nombre = rs.getString("Nombre");
        String nombreContacto = rs.getString("NombreContacto");
        String productoSuministra = rs.getString("ProductoSuministra");

        return new Proveedor(NIT, nombre, nombreContacto, productoSuministra);
    }

    @Override
    public Proveedor getByNit(String nit) {
         Proveedor proveedor = null;
        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
            stat.setString(1, nit);
            try (ResultSet rs = stat.executeQuery()) {
                if (rs.next()) {
                    proveedor = convertir(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return proveedor;
    }

    
}

