package app.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarroDTO {
    private Long id;
    private String nome;
    private int ano;
    private String marcaNome;
    private List<String> proprietariosNomes;
}
