package template.api.exceptiontest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import template.api.exceptiontest.dto.BindExceptionTestDto;
import template.api.exceptiontest.dto.TestEnum;
import template.global.error.ErrorCode;
import template.global.error.exception.BusinessException;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/exception")
@RequiredArgsConstructor
public class ExceptionTestController {

    @GetMapping("/bind-exception-test")
    public String bindExceptionTest(@Valid BindExceptionTestDto bindExceptionTestDto) {
        return "ok";
    }

    @GetMapping("/type-exception-test")
    public String typeMismatchException(TestEnum testEnum) {
        return "ok";
    }

    @GetMapping("/bisiness-exception-test")
    public String bisinessException(String isError) {
        if ("true".equals(isError)) {
            throw new BusinessException(ErrorCode.TEST);
        }
        return "ok";
    }

    @GetMapping("/exception-test")
    public String exceptionTest(String isError) {
        if("true".equals(isError)) {
            throw new IllegalArgumentException("Exception Test");
        }
        return "ok";
    }
}
