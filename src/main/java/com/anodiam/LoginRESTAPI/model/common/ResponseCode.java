package com.anodiam.LoginRESTAPI.model.common;

public enum ResponseCode {
    SUCCESS(0, "SUCCESS: Microsvc002: Student Login: Student login successful: "),
    FAILURE(1, "ERR: Microsvc002: Student Login: Failure with exception message: "),
    USER_EXISTS(3, "Microsvc002: Student Login: Username / Email exists: "),
    USER_NOT_REGISTERED(4, "ERR: Microsvc002: Student Login: Username/Email NOT registered: "),
    ROLE_NAME_EXISTS(100, "Microsvc002: Student Login: Role name exists: "),
    ROLE_NAME_INVALID(101, "ERR: Microsvc002: Student Login: Role name INVALID: "),
    PERMISSION_NAME_EXISTS(200, "Microsvc002: Student Login: Permission name exists: "),
    PERMISSION_NAME_INVALID(201, "ERR: Microsvc002: Student Login: Permission name INVALID: ");

    private Integer id;
    private String message;

    ResponseCode(Integer id, String message){
        this.id = id;
        this.message=message;
    }

    public Integer getID(){
        return id;
    }
    public String getMessage() {return message;}
}