<%@page import="java.util.ArrayList"%>
<%@page import="com.my.emergentes2.objetos.post2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Listado de Posts</title>
        <style>
            /* Estilos CSS */
            .titulo {
                font-size: 24px;
                font-weight: bold;
                color: #333; /* color del texto */
                margin-bottom: 5px; /* espacio entre el título y el contenido */
            }
            .fecha {
                font-size: 14px;
                color: #666; /* color del texto */
                margin-bottom: 10px; /* espacio entre la fecha y el contenido */
            }
            .contenido {
                font-size: 16px;
                color: #444; /* color del texto */
            }
            .linea-central {
                width: 50%; /* Establece el ancho deseado */
                margin: 0 auto; /* Centra horizontalmente */
                border-top: 2px solid #333; /* Establece el grosor y color de la línea */
            }
            h1 {
                text-align: center; /* Alinea el texto al centro */
            }
            h5 {
                text-align: center; /* Alinea el texto al centro */
            }
            .boton-editar, .boton-eliminar {
                display: inline-block; /* Mostrar botones en línea */
                margin-right: 10px; /* Espacio entre botones */
                padding: 5px 10px; /* Espaciado interno */
                font-size: 16px; /* Tamaño de fuente */
                background-color: #4CAF50; /* Color de fondo */
                color: white; /* Color del texto */
                border: none; /* Quitar borde */
                border-radius: 5px; /* Bordes redondeados */
                cursor: pointer; /* Cambiar cursor al pasar sobre el botón */
                text-decoration: none; /* Quitar subrayado del texto */
            }
        </style>
    </head>
    <body>
        <h1> Blog de Tecnologia</h1>
        <h5> Autor: Ever Quispe Apaza</h5>

        <!-- Botón para agregar un nuevo post -->
        <a href="nuevo.jsp" class="boton-agregar">Nuevo Post</a>

        <%
            ArrayList<post2> posts = (ArrayList<post2>) request.getAttribute("posts");
            if (posts != null) {
                for (post2 post : posts) {
        %>
        <div>
            <p class="titulo"> <%= post.getTitulo()%></p>
            <p class="fecha">Fecha: <%= post.getFecha()%></p>
            <p class="contenido"> <%= post.getContenido()%></p>
            <!-- Botones de Editar y Eliminar -->
            <!-- Botón de Editar -->
            <a href="editar.jsp?id=<%= post.getId()%>" class="boton-editar">Editar</a>

            <form action="post?action=eliminar" method="post" style="display: inline;">
                <input type="hidden" name="id" value="<%= post.getId()%>">
                <button type="submit" class="boton-eliminar">Eliminar</button>
            </form>
                
            <hr class="linea-central">
        </div>
        <%
            }
        } else {
        %>
        <p>No hay posts disponibles</p>
        <% }%>
    </body>
</html>
