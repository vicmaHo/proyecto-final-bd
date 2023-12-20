package model.dao.implementaciones;


/**
 *
 * @author cocodrelo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Uniforme;
import model.dao.ClienteDAO;
import model.dao.UniformeDAO;

public class UniformeDAOImpl implements UniformeDAO {

    private final String INSERT = "INSERT INTO uniforme (idprenda, tipo, idcolegio, caracteristicasPropias) VALUES (?, ?, ?, ?);";
    private final String UPDATE = "UPDATE uniforme SET idprenda=?, tipo=?, idcolegio=?, caracteristicasPropias=? WHERE idprenda=? AND idcolegio=?;";
    private final String DELETE = "DELETE FROM uniforme WHERE idprenda=? AND idcolegio=?;";
    private final String GETALL = "SELECT * FROM uniforme;";
    private final String GETONE = "SELECT * FROM uniforme WHERE idprenda=?;";

    private Connection conn = null;

    public UniformeDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insertar(Uniforme uniforme) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setInt(1, uniforme.getIdprenda());
            stat.setString(2, uniforme.getTipo());
            stat.setInt(3, uniforme.getIdcolegio());
            stat.setString(4, uniforme.getCaracteristicasPropias());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Uniforme uniforme) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setInt(1, uniforme.getIdprenda());
            stat.setString(2, uniforme.getTipo());
            stat.setInt(3, uniforme.getIdcolegio());
            stat.setString(4, uniforme.getCaracteristicasPropias());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Uniforme uniforme) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setInt(1, uniforme.getIdprenda());
            stat.setInt(2, uniforme.getIdcolegio());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Uniforme> obtenerTodos() {
        List<Uniforme> uniformes = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                uniformes.add(convertir(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return uniformes;
    }
    private Uniforme convertir(ResultSet rs) throws SQLException {
        return new Uniforme(
                rs.getInt("idprenda"),
                rs.getString("tipo"),
                rs.getInt("idcolegio"),
                rs.getString("caracteristicasPropias")
        );
    }

    @Override
    public Uniforme getById(int id) {
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
    
    
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/bd_proyecto";
        String USER = "postgres";
        String PASS = "admin";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            UniformeDAO dao = new UniformeDAOImpl(conn);


            Uniforme uniforme = dao.getById(1);
            System.out.println(uniforme.toString());
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }
}
