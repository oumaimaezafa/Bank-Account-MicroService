package ma.oumaimaezafa.activite1.web;


import ma.oumaimaezafa.activite1.Dtos.CompteDTO;
import ma.oumaimaezafa.activite1.entities.Compte;
import ma.oumaimaezafa.activite1.repositories.CompteRepository;
import ma.oumaimaezafa.activite1.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private CompteRepository compteRepository;



    @GetMapping("/accounts")
    public List<Compte> compteList(){
        return compteRepository.findAll();
    }


    @PostMapping("/accounts")
    public CompteDTO saveAccount(@RequestBody CompteDTO compte){
           return accountService.saveAccount(compte);

    }

    @GetMapping("/accounts/{id}")
    public CompteDTO getAccount(@PathVariable  String id ){
        return accountService.getAccount(id);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount (@PathVariable String id){
         compteRepository.deleteById(id);
    }

    @PutMapping("/accounts/{id}")
    public CompteDTO updateAccount( @PathVariable  String id, @RequestBody CompteDTO compte){
          return  accountService.updateAccount(id,compte);
    }



}
