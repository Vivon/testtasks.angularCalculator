package com.testTask.angular.calculator.web;

import com.testTask.angular.calculator.common.ServiceException;
import com.testTask.angular.calculator.service.arithmeticOperation.SimpleOperationServiceI;
import com.testTask.angular.calculator.service.arithmeticOperation.input.SimpleOperationRequest;
import com.testTask.angular.calculator.service.arithmeticOperation.output.SimpleOperationResponse;
import com.testTask.angular.calculator.service.arithmeticOperation.output.SimpleOperationResponseI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

@Controller
@RequestMapping("/api")
public class ApiController {

    private Logger LOGGER = Logger.getLogger(ApiController.class.getName());

    @Autowired
    private SimpleOperationServiceI simpleOperationService;

    /**
     * Method for simple arithmetic operation(+, -, *, /)
     * @param simpleOperationRequest request for operation
     * @return result of operation
     * @throws ServiceException
     */
    @RequestMapping(value = "doSimpleArithmeticOperation", method = RequestMethod.POST)
    public @ResponseBody SimpleOperationResponseI doSimpleArithmeticOperation(@RequestBody SimpleOperationRequest simpleOperationRequest) throws ServiceException {
        return new SimpleOperationResponse(simpleOperationService.doOperation(simpleOperationRequest));
    }
}
