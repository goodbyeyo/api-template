package template.api.login.validator;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import template.global.error.ErrorCode;
import template.global.error.exception.AuthenticationException;
import template.global.jwt.constant.GrantType;

@Service
public class OauthValidator {

    public void validateMemberType(String memberType) {
        if (!StringUtils.hasText(memberType)) {
            throw new AuthenticationException(ErrorCode.INVALID_MEMBER_TYPE);
        }
    }


}
