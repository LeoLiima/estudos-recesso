package desafio.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;


@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 50)
    @Size(min = 3, max = 50)
    @NotBlank
    String nome;

    @Column(name = "preco", nullable = false, scale = 2)
    @NotNull
    @DecimalMin(value = "10.00", inclusive = true)
    private Double preco;


    @Column(name = "Descricao", length = 255)
    @NotBlank
    @Size(min = 30, max = 255)
    String descricao;

    @Column(name = "imagemUrl")
    String imagemUrl;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}
