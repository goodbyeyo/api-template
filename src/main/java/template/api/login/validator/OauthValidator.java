package template.api.login.validator;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import template.global.error.ErrorCode;
import template.global.error.exception.AuthenticationException;
import template.global.jwt.constant.GrantType;

@Service
public class OauthValidator {

    public void validateAuthorization(String authorizationHeader) {
        // 1. authorizationHeader 필수 체크
        if (!StringUtils.hasText(authorizationHeader)) {
            throw new AuthenticationException(ErrorCode.NOT_EXIST_AUTHORIZATION);
        }

        // 2. authorizationHeader Bearer 체크
        String[] authorizations = authorizationHeader.split(" ");
        if (authorizations.length < 2 || !GrantType.BEARER.getType().equals(authorizations[0])) {
            throw new AuthenticationException(ErrorCode.NOT_VALID_BEARER_GRANT_TYPE);
        }
    }

    public void validateMemberType(String memberType) {
        if (!StringUtils.hasText(memberType)) {
            throw new AuthenticationException(ErrorCode.INVALID_MEMBER_TYPE);
        }
    }


}
