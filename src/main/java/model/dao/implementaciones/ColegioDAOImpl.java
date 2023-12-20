package model.dao.implementaciones;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Colegio;
import model.dao.ColegioDAO;

public class ColegioDAOImpl implements ColegioDAO{
    private final String INSERT = "INSERT into Colegio (IdColegio , Direccion , Nombre ) VALUES (?,?,?);";
    private final String UPDATE = "UPDATE Colegio SET Direccion = ?, Nombre = ? WHERE IdColegio = ?;";
    private final String DELETE = "DELETE FROM Colegio WHERE IdColegio = ?;";


    private final String GETALL = "SELECT * FROM Colegio ;";
    private final String GETONE = "SELECT * FROM Colegio WHERE IdColegio = ?;";
    private Connection conn = null;

    public ColegioDAOImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insertar(Colegio t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            //REVISAR ESTA VAINA NO ME CONVENCE
            stat.setString(2, t.getDireccion());
            stat.setString(3, t.getNombre());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(Colegio t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, t.getDireccion());
            stat.setString(2, t.getNombre());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Colegio t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, t.getIdColegio());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Colegio> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Colegio> colegios = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                colegios.add(convertir(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return colegios;
    }

    private Colegio convertir(ResultSet rs) {
        try {
            int IdColegio = rs.getInt(1);
            String Direccion = rs.getString(2);
            String Nombre = rs.getString(3);



            Colegio colegio = new Colegio(IdColegio, Direccion, Nombre);
            return colegio;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public Colegio getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Colegio colegio = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                colegio = convertir(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return colegio;
    }


}
