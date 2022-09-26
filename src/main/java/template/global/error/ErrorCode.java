package template.global.error;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {
    TEST(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Business Exception Test"),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A001", "token is expired"),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A002","token is invalid"),
    NOT_EXIST_AUTHORIZATION(HttpStatus.UNAUTHORIZED, "A003", "Authorization Header is empty"),
    NOT_VALID_BEARER_GRANT_TYPE(HttpStatus.UNAUTHORIZED, "A004", "valid type is not bearer type"),
    INVALID_MEMBER_TYPE(HttpStatus.BAD_REQUEST, "M001", "Invalid Member Type(member type : KaKaO");
    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
