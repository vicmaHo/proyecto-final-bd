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
import model.Usan;
import model.dao.UsanDAO;

public class UsanDAOImpl implements UsanDAO {

    private final String INSERT = "INSERT INTO usan (idprenda, codPri) VALUES (?, ?);";
    private final String UPDATE = "UPDATE usan SET idprenda=?, codPri=? WHERE idprenda=? AND codPri=?;";
    private final String DELETE = "DELETE FROM usan WHERE idprenda=? AND codPri=?;";
    private final String GETALL = "SELECT * FROM usan;";
    private final String GETONE = "SELECT * FROM usan WHERE idprenda=? AND codPri=?;";

    private Connection conn = null;

    public UsanDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Usan usan) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setInt(1, usan.getIdprenda());
            stat.setInt(2, usan.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Usan usanNuevo, Usan usanViejo) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setInt(1, usanNuevo.getIdprenda());
            stat.setInt(2, usanNuevo.getCodPri());
            stat.setInt(3, usanViejo.getIdprenda());
            stat.setInt(4, usanViejo.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Usan usan) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setInt(1, usan.getIdprenda());
            stat.setInt(2, usan.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Usan> obtenerTodos() {
        List<Usan> usanList = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                usanList.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return usanList;
    }

    private Usan convertir(ResultSet rs) throws SQLException {
        return new Usan(
                rs.getInt("idprenda"),
                rs.getInt("codPri")
        );
    }

    @Override
    public Usan getById(int id) {
        return null;
    }

    @Override
    public Usan getByIdCompuesto(int idPrenda, int codPri) {
        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
            stat.setInt(1, idPrenda);
            stat.setInt(2, codPri);
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

    @Override
    public void modificar(Usan t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }
}
