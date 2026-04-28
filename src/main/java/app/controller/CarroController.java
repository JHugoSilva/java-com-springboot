package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import app.dto.CarroDTO;
import app.entity.Carro;
import app.service.CarroService;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/save")
    public ResponseEntity<String> save(@Valid @RequestBody Carro carro) {
        try {
            return new ResponseEntity<>(carroService.save(carro), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@Valid @RequestBody Carro carro, @PathVariable long id) {
        try {
            return ResponseEntity.ok(carroService.update(carro, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao atualizar");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        try {
            return ResponseEntity.ok(carroService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao deletar");
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CarroDTO>> findAll() {
        List<CarroDTO> lista = carroService.findAll();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Carro> findById(@PathVariable long id) {
        try {
            return ResponseEntity.ok(carroService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/findByNome")
    public ResponseEntity<?> findByNome(@RequestParam String nome) {
        try {
            List<CarroDTO> lista = this.carroService.findByNome(nome);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<?> findByMarca(@RequestParam long idMarca) {
        try {
            List<CarroDTO> lista = this.carroService.findByMarca(idMarca);
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findAcimaAno")
    public ResponseEntity<?> findAcimaAno(@RequestParam int ano) {
        try {
            List<CarroDTO> carros = this.carroService.findAcimaAno(ano);
            return new ResponseEntity<>(carros, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}