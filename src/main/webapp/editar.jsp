<%@page import="com.my.emergentes2.objetos.post2"%>
<%@page import="com.my.emergentes2.DAOtabla.postDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Editar Post</title>
    <style>
        /* Estilos CSS */
        form {
            max-width: 500px; /* Ancho máximo del formulario */
            margin: 0 auto; /* Centrar formulario */
            padding: 20px; /* Espaciado interno */
            border: 1px solid #ccc; /* Borde del formulario */
            border-radius: 5px; /* Bordes redondeados */
        }
        input[type="text"], textarea, input[type="date"] {
            width: 100%; /* Ancho completo */
            margin-bottom: 10px; /* Espacio entre campos */
            padding: 10px; /* Espaciado interno */
            border: 1px solid #ccc; /* Borde del campo */
            border-radius: 3px; /* Bordes redondeados */
            box-sizing: border-box; /* Incluir padding y borde en el ancho */
        }
        input[type="submit"], .boton-cancelar {
            width: 100%; /* Ancho completo */
            padding: 10px; /* Espaciado interno */
            background-color: #4CAF50; /* Color de fondo */
            color: white; /* Color del texto */
            border: none; /* Quitar borde */
            border-radius: 3px; /* Bordes redondeados */
            cursor: pointer; /* Cambiar cursor al pasar sobre el botón */
        }
        .boton-cancelar {
            background-color: #ccc; /* Color de fondo para el botón de cancelar */
            margin-top: 10px; /* Espacio superior */
        }
    </style>
</head>
<body>
    <h1>Editar Post</h1>
    
    <!-- Formulario para editar un post -->
    <form action="post" method="post">
        <%-- Obtener el ID del post de la URL --%>
        <% 
        String postId = request.getParameter("id");
        if (postId != null) {
            // Aquí puedes realizar alguna lógica adicional si es necesario con el ID del post
            // Por ejemplo, puedes usar este ID para obtener los datos del post de la base de datos y mostrarlos en el formulario para su edición
            if (postId != null) {
                // Aquí deberías realizar la consulta a la base de datos para obtener los detalles del post con el ID proporcionado
                // Por ejemplo, si tienes un DAO (Objeto de Acceso a Datos) para manejar los posts, podrías hacer algo como esto:
                postDAO dao = new postDAO();
                post2 post = dao.getById(Integer.parseInt(postId));
                
                // Luego, puedes mostrar los detalles del post en el formulario para su edición
                if (post != null) {
        %>
        <input type="hidden" name="action" value="actualizar">
        <input type="hidden" name="id" value="<%= post.getId() %>">
        <label for="titulo">Título:</label>
        <input type="text" name="titulo" value="<%= post.getTitulo() %>">
        <label for="fecha">Fecha:</label>
        <input type="date" name="fecha" value="<%= post.getFecha() %>">
        <label for="contenido">Contenido:</label>
        <textarea name="contenido" rows="4"><%= post.getContenido() %></textarea>
        <%
                }
            }
        %>
        <% } else { %>
        <input type="hidden" name="action" value="insertar">
        <% } %>
        
        <button type="submit" class="boton-agregar">Guardar</button>
        <a href="post.jsp" class="boton-cancelar">Cancelar</a>
    </form>
</body>
</html>
