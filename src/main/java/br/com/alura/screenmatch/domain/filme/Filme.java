package br.com.alura.screenmatch.domain.filme;

import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Integer duracaoEmMinutos;
    private Integer anoLancamento;
    private String genero;

    public Filme(DadosCadastraFilme dadosCadastraFilme) {
        this.nome = dadosCadastraFilme.nome();
        this.duracaoEmMinutos = dadosCadastraFilme.duracaoEmMinutos();
        this.anoLancamento = dadosCadastraFilme.anoLancamento();
        this.genero = dadosCadastraFilme.genero();
    }

    public Filme() {}

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", anoLancamento=" + anoLancamento +
                ", genero='" + genero + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void atualizaDados(DadosAlteracaoFilme dadosAlteracaoFilme) {
        this.nome = dadosAlteracaoFilme.nome();
        this.duracaoEmMinutos = dadosAlteracaoFilme.duracaoEmMinutos();
        this.anoLancamento = dadosAlteracaoFilme.anoLancamento();
        this.genero = dadosAlteracaoFilme.genero();
    }
}
