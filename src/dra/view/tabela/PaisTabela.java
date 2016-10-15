/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view.tabela;

import dra.model.Pais;
import dra.util.DateUtil;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos.Tavares
 */
public class PaisTabela extends AbstractTableModel {

    private final List<Pais> paises;

    public PaisTabela(List<Pais> paises) {
        this.paises = paises;
    }

    @Override
    public int getRowCount() {
        return this.paises.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Pais pais = this.paises.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return pais.getDescricao();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Descrição";
        }
        return null;
    }
}
