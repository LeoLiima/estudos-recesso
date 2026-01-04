package desafio.api.DTO;
import lombok.*;


import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoResponse {

    private UUID id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String imagem;
}