package app.entity;

import lombok.*;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do carro é obrigatório")
    private String nome;
    @NotNull(message = "O ano é obrigatório")
    private int ano;

    @ManyToOne(cascade = CascadeType.ALL)
    private Marca marca;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "carro_proprietario")
    private List<Proprietario> proprietarios;

}
