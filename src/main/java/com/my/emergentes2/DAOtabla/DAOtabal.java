
package com.my.emergentes2.DAOtabla;


import com.my.emergentes2.objetos.usuario;
import java.util.List;

public interface DAOtabal {
     public void insert(usuario doctor) throws Exception;

    public void update(usuario doctor) throws Exception;

    public void delete(int id) throws Exception;

    public usuario  getById(int id) throws Exception;

    public List<usuario> getAll() throws Exception;
}
