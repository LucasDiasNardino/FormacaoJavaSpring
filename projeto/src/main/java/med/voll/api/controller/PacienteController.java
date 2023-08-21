package med.voll.api.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosDetalhamentoPaciente;
import med.voll.api.paciente.PacienteRepository;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.DadosAtualizacaoPaciente;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    
    @PostMapping
    @Transactional
    public ResponseEntity cadastrarPaciente(@RequestBody DadosCadastroPaciente payload, UriComponentsBuilder uriBuilder){
        var paciente = new Paciente(payload);

        repository.save(paciente);

        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosListagemPaciente(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listarPacientes(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);

        return ResponseEntity.ok(page);
    }
    

    @PutMapping
    @Transactional
    public ResponseEntity atualizaPaciente(@RequestBody DadosAtualizacaoPaciente payload){
        var paciente = repository.getReferenceById(payload.id());
        paciente.atualizarPaciente(payload);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoPaciente(paciente));
    }
}
