/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view.tabela;

import dra.model.Pessoa;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos.Tavares
 */
public class PessoaTabela extends AbstractTableModel {
    
    private final List<Pessoa> pessoas;

    public PessoaTabela(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    @Override
    public int getRowCount() {
        return this.pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pessoa pessoa = this.pessoas.get(rowIndex);
        switch(columnIndex) {
            case 0: return pessoa.getNome();
            case 1: return pessoa.getNascimento();
            case 2: return pessoa.getBairro().getCidade();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "Nome";
            case 1: return "Nascimento";
            case 2: return "Cidade";
        }
        return null;
    }
    
}
