package med.voll.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		/**
		 * TODO
		 * 
		 * para arrumar o erro, criar tabela 
		 * 
		 * create database vollmed_api
		 * 
		 * depois subir migrations para alterar tabela medicos
		 *
		 */
	}

}
