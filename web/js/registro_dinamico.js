/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module('myApp', []);

app.controller('myCtrl1', function($scope, $http) {

    $scope.bolivianos = 0;
    $scope.dato1 = false;
    $scope.operacion = 2;
    $scope.valor1 = false;
    $scope.valor2 = false;
    $scope.valor3 = false;
    $scope.valor4 = false;
    $scope.importar = function(){
      $http.get('datos.json').success(function(datos){
          $scope.actividad = datos;
      });
    };
    $scope.importar();
});
