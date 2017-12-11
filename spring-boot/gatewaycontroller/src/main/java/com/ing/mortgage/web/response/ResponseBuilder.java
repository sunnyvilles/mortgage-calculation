package com.ing.mortgage.web.response;

public class ResponseBuilder {

    public static ResponseEntity buildSucessResponse(Object response) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setStatus(ResponseStatus.SUCCESS);
        responseEntity.setData(response);
        return responseEntity;
    }

    public static ResponseEntity buildErrorResponse(String error) {
        ResponseEntity responseEntity = new ResponseEntity();
        responseEntity.setStatus(ResponseStatus.ERROR);
        responseEntity.setError(error);
        return responseEntity;
    }
}
