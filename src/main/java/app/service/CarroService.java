package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import app.dto.CarroDTO;
import app.entity.Carro;
import app.entity.Marca;
import app.entity.Proprietario;
import app.repository.CarroRepository;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public String save(Carro carro) {
        this.carroRepository.save(carro);
        return "Carro salvo com sucesso!";
    }

    public String update(Carro carro, long id) {
        carro.setId(id);
        this.carroRepository.save(carro);
        return "Carro atualizado com sucesso!";
    }

    public String delete(long id) {
        this.carroRepository.deleteById(id);
        return "Carro excluído com sucesso!";
    }

    public List<CarroDTO> findAll() {
        List<Carro> carros = this.carroRepository.findAllWithProprietarios();
        List<CarroDTO> list = new ArrayList<>();
        for (int i = 0; i < carros.size(); i++) {
            Carro c = carros.get(i);
            CarroDTO dto = new CarroDTO();
            dto.setId(c.getId());
            dto.setNome(c.getNome());
            dto.setAno(c.getAno());
            dto.setMarcaNome(c.getMarca().getNome());
            List<String> proprietariosNomes = new ArrayList<>();
            List<Proprietario> proprietarios = c.getProprietarios();
            for (int j = 0; j < proprietarios.size(); j++) {
                Proprietario p = proprietarios.get(j);
                proprietariosNomes.add(p.getNome());
            }
            dto.setProprietariosNomes(proprietariosNomes);
            list.add(dto);

        }
        return list;

    }

    public Carro findById(long id) {
        Carro carro = this.carroRepository.findById(id).orElse(null);
        return carro;
    }

    public List<CarroDTO> findByNome(String nome) {
        List<Carro> carros = this.carroRepository.findByNome(nome);
        List<CarroDTO> list = new ArrayList<>();

        for (int i = 0; i < carros.size(); i++) {
            Carro c = carros.get(i);
            CarroDTO dto = new CarroDTO();
            dto.setId(c.getId());
            dto.setNome(c.getNome());
            dto.setAno(c.getAno());
            dto.setMarcaNome(c.getMarca().getNome());
            List<String> proprietariosNomes = new ArrayList<>();
            List<Proprietario> proprietarios = c.getProprietarios();
            for (int j = 0; j < proprietarios.size(); j++) {
                Proprietario p = proprietarios.get(j);
                proprietariosNomes.add(p.getNome());
            }
            dto.setProprietariosNomes(proprietariosNomes);
            list.add(dto);

        }

        return list;
    }

    public List<CarroDTO> findByMarca(Long idMarca) {
        Marca marca = new Marca();
        marca.setId(idMarca);
        List<Carro> carros = this.carroRepository.findByMarca(marca);
        List<CarroDTO> list = new ArrayList<>();

        for (int i = 0; i < carros.size(); i++) {

            Carro c = carros.get(i);
            CarroDTO dto = new CarroDTO();

            dto.setId(c.getId());
            dto.setNome(c.getNome());
            dto.setAno(c.getAno());
            dto.setMarcaNome(c.getMarca().getNome());

            List<String> proprietariosNomes = new ArrayList<>();
            List<Proprietario> proprietarios = c.getProprietarios();

            for (int j = 0; j < proprietarios.size(); j++) {
                Proprietario p = proprietarios.get(j);
                proprietariosNomes.add(p.getNome());
            }

            dto.setProprietariosNomes(proprietariosNomes);
            list.add(dto);

        }

        return list;
    }

    public List<CarroDTO> findAcimaAno(int ano) {
        List<Carro> carros = this.carroRepository.findAcimaAno(ano);
        List<CarroDTO> list = new ArrayList<>();
        for (int i = 0; i < carros.size(); i++) {
            Carro c = carros.get(i);
            CarroDTO dto = new CarroDTO();
            dto.setId(c.getId());
            dto.setNome(c.getNome());
            dto.setAno(c.getAno());
            dto.setMarcaNome(c.getMarca().getNome());
            List<String> proprietariosNomes = new ArrayList<>();
            List<Proprietario> proprietarios = c.getProprietarios();
            for (int j = 0; j < proprietarios.size(); j++) {
                Proprietario p = proprietarios.get(j);
                proprietariosNomes.add(p.getNome());
            }
            dto.setProprietariosNomes(proprietariosNomes);
            list.add(dto);
        }
        return list;
    }

}
