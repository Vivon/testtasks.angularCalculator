package com.testTask.angular.calculator.filters;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LoggerFilter implements Filter {

    private static Logger LOGGER = LoggerFactory.getLogger(LoggerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestWrapper requestWrapper =
                new RequestWrapper((HttpServletRequest) request, IOUtils.toByteArray(request.getInputStream()));
        ResponseWrapper responseWrapper =
                new ResponseWrapper((HttpServletResponse) response, response.getOutputStream());
        loggingRequest(requestWrapper);
        chain.doFilter(requestWrapper, responseWrapper);
        loggingResponse(responseWrapper);
    }

    private void loggingRequest(RequestWrapper request) throws UnsupportedEncodingException {
        String requestBody = new String(request.getRequestBytes(), CharEncoding.UTF_8);
        LOGGER.info("Request body: {}", requestBody);
    }

    private void loggingResponse(ResponseWrapper response) throws UnsupportedEncodingException {
        String responseBody = new String(response.getResponseBytes(), CharEncoding.UTF_8);
        if (!responseBody.isEmpty()) {
            LOGGER.info("Response body: {}", responseBody);
        }
    }

    @Override
    public void destroy() {
    }
}
