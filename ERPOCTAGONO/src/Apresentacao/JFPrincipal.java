/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Locale;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Wallace
 */
public class JFPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFPrincipal
     */
    private JFIEmpresas frmempresa;
    private JFICargos frmcargo;
    private JFIEscalas frmescala;
    private JDLogin frmlogin;
    private String usuario;
    private JFIFuncionarios frmfuncionarios;
    public JFPrincipal() {
        super();
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
public void mostralogin(){
    JDLogin login = new JDLogin(this,true);
    login.setLocationRelativeTo(null);
    login.setVisible(true);
  
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        JAreaTrabalho = new javax.swing.JDesktopPane();
        JmnSistema = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        JmnCadastro = new javax.swing.JMenu();
        JmnEmpresa = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        Jmnlogin = new javax.swing.JMenuItem();
        JmnSair = new javax.swing.JMenuItem();
        JmnControles = new javax.swing.JMenu();
        Jmnrh = new javax.swing.JMenu();
        JmnCargos = new javax.swing.JMenuItem();
        Jmnfuncionarios = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Jmnescalas = new javax.swing.JMenuItem();
        JmnFrota = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        JmnFinanceiro = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        JmnSobre = new javax.swing.JMenu();
        JmenuSobre = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar1.add(jMenu2);

        jMenu4.setText("Edit");
        jMenuBar1.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        JAreaTrabalho.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JAreaTrabalhoFocusGained(evt);
            }
        });

        javax.swing.GroupLayout JAreaTrabalhoLayout = new javax.swing.GroupLayout(JAreaTrabalho);
        JAreaTrabalho.setLayout(JAreaTrabalhoLayout);
        JAreaTrabalhoLayout.setHorizontalGroup(
            JAreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );
        JAreaTrabalhoLayout.setVerticalGroup(
            JAreaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        jMenu1.setText("Sistema");

        JmnCadastro.setText("Cadastro");
        JmnCadastro.setEnabled(false);
        JmnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnCadastroActionPerformed(evt);
            }
        });

        JmnEmpresa.setText("Empresas");
        JmnEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnEmpresaActionPerformed(evt);
            }
        });
        JmnCadastro.add(JmnEmpresa);

        jMenuItem13.setText("Usuários");
        JmnCadastro.add(jMenuItem13);

        jMenu1.add(JmnCadastro);

        Jmnlogin.setText("Login");
        Jmnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnloginActionPerformed(evt);
            }
        });
        jMenu1.add(Jmnlogin);

        JmnSair.setText("Sair");
        JmnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnSairActionPerformed(evt);
            }
        });
        jMenu1.add(JmnSair);

        JmnSistema.add(jMenu1);

        JmnControles.setText("Controle");
        JmnControles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnControlesActionPerformed(evt);
            }
        });

        Jmnrh.setText("RH");
        Jmnrh.setEnabled(false);

        JmnCargos.setText("Cargos");
        JmnCargos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnCargosActionPerformed(evt);
            }
        });
        Jmnrh.add(JmnCargos);

        Jmnfuncionarios.setText("Funcionários");
        Jmnfuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnfuncionariosActionPerformed(evt);
            }
        });
        Jmnrh.add(Jmnfuncionarios);

        jMenuItem5.setText("Benefícios");
        Jmnrh.add(jMenuItem5);

        jMenuItem6.setText("Desconto de Multas");
        Jmnrh.add(jMenuItem6);

        Jmnescalas.setText("Escalas");
        Jmnescalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnescalasActionPerformed(evt);
            }
        });
        Jmnrh.add(Jmnescalas);

        JmnControles.add(Jmnrh);

        JmnFrota.setText("Frota");
        JmnFrota.setEnabled(false);

        jMenuItem7.setText("Veiculos");
        JmnFrota.add(jMenuItem7);

        jMenuItem8.setText("Multas");
        JmnFrota.add(jMenuItem8);

        jMenuItem9.setText("IPVA/Licenciamento");
        JmnFrota.add(jMenuItem9);

        JmnControles.add(JmnFrota);

        JmnFinanceiro.setText("Contas a Pagar");
        JmnFinanceiro.setEnabled(false);

        jMenuItem10.setText("Multas a Pagar");
        JmnFinanceiro.add(jMenuItem10);

        jMenuItem11.setText("IPVA/Licenciamento a Pagar");
        JmnFinanceiro.add(jMenuItem11);

        JmnControles.add(JmnFinanceiro);

        JmnSistema.add(JmnControles);

        jMenu3.setText("Relatórios");
        JmnSistema.add(jMenu3);

        JmnSobre.setText("Ajuda");
        JmnSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmnSobreActionPerformed(evt);
            }
        });

        JmenuSobre.setText("Sobre");
        JmenuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmenuSobreActionPerformed(evt);
            }
        });
        JmnSobre.add(JmenuSobre);

        JmnSistema.add(JmnSobre);

        setJMenuBar(JmnSistema);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JAreaTrabalho)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JAreaTrabalho)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JmenuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmenuSobreActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_JmenuSobreActionPerformed

    private void JmnSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnSobreActionPerformed
        // TODO add your handling code here:
         JDialogSobre dialog = new JDialogSobre(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
    }//GEN-LAST:event_JmnSobreActionPerformed

    private void JmnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnSairActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_JmnSairActionPerformed

    private void JmnControlesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnControlesActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_JmnControlesActionPerformed

    private void JmnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnCadastroActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_JmnCadastroActionPerformed

    private void JmnEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnEmpresaActionPerformed
        // TODO add your handling code here:
                        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        int width = (int)scrnsize.getWidth();
        int heigth = (int)scrnsize.getHeight();
        if(frmempresa==null){
            frmempresa = new JFIEmpresas();
            JAreaTrabalho.add(frmempresa);
        }
        frmempresa.setVisible(true);
        try{
            frmempresa.setSelected(true);
        }catch(java.beans.PropertyVetoException e){

        }
    }//GEN-LAST:event_JmnEmpresaActionPerformed

    private void JmnCargosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnCargosActionPerformed
        // TODO add your handling code here:
                        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        int width = (int)scrnsize.getWidth();
        int heigth = (int)scrnsize.getHeight();
        if(frmcargo==null){
            frmcargo = new JFICargos();
            
            JAreaTrabalho.add(frmcargo);
        }
        frmcargo.setVisible(true);
        try{
            frmcargo.setSelected(true);
        }catch(java.beans.PropertyVetoException e){

        }
    }//GEN-LAST:event_JmnCargosActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        mostralogin();
    }//GEN-LAST:event_formWindowOpened

    private void JmnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnloginActionPerformed
        // TODO add your handling code here:
         JDLogin login = new JDLogin(this,true);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }//GEN-LAST:event_JmnloginActionPerformed

    private void JAreaTrabalhoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JAreaTrabalhoFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_JAreaTrabalhoFocusGained

    private void JmnescalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnescalasActionPerformed
        // TODO add your handling code here:
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        int width = (int)scrnsize.getWidth();
        int heigth = (int)scrnsize.getHeight();
        if(frmescala==null){
            frmescala = new JFIEscalas();
            
            JAreaTrabalho.add(frmescala);
        }
        frmescala.setVisible(true);
        try{
            frmescala.setSelected(true);
        }catch(java.beans.PropertyVetoException e){

        }
    }//GEN-LAST:event_JmnescalasActionPerformed

    private void JmnfuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmnfuncionariosActionPerformed
        // TODO add your handling code here:
                                                   
        // TODO add your handling code here:
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        final Dimension scrnsize = toolkit.getScreenSize();
        int width = (int)scrnsize.getWidth();
        int heigth = (int)scrnsize.getHeight();
        if(frmfuncionarios==null){
            frmfuncionarios = new JFIFuncionarios();
            
            JAreaTrabalho.add(frmfuncionarios);
        }
        frmfuncionarios.setVisible(true);
        try{
            frmfuncionarios.setSelected(true);
        }catch(java.beans.PropertyVetoException e){

        }
    
    }//GEN-LAST:event_JmnfuncionariosActionPerformed

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
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new JFPrincipal().setVisible(true);
                
                
            }
        });
        
    }

    public void setFrmempresa(JFIEmpresas frmempresa) {
        this.frmempresa = frmempresa;
    }

    public void setFrmcargo(JFICargos frmcargo) {
        this.frmcargo = frmcargo;
    }

    public void HabilitaJmnCadastro(boolean habilitado ) {
        this.JmnCadastro.setEnabled(habilitado);
        
    }

    public void setusuario(String usuario){
        this.usuario=usuario;
    }
    public String getusuario(){
        return this.usuario;
    }
    
    public void setJmnSair(JMenuItem JmnSair) {
        this.JmnSair = JmnSair;
    }

    public void setJmnSistema(JMenuBar JmnSistema) {
        this.JmnSistema = JmnSistema;
    }

    public void setJmnSobre(JMenu JmnSobre) {
        this.JmnSobre = JmnSobre;
    }

    public void HabilitaJmnrh(boolean habilitado) {
        this.Jmnrh.setEnabled(habilitado);
    }
     public void HabilitaJmnFrota(boolean habilitado) {
        this.JmnFrota.setEnabled(habilitado);
    }
   public void HabilitaJmnFinanceiro(boolean habilitado) {
        this.JmnFinanceiro.setEnabled(habilitado);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane JAreaTrabalho;
    private javax.swing.JMenuItem JmenuSobre;
    private javax.swing.JMenu JmnCadastro;
    private javax.swing.JMenuItem JmnCargos;
    private javax.swing.JMenu JmnControles;
    private javax.swing.JMenuItem JmnEmpresa;
    private javax.swing.JMenu JmnFinanceiro;
    private javax.swing.JMenu JmnFrota;
    private javax.swing.JMenuItem JmnSair;
    private javax.swing.JMenuBar JmnSistema;
    private javax.swing.JMenu JmnSobre;
    private javax.swing.JMenuItem Jmnescalas;
    private javax.swing.JMenuItem Jmnfuncionarios;
    private javax.swing.JMenuItem Jmnlogin;
    private javax.swing.JMenu Jmnrh;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}