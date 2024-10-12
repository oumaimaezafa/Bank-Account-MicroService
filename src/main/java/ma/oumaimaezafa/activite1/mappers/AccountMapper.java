package ma.oumaimaezafa.activite1.mappers;


import ma.oumaimaezafa.activite1.Dtos.CompteDTO;
import ma.oumaimaezafa.activite1.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {


    public CompteDTO  fromCompte (Compte compte){
        CompteDTO compteDTO=new CompteDTO();
        BeanUtils.copyProperties(compte,compteDTO);
        return compteDTO;
    }

    public Compte fromDTO(CompteDTO compteDTO){
        Compte compte=new Compte();
        BeanUtils.copyProperties(compteDTO,compte);
        return compte;
    }

}
