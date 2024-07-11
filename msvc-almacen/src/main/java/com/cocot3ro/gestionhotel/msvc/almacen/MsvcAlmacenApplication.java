package com.cocot3ro.gestionhotel.msvc.almacen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsvcAlmacenApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsvcAlmacenApplication.class, args);
    }

}
