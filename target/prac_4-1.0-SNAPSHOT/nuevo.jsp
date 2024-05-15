<%@page import="com.my.emergentes2.objetos.post2"%>
<%@page import="com.my.emergentes2.DAOtabla.postDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agregar Post</title>
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
    <h1>Agregar Post</h1>
    
    <!-- Formulario para agregar un post -->
    <form action="post" method="post">
        <input type="hidden" name="action" value="insertar">
        
        <label for="titulo">Título:</label>
        <input type="text" name="titulo">
        <label for="fecha">Fecha:</label>
        <input type="date" name="fecha">
        <label for="contenido">Contenido:</label>
        <textarea type="text" name="contenido" rows="4"></textarea>
        
        <button type="submit" class="boton-agregar">Guardar</button>
        <a href="post.jsp" class="boton-cancelar">Cancelar</a>
    </form>
</body>
</html>
