package template.api.health.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class HealthCheckResponseDto {
    @Schema(description = "서버 Health 상태", example = "ok", required = true)
    private String health;
    @Schema(description = "현재 실행 중인 profile", example = "[dev]", required = true)
    private List<String> activeProfiles;

    @Builder
    public HealthCheckResponseDto(String health, List<String> activeProfiles) {
        this.health = health;
        this.activeProfiles = activeProfiles;
    }
}
