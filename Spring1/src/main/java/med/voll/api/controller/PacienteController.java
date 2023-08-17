package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.PacienteRepository;
import med.voll.api.paciente.Paciente;

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
}
