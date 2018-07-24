﻿var app = angular.module("app", []);
app.controller("beFruitController", function ($scope, $http) {

    $scope.title = "sadsadsasdasdasdasdasdasdasdasdasdasd";
    $scope.accion = 'Inicio';


    $scope.Inicio = function () {
        $scope.accion = 'Inicio';

    };

    $scope.Venta = function () {
        $scope.accion = 'Venta';
    };

    $scope.Stock = function () {
        $scope.accion = 'Stock';

    };

    $scope.Caja = function () {
        $scope.accion = 'Caja';
    };

    $scope.Empleados = function () {
        $scope.accion = 'Empleados';
    };

    $scope.Informes = function () {
        $scope.accion = 'Informes';
    };

    $scope.Promociones = function () {
        $scope.accion = 'Promociones';
    };

    $scope.Franquicias = function () {
        $scope.accion = 'Franquicias';
    };

    $scope.Configuracion = function () {
        $scope.accion = 'Configuracion';
    };


});

app.controller("stockController", function ($scope, $http) {

    $scope.subaccion = 'Stock1';

    //Subacciones...

    $scope.Stock1 = function () {
        $scope.subaccion = 'Stock1';
        $scope.obtenerInsumos();

    };

    $scope.Stock2 = function () {
        $scope.subaccion = 'Stock2';


    };

    $scope.Stock3 = function () {
        $scope.subaccion = 'Stock3';
        $scope.tempDetalles = [];
    };


    $scope.Stock4 = function () {
        $scope.subaccion = 'Stock4';
    };

    $scope.Stock5 = function () {
        $scope.subaccion = 'Stock5';
    };

    //Funciones...

    $scope.obtenerInsumos = function () {
        $http.get('/beFruit/stock/insumo')
            .then (function (response){
                $scope.insumos = response.data;
            });
    };

    $scope.obtenerMovimientos = function () {
        $http.get('/beFruit/stock/movimientoStock')
            .then(function (response) {
                $scope.movimientos = response.data;
            });
    };



    $scope.anularMovimiento = function (m) {
        if (confirm("¿Desea anular el movimiento " + m.id + "?") == true) {
            $http.delete("/beFruit/stock/movimientoStock", m.id).then(
                function (response) {
                    alert("Movimiento anulado exitosamente");
                    $scope.obtenerMovimientos();
                },
                function (response) {
                    alert("No se puedo anular el movimiento...");
                })
        }
        ;

    };

    $scope.verDetalles = function (m) {
        $scope.detalles = m.detalles;
    };


    $scope.sumarDetalle = function (m, d) {
        if ((d.insumo != null) && (d.cantidad != null) && (d.cantidad >= 1)) {
            d.idMovimiento = m.id;
            d.insumo = $scope.detalle.insumo;
            $scope.tempDetalles.push(d);
            $scope.detalle = {};
        } else {
            alert("Faltan datos...");
        }
        ;


    };

    $scope.restarDetalle = function (index) {
        $scope.tempDetalles.splice(index, 1);

    };

    $scope.cancelarMovimiento = function () {
        $scope.tempDetalles = [];
        $scope.detalle = {};
        $scope.movimiento = {};

    };

    $scope.agregarMovimiento = function () {
        var count = 1;
        var detalles = [];
        angular.forEach($scope.tempDetalles, function (det) {
            det.idMovimiento = $scope.movimiento.id;
            det.idDetalleMovimientoStock = count;
            detalles.push(det);
        });
        $scope.CurrentDate = new Date();
        var mov = {
            "id": $scope.movimiento.id,
            "idVenta": null,
            "idTurno": null,
            "fechaHora": $scope.CurrentDate,
            "fechaHoraAnulacion": null,
            "entrada": $scope.movimiento.tipo,
            "detalles": detalles
        };
        $http.post("/beFruit/stock/movimientoStock", mov).then(function (response) {
                $http.post("/beFruit/stock/detalleMovimientoStock", detalles, mov.id).then(function (response) {
                    alert("Movimiento agregado");

                });

            },
            function (response) {
                alert("No se puedo agregar el movimiento...");
            });
        $scope.tempDetalles = [];
        $scope.detalle = {};
        $scope.movimiento = {};


    };

    //Insumos

    $scope.grabarInsumo = function () {
        if ($scope.nvoInsumo.idInsumo == undefined)  // agregar
        {
            $scope.nvoInsumo.idInsumo = null ;
            $scope.nvoInsumo.alta = true ;
            $http.post('/beFruit/stock/insumo', JSON.stringify($scope.nvoInsumo)).then(function (response) {
                alert("Registro agregado correctamente.");
                $scope.Stock4();
                $scope.nvoInsumo = null;

            },
                function (response) {
                    alert("No se puedo guardar el nuevo insumo...");
                    alert(JSON.stringify($scope.nvoInsumo));
                }
                )

        }

        else {

            $scope.nvoInsumo.alta = false ;
            $http.put('/beFruit/stock/insumo/' + $scope.nvoInsumo.idInsumo, JSON.stringify($scope.nvoInsumo)).then(function (response) {
                alert("Registro modificado correctamente.");
                $scope.Stock1();
                $scope.nvoInsumo = null;

            });
        }
    };

    $scope.borrarInsumo = function (Insumo) {
        $scope.inBorrar = Insumo;
        if (confirm("¿Desea borrar de forma permanente el insumo  " + $scope.inBorrar.idInsumo + "?") == true) {
        $http.delete('/beFruit/stock/insumo/' + $scope.inBorrar.idInsumo, $scope.inBorrar.idInsumo).then(function (response) {

            alert("Registro eliminado");
                $scope.Stock1();
        },
            function (response) {
                alert("No se puedo borrar el insumo...");
            })
        };

    };

    $scope.buscarInsumoPorId = function (Insumo) {
        $scope.nvoInsumo = Insumo;
        $scope.Stock4();
    };
    //UnidadMedida - FUNCIONANDO
    $scope.obtenerUnidades = function () {
        $http.get('/beFruit/stock/unidadMedida')
            .then (function (response){
                $scope.unidades = response.data;
            });

    };
    $scope.buscarUnidadMedidaPorId = function (unidadMedida) {
        $scope.nvoUnidad = unidadMedida;
    };
    $scope.grabarUnidadMedida = function () {
        if($scope.nvoUnidad.idUnidad == null){
            if(confirm('¿Desea agregar esta nueva unidad?') == true){
                $http.post('/beFruit/stock/unidadMedida' , $scope.nvoUnidad).then(function (response) {
                    alert("Unidad de medida nueva agregadoa correctamente.");
                    $scope.nvoUnidad = null;
                    $scope.obtenerUnidades();
                });
            }

        }
        else {
            if(confirm('¿Desea realizar estos cambios?') == true){
                $http.put('/beFruit/stock/unidadMedida/'+ $scope.nvoUnidad.idUnidad,$scope.nvoUnidad).then(function (response) {
                    alert("Los cambios fueron realizados correctamente.")
                    $scope.nvoUnidad = null;
                    $scope.obtenerUnidades();
                })
            }

        }

    };


    //Valores inicializados (sino materialize no carga los select):

    $scope.insumos = $scope.obtenerInsumos();
    $scope.unidades = $scope.obtenerUnidades();
    $scope.movimientos = $scope.obtenerMovimientos();
    $scope.nvoInsumo = $scope.nvoInsumo;


});


app.controller("franquiciasController", function ($scope, $http) {

    $scope.subaccion = 'Franquicias1';

    //Subacciones...

    $scope.Franquicias1 = function () {
        $scope.subaccion = 'Franquicias1';

    };

    $scope.Franquicias2 = function () {
        $scope.subaccion = 'Franquicias2';

    };

    //Funciones...

    $scope.obtenerFranquicias = function () {
        $http.get('/beFruit/franquicias')
            .then (function (response){
                $scope.franquicia = response.data;
            });
    };

    $scope.obtenerFranquicias();
});

app.controller("ventaController", function ($scope, $http) {
});

app.controller("cajaController", function ($scope, $http) {
});

app.controller("empleadosController", function ($scope, $http) {
    $scope.subaccion = 'Empleados1';

    //Subacciones...

    $scope.Empleados1 = function () {
        $scope.subaccion = 'Empleados1';

    };

    $scope.Empleados2 = function () {
        $scope.subaccion = 'Empleados2';

    };

    //Funciones...


});

app.controller("informesController", function ($scope, $http) {
});

app.controller("promocionesController", function ($scope, $http) {
});

app.controller("configController", function ($scope, $http) {
});
