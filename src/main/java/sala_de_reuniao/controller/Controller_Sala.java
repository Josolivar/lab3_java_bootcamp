package sala_de_reuniao.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sala_de_reuniao.exception.ResourceNotFoundException;
import sala_de_reuniao.model.Sala;
import sala_de_reuniao.repository.Repository_Sala;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class Controller_Sala {

    @Autowired
    private Repository_Sala repository_sala;

    @GetMapping("/salas")
    public List<Sala> getAllSalas() {
        return repository_sala.findAll();
    }

    @GetMapping("salas/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable(value = "id") long idDaSala) throws ResourceNotFoundException {
        return ResponseEntity.ok().body(
                repository_sala.findById(idDaSala)
                                         .orElseThrow(
                                                 () -> new ResourceNotFoundException("Sala não encontrada :: " + idDaSala)
                                         )
        );
    }

    @PostMapping("/salas")
    public Sala criaSala(@Valid @RequestBody Sala novaSala) {
        return repository_sala.save(novaSala);
    }

    @PutMapping("/salas/{id}")
    public ResponseEntity<Sala> atualizaSala(@PathVariable(value = "id") long idDaSala,
                                             @Valid @RequestBody Sala sala) throws ResourceNotFoundException {
        Sala salaParaAtualizar = repository_sala.findById(idDaSala)
                        .orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada :: " + idDaSala));
        salaParaAtualizar.setNomeDaSala(sala.getNomeDaSala());
        salaParaAtualizar.setDataDaReserva(sala.getDataDaReserva());
        salaParaAtualizar.setHorarioInicio(sala.getHorarioInicio());
        salaParaAtualizar.setHorarioFinal(sala.getHorarioFinal());
        return ResponseEntity.ok().body(repository_sala.save(salaParaAtualizar));
    }

    @DeleteMapping("/salas/{id}")
    public Map<String,Boolean> deletaSala(@PathVariable(value = "id") long idDaSala) throws ResourceNotFoundException {
        Sala salaParaDeletar = repository_sala.findById(idDaSala).orElseThrow(
                () -> new ResourceNotFoundException("Sala não encontrada :: " + idDaSala));
        repository_sala.delete(salaParaDeletar);
        Map<String,Boolean> resposta = new HashMap<>().;
        resposta.put("deletado", Boolean.TRUE);
        return resposta;
    }
}