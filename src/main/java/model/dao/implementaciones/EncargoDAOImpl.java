package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Encargo;
import model.dao.EncargoDAO;

public class EncargoDAOImpl implements EncargoDAO {

    private final String INSERT = "INSERT INTO Encargo (NumPedido, FechaEncargo, FechaEntrega, Anotacion, Estado, Abono, ValorTotal, Documento) VALUES (?,?,?,?,?,?,?,?);";
    private final String UPDATE = "UPDATE Encargo SET FechaEncargo = ?, FechaEntrega = ?, Anotacion = ?, Estado = ?, Abono = ?, ValorTotal = ?, Documento = ? WHERE NumPedido = ?;";
    private final String DELETE = "DELETE FROM Encargo WHERE NumPedido = ?;";
    private final String GETALL = "SELECT * FROM Encargo;";
    private final String GETONE = "SELECT * FROM Encargo WHERE NumPedido = ?;";

    private Connection conn = null;

    public EncargoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Encargo encargo) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setInt(1, encargo.getNumPedido());
            stat.setDate(2, encargo.getFechaEncargo());
            stat.setDate(3, encargo.getFechaEntrega());
            stat.setString(4, encargo.getAnotacion());
            stat.setString(5, encargo.getEstado());
            stat.setDouble(6, encargo.getAbono());
            stat.setDouble(7, encargo.getValorTotal());
            stat.setInt(8, encargo.getDocumento());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Encargo encargo) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setDate(1, encargo.getFechaEncargo());
            stat.setDate(2, encargo.getFechaEntrega());
            stat.setString(3, encargo.getAnotacion());
            stat.setString(4, encargo.getEstado());
            stat.setDouble(5, encargo.getAbono());
            stat.setDouble(6, encargo.getValorTotal());
            stat.setInt(7, encargo.getDocumento());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Encargo encargo) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setInt(1, encargo.getNumPedido());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Encargo> obtenerTodos() {
        List<Encargo> encargos = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                encargos.add(convertir(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return encargos;
    }

    @Override
    public Encargo getById(int numPedido) {
        Encargo encargo = null;
        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
            stat.setInt(1, numPedido);
            try (ResultSet rs = stat.executeQuery()) {
                if (rs.next()) {
                    encargo = convertir(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return encargo;
    }

    private Encargo convertir(ResultSet rs) throws SQLException {
        int numPedido = rs.getInt("NumPedido");
        java.sql.Date fechaEncargo = rs.getDate("FechaEncargo");
        java.sql.Date fechaEntrega = rs.getDate("FechaEntrega");
        String anotacion = rs.getString("Anotacion");
        String estado = rs.getString("Estado");
        Double abono = rs.getDouble("Abono");
        Double valorTotal = rs.getDouble("ValorTotal");
        int documento = rs.getInt("Documento");

        return new Encargo(numPedido, fechaEncargo, fechaEntrega, anotacion, estado, abono, valorTotal, documento);
    }
}
