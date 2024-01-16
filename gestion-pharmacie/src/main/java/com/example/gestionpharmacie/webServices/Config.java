package com.example.gestionpharmacie.webServices;

import com.example.gestionpharmacie.metier.MedicamentService;
import com.example.gestionpharmacie.web.ControllerImpl.MedicamentEndpoint;
import jakarta.xml.ws.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;


@Configuration
@EnableWs
public class Config {
    @Bean
    public Endpoint endpoint(MedicamentService medicamentService) {
        Endpoint endpoint = Endpoint.publish("http://0.0.0.0:8087/",new MedicamentEndpoint(medicamentService));
        return endpoint;
    }

}

