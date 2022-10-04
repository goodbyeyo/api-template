package template.global.config;

import io.swagger.models.SecurityScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import template.global.resolver.memberinfo.MemberInfo;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()   //APISelectorBuilder 생성
                .apis(RequestHandlerSelectors.basePackage("template")) // API package path TODO
                // .paths(PathSelectors.any()) // 모든 API URI 에 대해서 문서화
                .paths(PathSelectors.ant("/api/**")) // API URI 문서화 조건 pattern // TODO
                .build()
                .apiInfo(apiInfo()) // API 문서에 대한 정보 추가
                .useDefaultResponseMessages(false) // swagger 제공 기본 응답코드 설명 제거(400, 403, 404 display off)
                .securityContexts(List.of(securityContext()))
                .securitySchemes(List.of(apiKey()))
                .ignoredParameterTypes(MemberInfo.class);   // token -> resolver 입력 : 파라미터 받는것 아님 -> 무시 설정
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("api documentation")
                .description("api documentation for spring template project")
                .version("1.1")
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return List.of(new SecurityReference("Authorization", authorizationScopes));
//        return Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }

    private ApiKey apiKey() {
        return new ApiKey("Authorization", "Authorization", "header");
    }

}
