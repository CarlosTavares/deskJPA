/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view.tabela;

import dra.model.Telefone;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos.Tavares
 */
public class TelefoneTabela extends AbstractTableModel {
    
    private final List<Telefone> telefones;

    public TelefoneTabela(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0: return "DDD";
            case 1: return "Numero";
            case 2: return "Tipo";
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return this.telefones.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Telefone telefone = this.telefones.get(rowIndex);
        switch(columnIndex) {
            case 0: return telefone.getArea();
            case 1: return telefone.getNumero();
            case 2: return telefone.getTipoFone();
        }
        return null;
    }
}
