package cc.notsoclever.examples.cxf.wsdlfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(value = "classpath:META-INF/spring/camel-client-context.xml")
public class myApplication {

    public static void main(String[] args) {
        SpringApplication.run(myApplication.class, args);
    }
}
