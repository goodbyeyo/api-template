package template.global.error.exception;

import template.global.error.ErrorCode;

public class EntityNotFoundException extends BusinessException{

    public EntityNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
