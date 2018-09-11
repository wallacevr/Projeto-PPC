/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.awt.Component;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Wallace
 */
public class Utilitarios {
    public void LimpaTela(JInternalFrame Frame) {     
            //limpa os campos     
            for (int i=0; i < Frame.getContentPane().getComponentCount(); i++) {   
                //varre todos os componentes     
                Component c = Frame.getContentPane().getComponent(i); 
                
                if (c instanceof JTextField) {       
                                      
                    JTextField field = (JTextField) c;
                    JOptionPane.showMessageDialog(null,field.getText());
                    field.setText("");                      
                    }   
                }   
            }

}
