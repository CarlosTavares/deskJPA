/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.facade;

import dra.controle.BairroControle;
import dra.controle.CidadeControle;
import dra.controle.EstadoCivilControle;
import dra.controle.EstadoControle;
import dra.controle.HabilidadeControle;
import dra.controle.PaisControle;
import dra.controle.PessoaControle;
import dra.model.Bairro;
import dra.model.Cidade;
import dra.model.Estado;
import dra.model.EstadoCivil;
import dra.model.Habilidade;
import dra.model.Pais;
import dra.model.Pessoa;
import dra.model.SexoEnum;
import dra.model.Telefone;
import dra.model.TipoFoneEnum;
import dra.util.JPAUtil;
import java.util.Calendar;
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
    private final PaisControle controlePais;
    private final HabilidadeControle controleHabilidade;
    private String nome;
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
    private List<EstadoCivil> estadosCivis;
    private List<Estado> estados;
    private List<Cidade> cidades;
    private List<Bairro> bairros;
    private List<Pais> paises;
    private List<Habilidade> habilidades;
    private Telefone telefone;
    private List<Telefone> telefones;

    public PessoaFacade() {
        this.em = new JPAUtil().getEntityManager();
        this.controle = new PessoaControle(em);
        this.controleEstadoCivil = new EstadoCivilControle(em);
        this.controleEstado = new EstadoControle(em);
        this.controleCidade = new CidadeControle(em);
        this.controleBairro = new BairroControle(em);
        this.controlePais = new PaisControle(em);
        this.controleHabilidade = new HabilidadeControle(em);
        this.listarEstadosCivis();
        this.listasPaises();
        this.listarHabilidades();
    }

    public void pesquisar() {
        if (this.nome.isEmpty()) {
            this.pessoas = this.controle.listarTodos();
        } else {
            this.pessoas = this.controle.listarPorNome(this.nome);
        }
    }

    public void consultar(int linha) {
        Pessoa aux = this.pessoas.get(linha);
        this.pessoa = this.controle.consultar(aux);
    }
    
    public Telefone consultarTelefone(int linha) {
        return this.pessoa.getTelefones().get(linha);
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
        if (this.pessoa.getID() == 0) {
            this.controle.inserir(this.pessoa);
        } else {
            this.controle.alterar(this.pessoa);
        }
    }
    
    public void addTelefone() {
        this.telefone.setPessoa(this.pessoa);
        this.pessoa.getTelefones().add(this.telefone);
        this.novoTelefone();
    }
    
    public void removeTelefone(Telefone telefone) {
        this.pessoa.getTelefones().remove(telefone);
    }
    
    public void novoTelefone() {
        this.telefone = new Telefone();
    }
    
    public void preencheDadosTelefone(String area, String numero, TipoFoneEnum tipo) {
        this.telefone.setArea(area);
        this.telefone.setNumero(numero);
        this.telefone.setTipoFone(tipo);
    }

    public void novaPessoa() {
        this.pessoa = new Pessoa();
    }

    public void fechar() {
        new JPAUtil().close(this.em);
    }

    public void preencheDadosPessoa(String nome, Calendar nascimento, SexoEnum sexo,
            EstadoCivil estadoCivil, String endereco, Bairro bairro, List<Habilidade> habilidades) {
        this.pessoa.setNome(nome);
        this.pessoa.setNascimento(nascimento);
        this.pessoa.setSexo(sexo);
        this.pessoa.setEstadoCivil(estadoCivil);
        this.pessoa.setEndereco(endereco);
        this.pessoa.setBairro(bairro);
        this.pessoa.setHabilidades(habilidades);
    }

    private void listarEstadosCivis() {
        this.estadosCivis = this.controleEstadoCivil.listarTodos();
    }

    private void listasPaises() {
        this.paises = this.controlePais.listarTodos();
    }

    private void listarHabilidades() {
        this.habilidades = this.controleHabilidade.listarTodos();
    }

    public void listarEstadosPorPais(Pais pais) {
        this.estados = this.controleEstado.listarPorPais(pais);
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

    public List<Pais> getPaises() {
        return paises;
    }

    public void setPaises(List<Pais> paises) {
        this.paises = paises;
    }

    public List<Habilidade> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidade> habilidades) {
        this.habilidades = habilidades;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }
}
