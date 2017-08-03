escuelita.service.provincia = (function () {

    var urlService = "/dosideas-jee001-workshop/api/provincia/";

    function buscarPorId(idProvincia) {
        var urlServiceBuscarPorId = urlService + idProvincia;
        return $.get(urlServiceBuscarPorId);
    }
    
    function crearProvincia(provincia) {       
        return $.ajax({
            contentType: 'application/json',
            data: JSON.stringify(provincia),
            dataType: 'json',
            type: 'POST',
            url: urlService
        });
    }

    return {
        buscarPorId: buscarPorId,
        crearProvincia: crearProvincia
    };

})();

//var f = function() {
//    var a = 1;
//};
//
//f();
//console.log(a);
//
//
//var o = (function () {
//    var edad;
//    var peso;
//    
//    function getEdadPrivada() {
//        return edad;
//    }
//    
//    return {
//        getEdad: getEdadPrivada
//    };
//})();
