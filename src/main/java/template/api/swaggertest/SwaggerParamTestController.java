package template.api.swaggertest;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/api/swaggerTest")
@RestController
public class SwaggerParamTestController {

    @Parameters({
            @Parameter(name = "query", description = "query parameter", in = ParameterIn.QUERY, required = true),
            @Parameter(name = "variable", description = "variable parameter", in = ParameterIn.PATH, required = false)
    })
    @GetMapping("/{variable}")
    public String swaggerTest(String query, @PathVariable String variable) {
        log.info("query : {}, variable : {}", query, variable);
        return "swagger-test";
    }

}
