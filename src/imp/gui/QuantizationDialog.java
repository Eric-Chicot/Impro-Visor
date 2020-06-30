/**
 * This Java Class is part of the Impro-Visor Application
 *
 * Copyright (C) 2016-2019 Robert Keller and Harvey Mudd College
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
import java.util.ResourceBundle;

/**
 * @author keller
 */
public class QuantizationDialog extends javax.swing.JDialog
  {
  Notate notate;
  private ResourceBundle bundle2 = java.util.ResourceBundle.getBundle("imp/internationalize/Bundle"); // NOI18N
    /**
     * Creates new form QuantizationDialog
     */
    public QuantizationDialog(Notate notate, boolean modal)
    {
        super(notate, modal);
        this.notate = notate;
        initComponents();
        quantizationSpinner.setModel(new javax.swing.SpinnerListModel(getQuantumString()));
        quantizationSpinner.setValue(intialQuantumString);
    }

    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        eighthNoteSwingBox = new javax.swing.JCheckBox();
        quantizeButton = new javax.swing.JButton();
        quantizationSpinner = new javax.swing.JSpinner();
        playPanel = new javax.swing.JPanel();
        playBtn = new javax.swing.JButton();
        pauseBtn = new javax.swing.JToggleButton();
        stopBtn = new javax.swing.JButton();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("imp/internationalize/Bundle"); // NOI18N
        setTitle(bundle.getString("QuantizationDialog.title")); // NOI18N
        setAlwaysOnTop(true);
        setBounds(new java.awt.Rectangle(650, 25, 0, 0));
        setLocation(new java.awt.Point(625, 25));
        setMaximumSize(new java.awt.Dimension(450, 150));
        setMinimumSize(new java.awt.Dimension(450, 150));
        setPreferredSize(new java.awt.Dimension(450, 150));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        eighthNoteSwingBox.setText(bundle.getString("QuantizationDialog.eighthNoteSwingBox.text")); // NOI18N
        eighthNoteSwingBox.setToolTipText(bundle.getString("QuantizationDialog.eighthNoteSwingBox.toolTipText")); // NOI18N
        eighthNoteSwingBox.setMaximumSize(new java.awt.Dimension(158, 50));
        eighthNoteSwingBox.setMinimumSize(new java.awt.Dimension(158, 50));
        eighthNoteSwingBox.setPreferredSize(new java.awt.Dimension(158, 50));
        eighthNoteSwingBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eighthNoteSwingBoxActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        getContentPane().add(eighthNoteSwingBox, gridBagConstraints);

        quantizeButton.setBackground(new java.awt.Color(0, 255, 0));
        quantizeButton.setText(bundle.getString("QuantizationDialog.quantizeButton.text")); // NOI18N
        quantizeButton.setToolTipText(bundle.getString("QuantizationDialog.quantizeButton.toolTipText")); // NOI18N
        quantizeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        quantizeButton.setContentAreaFilled(false);
        quantizeButton.setMargin(new java.awt.Insets(0, 2, 4, 2));
        quantizeButton.setMaximumSize(new java.awt.Dimension(210, 45));
        quantizeButton.setMinimumSize(new java.awt.Dimension(210, 45));
        quantizeButton.setOpaque(true);
        quantizeButton.setPreferredSize(new java.awt.Dimension(210, 45));
        quantizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantizeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(quantizeButton, gridBagConstraints);

        quantizationSpinner.setModel(new javax.swing.SpinnerListModel(new String[] {"Item 0", "Item 1", "Item 2", "Item 3"}));
        quantizationSpinner.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("QuantizationDialog.quantizationSpinner.border.title"))); // NOI18N
        quantizationSpinner.setMinimumSize(new java.awt.Dimension(250, 50));
        quantizationSpinner.setPreferredSize(new java.awt.Dimension(250, 50));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(quantizationSpinner, gridBagConstraints);

        playPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("QuantizationDialog.playPanel.border.title"))); // NOI18N
        playPanel.setMaximumSize(new java.awt.Dimension(32767, 60));
        playPanel.setMinimumSize(new java.awt.Dimension(160, 60));
        playPanel.setPreferredSize(new java.awt.Dimension(100, 60));

        playBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imp/gui/graphics/toolbar/play.gif"))); // NOI18N
        playBtn.setToolTipText(bundle.getString("QuantizationDialog.playBtn.toolTipText")); // NOI18N
        playBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        playBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        playBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        playBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });
        playPanel.add(playBtn);

        pauseBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imp/gui/graphics/toolbar/pause.gif"))); // NOI18N
        pauseBtn.setToolTipText(bundle.getString("QuantizationDialog.pauseBtn.toolTipText")); // NOI18N
        pauseBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pauseBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        pauseBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        pauseBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });
        playPanel.add(pauseBtn);

        stopBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imp/gui/graphics/toolbar/stop.gif"))); // NOI18N
        stopBtn.setToolTipText(bundle.getString("QuantizationDialog.stopBtn.toolTipText")); // NOI18N
        stopBtn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        stopBtn.setMaximumSize(new java.awt.Dimension(30, 30));
        stopBtn.setMinimumSize(new java.awt.Dimension(30, 30));
        stopBtn.setPreferredSize(new java.awt.Dimension(30, 30));
        stopBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopBtnActionPerformed(evt);
            }
        });
        playPanel.add(stopBtn);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(playPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
   static int quantum[] = {20, 30, 40, 60, 120, 180, 240, 360, 480};
    
    String quantumString[] =             
      {
          bundle2.getString("Notate.quantumString.text1"),
          bundle2.getString("Notate.quantumString.text2"),
          bundle2.getString("Notate.quantumString.text3"),
          bundle2.getString("Notate.quantumString.text4"),
          bundle2.getString("Notate.quantumString.text5"),
          bundle2.getString("Notate.quantumString.text6"),
          bundle2.getString("Notate.quantumString.text7"),
          bundle2.getString("Notate.quantumString.text8"),
          bundle2.getString("Notate.quantumString.text9")          
      };
    
    String intialQuantumString = bundle2.getString("Notate.quantumString.text4");
    
    public boolean getSwing()
    {
        return eighthNoteSwingBox.isSelected();
    }

    public void hideQuantizeButton()
    {
        quantizeButton.setVisible(false);
    }
    

int getSelectedQuantumIndex()
    {
        return notate.getQuantumIndex(getSelectedQuantumString());
    }      

int getSelectedQuantumValue()
{
    return quantum[getSelectedQuantumIndex()];
}
    
  public String getSelectedQuantumString()
  {
      return (String)quantizationSpinner.getValue();
  }
  
  public String[] getQuantumString()
    {
        return quantumString;
    }
    
    private void eighthNoteSwingBoxActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_eighthNoteSwingBoxActionPerformed
    {//GEN-HEADEREND:event_eighthNoteSwingBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eighthNoteSwingBoxActionPerformed

    private void quantizeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_quantizeButtonActionPerformed
    {//GEN-HEADEREND:event_quantizeButtonActionPerformed
         notate.quantizeCurrentMelody(getSelectedQuantumIndex(), eighthNoteSwingBox.isSelected());
    }//GEN-LAST:event_quantizeButtonActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_playBtnActionPerformed
    {//GEN-HEADEREND:event_playBtnActionPerformed
        notate.playBtnPressed();
    }//GEN-LAST:event_playBtnActionPerformed

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_pauseBtnActionPerformed
    {//GEN-HEADEREND:event_pauseBtnActionPerformed
        notate.pauseBtnPressed();
    }//GEN-LAST:event_pauseBtnActionPerformed

    private void stopBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_stopBtnActionPerformed
    {//GEN-HEADEREND:event_stopBtnActionPerformed
        notate.stopButtonPressed();
    }//GEN-LAST:event_stopBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox eighthNoteSwingBox;
    private javax.swing.JToggleButton pauseBtn;
    private javax.swing.JButton playBtn;
    private javax.swing.JPanel playPanel;
    private javax.swing.JSpinner quantizationSpinner;
    private javax.swing.JButton quantizeButton;
    private javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables
  }
