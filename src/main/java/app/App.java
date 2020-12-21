package app;

import com.fasterxml.jackson.databind.Module;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    @Bean
    Module vavrModule() {
        return new VavrModule();
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
