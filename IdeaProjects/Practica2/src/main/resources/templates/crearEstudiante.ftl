<!DOCTYPE html>
<html>
    <head>
        <title>${titulo}</title>
    </head>
    <body>
        <h1>Registrar Estudiante</h1>
        <form action="/confirmarEstudiante" method="post">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><input type="text" name="nombre" required="required"></td>
                </tr>
                <tr>
                    <td>Apellido:</td>
                    <td><input type="text" name="apellido" required="required"></td>
                </tr>
                <tr>
                    <td>Matricula:</td>
                    <td><input type="number" name="matricula" required="required"></td>
                </tr>
                <tr>
                    <td>Telefono:</td>
                    <td><input type="number" name="telefono" required="required"></td>
                </tr>
                <tr>
                    <td><button type="submit">Registrar</button></td>
                    <td><a href="/">
                        <button type="button">Cancelar</button>
                    </a></td>
                </tr>
            </table>
        </form>
    </body>
</html>