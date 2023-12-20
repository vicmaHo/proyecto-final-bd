package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.MateriasPrimas;
import model.dao.MateriasPrimasDAO;

public class MateriasPrimasDAOImpl implements MateriasPrimasDAO {

    private final String INSERT = "INSERT into MateriasPrimas  (Tipo, CantPri, UnidadMedida, DescripcionPri ) VALUES (?,?,?,?);";
    private final String UPDATE = "UPDATE MateriasPrimas SET Tipo = ?, CantPri = ?, UnidadMedida = ?, DescripcionPri = ? WHERE CodPri = ?;";
    private final String DELETE = "DELETE FROM MateriasPrimas WHERE CodPri = ?;";


    private final String GETALL = "SELECT * FROM MateriasPrimas ;";
    private final String GETONE = "SELECT * FROM MateriasPrimas WHERE CodPri = ?;";
    private Connection conn = null;

    public MateriasPrimasDAOImpl(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void insertar(MateriasPrimas t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(INSERT);
            stat.setString(1, t.getTipo());
            stat.setString(2, t.getCantPri());
            stat.setString(3, t.getUnidadMedida());
            stat.setString(4, t.getDescripcionPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modificar(MateriasPrimas t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, t.getTipo());
            stat.setString(2, t.getCantPri());
            stat.setString(3, t.getUnidadMedida());
            stat.setString(4, t.getDescripcionPri());
            stat.setInt(5, t.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(MateriasPrimas t) {
        PreparedStatement stat = null;
        try {
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, t.getCodPri());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<MateriasPrimas> obtenerTodos() {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<MateriasPrimas> materiasPrimas = new ArrayList<>();
        try {
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            while (rs.next()) {
                materiasPrimas.add(convertir(rs));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return materiasPrimas;
    }

    private MateriasPrimas convertir(ResultSet rs) {
        try {
            int CodPri = rs.getInt(1);
            String Tipo = rs.getString(2);
            String CantPri = rs.getString(3);
            String UnidadMedida = rs.getString(4);
            String DescripcionPri = rs.getString(5);



            MateriasPrimas materiasPrimas = new MateriasPrimas(CodPri, Tipo, CantPri,UnidadMedida,DescripcionPri);
            return materiasPrimas;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public MateriasPrimas getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        MateriasPrimas materiasPrimas = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                materiasPrimas = convertir(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return materiasPrimas;
    }
}
