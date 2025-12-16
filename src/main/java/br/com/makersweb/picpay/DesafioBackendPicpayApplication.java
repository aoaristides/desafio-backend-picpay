package br.com.makersweb.picpay;

import br.com.makersweb.picpay.infrastructure.configuration.WebServerConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioBackendPicpayApplication {

    private static final Logger LOG = LoggerFactory.getLogger(DesafioBackendPicpayApplication.class);

    public static void main(String[] args) {
        LOG.info("[step:to-be-init] [id:1] Inicializando o Spring");
        SpringApplication.run(WebServerConfig.class, args);
        LOG.info("[step:inittialized] [id:2] Spring inicializado..");
    }

}
