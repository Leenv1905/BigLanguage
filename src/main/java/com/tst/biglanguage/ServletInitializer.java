package com.tst.biglanguage;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BigLanguageApplication.class);
    }
    @RestController
    public class HelloController {

        @GetMapping("/hello")
        public String sayHello() {
            return "Hello BigLanguageApplication";
        }
    }


}
