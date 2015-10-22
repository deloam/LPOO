/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasNovas;

import DAO.AgendaDAO;
import DAO.ContatoDAO;
import DTO.AgendaDTO;
import DTO.ContatoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ulissesweyl
 */
public class TelaRelatorio extends javax.swing.JFrame {
    private TelaContato telaContato;

    /**
     * Creates new form telaRelatorio
     */
    public TelaRelatorio() {
        initComponents();
        carregarListaContato();
    }
    
    public TelaRelatorio (TelaContato telaContato) {
        this();
        this.telaContato = telaContato;
    }
    
        private void carregarListaContato() {
        ContatoDAO contatoDAO = new ContatoDAO();
        AgendaDAO agendaDAO = new AgendaDAO();
        
        String nome = this.buscarContatoRelatorio.getText();
        List<ContatoDTO> listaContato = new ArrayList<>();
        listaContato = contatoDAO.listarBusca(nome); 
         
     
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nome");
        modelo.addColumn("Endereço");
        modelo.addColumn("Telefone");
        modelo.addColumn("Email");
        modelo.addColumn("Agenda");

        if (listaContato.size() == 0) {
            modelo.addRow(new String[]{"Sem dados",
                        null,
                        null,
                        null,
                        null,
                        null});
        }
        
        for (int i = 0; i < listaContato.size(); i++) {
            ContatoDTO p = listaContato.get(i);
           
            List<AgendaDTO> nomeAg = agendaDAO.pegacombo(p.getIdAgenda());
            AgendaDTO ag = nomeAg.get(0);
            // Alimenta as linhas de dados  
            modelo.addRow(new Object[]{
                        p.getIdContato(),
                        p.getNomeContato(),
                        p.getEnderecoContato(),
                        p.getTelefoneContato(),
                        p.getEmailContato(),
                        ag.getNomeAgenda()});
        }

        tabelaListaContato.setModel(modelo);

    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelTituloRelatorio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        painelTabelaRelatorio = new javax.swing.JPanel();
        painelBuscarContato = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botaoBuscarContato = new javax.swing.JButton();
        buscarContatoRelatorio = new javax.swing.JTextField();
        painelListaContato = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaListaContato = new javax.swing.JTable();
        painelBotoesRelatorio = new javax.swing.JPanel();
        botaoEditarContato = new javax.swing.JButton();
        botaoExcluirContato = new javax.swing.JButton();
        botaoFecharRelatorio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(480, 320));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        painelTituloRelatorio.setOpaque(false);
        painelTituloRelatorio.setPreferredSize(new java.awt.Dimension(480, 40));

        jLabel2.setFont(new java.awt.Font("DejaVu Sans Mono", 0, 18)); // NOI18N
        jLabel2.setText("Relatório de Contato");
        painelTituloRelatorio.add(jLabel2);

        getContentPane().add(painelTituloRelatorio, java.awt.BorderLayout.NORTH);

        painelTabelaRelatorio.setBorder(javax.swing.BorderFactory.createTitledBorder("Gerenciar Contatos"));
        painelTabelaRelatorio.setPreferredSize(new java.awt.Dimension(480, 240));
        painelTabelaRelatorio.setLayout(new java.awt.BorderLayout());

        painelBuscarContato.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Buscar Contato:");
        painelBuscarContato.add(jLabel1, java.awt.BorderLayout.WEST);

        botaoBuscarContato.setText("Buscar");
        botaoBuscarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarContatoActionPerformed(evt);
            }
        });
        painelBuscarContato.add(botaoBuscarContato, java.awt.BorderLayout.EAST);
        painelBuscarContato.add(buscarContatoRelatorio, java.awt.BorderLayout.CENTER);

        painelTabelaRelatorio.add(painelBuscarContato, java.awt.BorderLayout.NORTH);

        tabelaListaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelaListaContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaListaContatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaListaContato);

        painelListaContato.add(jScrollPane1);

        painelTabelaRelatorio.add(painelListaContato, java.awt.BorderLayout.CENTER);

        getContentPane().add(painelTabelaRelatorio, java.awt.BorderLayout.CENTER);

        botaoEditarContato.setText("Editar");
        botaoEditarContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarContatoActionPerformed(evt);
            }
        });
        painelBotoesRelatorio.add(botaoEditarContato);

        botaoExcluirContato.setText("Excluir");
        botaoExcluirContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirContatoActionPerformed(evt);
            }
        });
        painelBotoesRelatorio.add(botaoExcluirContato);

        botaoFecharRelatorio.setText("Fechar");
        botaoFecharRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharRelatorioActionPerformed(evt);
            }
        });
        painelBotoesRelatorio.add(botaoFecharRelatorio);

        getContentPane().add(painelBotoesRelatorio, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoExcluirContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirContatoActionPerformed
        // TODO add your handling code here:
        try{
            ContatoDAO contato = new ContatoDAO();
            int linha = tabelaListaContato.getSelectedRow();   
                    int coluna = tabelaListaContato.getColumnModel().getColumnIndex("ID"); 
                    Object value = tabelaListaContato.getValueAt(linha, coluna);  
                    Integer numero = (Integer)value;
                    System.out.println(numero);
        contato.remover(numero);
                    
        carregarListaContato();
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Selecione um Contato!");
        }
        
    }//GEN-LAST:event_botaoExcluirContatoActionPerformed

    private void botaoFecharRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharRelatorioActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_botaoFecharRelatorioActionPerformed

    private void botaoEditarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarContatoActionPerformed
        // TODO add your handling code here:
        try {
            
            int linha = tabelaListaContato.getSelectedRow();
            ContatoDAO contatoDAO = new ContatoDAO();
            //List<ContatoDTO> listaContato = new ArrayList<>();

            ContatoDTO c = contatoDAO.listarTodos().get(linha);
            System.out.println(c.toString());

//            this.setEnabled(false);
//            botaoEditarContato.setEnabled(false);

            new TelaContato(this, c).setVisible(true);
            carregarListaContato();
            } catch (Exception e) {
            
            JOptionPane.showMessageDialog(this, "Selecione um Contato!");
            //botaoEditarContato.setEnabled(false);
        }
    }//GEN-LAST:event_botaoEditarContatoActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
        carregarListaContato();
        
    
    }//GEN-LAST:event_formWindowActivated

    private void botaoBuscarContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarContatoActionPerformed
        // TODO add your handling code here:
        carregarListaContato();
    }//GEN-LAST:event_botaoBuscarContatoActionPerformed

    private void tabelaListaContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaListaContatoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaListaContatoMouseClicked

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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBuscarContato;
    private javax.swing.JButton botaoEditarContato;
    private javax.swing.JButton botaoExcluirContato;
    private javax.swing.JButton botaoFecharRelatorio;
    private javax.swing.JTextField buscarContatoRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelBotoesRelatorio;
    private javax.swing.JPanel painelBuscarContato;
    private javax.swing.JPanel painelListaContato;
    private javax.swing.JPanel painelTabelaRelatorio;
    private javax.swing.JPanel painelTituloRelatorio;
    private javax.swing.JTable tabelaListaContato;
    // End of variables declaration//GEN-END:variables


}