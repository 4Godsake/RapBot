package com.rapdog.rapbot.exception;

public class RapBotBaseException extends RuntimeException{

    /**
     * 异常代码
     */
    private int code;

    public RapBotBaseException(String message) {
        super(message);
    }

    public RapBotBaseException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
