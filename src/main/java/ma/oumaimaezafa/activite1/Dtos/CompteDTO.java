package ma.oumaimaezafa.activite1.Dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.oumaimaezafa.activite1.enums.TypeAccount;

@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class CompteDTO {
    private String id;
    private Double balance;
    private TypeAccount typeAccount;

}
