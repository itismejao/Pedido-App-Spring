package com.example.PedidoAppSpring;

import com.example.PedidoAppSpring.model.Cliente;
import com.example.PedidoAppSpring.model.ClienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PedidoAppSpringApplication {
   

	public static void main(String[] args) {

            SpringApplication.run(PedidoAppSpringApplication.class, args);
	}
        
        @Bean
        CommandLineRunner init(ClienteRepository clienteRepository){
            return args ->{
                //clienteRepository.deleteAll();
                //Cliente c = new Cliente("123","Teste Spring","Endereço Spring","email@spring");
                //clienteRepository.save(c);
                //System.out.println(c);
            };
        }

}
