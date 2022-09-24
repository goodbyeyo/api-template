package template.global.error;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {
    TEST(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Business Exception Test"),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A001", "token is expired"),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A002","token is invalid");
    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
