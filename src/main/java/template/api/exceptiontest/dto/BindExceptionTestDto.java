package template.api.exceptiontest.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@Builder
public class BindExceptionTestDto {
    @NotBlank(message = "해당값은 필수 입력값입니다")
    private String value1;

    @Max(value = 10, message = "최대 입력값은 10입니다")
    private Integer value2;
}
