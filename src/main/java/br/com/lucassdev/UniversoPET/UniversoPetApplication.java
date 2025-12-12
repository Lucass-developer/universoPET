package br.com.lucassdev.UniversoPET;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversoPetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UniversoPetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MainTestes main = new MainTestes();
		main.teste();
	}

}
