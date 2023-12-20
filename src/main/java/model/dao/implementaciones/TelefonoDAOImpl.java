package model.dao.implementaciones;


/**
 *
 * @author cocodrelo
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Telefono;
import model.dao.TelefonoDAO;

public class TelefonoDAOImpl implements TelefonoDAO {

    private final String INSERT = "INSERT INTO telefono (Documento, telefono) VALUES (?, ?);";
    private final String UPDATE = "UPDATE telefono SET telefono=? WHERE Documento = ? ";
    private final String DELETE = "DELETE FROM telefono WHERE Documento=?;";
    private final String GETALL = "SELECT * FROM telefono;";
    private final String GETONE = "SELECT * FROM telefono WHERE Documento=?;";

    private Connection conn = null;

    public TelefonoDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Telefono telefono) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setString(1, telefono.getDocumento());
            stat.setString(2, telefono.getTelefono());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Telefono telefono) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setString(2, telefono.getDocumento());
            stat.setString(1, telefono.getTelefono());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Telefono telefono) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setString(1, telefono.getDocumento());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Telefono> obtenerTodos() {
        List<Telefono> telefonos = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                telefonos.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return telefonos;
    }

    @Override
    public Telefono getById(int Documento) {
        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
            stat.setInt(1, Documento);
            try (ResultSet rs = stat.executeQuery()) {
                if (rs.next()) {
                    return convertir(rs);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    private Telefono convertir(ResultSet rs) throws SQLException {
        return new Telefono(
                rs.getString("Documento"),
                rs.getString("telefono")
        );
    }
}
