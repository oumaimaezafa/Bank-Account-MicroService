package ma.oumaimaezafa.activite1;

import ma.oumaimaezafa.activite1.entities.Compte;
import ma.oumaimaezafa.activite1.enums.TypeAccount;
import ma.oumaimaezafa.activite1.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class Activite1Application {

    public static void main(String[] args) {
        SpringApplication.run(Activite1Application.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            for(int i=1;i<=10;i++){
                Compte c=Compte.builder().
                        id(UUID.randomUUID().toString())
                        .typeAccount(Math.random()<0.5? TypeAccount.CURRENT_ACCOUNT : TypeAccount.SAVING_ACCOUNT)
                        .balance(Math.random()*56789)
                        .currency("EUR")
                        .createdAt(new Date())
                        .build();
                compteRepository.save(c);
            }
        };
    }
}
