package com.ticketmaster.api.advice;

import com.ticketmaster.api.exception.*;
import com.ticketmaster.api.model.ResponseMessage;
import java.util.Collection;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class RestControllerAdvice implements ResponseBodyAdvice<Collection<?>> {

    @Override
    public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> type) {
        //Checks if this advice is applicable. It applies to any endpoint which returns a collection.
        return Collection.class.isAssignableFrom(mp.getParameterType()); 
    }

    @Override
    public Collection<?> beforeBodyWrite(Collection<?> body, MethodParameter mp, MediaType mt, Class<? extends HttpMessageConverter<?>> type, ServerHttpRequest request, ServerHttpResponse response) {
        //Add x-total-count header to response 
        response.getHeaders().add("X-Total-Count", String.valueOf(body.size()));
        return body;        
    }
    
    @ResponseBody
    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseMessage handleNotFoundExceptionHandler(CustomNotFoundException exception) {
        ResponseMessage responseMessage = new ResponseMessage(exception.getMessage());
        return responseMessage;
    }
}