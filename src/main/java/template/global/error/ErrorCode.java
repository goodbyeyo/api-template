package template.global.error;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@ToString
public enum ErrorCode {
    TEST(HttpStatus.INTERNAL_SERVER_ERROR, "001", "Business Exception Test"),

    // 인증 & 인가
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED, "A001", "token is expired"),
    NOT_VALID_TOKEN(HttpStatus.UNAUTHORIZED, "A002","token is invalid"),
    NOT_EXIST_AUTHORIZATION(HttpStatus.UNAUTHORIZED, "A003", "Authorization Header is empty"),
    NOT_VALID_BEARER_GRANT_TYPE(HttpStatus.UNAUTHORIZED, "A004", "valid type is not bearer type"),
    REFRESH_TOKEN_NOT_FOUND(HttpStatus.UNAUTHORIZED,"A005", "this refresh token is not exist"),
    REFRESH_TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED,"A006", "this refresh token is expired"),
    NOT_ACCESS_TOKEN_TYPE(HttpStatus.UNAUTHORIZED, "A007", "this is not access token type"),
    FORBIDDEN_ADMIN(HttpStatus.FORBIDDEN, "A008" ,"You are not admin role"),

    // 회원
    INVALID_MEMBER_TYPE(HttpStatus.BAD_REQUEST, "M001", "Invalid Member Type(member type : KaKaO"),
    ALREADY_REGISTERED_MEMBER(HttpStatus.BAD_REQUEST, "M002", "memberId is already registered"),
    MEMBER_NOT_EXIST(HttpStatus.BAD_REQUEST, "M003", "member is not exist");

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }
}
