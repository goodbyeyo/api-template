package template.api.health.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class HealthCheckResponseDto {
    private String health;
    private List<String> activeProfiles;

    @Builder
    public HealthCheckResponseDto(String health, List<String> activeProfiles) {
        this.health = health;
        this.activeProfiles = activeProfiles;
    }
}
