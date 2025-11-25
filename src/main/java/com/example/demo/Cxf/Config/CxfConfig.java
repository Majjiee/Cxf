package com.example.demo.Cxf.Config;


import com.example.demo.Cxf.ws.CompteSoapService;

import jakarta.xml.ws.Endpoint;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {

    @Autowired
    private Bus bus;

    @Autowired
    private CompteSoapService compteSoapService;

    @Bean
    public Endpoint compteEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, compteSoapService);
        endpoint.publish("/banque");  // Only publish path, no serviceName
        return endpoint;
    }
}

