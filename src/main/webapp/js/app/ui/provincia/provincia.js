escuelita.ui.provincia = (function () {

    var $bodyTablaProvincia = $("#bodyTablaProvincia");
    var $spanIdProvinciaEncontrado = $("#idProvinciaEncontrado");
    var $divMensajeNoEncontrado = $("#mensajeNoEncontrado");
    var $idProvinciaNueva = $("#idProvinciaNueva");
    var $nombreProvinciaNueva = $("#nombreProvinciaNueva");
    var $paisProvinciaNueva = $("#paisProvinciaNueva");

    function inicializar() {
        buscar(1);
        bindearEventosABotones();
    }

    function buscar(idProvincia) {
        escuelita.service.provincia.buscarPorId(idProvincia)
                .done(mostrar)
                .fail(mostrarMensajeNoEncontrado);
    }

    function crearProvincia(provincia) {
        console.log(provincia);


        escuelita.service.provincia.crearProvincia(provincia)
                .done(provinciaCreada)
                .fail(mostrarMensajeNoEncontrado);
        console.log(provincia);
    }

    function provinciaCreada() {
        $idProvinciaNueva.text("");
        $nombreProvinciaNueva.text("");
        $paisProvinciaNueva.text(0);
        $divMensajeNoEncontrado.removeClass("hide");
    }

    function mostrar(provincia) {
        $bodyTablaProvincia.html("<tr><td>" + provincia.id + "</td><td>" + provincia.pais.nombre + "</td><td>" + provincia.nombre + "</td></tr>");
        $spanIdProvinciaEncontrado.text(provincia.id);
    }

    function bindearEventosABotones() {
        bindearBotonBuscar();
        bindearBotonCrear();
        bindearEnter();

    }

    function bindearBotonCrear() {
        $("#botonCrearProvinciaNueva").on("click", function () {
            eventosABindearCrear();
        });
    }

    function bindearBotonBuscar() {
        $("#botonBuscarProvinciaPorId").on("click", function () {
            eventosABindearBuscar();
        });
    }

    function bindearEnter() {
        $("#idProvinciaABuscar").keypress(function (e) {
            if (e.which === 13) {
                eventosABindear();
            }
        });
    }

    function eventosABindearBuscar() {
        $("#mensajeNoEncontrado").addClass("hide");
        var idProvinciaABuscar = $("#idProvinciaABuscar").val();
        buscar(idProvinciaABuscar);
    }

    function eventosABindearCrear() {
        $("#mensajeError").addClass("hide");
        var provincia = {
            "id": $("#idProvinciaNueva").val(),
            "nombre": $("#nombreProvinciaNueva").val()
        };
        escuelita.service.pais.buscarPorId($("#paisProvinciaNueva").val()).done(function (pais) {
            provincia.pais = pais;
        });
        console.log(provincia);
        crearProvincia(provincia);
        
    }


    function mostrarMensajeNoEncontrado() {
        $bodyTablaProvincia.text("");
        $spanIdProvinciaEncontrado.text("");
        $divMensajeNoEncontrado.removeClass("hide");
    }

    return {
        inicializar: inicializar,
        buscar: buscar
    };

})();

$(document).ready(function () {
    escuelita.ui.provincia.inicializar();
});
