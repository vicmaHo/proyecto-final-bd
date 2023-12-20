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
import model.Prenda;
import model.dao.PrendaDAO;

public class PrendaDAOImpl implements PrendaDAO {

    private final String INSERT = "INSERT INTO prenda (color, cantidad, talla, descripcion, tipoTela, precioVenta, sexo, numPedido) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    private final String UPDATE = "UPDATE prenda SET color=?, cantidad=?, talla=?, descripcion=?, tipoTela=?, precioVenta=?, sexo=?, numPedido=? WHERE idPrenda=?;";
    private final String DELETE = "DELETE FROM prenda WHERE idPrenda=?;";
    private final String GETALL = "SELECT * FROM prenda;";
    private final String GETONE = "SELECT * FROM prenda WHERE idPrenda=?;";

    private Connection conn = null;

    public PrendaDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Prenda prenda) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setString(1, prenda.getColor());
            stat.setInt(2, prenda.getCantidad());
            stat.setString(3, prenda.getTalla());
            stat.setString(4, prenda.getDescripcion());
            stat.setString(5, prenda.getTipoTela());
            stat.setString(6, prenda.getPrecioVenta());
            stat.setString(7, prenda.getSexo());
            stat.setInt(8, prenda.getNumPedido());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Prenda prenda) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setString(1, prenda.getColor());
            stat.setInt(2, prenda.getCantidad());
            stat.setString(3, prenda.getTalla());
            stat.setString(4, prenda.getDescripcion());
            stat.setString(5, prenda.getTipoTela());
            stat.setString(6, prenda.getPrecioVenta());
            stat.setString(7, prenda.getSexo());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Prenda prenda) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setInt(1, prenda.getIdPrenda());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Prenda> obtenerTodos() {
        List<Prenda> prendas = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                prendas.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prendas;
    }

    @Override
    public Prenda getById(int id) {
        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
            stat.setInt(1, id);
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

    private Prenda convertir(ResultSet rs) throws SQLException {
        return new Prenda(
                rs.getInt("idPrenda"),
                rs.getString("color"),
                rs.getInt("cantidad"),
                rs.getString("talla"),
                rs.getString("descripcion"),
                rs.getString("tipoTela"),
                rs.getString("precioVenta"),
                rs.getString("sexo"),
                rs.getInt("numPedido")
        );
    }
}

