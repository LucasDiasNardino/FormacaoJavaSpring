package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.PacienteRepository;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.DadosListagemPaciente;


@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;
    
    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente payload){
        repository.save(new Paciente(payload));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(@PageableDefault(size=10, sort={"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
    
}
