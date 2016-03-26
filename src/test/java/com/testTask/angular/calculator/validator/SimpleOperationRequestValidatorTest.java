package com.testTask.angular.calculator.validator;

import com.testTask.angular.calculator.common.ErrorNumber;
import com.testTask.angular.calculator.operation.OperationEnum;
import com.testTask.angular.calculator.service.arithmeticOperation.input.SimpleOperationRequestI;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SimpleOperationRequestValidatorTest {

    private SimpleOperationRequestValidator operationRequestValidatorForTest;
    private SimpleOperationRequestI simpleOperationRequestMock;

    private static final Double DEFAULT_FIRST_ARGUMENT = 10D;
    private static final Double DEFAULT_SECOND_ARGUMENT = 2D;
    private static final String DEFAULT_OPERATION_TOKEN = OperationEnum.DIVISION.getStringValue();

    @Before
    public void initTest(){
        operationRequestValidatorForTest = new SimpleOperationRequestValidator();

        simpleOperationRequestMock = mock(SimpleOperationRequestI.class);
        when(simpleOperationRequestMock.getFirstArgument()).thenReturn(DEFAULT_FIRST_ARGUMENT);
        when(simpleOperationRequestMock.getSecondArgument()).thenReturn(DEFAULT_SECOND_ARGUMENT);
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(DEFAULT_OPERATION_TOKEN);
    }

    @Test
    public void testWhenValidatorSuccessResult() throws RequestWrongException, ParamValidationException {
        operationRequestValidatorForTest.validate(simpleOperationRequestMock);

        verify(simpleOperationRequestMock, times(1)).getFirstArgument();
        verify(simpleOperationRequestMock, times(1)).getOperationToken();
        verify(simpleOperationRequestMock, never()).getSecondArgument();
    }

    @Test
    public void testWhenRequestNull() throws ParamValidationException {
        try {
            operationRequestValidatorForTest.validate(null);
            fail();
        } catch (RequestWrongException ex) {
            assertEquals(ErrorNumber.ERR_00_0, ex.getErrorNumber());
        }
    }

    @Test
    public void testWhenFirstArgumentNull() throws RequestWrongException {
        when(simpleOperationRequestMock.getFirstArgument()).thenReturn(null);
        try {
            operationRequestValidatorForTest.validate(simpleOperationRequestMock);
            fail();
        } catch (ParamValidationException ex) {
            assertEquals(ErrorNumber.ERR_00_1, ex.getErrorNumber());
            assertEquals("Не переданн обязательный параметр firstArgument !", ex.getMessage());
        }

        verify(simpleOperationRequestMock, times(1)).getFirstArgument();
        verify(simpleOperationRequestMock, never()).getOperationToken();
        verify(simpleOperationRequestMock, never()).getSecondArgument();
    }

    @Test
    public void testWhenOperationTokenNull() throws RequestWrongException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn(null);
        try {
            operationRequestValidatorForTest.validate(simpleOperationRequestMock);
            fail();
        } catch (ParamValidationException ex) {
            assertEquals(ErrorNumber.ERR_00_1, ex.getErrorNumber());
            assertEquals("Не переданн обязательный параметр operationToken !", ex.getMessage());
        }

        verify(simpleOperationRequestMock, times(1)).getFirstArgument();
        verify(simpleOperationRequestMock, times(1)).getOperationToken();
        verify(simpleOperationRequestMock, never()).getSecondArgument();
    }

    @Test
    public void testWhenOperationTokenEmpty() throws RequestWrongException {
        when(simpleOperationRequestMock.getOperationToken()).thenReturn("");
        try {
            operationRequestValidatorForTest.validate(simpleOperationRequestMock);
            fail();
        } catch (ParamValidationException ex) {
            assertEquals(ErrorNumber.ERR_00_1, ex.getErrorNumber());
            assertEquals("Не переданн обязательный параметр operationToken !", ex.getMessage());
        }

        verify(simpleOperationRequestMock, times(1)).getFirstArgument();
        verify(simpleOperationRequestMock, times(1)).getOperationToken();
        verify(simpleOperationRequestMock, never()).getSecondArgument();
    }
}
