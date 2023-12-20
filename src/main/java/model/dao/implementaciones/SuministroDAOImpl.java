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
import model.Suministro;
import model.dao.SuministroDAO;

public class SuministroDAOImpl implements SuministroDAO {

    private final String INSERT = "INSERT INTO suministro (NIT, codPri) VALUES (?, ?);";
    private final String UPDATE = "UPDATE suministro SET NIT=?, codPri=? WHERE NIT=? AND codPri=?;";
    private final String DELETE = "DELETE FROM suministro WHERE NIT=? AND codPri=?;";
    private final String GETALL = "SELECT * FROM suministro;";
    private final String GETONE = "SELECT * FROM suministro WHERE NIT=? AND codPri=?;";

    private Connection conn = null;

    public SuministroDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Suministro suministro) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setString(1, suministro.getNIT());
            stat.setInt(2, suministro.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Suministro suministro) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setString(1, suministro.getNIT());
            stat.setInt(2, suministro.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Suministro suministro) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setString(1, suministro.getNIT());
            stat.setInt(2, suministro.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Suministro> obtenerTodos() {
        List<Suministro> suministros = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                suministros.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return suministros;
    }

    
    private Suministro convertir(ResultSet rs) throws SQLException {
        return new Suministro(
                rs.getString("NIT"),
                rs.getInt("codPri")
        );
    }

    @Override
    public Suministro getById(int id) {
       return null;
    }

    @Override
    public Suministro getByIdCompuesto(String NIT, int codPri) {
        try (PreparedStatement stat = conn.prepareStatement(GETONE)) {
            stat.setString(1, NIT);
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
}
