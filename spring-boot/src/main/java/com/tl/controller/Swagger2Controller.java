package com.tl.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Swagger-api", description = "接口示例")
@RestController("mySwagger2Controller")
@RequestMapping("/api")
public class Swagger2Controller {

    //    http://localhost:8080/swagger-ui.html
    @ApiOperation(value = "swagger 接口", notes = "这是注释")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "name", value = "字段的描述", defaultValue = "tianlei",required = true, dataType = "String"
            )
    )
    @GetMapping("/swagger")
    public String swagger(String name) {

        return name;
    }
}
