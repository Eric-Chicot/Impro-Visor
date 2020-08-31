/**
 * This Java Class is part of the Impro-Visor Application.
 *
 * Copyright (C) 2005-2018 Robert Keller and Harvey Mudd College.
 *
 * Impro-Visor is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * Impro-Visor is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of merchantability or fitness
 * for a particular purpose. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Impro-Visor; if not, write to the Free Software Foundation, Inc., 51 Franklin
 * St, Fifth Floor, Boston, MA 02110-1301 USA
 */

package imp.gui;

import java.awt.Color;
import java.util.ResourceBundle;

/**
 *
 * @author Robert Keller
 */

public class GrammarMenuDialog extends javax.swing.JDialog
  {
  Notate notate;
  private ResourceBundle bundle2 = java.util.ResourceBundle.getBundle("imp/internationalize/Bundle"); // NOI18N
  javax.swing.DefaultListModel grammarListModel = new javax.swing.DefaultListModel();
  
  String currentSelection;
  
  public static final int CHOSEN = 0;
  public static final int CYCLE = 1;
  public static final int SHUFFLE = 2;
  
  int mode = CHOSEN;
  
  String DEFAULT_GRAMMAR = "chord+approach";
  
    /**
     * Creates new form GrammarMenuDialog
     */
    public GrammarMenuDialog(Notate notate, boolean modal)
    {
        super(notate, modal);
        initComponents();
        this.setTitle(bundle2.getString("GrammarMenuDialog.title"));
        this.notate = notate;
    }

    public javax.swing.JList getGrammarList()
    {
        return grammarJlist;
    }
    
    public javax.swing.DefaultListModel getGrammarListModel()
    {
        return grammarListModel;
    }
    
    public void setGrammarName(String grammarName)
    {
        grammarJlist.setSelectedValue(grammarName, true);
        currentSelection = grammarName;
    }
    
    public String getGrammarName()
    {
        return grammarJlist.getSelectedValue();
    }
     
    public int getGrammarIndex()
    {
       return grammarJlist.getSelectedIndex();
    }
  
    public int getNextGrammarIndex()
    {
       return (1 + getGrammarIndex()) % grammarJlist.getModel().getSize() ;
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

        grammarButtonGroup = new javax.swing.ButtonGroup();
        grammarButtonPanel = new javax.swing.JPanel();
        chosenGrammarButton = new javax.swing.JRadioButton();
        cycleGrammarButton = new javax.swing.JRadioButton();
        shuffleGrammarButton = new javax.swing.JRadioButton();
        improviseButton = new javax.swing.JToggleButton();
        grammarListScrollPane = new javax.swing.JScrollPane();
        grammarJlist = new javax.swing.JList<>();

        setAlwaysOnTop(true);
        setName("grammarChoiceDialog"); // NOI18N
        getContentPane().setLayout(new java.awt.GridBagLayout());

        grammarButtonPanel.setName("Grammar Menu"); // NOI18N
        grammarButtonPanel.setLayout(new java.awt.GridBagLayout());

        grammarButtonGroup.add(chosenGrammarButton);
        chosenGrammarButton.setSelected(true);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("imp/internationalize/Bundle"); // NOI18N
        chosenGrammarButton.setText(bundle.getString("GrammarMenuDialog.chosenGrammarButton.text")); // NOI18N
        chosenGrammarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chosenGrammarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        grammarButtonPanel.add(chosenGrammarButton, gridBagConstraints);

        grammarButtonGroup.add(cycleGrammarButton);
        cycleGrammarButton.setLabel(bundle.getString("GrammarMenuDialog.cycleGrammarButton.label")); // NOI18N
        cycleGrammarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cycleGrammarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        grammarButtonPanel.add(cycleGrammarButton, gridBagConstraints);

        grammarButtonGroup.add(shuffleGrammarButton);
        shuffleGrammarButton.setLabel(bundle.getString("GrammarMenuDialog.shuffleGrammarButton.label")); // NOI18N
        shuffleGrammarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shuffleGrammarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        grammarButtonPanel.add(shuffleGrammarButton, gridBagConstraints);

        improviseButton.setBackground(new java.awt.Color(0, 255, 0));
        improviseButton.setText(bundle.getString("GrammarMenuDialog.improviseButton.text")); // NOI18N
        improviseButton.setToolTipText(bundle.getString("GrammarMenuDialog.improviseButton.toolTipText")); // NOI18N
        improviseButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        improviseButton.setFocusable(false);
        improviseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        improviseButton.setIconTextGap(0);
        improviseButton.setMaximumSize(new java.awt.Dimension(50, 30));
        improviseButton.setMinimumSize(new java.awt.Dimension(50, 30));
        improviseButton.setPreferredSize(new java.awt.Dimension(50, 30));
        improviseButton.setRequestFocusEnabled(false);
        improviseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        improviseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                improviseButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        grammarButtonPanel.add(improviseButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        getContentPane().add(grammarButtonPanel, gridBagConstraints);

        grammarListScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        grammarListScrollPane.setAutoscrolls(true);
        grammarListScrollPane.setDoubleBuffered(true);
        grammarListScrollPane.setHorizontalScrollBar(null);
        grammarListScrollPane.setMinimumSize(new java.awt.Dimension(300, 100));
        grammarListScrollPane.setName("Grammar Menu"); // NOI18N
        grammarListScrollPane.setPreferredSize(new java.awt.Dimension(300, 600));

        grammarJlist.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        grammarJlist.setModel(grammarListModel);
        grammarJlist.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        grammarJlist.setToolTipText(bundle.getString("GrammarMenuDialog.grammarJlist.toolTipText")); // NOI18N
        grammarJlist.setVisibleRowCount(200);
        grammarJlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grammarJlistMouseClicked(evt);
            }
        });
        grammarListScrollPane.setViewportView(grammarJlist);
        grammarJlist.getAccessibleContext().setAccessibleName(bundle.getString("GrammarMenuDialog.grammarJlist.AccessibleContext.accessibleName")); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(grammarListScrollPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void grammarJlistMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_grammarJlistMouseClicked
    {//GEN-HEADEREND:event_grammarJlistMouseClicked
        grammarAction();
        notate.maybeEditGrammar(); // only edit grammar if editor already open
        if( evt.getClickCount() == 2 )
          {
            notateImprovisationOff();
            notateImprovisationOn();
          }
    }//GEN-LAST:event_grammarJlistMouseClicked

    private void shuffleGrammarButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_shuffleGrammarButtonActionPerformed
    {//GEN-HEADEREND:event_shuffleGrammarButtonActionPerformed
        mode = SHUFFLE;
        grammarAction();
    }//GEN-LAST:event_shuffleGrammarButtonActionPerformed

    private void chosenGrammarButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_chosenGrammarButtonActionPerformed
    {//GEN-HEADEREND:event_chosenGrammarButtonActionPerformed
        mode = CHOSEN;
        grammarAction();
    }//GEN-LAST:event_chosenGrammarButtonActionPerformed

    private void cycleGrammarButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_cycleGrammarButtonActionPerformed
    {//GEN-HEADEREND:event_cycleGrammarButtonActionPerformed
        mode = CYCLE;
        grammarAction();
    }//GEN-LAST:event_cycleGrammarButtonActionPerformed

    private void improviseButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_improviseButtonActionPerformed
    {//GEN-HEADEREND:event_improviseButtonActionPerformed
    boolean improvisationOn = improviseButton.isSelected();
    if( improvisationOn )
      {
        notateImprovisationOn();
     }
    else
      {
        notateImprovisationOff();
      }        
    }//GEN-LAST:event_improviseButtonActionPerformed

    public void improvisationOn()
    {
        improviseButton.setBackground(new Color(255, 0, 0));
        improviseButton.setText("<html><center>Stop</center></html>");
        improviseButton.setSelected(true);
    }
    
    public void improvisationOff()
    {
        improviseButton.setBackground(new Color(0, 255, 0));
        improviseButton.setText("<html><center>Improv</center></html>"); 
        improviseButton.setSelected(false);
    }
    
    private void notateImprovisationOn()
    {
        improvisationOn();
        notate.improvisationOn();
        notate.playAll();       
    }
    
    private void notateImprovisationOff()
    {
        improvisationOff();
        notate.improvisationOff();
        notate.stopPlaying();     
    }
    
    private void grammarAction()
    {
        currentSelection = grammarJlist.getSelectedValue();
        notate.grammarSelected(currentSelection, mode);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton chosenGrammarButton;
    private javax.swing.JRadioButton cycleGrammarButton;
    private javax.swing.ButtonGroup grammarButtonGroup;
    private javax.swing.JPanel grammarButtonPanel;
    private javax.swing.JList<String> grammarJlist;
    private javax.swing.JScrollPane grammarListScrollPane;
    private javax.swing.JToggleButton improviseButton;
    private javax.swing.JRadioButton shuffleGrammarButton;
    // End of variables declaration//GEN-END:variables
  }
