package desafio.api.DTO;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProdutoRequest {

    @NotBlank
    @Size(min = 3, max = 50)
    private String nome;

    @NotNull
    @DecimalMin(value = "10.00", inclusive = true)
    private BigDecimal preco;

    @NotBlank
    @Size(min = 30, max = 255)
    private String descricao;


    private String imagem;
}