package desafio.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;


@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @Column(length = 36)
    private UUID id;

    @Column(name = "nome", length = 50)
    @Size(min = 3, max = 50)
    @NotBlank
    String nome;

    @Column(name = "preco", nullable = false, precision = 10, scale = 2)
    @NotNull
    @DecimalMin(value = "10.00")
    private BigDecimal preco;

    @Column(name = "descricao", length = 255, nullable = false)
    @NotBlank
    @Size(min = 30, max = 255)
    private String descricao;

    @Column(name = "imagem")
    private String imagem;
}
