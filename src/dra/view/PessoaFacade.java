/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view;

import dra.controle.BairroControle;
import dra.controle.CidadeControle;
import dra.controle.EstadoCivilControle;
import dra.controle.EstadoControle;
import dra.controle.PessoaControle;
import dra.model.Bairro;
import dra.model.Cidade;
import dra.model.Estado;
import dra.model.EstadoCivil;
import dra.model.Pessoa;
import dra.util.JPAUtil;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Carlos.Tavares
 */
public class PessoaFacade {
    
    private final EntityManager em;
    private final PessoaControle controle;
    private final EstadoCivilControle controleEstadoCivil;
    private final EstadoControle controleEstado;
    private final CidadeControle controleCidade;
    private final BairroControle controleBairro;
    private String nome;
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private List<EstadoCivil> estadosCivis;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private List<Bairro> bairros;

    public PessoaFacade() {
        this.em = new JPAUtil().getEntityManager();
        this.controle = new PessoaControle(em);
        this.controleEstadoCivil = new EstadoCivilControle(em);
        this.controleEstado = new EstadoControle(em);
        this.controleCidade = new CidadeControle(em);
        this.controleBairro = new BairroControle(em);
        this.listarEstadosCivis();
        this.listarEstados();
    }
    
    public void pesquisar() {
        if (this.nome.isEmpty()) {
            this.pessoas = this.controle.listarTodos();
        } else {
            this.pessoas = this.controle.listarPorNome(this.nome);
        }
    }
    
    public void consultar(Long id) {
        Pessoa aux = new Pessoa();
        aux.setID(id);
        this.pessoa = this.controle.consultar(aux);
    }
    
    public void detalhar(String nome) {
        this.novaPessoa();
        for (Pessoa p : this.pessoas) {
            if (nome.equalsIgnoreCase(p.getNome())) {
                this.pessoa = p;
                break;
            }
        }
    }
    
    public void excluir() {
        this.controle.remover(this.pessoa);
    }

    public void salvar() {
        if (this.pessoa.getID()==0) {
            this.controle.inserir(this.pessoa);
        } else {
            this.controle.alterar(this.pessoa);
        }
    }
    
    private void novaPessoa() {
        this.pessoa = new Pessoa();
    }
    
    private void listarEstadosCivis() {
        this.estadosCivis = this.controleEstadoCivil.listarTodos();
    }
    
    private void listarEstados() {
        this.estados = this.controleEstado.listarTodos();
    }
    
    public void listarCidadesPorEstado(Estado estado) {
        this.cidades = this.controleCidade.listarPorEstado(estado);
    }
    
    public void listarBairrosPorCidade(Cidade cidade) {
        this.bairros = this.controleBairro.listarPorCidade(cidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public List<EstadoCivil> getEstadosCivis() {
        return estadosCivis;
    }

    public void setEstadosCivis(List<EstadoCivil> estadosCivis) {
        this.estadosCivis = estadosCivis;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

    public List<Bairro> getBairros() {
        return bairros;
    }

    public void setBairros(List<Bairro> bairros) {
        this.bairros = bairros;
    }
}
