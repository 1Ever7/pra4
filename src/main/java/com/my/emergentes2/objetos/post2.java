/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.emergentes2.objetos;

import java.sql.Date;

/**
 *
 * @author ALVARO
 */
public class post2 {
    
    
     private int id;
    private Date fecha;
    private String titulo;
    private String contenido;

    public post2() {
    }

    public post2(int id, Date fecha, String titulo, String contenido) {
        this.id = id;
        this.fecha = fecha;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    
    
    
}
