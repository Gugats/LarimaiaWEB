/**
 * Created by Virmerson on 14/09/15.
 */
'use strict';

//Um controller dela
appCrudAngular.controller('TipoEventoCtrl', function ($scope, $http) {

    $scope.tiposEvento = {}; //Lista de Tipo Evento vinculadas a tela
    $scope.tipoEvento = {}; // Objeto Tipo Evento Vinculado a tela (Form)

    $scope.listar = function () {

        $http.get("ws/tipoevento/listar").success(function (dados) {
            $scope.tiposEvento = dados;
        });
    };

    $scope.salvar = function (){
        $http.post("ws/tipoevento/salvar", $scope.tipoEvento).success(function (dados){
            //$scope.clientes.push(dados);
            window.alert("Sucesso ao salvar!");
            $scope.tipoEvento= {};
            $scope.listar();

        });

    };

    $scope.excluir =  function (idP){
        $http.delete("ws/tipoevento/excluir/"+ idP,{}).success(function (){
            window.alert("Sucesso ao excluir!");
            $scope.tipoEvento= {};
            $scope.listar();
        });

    };

    $scope.editar = function (tipoEvento){
        $scope.tipoEvento = tipoEvento;
    }

    $scope.limpar = function () {
        $scope.tipoEvento = {};
    }

    $scope.listar(); //carregando inicialmente


});
