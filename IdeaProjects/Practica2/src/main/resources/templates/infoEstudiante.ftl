<!DOCTYPE html>
<html>
<head>
    <title>${titulo}</title>
</head>
<body>
    <h1>${titulo}!</h1>
    <h3>Informacion del Estudiante</h3>
    <p><b>Nombre:</b> ${student.nombre}</p>
    <p><b>Apellido:</b> ${student.apellido}</p>
    <p><b>Matricula:</b> ${student.matricula?string("0")}</p>
    <p><b>Telefono:</b> ${student.telefono}</p>
    <a href="/">
        <button type="submit">Volver al inicio</button>
    </a>
</body>
</html>