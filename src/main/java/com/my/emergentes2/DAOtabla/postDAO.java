/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.emergentes2.DAOtabla;

import com.emergentes.prac_4.conexionDB;
import com.my.emergentes2.objetos.post2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALVARO
 */
public class postDAO extends conexionDB implements post1{
   @Override
    public void insert(post2 p) throws Exception {
        try (Connection con = conexionDB.getConnection()) {
            String sql = "INSERT INTO posts (fecha, titulo, contenido) VALUES (?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, p.getFecha());
            stmt.setString(2, p.getTitulo());
            stmt.setString(3, p.getContenido());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(post2 p) throws Exception {
        try (Connection con = conexionDB.getConnection()) {
            String sql = "UPDATE posts SET fecha = ?, titulo = ?, contenido = ? WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setDate(1, p.getFecha());
            stmt.setString(2, p.getTitulo());
            stmt.setString(3, p.getContenido());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (Connection con = conexionDB.getConnection()) {
            String sql = "DELETE FROM posts WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public post2 getById(int id) throws Exception {
        post2 p = null;
        try (Connection con = conexionDB.getConnection()) {
            String sql = "SELECT * FROM posts WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p = new post2();
                p.setId(rs.getInt("id"));
                p.setFecha(rs.getDate("fecha"));
                p.setTitulo(rs.getString("titulo"));
                p.setContenido(rs.getString("contenido"));
            }
        }catch (Exception e) {
            throw e;
        } finally {
            Connection conn = null;
            this.desconectar(conn);

        }
        return p;
    }

    @Override
    public List<post2> getAll() throws Exception {
        List<post2> posts = new ArrayList<>();
        try (Connection con = conexionDB.getConnection()) {
            String sql = "SELECT * FROM posts";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                post2 p = new post2();
                p.setId(rs.getInt("id"));
                p.setFecha(rs.getDate("fecha"));
                p.setTitulo(rs.getString("titulo"));
                p.setContenido(rs.getString("contenido"));
                posts.add(p);
            }
        }
        return posts;
    }    
}
