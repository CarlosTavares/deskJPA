/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view.tela.pessoa;

import dra.model.SexoEnum;
import dra.util.DateUtil;
import dra.view.PessoaFacade;

/**
 *
 * @author Carlos.Tavares
 */
public class Alterar extends Cadastrar {

    public Alterar(PessoaFacade facade) {
        super(facade);
        this.preencheCampos();
    }

    private void preencheCampos() {
        campoNome.setText(facade.getPessoa().getNome());
        campoNascimento.setText(DateUtil.toString(facade.getPessoa().getNascimento()));
        comboEstadoCivil.setSelectedItem(facade.getPessoa().getEstadoCivil());
        if (facade.getPessoa().getSexo().equals(SexoEnum.MASCULINO)) {
            radioMasculino.setSelected(true);
        } else {
            radioFeminino.setSelected(true);
        }
        campoEndereco.setText(facade.getPessoa().getEndereco());
        comboEstado.setSelectedItem(facade.getPessoa().getBairro().getCidade().getEstado());
        comboCidade.setSelectedItem(facade.getPessoa().getBairro().getCidade());
        comboBairro.setSelectedItem(facade.getPessoa().getBairro());
        botaoSalvar.setText("Alterar");
    }
}
