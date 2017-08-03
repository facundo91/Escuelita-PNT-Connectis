<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Provincia</title>

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/estilos.css">
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="encabezado">Provincia</h1>
                </div>
            </div>
            <hr>
            <div class="row">
                <div class="col-md-6">
                    <h4 class="encabezado-chico">Todos</h4>
                    <table class="table table-bordered table-resultado-todos">
                        <thead>
                            <tr>
                                <th class="titulosTodos">ID</th>
                                <th class="titulosTodos">Pais</th>
                                <th class="titulosTodos">Nombre</th>
                                <th class="titulosTodos">Borrar</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="provincia" items="${provincias}">
                                <tr>
                                    <td>${provincia.id}</td>
                                    <td><a href="/dosideas-jee001-workshop/paises">${provincia.pais.nombre}</a> </td>
                                    <td>${provincia.nombre}</td>
                                    <td><button class="borrarProvincia">CHAU</button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-6">
                    <div id="mensajeNoEncontrado" class="alert alert-warning hide">
                        <strong>No encontrado!</strong> No existe un provincia con el ID buscado.
                    </div>
                    <div class="input-group">
                        <input id="idProvinciaABuscar" type="text" class="form-control" placeholder="#ID provincia a buscar">
                        <div class="input-group-btn">
                            <button id="botonBuscarProvinciaPorId" class="btn btn-info" type="button">Buscar</button>
                        </div>
                    </div>
                    <h4>Solo Provincia con Id #<span id="idProvinciaEncontrado"></span> !!!</h4>
                    <table class="table table-bordered table-resultado-busqueda">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Pais</th>
                                <th>Nombre</th>
                            </tr>
                        </thead>
                        <tbody id="bodyTablaProvincia"></tbody>
                    </table>
                    <div>
                        <div id="mensajeError" class="alert alert-warning hide">
                            <strong>Error!</strong> Ha habido un error!
                        </div>
                        <div id="mensajeExito" class="success hide">
                            <strong>Exito!</strong> Ha habido un exito!
                        </div>
                    <div class="input-group row">
                        <div class="col-md-6">
                            <input id="idProvinciaNueva" type="number" class="form-control" placeholder="#ID provincia a crear">
                            <input id="nombreProvinciaNueva" type="text" class="form-control" placeholder="#Nombre provincia a crear">
                            <input id="paisProvinciaNueva" type="number" class="form-control" placeholder="#Pais asociado">
                        </div>
                        <div class="col-md-6">
                            <div class="input-group-btn">
                                <button id="botonCrearProvinciaNueva" class="btn btn-info" type="button">Crear</button>
                            </div>
                        </div>
                    </div>                        
                        
                    </div>
                </div>
            </div>
        </div>

        <!-- Lib JS -->
        <script src="js/lib/jquery-1.11.1.js"></script>
        <script src="js/lib/bootstrap.min.js"></script>

        <!-- JS de la aplicacion -->
        <script src="js/app/escuelita.js"></script>
        <script src="js/app/ui/ui.js"></script>
        <script src="js/app/service/service.js"></script>
        <script src="js/app/ui/provincia/provincia.js"></script>
        <script src="js/app/service/provincia/provincia.js"></script>
        <script src="js/app/service/pais/pais.js"></script>
    </body>
</html>