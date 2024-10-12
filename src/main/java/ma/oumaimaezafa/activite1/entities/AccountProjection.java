package ma.oumaimaezafa.activite1.entities;

import ma.oumaimaezafa.activite1.enums.TypeAccount;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = Compte.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public TypeAccount getTypeAccount();
    public Double getBalance();

}
