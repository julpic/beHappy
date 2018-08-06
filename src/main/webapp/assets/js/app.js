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
        $scope.subaccion = 'Stock1';

    };

    $scope.Proveedores = function () {
        $scope.accion = 'Proveedores'
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

    $scope.login = function (user) {
        var credentials = btoa(user.username + ':' + user.password);
        var authorization = {'Authorization': 'Basic ' + credentials};
        var header = {headers: authorization};
        $http.post('/beFruit/usuarios/sesion' , header)
            .then(function(response) {
                alert(response.data);
            });
    }


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
            "entrada": $scope.movimiento.tipo
        });
        alert(mov)
        
        $http.post("/beFruit/stock/movimientoStock", mov).then(function (response) { //aca deberia agregar el movimiento
            alert("Movimiento agregado");
            var idMov = response.data;
            $http.post("/beFruit/stock/detalleMovimientoStock/movimiento/" + idMov, detallesJson).then(function (response) { //aca deberia agregar los detalles
            alert("Detalles agregados");
            },
            function (response) {
                alert("No se puedieron agregar los detalles...");
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
        if ($scope.nvoInsumo.nombre != null && $scope.nvoInsumo.stockMinimo != null && $scope.nvoInsumo.unidadMedida != null) {
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
            }
        else {
            alert("Faltan datos..");
        };
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
                    alert("Unidad de medida nueva agregada correctamente.");
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

    $scope.subaccion = 'Proveedores1';

    //Subacciones...

    $scope.Proveedores1 = function () {
        $scope.subaccion = 'Proveedores1';
    };

    $scope.Proveedores2 = function () {
        $scope.subaccion = 'Proveedores2';
    };

    //Funciones...
    $scope.obtenerProveedores = function () {
        $http.get('/beFruit/franquicias/proveedor')
            .then (function (response){
                $scope.proveedores = response.data;
            });

    };

    $scope.grabarProveedor = function (proveedor) {
        if (proveedor.idProveedor == null) {
            proveedor.idProveedor = -1;
            alert(JSON.stringify(proveedor));
            $http.post('/beFruit/franquicias/proveedor', JSON.stringify(proveedor)).then (function (response) {
                    $scope.obtenerProveedores();
                    alert('El proveedor fue agregado corectamente');
                    proveedor = null;
                },
                function (response) {
                    alert('No se pudo agregar el proveedor')
                });
        }
        else {
            $http.put('/beFruit/franquicias/proveedor/'+ proveedor.idProveedor , JSON.stringify(proveedor)).then (function (response) {
                    $scope.obtenerProveedores();
                    $scope.Proveedores1();
                    alert('El proveedor fue modificado corectamente');
                    proveedor = null;
                },
                function (response) {
                    alert('No se pudo modificar el proveedor')
                });

        }

    };

    $scope.modificarProveedor= function(proveedor){
        $scope.p = proveedor;
        $scope.Proveedores2();
    }

    $scope.borrarProveedor = function(proveedor) {
        if(confirm('Desea dar de baja como proveedor a'+ proveedor.razonSocial + 'de su franquicia?') == true) {
            $http.delete('/beFruit/franquicias/proveedor/' + proveedor.idProveedor).then (function (response) {
                    alert('El proveedor ha sido eliminado correctamente');
                    $scope.obtenerEmpleados();
                },
                function (response) {
                    alert('No se pudo eliminar el proveedor')
                })
        }
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
    $scope.modificarFranquicia = function(f){
      $scope.franquicia = f;
      $scope.Franquicias2();
    };
    $scope.grabarFranquicia = function (franquicia) {
        if (franquicia.direccion != null && franquicia.alta != null && franquicia.nombreDueno != null && franquicia.apellidoDueno != null && franquicia.eMailDueno != null && franquicia.cuit != null) {
            if (franquicia.idFranquicia == null) {
                var franquiciaJson = {
                    "idFranquicia": -1,
                    "cuit": franquicia.cuit,
                    "direccion": franquicia.direccion,
                    "nombreDueno": franquicia.nombreDueno,
                    "eMailDueno": franquicia.eMailDueno,
                    "apellidoDueno": franquicia.apellidoDueno,
                    "alta": franquicia.alta,
                    "empleados": []
                };

                $http.post('/beFruit/franquicias/franquicia', JSON.stringify(franquiciaJson)).then(function (response) {
                        alert("Franquicia agregada correctamente.");
                        $scope.obtenerFranquicias();
                        $scope.franquicia = null ;
                    },
                    function (response) {
                        alert('No se pudo crear la Franquicia');
                    })
            }

            else {
                var franquiciaJson = {
                    "idFranquicia": franquicia.idFranquicia,
                    "cuit": franquicia.cuit,
                    "direccion": franquicia.direccion,
                    "nombreDueno": franquicia.nombreDueno,
                    "eMailDueno": franquicia.eMailDueno,
                    "apellidoDueno": franquicia.apellidoDueno,
                    "alta": franquicia.alta,
                    "empleados": []
                };

                $http.put('/beFruit/franquicias/franquicia/' + franquiciaJson.idFranquicia, JSON.stringify(franquiciaJson)).then(function (response) {
                        alert("Franquicia modificada exitosamente.");
                        $scope.obtenerFranquicias();
                        $scope.Franquicias1();
                        $scope.franquicia = null;
                    },
                    function (response) {
                        alert('No se pudo modificar la Franquicia');
                    })
            }

        } else {
            alert("Faltan datos...");
        }

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
    $scope.subaccion = 'Caja1';
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

    $scope.grabarEmpleado = function (empleado) {
        if (empleado.idEmpleado == null) {
            empleado.idEmpleado = -1;
            $http.post('/beFruit/franquicias/empleado', JSON.stringify(empleado)).then (function (response) {
                    $scope.obtenerEmpleados();
                    alert('El empleado fue agregado corectamente');
                    empleado = null
                },
                function (response) {
                    alert('No se pudo agregar el empleado')
                });
        }
        else {
            $http.put('/beFruit/franquicias/empleado/'+ empleado.idEmpleado , JSON.stringify(empleado)).then (function (response) {
                    $scope.obtenerEmpleados();
                    $scope.Empleados1();
                    alert('El empleado fue modificado corectamente');
                    empleado = null;
                },
                function (response) {
                    alert('No se pudo modificar el empleado')
                });

        }

    };

    $scope.modificarEmpleado = function(empleado){
        $scope.empleado = empleado;
        $scope.Empleados2();
    }

    $scope.borrarEmpleado = function(empleado) {
        if(confirm('Desea dar de baja a'+ empleado.nombre + 'de su franquicia?') == true) {
            $http.delete('/beFruit/franquicias/empleado/' + empleado.idEmpleado).then (function (response) {
                alert('El empleado ha sido eliminado correctamente');
                $scope.obtenerEmpleados();
            },
            function (response) {
                alert('No se pudo eliminar al empleado')
            })
        }
        };

    $scope.obtenerEmpleados();

    //{
        //"idEmpleado":-1,
        //"idFranquicia":"1",
        //"apellido":"Abanto",
        //"dni":"19053215",
        //"eMail":"Diego@abanto.com",
        //"fechaNacimiento":"1996-11-27",
        //"nombre":"Diego",
        //"telefonoContacto":3515466380,
        //"alta":true
    //}
});

app.controller("informesController", function ($scope, $http) {
    $scope.subaccion = 'Informes1';
});

app.controller("promocionesController", function ($scope, $http) {
    $scope.subaccion = 'Promociones1';
});

app.controller("configController", function ($scope, $http) {
    $scope.subaccion = 'Configuracion1';


    //Subacciones
    $scope.Configuracion1 = function(){
        $scope.subaccion = 'Configuracion1';
        $scope.obtenerUsuarios();
    };

    $scope.obtenerEmpleados = function () {
        $http.get('/beFruit/franquicias/empleado')
            .then (function (response){
                $scope.empleados = response.data;
            });
    };

    $scope.obtenerPerfiles = function() {
      $http.get('/beFruit/usuarios/perfil').
      then (function (response) {
           $scope.perfiles = response.data;
          }
      );
    };


    $scope.Configuracion2 = function(){
        $scope.subaccion = 'Configuracion2'}
    
    //Funciones
    
    $scope.obtenerUsuarios = function(){
         $http.get('/beFruit/usuarios/usuario')
            .then (function (response){
                $scope.usuarios = response.data;
             ;});
    };

    $scope.grabarUsuario = function (usuario) {
        alert("HOOOLA");
        alert(JSON.stringify(usuario));
        usuario.idFranquicia = empleados.idFranquicia;
        usuario.idUsuario = -1;
        alert(usuario);

        $http.post('/beFruit/usuarios/usuario',JSON.stringify(usuario)).
            then(function (response) {
                alert("El usuario fue creado correctamente");
            },
            function (response) {
                alert("No se pudo crear el usuario");
            }
        );

    };


    $scope.obtenerUsuarios();
    $scope.obtenerEmpleados();
    $scope.obtenerPerfiles();
});
