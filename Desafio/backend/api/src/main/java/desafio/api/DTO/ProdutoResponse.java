package desafio.api.DTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ProdutoResponse {

    private String nome;
    private Double preco;
    private String descricao;
    private String imagemUrl;
}