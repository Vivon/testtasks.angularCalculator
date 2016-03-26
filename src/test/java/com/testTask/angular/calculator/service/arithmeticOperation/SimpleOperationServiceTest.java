package com.testTask.angular.calculator.service.arithmeticOperation;

import com.testTask.angular.calculator.common.ErrorNumber;
import com.testTask.angular.calculator.common.ServiceException;
import com.testTask.angular.calculator.operation.OperationEnum;
import com.testTask.angular.calculator.operation.arithmetic.simple.DivisionByZeroException;
import com.testTask.angular.calculator.operation.arithmetic.simple.DivisionOperation;
import com.testTask.angular.calculator.operation.arithmetic.simple.MultiplicationOperation;
import com.testTask.angular.calculator.operation.arithmetic.simple.SubtractionOperation;
import com.testTask.angular.calculator.operation.arithmetic.simple.SumOperation;
import com.testTask.angular.calculator.service.arithmeticOperation.input.SimpleOperationRequestI;
import com.testTask.angular.calculator.validator.RequestWrongException;
import com.testTask.angular.calculator.validator.SimpleOperationRequestValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SimpleOperationServiceTest {

    private SimpleOperationService operationServiceForTest;

    private SumOperation sumOperationMock;
    private SubtractionOperation subtractionOperationMock;
    private MultiplicationOperation multiplicationOperationMock;
    private DivisionOperation divisionOperationMock;
    private SimpleOperationRequestValidator simpleOperationRequestValidatorMock;
    private SimpleOperationRequestI simpleOperationRequestMock;

    private static final Double DEFAULT_FIRST_ARGUMENT = 10D;
    private static final Double DEFAULT_SECOND_ARGUMENT = 2D;
    private static final Double DEFAULT_SERVICE_RESULT = 5D;

    @Before
    public void initTest(){
        operationServiceForTest = new SimpleOperationService();

        sumOperationMock = mock(SumOperation.class);
        subtractionOperationMock = mock(SubtractionOperation.class);
        multiplicationOperationMock = mock(MultiplicationOperation.class);
        divisionOperationMock = mock(DivisionOperation.class);
        simpleOperationRequestValidatorMock = mock(SimpleOperationRequestValidator.class);
        simpleOperationRequestMock = mock(SimpleOperationRequestI.class);

        operationServiceForTest.setDivisionOperation(divisionOperationMock);
        operationServiceForTest.setMultiplicationOperation(multiplicationOperationMock);
        operationServiceForTest.setSimpleOperationRequestValidator(simpleOperationRequestValidatorMock);
        operationServiceForTest.setSubtractionOperation(subtractionOperationMock);
        operationServiceForTest.setSumOperation(sumOperationMock);

        when(simpleOperationRequestMock.getFirstArgument()).thenReturn(DEFAULT_FIRST_ARGUMENT);
        when(simpleOperationRequestMock.getSecondArgument()).thenReturn(DEFAULT_SECOND_ARGUMENT);
    }

    @Test
    public void testSuccessSumOperation() throws ServiceException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(OperationEnum.SUM.getStringValue());
        when(sumOperationMock.doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT)).thenReturn(DEFAULT_SERVICE_RESULT);

        assertEquals(DEFAULT_SERVICE_RESULT, operationServiceForTest.doOperation(simpleOperationRequestMock));

        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock).getOperationToken();
        verify(sumOperationMock).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);

        verify(subtractionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(multiplicationOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(divisionOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }

    @Test
    public void testSuccessSubtractionOperation() throws ServiceException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(OperationEnum.SUBTRACTION.getStringValue());
        when(subtractionOperationMock.doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT)).thenReturn(DEFAULT_SERVICE_RESULT);

        assertEquals(DEFAULT_SERVICE_RESULT, operationServiceForTest.doOperation(simpleOperationRequestMock));

        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock).getOperationToken();
        verify(subtractionOperationMock).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);

        verify(sumOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(multiplicationOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(divisionOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }

    @Test
    public void testSuccessMultiplicationOperation() throws ServiceException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(OperationEnum.MULTIPLICATION.getStringValue());
        when(multiplicationOperationMock.doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT)).thenReturn(DEFAULT_SERVICE_RESULT);

        assertEquals(DEFAULT_SERVICE_RESULT, operationServiceForTest.doOperation(simpleOperationRequestMock));

        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock).getOperationToken();
        verify(multiplicationOperationMock).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);

        verify(sumOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(subtractionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(divisionOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }

    @Test
    public void testSuccessDivisionOperation() throws ServiceException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(OperationEnum.DIVISION.getStringValue());
        when(divisionOperationMock.doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT)).thenReturn(DEFAULT_SERVICE_RESULT);

        assertEquals(DEFAULT_SERVICE_RESULT, operationServiceForTest.doOperation(simpleOperationRequestMock));

        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock).getOperationToken();
        verify(divisionOperationMock).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);

        verify(sumOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(subtractionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(multiplicationOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }

    @Test
    public void testWhenOperationTokenIsWrong() throws ServiceException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn("ntcn");

        try {
            operationServiceForTest.doOperation(simpleOperationRequestMock);
            fail();
        } catch (NotSupportedOperationException ex) {
            assertEquals(ErrorNumber.ERR_01_1, ex.getErrorNumber());
        }

        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock).getOperationToken();
        verify(divisionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(sumOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(subtractionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(multiplicationOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }

    @Test
    public void testWhenSimpleOperationValidatorThrowException() throws ServiceException {
        RequestWrongException exceptionForTest = new RequestWrongException();
        doThrow(exceptionForTest).when(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        try {
            operationServiceForTest.doOperation(simpleOperationRequestMock);
            fail();
        } catch (RequestWrongException ex) {
            assertEquals(exceptionForTest, ex);
        }
        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock, never()).getOperationToken();
        verify(divisionOperationMock, never()).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);
        verify(sumOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(subtractionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(multiplicationOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }

    @Test
    public void testWhenOperationServiceThrowException() throws ServiceException {
        DivisionByZeroException exceptionForTest = new DivisionByZeroException();
        doThrow(exceptionForTest).when(divisionOperationMock).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(OperationEnum.DIVISION.getStringValue());

        try {
            operationServiceForTest.doOperation(simpleOperationRequestMock);
            fail();
        } catch (ServiceException ex) {
            assertEquals(exceptionForTest, ex);
        }

        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock).getOperationToken();
        verify(divisionOperationMock).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);

        verify(subtractionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(multiplicationOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(sumOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }

    @Test
    public void testSuccessOperationWhenSecondArgumentNull() throws ServiceException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(OperationEnum.SUM.getStringValue());
        when(simpleOperationRequestMock.getSecondArgument()).thenReturn(null);
        when(sumOperationMock.doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_FIRST_ARGUMENT)).thenReturn(DEFAULT_SERVICE_RESULT);

        assertEquals(DEFAULT_SERVICE_RESULT, operationServiceForTest.doOperation(simpleOperationRequestMock));

        verify(simpleOperationRequestValidatorMock).validate(simpleOperationRequestMock);
        verify(simpleOperationRequestMock).getOperationToken();
        verify(sumOperationMock).doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_FIRST_ARGUMENT);

        verify(sumOperationMock, times(1)).doOperation(anyDouble(), anyDouble());
        verify(subtractionOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(multiplicationOperationMock, never()).doOperation(anyDouble(), anyDouble());
        verify(divisionOperationMock, never()).doOperation(anyDouble(), anyDouble());
    }
}
