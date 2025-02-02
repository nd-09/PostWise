package com.user.postwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    int status;
    String message;
    Object data;
}
