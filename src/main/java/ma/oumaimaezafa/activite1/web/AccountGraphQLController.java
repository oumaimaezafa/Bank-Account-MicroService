package ma.oumaimaezafa.activite1.web;


import ma.oumaimaezafa.activite1.Dtos.CompteDTO;
import ma.oumaimaezafa.activite1.entities.Compte;
import ma.oumaimaezafa.activite1.repositories.CompteRepository;
import ma.oumaimaezafa.activite1.services.AccountService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQLController {


    private AccountService accountService;
    private CompteRepository compteRepository;

    public AccountGraphQLController(AccountService accountService, CompteRepository compteRepository) {
        this.accountService = accountService;
        this.compteRepository = compteRepository;
    }


    @QueryMapping
    public List<Compte> accountList(){
        return  compteRepository.findAll();
    }

    @QueryMapping
    public CompteDTO compteDTOById(@Argument String id){
        return accountService.getAccount(id);
    }

    public  CompteDTO saveAccount(@Argument CompteDTO compte){
        return  accountService.saveAccount(compte);
    }

}
