
import dra.controle.PessoaControle;
import dra.model.Bairro;
import dra.model.Estado;
import dra.model.EstadoCivil;
import dra.model.Pessoa;
import dra.model.SexoEnum;
import dra.util.JPAUtil;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos.Tavares
 */
public class Testes {

    public static void main(String[] args) {
        
        EntityManager em = new JPAUtil().getEntityManager();
        PessoaControle controle1 = new PessoaControle(em);
        /* CADASTRAR 
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Carlos Santos");
        Calendar data = new GregorianCalendar();
        data.set(Calendar.YEAR, 1970);
        data.set(Calendar.MONTH, 03);
        data.set(Calendar.DAY_OF_MONTH, 29);
        pessoa.setNascimento(data);
        EstadoCivil estadoCivil = new EstadoCivil();
        estadoCivil.setID(2);
        pessoa.setEstadoCivil(estadoCivil);
        pessoa.setSexo(SexoEnum.MASCULINO);
        pessoa.setEndereco("Rua Rayol dos Santos, 02");
        Bairro cidadenova = new Bairro();
        cidadenova.setID(9);
        pessoa.setBairro(cidadenova);
        controle1.inserir(pessoa);
        */
        /* PESQUISAR POR NOME */
        List<Pessoa> pessoas = controle1.listarPorNome("");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }
        
        /* PESQUISAR TODOS
        List<Pessoa> pessoas = controle1.listarTodos();
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.getNome());
        }
        */
        /* CONSULTAR
        Pessoa aux = new Pessoa();
        aux.setID(1);
        Pessoa pessoa = controle1.consultar(aux);
        System.out.println(pessoa.getNome());
        */
        /* ALTERAR
        Pessoa aux = new Pessoa();
        aux.setID(1);
        Pessoa pessoa = controle1.consultar(aux);
        System.out.println(pessoa.getNome());
        pessoa.setNome("Carlos Tavares");
        controle1.alterar(pessoa);
        */
        /* REMOVER
        Pessoa aux = new Pessoa();
        aux.setID(1);
        Pessoa pessoa = controle1.consultar(aux);
        controle1.remover(pessoa);
        */
        
    }
}
