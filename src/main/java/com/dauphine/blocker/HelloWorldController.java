package com.dauphine.blocker;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Tag(name = "Hello World API",
        description = "API to say hello world"
)
public class HelloWorldController {

    @GetMapping("/hello world")
    @Operation(summary = "Say hello world endpoint",
    description = "Say hello world")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/hello{name}")
    @Operation(summary = "Hello by name endpoint",
    description = "Return Hello {name} by path variable")
    public String sayHelloName(@Parameter (description = "Name to greet") @PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/hello")
    @Operation(summary = "Return Hello name with a request for the name")
    public String Hello(@Parameter (description = "Name to greet")  @RequestParam String name) {
        return "Hello " + name;
    }
}
