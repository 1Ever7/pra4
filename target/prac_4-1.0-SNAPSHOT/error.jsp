<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Error</title>
    <script>
    // Redirigir a la p�gina "index.jsp" despu�s de 2 segundos
    setTimeout(function() {
        window.location.href = "index.jsp";
    }, 2000); // 2000 milisegundos = 2 segundos
</script>

</head>
<body>
    <h1>Error</h1>
    <p>Ha ocurrido un error al procesar su solicitud.</p>
    <!-- Puedes agregar m�s detalles del error si lo deseas -->
</body>
</html>
