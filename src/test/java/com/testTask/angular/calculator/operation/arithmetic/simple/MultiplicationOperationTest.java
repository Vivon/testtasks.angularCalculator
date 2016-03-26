package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.common.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationOperationTest {

    private MultiplicationOperation operationForTest;

    private static final Double DEFAULT_FIRST_ARGUMENT = 10D;
    private static final Double DEFAULT_SECOND_ARGUMENT = 5D;
    private static final Integer DEFAULT_RESULT = 50;

    @Before
    public void initTest(){
        operationForTest = new MultiplicationOperation();
    }

    @Test
    public void testWhenFirstArgumentNull() throws ServiceException {
        Double result = operationForTest.doOperation(null, DEFAULT_SECOND_ARGUMENT);
        assertEquals(0, result.intValue());
    }

    @Test
    public void testWhenFirstArgumentZero() throws ServiceException {
        Double result = operationForTest.doOperation(0D, DEFAULT_SECOND_ARGUMENT);
        assertEquals(0, result.intValue());
    }

    @Test
    public void testWhenSecondArgumentNull() throws ServiceException {
        Double result = operationForTest.doOperation(DEFAULT_FIRST_ARGUMENT, null);
        assertEquals(0, result.intValue());
    }

    @Test
    public void testWhenSecondArgumentZero() throws ServiceException {
        Double result = operationForTest.doOperation(DEFAULT_FIRST_ARGUMENT, 0D);
        assertEquals(0, result.intValue());
    }

    @Test
    public void testWhenArgumentValid() throws ServiceException {
        Double result = operationForTest.doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);
        assertEquals(DEFAULT_RESULT.intValue(), result.intValue());
    }
}
