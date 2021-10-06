package org.openapitools.client.exception;

public class APIException extends Exception {

    public APIException(String message) {
        super(message);
    }

    public APIException(String message, Exception exp) {
        super(message, exp);
    }

}
