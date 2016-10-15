/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dra.view.tela.pessoa;

import dra.model.Bairro;
import dra.model.Cidade;
import dra.model.Estado;
import dra.model.EstadoCivil;
import dra.model.Habilidade;
import dra.model.Pais;
import dra.model.SexoEnum;
import dra.util.DateUtil;
import dra.facade.PessoaFacade;
import dra.view.tabela.HabilidadeListModel;
import dra.view.tela.pessoa.telefone.Telefones;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos.Tavares
 */
public class Cadastrar extends javax.swing.JFrame {

    protected PessoaFacade facade;
    protected HabilidadeListModel sourceModel;
    protected HabilidadeListModel destModel;

    /**
     * Creates new form Cadastrar
     */
    public Cadastrar() {
        initComponents();
    }

    public Cadastrar(PessoaFacade facade) {
        initComponents();
        this.facade = facade;
        this.preencherCombos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpSexo = new javax.swing.ButtonGroup();
        rotuloNome = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        rotuloNascimento = new javax.swing.JLabel();
        campoNascimento = new javax.swing.JTextField();
        rotuloEstadoCivil = new javax.swing.JLabel();
        comboEstadoCivil = new javax.swing.JComboBox<>();
        rotuloSexo = new javax.swing.JLabel();
        radioMasculino = new javax.swing.JRadioButton();
        radioFeminino = new javax.swing.JRadioButton();
        btnTelefones = new javax.swing.JButton();
        rotuloEndereco = new javax.swing.JLabel();
        campoEndereco = new javax.swing.JTextField();
        rotuloHabilidades = new javax.swing.JLabel();
        scrollSourceHab = new javax.swing.JScrollPane();
        sourceList = new javax.swing.JList<>();
        botaoAdd = new javax.swing.JButton();
        botaoRemove = new javax.swing.JButton();
        rotuloSelecionadas = new javax.swing.JLabel();
        scrollDestHab = new javax.swing.JScrollPane();
        destList = new javax.swing.JList<>();
        rotuloPais = new javax.swing.JLabel();
        comboPais = new javax.swing.JComboBox<>();
        rotuloEstado = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        rotuloCidade = new javax.swing.JLabel();
        comboCidade = new javax.swing.JComboBox<>();
        rotuloBairro = new javax.swing.JLabel();
        comboBairro = new javax.swing.JComboBox<>();
        botaoSalvar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar");

        rotuloNome.setText("Nome:");

        rotuloNascimento.setText("Nascimento:");

        rotuloEstadoCivil.setText("Estado Civil:");

        rotuloSexo.setText("Sexo:");

        grpSexo.add(radioMasculino);
        radioMasculino.setText("Masculino");

        grpSexo.add(radioFeminino);
        radioFeminino.setText("Feminino");

        btnTelefones.setText("Telefones");
        btnTelefones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefonesActionPerformed(evt);
            }
        });

        rotuloEndereco.setText("Endereço:");

        rotuloHabilidades.setText("Lista de Habilidades");

        scrollSourceHab.setViewportView(sourceList);

        botaoAdd.setText(">>");
        botaoAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAddActionPerformed(evt);
            }
        });

        botaoRemove.setText("<<");
        botaoRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRemoveActionPerformed(evt);
            }
        });

        rotuloSelecionadas.setText("Habilidades Selecionadas");

        scrollDestHab.setViewportView(destList);

        rotuloPais.setText("País:");

        comboPais.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPaisItemStateChanged(evt);
            }
        });

        rotuloEstado.setText("Estado:");

        comboEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboEstadoItemStateChanged(evt);
            }
        });

        rotuloCidade.setText("Cidade:");

        comboCidade.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCidadeItemStateChanged(evt);
            }
        });

        rotuloBairro.setText("Bairro:");

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollSourceHab, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(rotuloHabilidades, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollDestHab, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rotuloSelecionadas, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rotuloCidade)
                                    .addComponent(comboCidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rotuloPais)
                                    .addComponent(comboPais, 0, 188, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rotuloBairro)
                                            .addComponent(rotuloEstado))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(comboBairro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botaoSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoCancelar)))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rotuloNome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rotuloNascimento)
                                    .addComponent(campoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rotuloSexo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioMasculino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(radioFeminino))
                                    .addComponent(rotuloEndereco))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboEstadoCivil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rotuloEstadoCivil)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(btnTelefones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoEndereco))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoNome)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rotuloNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotuloNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(campoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rotuloSexo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(radioMasculino)
                            .addComponent(radioFeminino)
                            .addComponent(btnTelefones, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rotuloEndereco))
                    .addComponent(rotuloEstadoCivil))
                .addGap(2, 2, 2)
                .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotuloHabilidades)
                    .addComponent(rotuloSelecionadas))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(scrollDestHab, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(scrollSourceHab, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rotuloPais)
                            .addComponent(rotuloEstado))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotuloBairro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotuloCidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalvar)
                    .addComponent(botaoCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
        int resp = JOptionPane.showConfirmDialog(null, "Confirmar Cadastro?", "Cadastrar Pessoa", JOptionPane.YES_NO_OPTION);
        if (resp == 0) {
            try {
                this.salvar();
            } catch (ParseException ex) {
                Logger.getLogger(Cadastrar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_botaoSalvarActionPerformed

    protected void salvar() throws ParseException {
        this.preenchePessoa();
        this.facade.salvar();
    }

    private void preenchePessoa() throws ParseException {
        this.facade.preencheDadosPessoa(campoNome.getText(), DateUtil.toCalendar(campoNascimento.getText()),
                this.selecionaSexo(), (EstadoCivil) comboEstadoCivil.getSelectedItem(), campoEndereco.getText(),
                (Bairro) comboBairro.getSelectedItem(), destModel.getList());
    }

    private SexoEnum selecionaSexo() {
        if (radioMasculino.isSelected()) {
            return SexoEnum.MASCULINO;
        } else {
            return SexoEnum.FEMININO;
        }
    }

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void comboEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboEstadoItemStateChanged
        this.preencherComboCidade();
    }//GEN-LAST:event_comboEstadoItemStateChanged

    private void comboCidadeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCidadeItemStateChanged
        this.preencherComboBairro();
    }//GEN-LAST:event_comboCidadeItemStateChanged

    private void comboPaisItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPaisItemStateChanged
        this.preencherComboEstado();
    }//GEN-LAST:event_comboPaisItemStateChanged

    private void botaoAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAddActionPerformed
        this.addHabilidades();
    }//GEN-LAST:event_botaoAddActionPerformed

    private void botaoRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRemoveActionPerformed
        this.removeHabilidades();
    }//GEN-LAST:event_botaoRemoveActionPerformed

    private void btnTelefonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelefonesActionPerformed
        Telefones tel = new Telefones(this.facade);
        tel.setVisible(true);
    }//GEN-LAST:event_btnTelefonesActionPerformed

    protected void addHabilidades() {
        List<Habilidade> lista = this.sourceList.getSelectedValuesList();
        this.destModel.addList(lista);
        this.sourceModel.removeList(lista);
    }

    protected void removeHabilidades() {
        List<Habilidade> lista = this.destList.getSelectedValuesList();
        this.sourceModel.addList(lista);
        this.destModel.removeList(lista);
    }

    private void preencherComboEstadoCivil() {
        try {
            comboEstadoCivil.removeAllItems();
            for (EstadoCivil estadoCivil : this.facade.getEstadosCivis()) {
                comboEstadoCivil.addItem(estadoCivil);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao preencher combo Estado Civil " + ex.getMessage());
        }
    }

    private void preencherComboPais() {
        try {
            comboPais.removeAllItems();
            for (Pais pais : this.facade.getPaises()) {
                comboPais.addItem(pais);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao preencher combo Pais " + ex.getMessage());
        }
    }

    private void preencherComboEstado() {
        try {
            comboEstado.removeAllItems();
            comboCidade.removeAllItems();
            comboBairro.removeAllItems();
            this.facade.listarEstadosPorPais((Pais) comboPais.getSelectedItem());
            for (Estado estado : this.facade.getEstados()) {
                comboEstado.addItem(estado);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao preencher combo Estado " + ex.getMessage());
        }
    }

    private void preencherComboCidade() {
        try {
            comboCidade.removeAllItems();
            comboBairro.removeAllItems();
            this.facade.listarCidadesPorEstado((Estado) comboEstado.getSelectedItem());
            for (Cidade cidade : this.facade.getCidades()) {
                comboCidade.addItem(cidade);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao preencher combo Cidade " + ex.getMessage());
        }
    }

    private void preencherComboBairro() {
        try {
            comboBairro.removeAllItems();
            this.facade.listarBairrosPorCidade((Cidade) comboCidade.getSelectedItem());
            for (Bairro bairro : this.facade.getBairros()) {
                comboBairro.addItem(bairro);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao preencher combo Bairro " + ex.getMessage());
        }
    }

    private void preencherSourceHabilidades() {
        this.sourceModel = new HabilidadeListModel(this.facade.getHabilidades());
        sourceList.setModel(this.sourceModel);
    }

    protected void preencherPessoaHabilidades() {
        List<Habilidade> lista = new ArrayList<>();
        this.destModel = new HabilidadeListModel(lista);
        destList.setModel(this.destModel);
    }

    private void preencherCombos() {
        this.preencherComboEstadoCivil();
        this.preencherComboPais();
        this.preencherSourceHabilidades();
        this.preencherPessoaHabilidades();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cadastrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cadastrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdd;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoRemove;
    protected javax.swing.JButton botaoSalvar;
    private javax.swing.JButton btnTelefones;
    protected javax.swing.JTextField campoEndereco;
    protected javax.swing.JTextField campoNascimento;
    protected javax.swing.JTextField campoNome;
    protected javax.swing.JComboBox<Bairro> comboBairro;
    protected javax.swing.JComboBox<Cidade> comboCidade;
    protected javax.swing.JComboBox<Estado> comboEstado;
    protected javax.swing.JComboBox<EstadoCivil> comboEstadoCivil;
    protected javax.swing.JComboBox<Pais> comboPais;
    protected javax.swing.JList<Habilidade> destList;
    private javax.swing.ButtonGroup grpSexo;
    private javax.swing.JSeparator jSeparator1;
    protected javax.swing.JRadioButton radioFeminino;
    protected javax.swing.JRadioButton radioMasculino;
    private javax.swing.JLabel rotuloBairro;
    private javax.swing.JLabel rotuloCidade;
    private javax.swing.JLabel rotuloEndereco;
    private javax.swing.JLabel rotuloEstado;
    private javax.swing.JLabel rotuloEstadoCivil;
    private javax.swing.JLabel rotuloHabilidades;
    private javax.swing.JLabel rotuloNascimento;
    private javax.swing.JLabel rotuloNome;
    private javax.swing.JLabel rotuloPais;
    private javax.swing.JLabel rotuloSelecionadas;
    private javax.swing.JLabel rotuloSexo;
    private javax.swing.JScrollPane scrollDestHab;
    private javax.swing.JScrollPane scrollSourceHab;
    protected javax.swing.JList<Habilidade> sourceList;
    // End of variables declaration//GEN-END:variables
}
