package ma.oumaimaezafa.activite1.services;

import ma.oumaimaezafa.activite1.Dtos.CompteDTO;
import ma.oumaimaezafa.activite1.entities.Compte;
import org.springframework.stereotype.Service;

public interface AccountService {

    public CompteDTO saveAccount(CompteDTO c);
    public CompteDTO getAccount(String id);
    CompteDTO updateAccount(String id, CompteDTO compte);
}
