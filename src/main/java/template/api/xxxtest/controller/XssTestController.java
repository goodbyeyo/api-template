package template.api.xxxtest.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import template.api.xxxtest.dto.XssTestDto;

import java.awt.*;

@RestController
@RequestMapping("xss")
public class XssTestController {

    @RequestMapping("/test1")
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public XssTestDto xssTest1(XssTestDto xssTestDto) {
        return xssTestDto;
    }

    @RequestMapping("/test2")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public XssTestDto xssTest2(@RequestBody XssTestDto xssTestDto) {
        return xssTestDto;
    }
}
