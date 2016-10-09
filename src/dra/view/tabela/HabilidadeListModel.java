/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view.tabela;

import dra.model.Habilidade;
import java.util.List;
import javax.swing.AbstractListModel;

/**
 *
 * @author Carlos.Tavares
 */
public class HabilidadeListModel extends AbstractListModel<Habilidade> {

    protected List<Habilidade> list;

    public HabilidadeListModel(List<Habilidade> list) {
        this.list = list;
    }

    public void addElement(Habilidade habilidade) {
        this.list.add(habilidade);
        int index = this.list.size();
        fireContentsChanged(habilidade, index, index);
    }

    public void addList(List<Habilidade> lista) {
        if (this.list.addAll(lista)) {
            int index = this.list.size();
            fireIntervalAdded(this, index, index);
        }
    }

    public void removeElement(Habilidade habilidade) {
        if (this.list.remove(habilidade)) {
            int index = this.list.size();
            fireContentsChanged(this, index, index);
        }
    }
    
    public void removeList(List<Habilidade> list) {
        if (this.list.removeAll(list)) {
            int index = this.list.size();
            fireIntervalRemoved(this, index, index);
        }
    }

    public void fireDataChanged() {
        int index = this.list.size();
        fireContentsChanged(this.list.get(index - 1), index, index);
    }

    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Habilidade getElementAt(int index) {
        return this.list.get(index);
    }
    
    public List<Habilidade> getList() {
        return this.list;
    }
}
