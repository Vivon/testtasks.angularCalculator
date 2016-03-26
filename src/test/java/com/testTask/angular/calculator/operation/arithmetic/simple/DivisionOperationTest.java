package com.testTask.angular.calculator.operation.arithmetic.simple;

import com.testTask.angular.calculator.common.ErrorNumber;
import com.testTask.angular.calculator.common.ServiceException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DivisionOperationTest {

    private DivisionOperation operationForTest;

    private static final Double DEFAULT_FIRST_ARGUMENT = 10D;
    private static final Double DEFAULT_SECOND_ARGUMENT = 5D;
    private static final Integer DEFAULT_RESULT = 2;

    @Before
    public void initTest(){
        operationForTest = new DivisionOperation();
    }

    @Test
    public void testWhenSecondArgumentNull() throws ServiceException {
        try {
            operationForTest.doOperation(DEFAULT_FIRST_ARGUMENT, null);
            fail();
        } catch (DivisionByZeroException ex) {
            assertEquals(ErrorNumber.ERR_01_2, ex.getErrorNumber());
        }
    }

    @Test
    public void testWhenSecondArgumentZero() throws ServiceException {
        try {
            operationForTest.doOperation(DEFAULT_FIRST_ARGUMENT, 0D);
            fail();
        } catch (DivisionByZeroException ex) {
            assertEquals(ErrorNumber.ERR_01_2, ex.getErrorNumber());
        }
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
    public void testWhenArgumentValid() throws ServiceException {
        Double result = operationForTest.doOperation(DEFAULT_FIRST_ARGUMENT, DEFAULT_SECOND_ARGUMENT);
        assertEquals(DEFAULT_RESULT.intValue(), result.intValue());
    }
}
