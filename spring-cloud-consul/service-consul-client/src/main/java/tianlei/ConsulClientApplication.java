package tianlei;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ConsulClientApplication {

    @GetMapping("/test")
    public String test() {

        return "success";
    }

    public static void main(String[] args) {

        SpringApplication.run(ConsulClientApplication.class);

    }

}
