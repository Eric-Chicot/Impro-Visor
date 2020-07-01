/**
 * This Java Class is part of the Impro-Visor Application
 *
 * Copyright (C) 2005-2009 Robert Keller and Harvey Mudd College
 *
 * Impro-Visor is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * Impro-Visor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * merchantability or fitness for a particular purpose.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Impro-Visor; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package imp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 *
 * @author  mhunt
 */
public class UnsavedChanges extends javax.swing.JDialog {
    public enum Value { YES, NO, CANCEL }
    Value value = Value.CANCEL;
    
    /** Creates new form UnsavedChanges */
    public UnsavedChanges(java.awt.Frame parent, String message, Object[] options) {
        super(parent, true);
        initComponents();
        
        getRootPane().setDefaultButton(yesBtn);
        
        yesBtn.setText(options[0].toString());
        noBtn.setText(options[1].toString());
        cancelBtn.setText(options[2].toString());
        
        shortmsg.setText(message);
        pack();
    }
    
    @Override
    public void setVisible(boolean visible) {
        setLocationRelativeTo(getParent());
        super.setVisible(visible);
    }
    
    public Value getValue() {
        return value;
    }
    
    public void setMsg(String text) {
        msg.setText(text);
    }
                
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        msg = new javax.swing.JTextArea();
        yesBtn = new javax.swing.JButton();
        noBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        shortmsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        msg.setColumns(20);
        msg.setEditable(false);
        msg.setLineWrap(true);
        msg.setRows(5);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("imp/internationalize/Bundle"); // NOI18N
        msg.setText(bundle.getString("UnsavedChanges.msg.text")); // NOI18N
        msg.setWrapStyleWord(true);
        msg.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        getContentPane().add(msg, gridBagConstraints);

        yesBtn.setText(bundle.getString("UnsavedChanges.yesBtn.text")); // NOI18N
        yesBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Action yesAction = new AbstractAction("yesAction") {
            public void actionPerformed(ActionEvent e) {
                yesBtnActionPerformed(null);
            }
        };

        yesBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('y'), yesAction.getValue(Action.NAME));
        yesBtn.getActionMap().put(yesAction.getValue(Action.NAME),yesAction);
        yesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 5, 5);
        getContentPane().add(yesBtn, gridBagConstraints);

        noBtn.setText(bundle.getString("UnsavedChanges.noBtn.text")); // NOI18N
        noBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Action noAction = new AbstractAction("noAction") {
            public void actionPerformed(ActionEvent e) {
                noBtnActionPerformed(null);
            }
        };

        noBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('n'), noAction.getValue(Action.NAME));
        noBtn.getActionMap().put(noAction.getValue(Action.NAME),noAction);
        noBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        getContentPane().add(noBtn, gridBagConstraints);

        cancelBtn.setText(bundle.getString("UnsavedChanges.cancelBtn.text")); // NOI18N
        cancelBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Action cancelAction = new AbstractAction("cancelAction") {
            public void actionPerformed(ActionEvent e) {
                cancelBtnActionPerformed(null);
            }
        };

        cancelBtn.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelAction.getValue(Action.NAME));
        cancelBtn.getActionMap().put(cancelAction.getValue(Action.NAME),cancelAction);
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 5, 5);
        getContentPane().add(cancelBtn, gridBagConstraints);

        shortmsg.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        shortmsg.setText(bundle.getString("UnsavedChanges.shortmsg.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 10);
        getContentPane().add(shortmsg, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        value = Value.CANCEL;
        setVisible(false);
    }//GEN-LAST:event_formWindowClosing

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        value = Value.CANCEL;
        setVisible(false);
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void noBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noBtnActionPerformed
        value = Value.NO;
        setVisible(false);
    }//GEN-LAST:event_noBtnActionPerformed

    private void yesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesBtnActionPerformed
        value = Value.YES;
        setVisible(false);
    }//GEN-LAST:event_yesBtnActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JTextArea msg;
    private javax.swing.JButton noBtn;
    private javax.swing.JLabel shortmsg;
    private javax.swing.JButton yesBtn;
    // End of variables declaration//GEN-END:variables
    
}
