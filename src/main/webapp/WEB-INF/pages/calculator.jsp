<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html ng-app="CalculatorModule">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link rel='stylesheet' href="static/bootstrap/css/bootstrap.css">
    <script type='text/javascript' src="static/jquery/jquery.min.js"></script>
    <script type="text/javascript" src="static/angularjs/angular.min.js"></script>
    <script type='text/javascript' src="resources/js/calculator.js"></script>
    <link rel="stylesheet" href="resources/css/calculator.css">
    <title>Angular and Bootstrap Calculator</title>
</head>
<body>
<div ng-controller="CalculatorController">
    <div class="container calculator">
        <div class="row form-group">
            <div class="col-md-12">
                <input id="calcResult" type="text" readonly="readOnly" value="{{output}}" class="form-control"
                       pattern="[0-9]{,33}"/>
            </div>
        </div>

        <div class="row form-group">
            <div class="col-md-3">
                <button name="btn1" class="btn btn-success btn-block form-contol" value="1" ng-click='updateOutput(1)'>
                    1
                </button>
            </div>
            <div class="col-md-3">
                <button name="btn2" class="btn btn-success btn-block" value="2" ng-click='updateOutput(2)'>2</button>
            </div>
            <div class="col-md-3">
                <button name="btn3" class="btn btn-success btn-block" value="3" ng-click='updateOutput(3)'>3</button>
            </div>
            <div class="col-md-3">
                <button name="btnMinus" class="btn btn-warning btn-block" ng-click='subtract()'>-</button>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-3">
                <button name="btn4" class="btn btn-success btn-block form-contol" value="4" ng-click='updateOutput(4)'>
                    4
                </button>
            </div>
            <div class="col-md-3">
                <button name="btn5" class="btn btn-success btn-block" value="5" ng-click='updateOutput(5)'>5</button>
            </div>
            <div class="col-md-3">
                <button name="btn6" class="btn btn-success btn-block" value="6" ng-click='updateOutput(6)'>6</button>
            </div>
            <div class="col-md-3">
                <button name="btnPlus" class="btn btn-warning btn-block" ng-click='add()'>+</button>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-3">
                <button name="btn7" class="btn btn-success btn-block form-contol" value="7" ng-click='updateOutput(7)'>
                    7
                </button>
            </div>
            <div class="col-md-3">
                <button name="btn8" class="btn btn-success btn-block" value="8" ng-click='updateOutput(8)'>8</button>
            </div>
            <div class="col-md-3">
                <button name="btn9" class="btn btn-success btn-block" value="9" ng-click='updateOutput(9)'>9</button>
            </div>
            <div class="col-md-3">
                <button name="btnMulti" class="btn btn-warning btn-block" ng-click='multi()'>*</button>
            </div>
        </div>
        <div class="row form-group">
            <div class="col-md-3">
                <button name="btnClear" class="btn btn-danger btn-block form-contol" ng-click='clear()'>CE</button>
            </div>
            <div class="col-md-3">
                <button name="btn0" class="btn btn-success btn-block" value="0" ng-click='updateOutput(0)'>0</button>
            </div>
            <div class="col-md-3">
                <button name="btnEquals" class="btn btn-warning btn-block" ng-click='calculate()'>=</button>
            </div>
            <div class="col-md-3">
                <button name="btnDivision" class="btn btn-warning btn-block" ng-click='division()'>/</button>
            </div>
        </div>
    </div>


    <div class="modal fade" tabindex="-1" role="dialog" id="myModalAllert">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title">При выполнеии вычисления произшла ошибка!</h4>
                </div>
                <div class="modal-body">
                    <p>Код ошибки: {{errorCode}}</p>
                    <p>Текст ошибки: {{errorMessage}}</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>
<script type='text/javascript' src="static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
