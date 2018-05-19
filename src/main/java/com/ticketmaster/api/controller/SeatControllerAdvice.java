package com.ticketmaster.api.controller;

import java.util.Collection;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class SeatControllerAdvice implements ResponseBodyAdvice<Collection<?>> {

    @Override
    public boolean supports(MethodParameter mp, Class<? extends HttpMessageConverter<?>> type) {
        //Checks if this advice is applicable. 
        //In this case it applies to any endpoint which returns a collection.
        return Collection.class.isAssignableFrom(mp.getParameterType()); 
    }

    @Override
    public Collection<?> beforeBodyWrite(Collection<?> body, MethodParameter mp, MediaType mt, Class<? extends HttpMessageConverter<?>> type, ServerHttpRequest request, ServerHttpResponse response) {
        response.getHeaders().add("X-Total-Count", String.valueOf(body.size()));
        return body;        
    }
}