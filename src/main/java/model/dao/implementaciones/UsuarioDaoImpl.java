/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao.implementaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Colegio;
import model.Uniforme;
import model.Usuario;
import model.dao.UniformeDAO;
import model.dao.UsuarioDAO;

/**
 *
 * @author Victor
 */
public class UsuarioDaoImpl implements UsuarioDAO {
    
    
    private final String INSERT = "INSERT INTO usuarios (nombre, contrasena, tipo) VALUES (?,?,?);";
    private final String UPDATE = "UPDATE usuarios SET nombre = ?, contrasena = ?, tipo = ? WHERE id = ?;";
    private final String DELETE = "DELETE FROM usuarios WHERE id = ?;";
    private final String GETALL = "SELECT * FROM usuarios;";
    private final String GETONE = "SELECT * FROM usuarios WHERE id = ?;"; 

    private Connection conn = null;

    public UsuarioDaoImpl(Connection conn) {
        this.conn = conn;
    }

    
    @Override
    public void insertar(Usuario t) {
        try (PreparedStatement stat = conn.prepareStatement(INSERT)) {
            stat.setString(1, t.getNombre());
            stat.setString(2, t.getContrasena());
            stat.setString(3, t.getTipo());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }        
    }

    @Override
    public void modificar(Usuario t) {
        try (PreparedStatement stat = conn.prepareStatement(UPDATE)) {
            stat.setString(2, t.getNombre());
            stat.setString(3, t.getContrasena());
            stat.setString(4, t.getTipo() );
            stat.setInt(1, t.getId());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void eliminar(Usuario t) {
        try (PreparedStatement stat = conn.prepareStatement(DELETE)) {
            stat.setInt(1, t.getId());
            stat.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Usuario> obtenerTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        try (PreparedStatement stat = conn.prepareStatement(GETALL);
             ResultSet rs = stat.executeQuery()) {
            while (rs.next()) {
                usuarios.add(convertir(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return usuarios;
    }
    
    
    private Usuario convertir(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String contrasena = rs.getString("contrasena");
        String tipo = rs.getString("tipo");

        return new Usuario(id, nombre, contrasena, tipo);
    }

    @Override
    public Usuario getById(int id) {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Usuario usuario = null;
        try {
            stat = conn.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                usuario = convertir(rs);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return usuario;
    }
    
    
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/bd_proyecto";
        String USER = "postgres";
        String PASS = "admin";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            UsuarioDAO dao = new UsuarioDaoImpl(conn);

            Usuario l = new Usuario("admin", "admin", "administrador");
            dao.insertar(l);

            List<Usuario> usuarios = dao.obtenerTodos();
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.toString());
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }        
    }
}
