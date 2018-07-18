var app = angular.module("app", []);
app.controller("beFruitController", function ($scope, $http) {

    $scope.title = "HOLAAAAAAAAAA";
    $scope.accion = 'Inicio'; 
    $scope.subaccion = ''; 
    $scope.unidadesmedida =[];

    //Accion...
    
    $scope.Inicio = function () {
        $scope.accion = 'Inicio';
       
    };
    
    $scope.Venta = function () {
        $scope.accion = 'Venta'; 
    };
    
    $scope.Stock = function () {
        $scope.accion = 'Stock';
        $scope.subaccion = 'Stock1';
        $scope.insumos = $scope.obtenerInsumos()
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
    
    $scope.Sucursales = function () {
        $scope.accion = 'Sucursales'; 
    };
    
    $scope.Configuracion = function () {
        $scope.accion = 'Configuracion'; 
    };
    
    //Subacciones...
    $scope.obtenerInsumos = function () {
        $http.get('/beFruit/stock/insumo')
            .then (function (response){
                $scope.insumos = response.data;
            });
    };

    $scope.obtenerMovimientos = function() {
        var datos = [{"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    {"idMovimientos":"1" ,"fecha":"10-08-2017","tipo":"Baja" ,"articulo":"Samasung galaxy s7" ,"cantidad":"50" },
                    ];
        return datos
    };



    $scope.obtenerUnidad = function () {
        $http.get('/beFruit/stock/unidadMedida')
            .then (function (response){
                $scope.unidad = response.data;
        });
    }

    $scope.unidadesmedida = $scope.obtenerUnidad();


    //$scope.ObtenerUnMed = function ($scope, $http) {
    //    $http.get('/unidadMedida')
    //        .then(function (response) {
    //            $scope.insumos = response.data; 
    //};



    $scope.Stock1 = function () { 
        $scope.subaccion = 'Stock1'; 
        
    };

   
    
    $scope.Stock2 = function () { 
        $scope.subaccion = 'Stock2'; 
        $scope.movimientos = $scope.obtenerMovimientos ()
        
        
    };
    
    $scope.Stock3 = function () { 
        $scope.subaccion = 'Stock3'; 
       
        };

        
    
    $scope.Stock4 = function () { 
        $scope.subaccion = 'Stock4';
        
        //$scope.ObtenerUnMed();
        
        $scope.unidadesmedida = $scope.ListaUnMed();
    };
    $scope.nvoInsumo = $scope.nvoInsumo;
    
    $scope.Grabar = function () {
        if ($scope.nvoInsumo.idInsumo == undefined)  // agregar
        {
            $http.post('/application/json', $scope.nvoInsumo).then(function (response) {
                alert("Registro agregado correctamente.");
                $scope.Stock1();
                $scope.nvoInsumo = null;

            });
        }
        else {
            $http.put('/' + $scope.nvoInsumo.idInsumo, $scope.nvoInsumo).then(function (response) {
                alert("Registro modificado correctamente.");
                $scope.Stock1();
                $scope.nvoInsumo = null;
            });
        }
    };

    $scope.Agregar = function () {
        $scope.nvoInsumo = {};
        $scope.Stock4();
    };
    $scope.Borrar = function () {
     
        $http.put('/' + $scope.nvoInsumo.idInsumo, $scope.nvoInsumotoJson).then(function (response) {
            
                alert("Registro eliminado")
            });
        
    };

 

    $scope.BuscarPorId = function (Insumo) {
        $scope.nvoInsumo = Insumo;
        $scope.Stock4();
    };

    $scope.BuscarUmPorId = function (unidadMedida) {
        $scope.nvoUnidad = unidadMedida;
    };
    
    $scope.Stock5 = function () { 
        $scope.subaccion = 'Stock5';
        $scope.unidadesMedida = $scope.obtenerUnidadMedida
    };
    

});
