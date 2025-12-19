package desafio.api.DTO;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
public class ProdutoRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    @DecimalMin(value = "10.00", inclusive = true)
    private Double preco;

    @NotBlank
    @Size(min = 30, max = 255)
    private String descricao;


    private String imagemUrl;
}