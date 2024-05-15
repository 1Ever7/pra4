/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.my.emergentes2.DAOtabla.post1;
import com.my.emergentes2.DAOtabla.postDAO;
import com.my.emergentes2.objetos.post2;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALVARO
 */
@WebServlet(name = "post", urlPatterns = {"/post"})
public class post extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        
            postDAO dao = new postDAO();
            ArrayList<post2> posts = (ArrayList<post2>) dao.getAll();

        // Colocar la lista de posts en el alcance de la solicitud para ser utilizada en la JSP
        request.setAttribute("posts", posts);

        // Redireccionar a la página de posts para mostrar la tabla
        request.getRequestDispatcher("post.jsp").forward(request, response);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al conectar con la base de datos");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
        String action = request.getParameter("action");
        postDAO dao = new postDAO();
        if (action != null) {
            switch (action) {
                      
                    
                       case "insertar":
                
                        insertarPost(request, dao);
                    
                
                    break;

                case "ver":
                    // Lógica para ver
                   verPost(request, response, dao);
                    break;
                case "actualizar":
                    actualizarPost(request, dao);
                    break;
                case "eliminar":
                   eliminarPost(request, dao);
                    break;
                
                default:
                    break;
            }
    }
response.sendRedirect("post");
          } catch (Exception ex) {
            Logger.getLogger(post.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
    // Método para insertar un post
private void insertarPost(HttpServletRequest request, postDAO dao) 
        throws ClassNotFoundException, SQLException, IOException{
    try {
        // Obtener los parámetros del formulario
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        // Crear un nuevo objeto post2 con los datos recibidos
        post2 nuevoPost = new post2();
        nuevoPost.setFecha(fecha);
        nuevoPost.setTitulo(titulo);
        nuevoPost.setContenido(contenido);
        
        // Insertar el nuevo post en la base de datos
        dao.insert(nuevoPost);
        
        // Redireccionar a una página de éxito o mostrar un mensaje de éxito
       // response.sendRedirect("nuevo.jsp");
        
    } catch (Exception e) {
        // Manejar cualquier excepción que pueda ocurrir durante la inserción
        e.printStackTrace();
        // Redireccionar a una página de error o mostrar un mensaje de error
       // response.sendRedirect("error.jsp");
    }
}

// Método para actualizar un post
private void actualizarPost(HttpServletRequest request, postDAO dao) 
        throws IOException, ServletException {
    try {
        // Obtener los parámetros del formulario
        int id = Integer.parseInt(request.getParameter("id"));
        Date fecha = Date.valueOf(request.getParameter("fecha"));
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        // Crear un nuevo objeto post2 con los datos recibidos
        post2 postActualizado = new post2();
        postActualizado.setId(id);
        postActualizado.setTitulo(titulo);
        postActualizado.setFecha(fecha);
        postActualizado.setContenido(contenido);
        
        // Actualizar el post en la base de datos
        dao.update(postActualizado);
        
        // Redireccionar a una página de éxito o mostrar un mensaje de éxito
       //response.sendRedirect("exito.jsp");
    } catch (Exception e) {
        // Manejar cualquier excepción que pueda ocurrir durante la actualización
        e.printStackTrace();
        // Redireccionar a una página de error o mostrar un mensaje de error
        //response.sendRedirect("error.jsp");
        throw new ServletException("Error al actualizar ");
    }
}

// Método para eliminar un post
private void eliminarPost(HttpServletRequest request, postDAO dao) throws IOException {
    try {
        // Obtener el ID del post a eliminar
        int id = Integer.parseInt(request.getParameter("id"));
        
        // Eliminar el post de la base de datos
        dao.delete(id);
        
        // Redireccionar a una página de éxito o mostrar un mensaje de éxito
        //response.sendRedirect("exito.jsp");
    } catch (Exception e) {
        // Manejar cualquier excepción que pueda ocurrir durante la eliminación
        e.printStackTrace();
        // Redireccionar a una página de error o mostrar un mensaje de error
        //response.sendRedirect("error.jsp");
    }
}

    private void verPost(HttpServletRequest request, HttpServletResponse response, postDAO dao) 
            throws ServletException {
        try {
        int id = Integer.parseInt(request.getParameter("id"));
        post2 post = dao.getById(id);
        request.setAttribute("post", post);
        request.getRequestDispatcher("editar.jsp").forward(request, response);
    } catch (Exception e) {
        e.printStackTrace();
        throw new ServletException("Error ");
    }
    }

}
