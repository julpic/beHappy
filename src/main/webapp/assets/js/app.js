var app = angular.module("app", []);
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

    $scope.Proveedor = function () {
        $scope.accion = 'Proveedor'
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
        $scope.m = m
        if (confirm("¿Desea anular el movimiento " + $scope.m.idMovimientoStock + "?") == true) {
            $http.delete("/beFruit/stock/movimientoStock/" + $scope.m.idMovimientoStock, $scope.m.idMovimientoStock).then(
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
        var detallesJson = angular.toJson(detalles);

        $scope.CurrentDate = new Date();
        var mov = angular.toJson({
            "idMovimientoStock":null,
            "idVenta": null,
            "idTurno": null,
            "fechaHora": $scope.CurrentDate,
            "fechaHoraAnulacion": null,
            "entrada": true,
            "detalles":[]
        });
        alert(mov)
        $http.post("/beFruit/stock/movimientoStock", mov).then(function (response) {
                $http.post("/beFruit/stock/movimientoStock", mov).then(function (response) {
                    alert("Movimiento agregado");
                    $scope.idMov = response.data;
                    alert(idMov)


                });

            },
            function (response) {
                alert("No se puedo agregar el movimiento...");
            });
        $scope.tempDetalles = [];
        $scope.detalle = {};
        $scope.movimiento = {};


    };

    //Insumos - FUNCIONANDO

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
                $http.put('/beFruit/stock/unidadMedida/'+ $scope.nvoUnidad.idUnidad,$scope.nvoUnidad).then (function (response) {
                    alert("Los cambios fueron realizados correctamente.")
                    $scope.nvoUnidad = null;
                    $scope.obtenerUnidades();
                })
            }

        }

    };


    //Valores inicializados (sino materialize no carga los select):

    $scope.obtenerInsumos();
    $scope.obtenerUnidades();
    $scope.obtenerMovimientos();
    $scope.nvoInsumo = $scope.nvoInsumo;


});

app.controller("proveedoresController", function ($scope, $http) {

    $scope.subaccion = 'Proveedor1';

    //Subacciones...

    $scope.Proveedor1 = function () {
        $scope.subaccion = 'Proveedor1';
    };

    $scope.Proveedor2 = function () {
        $scope.subaccion = 'Proveedor2';
    };

    //Funciones...
    $scope.obtenerProveedores = function () {
        $http.get('/beFruit/franquicias/proveedor')
            .then (function (response){
                $scope.proveedores = response.data;
            });

    };

    $scope.obtenerProveedores();


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
        $http.get('/beFruit/franquicias/franquicia')
            .then(function (response) {
                $scope.franquicias = response.data;
            });
    };

    $scope.grabarFranquicia = function (franquicia) {
        var franquiciaJson = {
            "idFranquicia": null,
            "cuit": franquicia.cuit,
            "direccion": franquicia.direccion,
            "nombreDueno": franquicia.nombreDueno,
            "eMailDueno": franquicia.eMailDueno,
            "apellidoDueno": franquicia.apellidoDueno,
            "alta": franquicia.alta,
            "empleados": []
        };
        alert(JSON.stringify(franquiciaJson));

        $http.post('/beFruit/franquicias/franquicia', JSON.stringify(franquiciaJson)).then(function (response) {
                alert("Franquicia agregada correctamente.");
            },
            function (response) {
                alert('No se pudo crear la Franquicia');
            })

    };

    $scope.borrarFranquicia = function (franquicia) {
        $scope.franquiciaJson = angular.toJson(franquicia);
        if (confirm("¿Desea borrar de forma permanente el insumo  " + franquicia.idFranquicia+ "?") == true) {
            $http.delete('/beFruit/franquicias/franquicia/' + franquicia.idFranquicia).then(function (response) {

                    alert("Franquicia eliminadada");
                    $scope.obtenerFranquicias();
                },
                function (response) {
                    alert("No se puedo borrar la franquicia...");
                })
        };

    };
    $scope.obtenerFranquicias()
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
    $scope.obtenerEmpleados = function () {
        $http.get('/beFruit/franquicias/empleado')
            .then (function (response){
                $scope.empleados = response.data;
            });

    };

    $scope.obtenerEmpleados();


});

app.controller("informesController", function ($scope, $http) {
});

app.controller("promocionesController", function ($scope, $http) {
});

app.controller("configController", function ($scope, $http) {
});
