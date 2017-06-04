<!doctype html>
<html>
    <head>
        <title>${titulo}</title>
    </head>
    <body>
        <h1>Modificar Estudiante: ${estudiante.nombre} ${estudiante.apellido}</h1>
        <form action="/estudianteModificado/${estudiante.matricula?string("0")}" method="post">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre"></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><input type="text" name="apellido"></td>
                </tr>
                <tr>
                    <td>Matricula:</td>
                    <td><input type="number" name="matricula"></td>
                </tr>
                <tr>
                    <td>Telefono:</td>
                    <td><input type="number" name="telefono"></td>
                </tr>
                <tr>
                    <td><button type="submit">Modificar</button></td>
                    <td><a href="/">
                        <button type="button">Volver al inicio</button>
                    </a></td>
                </tr>
            </table>
        </form>
    </body>
</html>