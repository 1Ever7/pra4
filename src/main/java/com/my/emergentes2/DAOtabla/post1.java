/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.my.emergentes2.DAOtabla;

import com.my.emergentes2.objetos.post2;
import java.util.List;

/**
 *
 * @author ALVARO
 */
public interface post1 {
 
     public void insert(post2 doctor) throws Exception;

    public void update(post2 doctor) throws Exception;

    public void delete(int id) throws Exception;

    public post2  getById(int id) throws Exception;

    public List<post2> getAll() throws Exception;
}
