package com.rapdog.rapbot.exception;

/**
 * @author renzx
 */
public class InvalidParamException extends RapBotBaseException {

    private static final int INVALID_PARAM_CODE = 50001;

    public InvalidParamException(String message) {
        super(INVALID_PARAM_CODE,message);
    }
}
