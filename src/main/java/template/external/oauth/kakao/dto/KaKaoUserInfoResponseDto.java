package template.external.oauth.kakao.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

public class KaKaoUserInfoResponseDto {

    private String id;

    @JsonProperty("kakao_account")
    private KaKaoAccount kaKaoAccount;

    @Getter
    @Setter
    private static class KaKaoAccount {

        private String email;
        private Profile profile;

        @Getter
        @Setter
        private static class Profile {
            private String nickname;
            @JsonProperty("thumbnail_image_url")
            private String thumbnailImageUrl;
        }
    }


}
