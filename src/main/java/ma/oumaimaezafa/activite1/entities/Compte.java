package ma.oumaimaezafa.activite1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.oumaimaezafa.activite1.enums.TypeAccount;

import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Compte {
       @Id
       private String id ;
       private String currency;
       private Date createdAt;
       private Double balance;
       @Enumerated(EnumType.STRING)
       private TypeAccount typeAccount;
}
