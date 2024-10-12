package ma.oumaimaezafa.activite1.services;

import ma.oumaimaezafa.activite1.Dtos.CompteDTO;
import ma.oumaimaezafa.activite1.entities.Compte;
import ma.oumaimaezafa.activite1.enums.TypeAccount;
import ma.oumaimaezafa.activite1.mappers.AccountMapper;
import ma.oumaimaezafa.activite1.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;
@Service
@Transactional
public class AccountServiceImpl implements  AccountService{


    private CompteRepository compteRepository;
    @Autowired
    private AccountMapper accountMapper;

    public AccountServiceImpl(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public CompteDTO saveAccount(CompteDTO c) {
        Compte compte=Compte.builder().
        id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .typeAccount(c.getTypeAccount())
                .balance(c.getBalance())
                .build();
        Compte savedAccount=compteRepository.save(compte);
        return accountMapper.fromCompte(savedAccount);
    }

    @Override
    public CompteDTO getAccount(String id) {
        Compte  compte=
        compteRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not Found !! ",id)));
        return accountMapper.fromCompte(compte);//return DTO
    }

    @Override
    public CompteDTO updateAccount(String id, CompteDTO compte) {
        Compte c=compteRepository.findById(id).orElseThrow();
        if(compte.getBalance()!=null) c.setBalance(compte.getBalance());
        if(compte.getTypeAccount()!=null) c.setTypeAccount(compte.getTypeAccount());
        Compte updatedAccount=compteRepository.save(c);
        return accountMapper.fromCompte(updatedAccount);
    }


}
