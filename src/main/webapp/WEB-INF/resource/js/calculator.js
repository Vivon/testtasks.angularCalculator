var app = angular.module('CalculatorModule', []);

app.controller('CalculatorController', ['$scope', '$http', '$templateCache', CalculatorController]);

function CalcInfo(firstArg) {
    this.firstArgument = firstArg;
    this.secondArgument = null;
    this.operationToken = null;
}

function CalculatorController($scope, $http, $templateCache) {

    var DEFAULT_OUTPUT = "0";
    var OPERATION_SERVER_METHOD = "/api/doSimpleArithmeticOperation";
    var ADD_TOKEN = "+";
    var SUBTRACT_TOKEN = "-";
    var MULTI_TOKEN = "*";
    var DIVISION_TOKEN = "/";

    var newNumber = true;
    var calcInfo = new CalcInfo();
    var lastCalcInfo = null;

    $scope.output = DEFAULT_OUTPUT;

    $scope.updateOutput = function (btn) {
        if ($scope.output == DEFAULT_OUTPUT || newNumber) {
            $scope.output = btn;
            newNumber = false;
        } else {
            $scope.output += String(btn);
        }
    };

    $scope.clear = function () {
        delete calcInfo;
        delete lastCalcInfo;
        calcInfo = new CalcInfo();
        dropOutput();
    };

    $scope.add = function () {
        pushOperation(ADD_TOKEN);
    };

    $scope.subtract = function () {
        pushOperation(SUBTRACT_TOKEN);
    };

    $scope.multi = function () {
        pushOperation(MULTI_TOKEN);
    };

    $scope.division = function () {
        pushOperation(DIVISION_TOKEN);
    };

    $scope.calculate = function () {
        if (calcInfo.firstArgument) {
            calcInfo.secondArgument = $scope.output;
            $http.post(OPERATION_SERVER_METHOD, data, $templateCache)
                .then(successResponse, errorResponse);
        }
    };

    pushOperation = function (operationToken) {
        if ($scope.output) {
            calcInfo.firstArgument = $scope.output;
            calcInfo.operationToken = operationToken;
        }
        dropOutput();
    };

    successResponse = function (response) {
        var result = response.data;
        $scope.output = result.result;
        lastCalcInfo = calcInfo;
        calcInfo = new CalcInfo($scope.output);
        newNumber = true;
    };

    errorResponse = function (response) {
        var errorResponse = response.data;
        $scope.errorCode = errorResponse.code;
        $scope.errorMessage = errorResponse.message;
        $('#myModalAllert').modal('show');
    }


    dropOutput = function () {
        $scope.output = DEFAULT_OUTPUT;
        newNumber = true;
    };

    toNumber = function (numberString) {
        var result = 0;
        if (numberString) {
            result = numberString * 1.0;
        }
        return result;
    };

}