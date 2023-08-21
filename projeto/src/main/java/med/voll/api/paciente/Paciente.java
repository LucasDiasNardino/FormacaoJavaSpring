package med.voll.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.endereco.Endereco;

@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Paciente")
@Table(name = "pacientes")
public class Paciente {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;
    private String email;
    private String cpf;
    private String telefone;


    @Embedded
    private Endereco endereco;

    private Boolean ativo;

    public Paciente(DadosCadastroPaciente dadosCadastroPaciente) {
        this.ativo = true;
        this.nome = dadosCadastroPaciente.nome();
        this.email = dadosCadastroPaciente.email();
        this.cpf = dadosCadastroPaciente.cpf();
        this.telefone = dadosCadastroPaciente.telefone();
        this.endereco = new Endereco(dadosCadastroPaciente.endereco());
    }

    public void atualizarPaciente(DadosAtualizacaoPaciente dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if(dados.email() != null){
            this.email = dados.email();
        }

        if(dados.cpf() != null){
            this.cpf = dados.cpf();
        }

        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }

        if(dados.endereco() != null){
            this.endereco.atualizarEndereco(dados.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}