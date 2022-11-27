package com.example.brestaskk.enums;

public enum ExceptionEnum {

    USER_NOT_FOUND(401,"User can not find with given id"),
    TYPE_NOT_FOUND(411,"Type not found!"),
    ACCOUNT_NOT_FOUND(412,"Account not found with given id"),
    CARD_NOT_FOUND(413,"Card not found with this id!"),
    BALANCE_NOT_FOUND(414,"The balance of the card cannot exceed the account"),

    VALIDATION(402,"Validation error"),

    INPUT(406,"ID cannot be null and string.Please enter number"),

    UNKNOWN(403,"Unknown error"),

    SUCCESS(200,"Success"),

    ERROR(500,"Something went wrong"),

    EMPTY(405,"Users are not exist yet"),
    BAD_REQUEST(406,"Bad request.Cannot send empty data");

    private final String message;

    private final int code;

    ExceptionEnum(int code, String message) {
        this.message=message;
        this.code=code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
