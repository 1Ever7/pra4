package com.my.emergentes2.DAOtabla;

import com.emergentes.prac_4.conexionDB;
import com.my.emergentes2.objetos.usuario;
import com.my.emergentes2.objetos.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class tablaDAOimpl extends conexionDB implements DAOtabal {

    @Override
    public void insert(usuario usuario) throws Exception {
        try (Connection con = conexionDB.getConnection()) {
            String sql = "INSERT INTO usuarios (usuario, password) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(usuario usuario) throws Exception {
        try (Connection con = conexionDB.getConnection()) {
            String sql = "UPDATE usuarios SET usuario = ?, password = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getUsuario());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (Connection con = conexionDB.getConnection()) {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public usuario getById(int id) throws Exception {
        usuario usuario = null;
        try (Connection con = conexionDB.getConnection()) {
            String sql = "SELECT * FROM usuarios WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                usuario = new usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
            }
        }
        return usuario;
    }

    @Override
    public List<usuario> getAll() throws Exception {
        List<usuario> usuari = new ArrayList<>();
        try (Connection con = conexionDB.getConnection()) {
            String sql = "SELECT * FROM usuarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                usuario usuario = new usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("password"));
                usuari.add(usuario);
            }
        }
        return usuari;
    }

}
