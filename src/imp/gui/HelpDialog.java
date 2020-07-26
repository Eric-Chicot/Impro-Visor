/**
 * This Java Class is part of the Impro-Visor Application
 *
 * Copyright (C) 2005-2018 Robert Keller and Harvey Mudd College
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

/**
 *
 * @author  keller
 */
public class HelpDialog extends javax.swing.JDialog {

    /** Creates new form HelpDialog */
    public HelpDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        helpTabbedPane = new javax.swing.JTabbedPane();
        helpByTopic = new javax.swing.JScrollPane();
        helpByTopicList = new javax.swing.JTextPane();
        alphaCommandPane = new javax.swing.JScrollPane();
        alphaCommandList = new javax.swing.JTextPane();
        melodyNotation = new javax.swing.JScrollPane();
        melodyNotationHelp = new javax.swing.JTextPane();
        chordListingPane = new javax.swing.JScrollPane();
        chordList = new javax.swing.JTextArea();
        SoloGenerator = new javax.swing.JScrollPane();
        soloGenInstructions = new javax.swing.JTextArea();
        customSoloGenerator = new javax.swing.JScrollPane();
        customSoloGenInstructions = new javax.swing.JTextArea();
        styleHelpPane = new javax.swing.JScrollPane();
        styleHelpList1 = new javax.swing.JTextArea();
        drawingHelpPane = new javax.swing.JScrollPane();
        drawingHelp = new javax.swing.JTextArea();
        roadmapHelpPane = new javax.swing.JScrollPane();
        roadmapHelp = new javax.swing.JTextArea();
        lickGenSettingsPane = new javax.swing.JScrollPane();
        lickGenSettings = new javax.swing.JTextArea();
        audioInputPane = new javax.swing.JScrollPane();
        audioInputPaneText = new javax.swing.JTextArea();
        transformFunctionsPane = new javax.swing.JScrollPane();
        functionDocumentationTextArea = new javax.swing.JTextArea();
        transformHelpPane = new javax.swing.JScrollPane();
        transformHelpTextArea = new javax.swing.JTextArea();
        guideToneHelpPane = new javax.swing.JScrollPane();
        guideToneHelpTextArea = new javax.swing.JTextArea();
        fractalHelpPane = new javax.swing.JScrollPane();
        fractalHelpTextArea = new javax.swing.JTextArea();
        CriticHelpPane = new javax.swing.JScrollPane();
        criticHelpTextArea = new javax.swing.JTextArea();
        deepLearningHelpPane = new javax.swing.JScrollPane();
        deepLearningHelpTextArea = new javax.swing.JTextArea();
        rhythmHelperHelpPane = new javax.swing.JScrollPane();
        rhythmHelperHelpTextPane = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(680, 800));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("imp/internationalize/Bundle"); // NOI18N
        helpTabbedPane.setToolTipText(bundle.getString("HelpDialog.helpTabbedPane.toolTipText")); // NOI18N
        helpTabbedPane.setMinimumSize(new java.awt.Dimension(500, 700));
        helpTabbedPane.setPreferredSize(new java.awt.Dimension(600, 800));

        helpByTopic.setMinimumSize(new java.awt.Dimension(500, 800));
        helpByTopic.setPreferredSize(new java.awt.Dimension(600, 900));

        helpByTopicList.setContentType(bundle.getString("CommonDialog.contentType")); // NOI18N
        helpByTopicList.setText(bundle.getString("HelpDialog.helpByTopicList.text")); // NOI18N
        helpByTopic.setViewportView(helpByTopicList);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.helpByTopic.TabConstraints.tabTitle"), helpByTopic); // NOI18N

        alphaCommandPane.setMinimumSize(new java.awt.Dimension(500, 800));
        alphaCommandPane.setPreferredSize(new java.awt.Dimension(600, 900));

        alphaCommandList.setContentType(bundle.getString("CommonDialog.contentType")); // NOI18N
        alphaCommandList.setText(bundle.getString("HelpDialog.alphaCommandList.text")); // NOI18N
        alphaCommandPane.setViewportView(alphaCommandList);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.alphaCommandPane.TabConstraints.tabTitle"), alphaCommandPane); // NOI18N

        melodyNotation.setToolTipText(bundle.getString("HelpDialog.melodyNotation.toolTipText")); // NOI18N
        melodyNotation.setMinimumSize(new java.awt.Dimension(500, 800));
        melodyNotation.setPreferredSize(new java.awt.Dimension(600, 900));

        melodyNotationHelp.setContentType(bundle.getString("CommonDialog.contentType")); // NOI18N
        melodyNotationHelp.setText(bundle.getString("HelpDialog.melodyNotationHelp.text")); // NOI18N
        melodyNotation.setViewportView(melodyNotationHelp);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.melodyNotation.TabConstraints.tabTitle"), melodyNotation); // NOI18N

        chordListingPane.setToolTipText(bundle.getString("HelpDialog.chordListingPane.toolTipText")); // NOI18N
        chordListingPane.setMinimumSize(new java.awt.Dimension(500, 800));
        chordListingPane.setPreferredSize(new java.awt.Dimension(600, 900));

        chordList.setEditable(false);
        chordList.setColumns(20);
        chordList.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        chordList.setRows(5);
        chordList.setText(bundle.getString("HelpDialog.chordList.text")); // NOI18N
        chordListingPane.setViewportView(chordList);
        chordList.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.chordListingPane.TabConstraints.tabTitle"), chordListingPane); // NOI18N

        SoloGenerator.setMinimumSize(new java.awt.Dimension(500, 800));
        SoloGenerator.setPreferredSize(new java.awt.Dimension(600, 900));

        soloGenInstructions.setEditable(false);
        soloGenInstructions.setColumns(20);
        soloGenInstructions.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        soloGenInstructions.setRows(5);
        soloGenInstructions.setText(bundle.getString("HelpDialog.soloGenInstructions.text")); // NOI18N
        SoloGenerator.setViewportView(soloGenInstructions);
        lickGenSettings.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.SoloGenerator.TabConstraints.tabTitle"), SoloGenerator); // NOI18N

        customSoloGenerator.setMinimumSize(new java.awt.Dimension(500, 800));
        customSoloGenerator.setPreferredSize(new java.awt.Dimension(600, 900));

        customSoloGenInstructions.setEditable(false);
        customSoloGenInstructions.setColumns(20);
        customSoloGenInstructions.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        customSoloGenInstructions.setRows(5);
        customSoloGenInstructions.setText(bundle.getString("HelpDialog.customSoloGenInstructions.text")); // NOI18N
        customSoloGenerator.setViewportView(customSoloGenInstructions);
        lickGenSettings.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.customSoloGenerator.TabConstraints.tabTitle"), customSoloGenerator); // NOI18N

        styleHelpPane.setMinimumSize(new java.awt.Dimension(500, 800));
        styleHelpPane.setPreferredSize(new java.awt.Dimension(600, 900));

        styleHelpList1.setEditable(false);
        styleHelpList1.setColumns(20);
        styleHelpList1.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        styleHelpList1.setRows(5);
        styleHelpList1.setText(bundle.getString("HelpDialog.styleHelpList1.text")); // NOI18N
        styleHelpPane.setViewportView(styleHelpList1);
        styleHelpList1.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.styleHelpPane.TabConstraints.tabTitle"), styleHelpPane); // NOI18N

        drawingHelpPane.setMinimumSize(new java.awt.Dimension(500, 800));
        drawingHelpPane.setPreferredSize(new java.awt.Dimension(600, 900));

        drawingHelp.setEditable(false);
        drawingHelp.setColumns(20);
        drawingHelp.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        drawingHelp.setRows(5);
        drawingHelp.setText(bundle.getString("HelpDialog.drawingHelp.text")); // NOI18N
        drawingHelpPane.setViewportView(drawingHelp);
        drawingHelp.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.drawingHelpPane.TabConstraints.tabTitle"), drawingHelpPane); // NOI18N

        roadmapHelpPane.setMinimumSize(new java.awt.Dimension(500, 800));
        roadmapHelpPane.setPreferredSize(new java.awt.Dimension(600, 900));

        roadmapHelp.setEditable(false);
        roadmapHelp.setColumns(20);
        roadmapHelp.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        roadmapHelp.setRows(5);
        roadmapHelp.setText(bundle.getString("HelpDialog.roadmapHelp.text")); // NOI18N
        roadmapHelpPane.setViewportView(roadmapHelp);
        roadmapHelp.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.roadmapHelpPane.TabConstraints.tabTitle"), roadmapHelpPane); // NOI18N

        lickGenSettingsPane.setMinimumSize(new java.awt.Dimension(500, 800));
        lickGenSettingsPane.setPreferredSize(new java.awt.Dimension(600, 900));

        lickGenSettings.setEditable(false);
        lickGenSettings.setColumns(20);
        lickGenSettings.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        lickGenSettings.setRows(5);
        lickGenSettings.setText(bundle.getString("HelpDialog.lickGenSettings.text")); // NOI18N
        lickGenSettingsPane.setViewportView(lickGenSettings);
        lickGenSettings.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.lickGenSettingsPane.TabConstraints.tabTitle"), lickGenSettingsPane); // NOI18N

        audioInputPane.setMinimumSize(new java.awt.Dimension(500, 800));
        audioInputPane.setPreferredSize(new java.awt.Dimension(600, 900));

        audioInputPaneText.setEditable(false);
        audioInputPaneText.setColumns(20);
        audioInputPaneText.setFont(new java.awt.Font("Lucida Console", 0, 13)); // NOI18N
        audioInputPaneText.setRows(5);
        audioInputPaneText.setText(bundle.getString("HelpDialog.audioInputPaneText.text")); // NOI18N
        audioInputPane.setViewportView(audioInputPaneText);
        lickGenSettings.setEditable(false);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.audioInputPane.TabConstraints.tabTitle"), audioInputPane); // NOI18N

        functionDocumentationTextArea.setEditable(false);
        functionDocumentationTextArea.setColumns(20);
        functionDocumentationTextArea.setRows(5);
        functionDocumentationTextArea.setTabSize(4);
        functionDocumentationTextArea.setText(bundle.getString("HelpDialog.functionDocumentationTextArea.text")); // NOI18N
        transformFunctionsPane.setViewportView(functionDocumentationTextArea);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.transformFunctionsPane.TabConstraints.tabTitle"), transformFunctionsPane); // NOI18N

        transformHelpPane.setMinimumSize(new java.awt.Dimension(502, 800));

        transformHelpTextArea.setEditable(false);
        transformHelpTextArea.setColumns(20);
        transformHelpTextArea.setRows(5);
        transformHelpTextArea.setTabSize(4);
        transformHelpTextArea.setText(bundle.getString("HelpDialog.transformHelpTextArea.text")); // NOI18N
        transformHelpPane.setViewportView(transformHelpTextArea);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.transformHelpPane.TabConstraints.tabTitle"), transformHelpPane); // NOI18N

        guideToneHelpPane.setMinimumSize(new java.awt.Dimension(502, 800));

        guideToneHelpTextArea.setEditable(false);
        guideToneHelpTextArea.setColumns(20);
        guideToneHelpTextArea.setRows(5);
        guideToneHelpTextArea.setTabSize(4);
        guideToneHelpTextArea.setText(bundle.getString("HelpDialog.guideToneHelpTextArea.text")); // NOI18N
        guideToneHelpPane.setViewportView(guideToneHelpTextArea);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.guideToneHelpPane.TabConstraints.tabTitle"), guideToneHelpPane); // NOI18N

        fractalHelpTextArea.setEditable(false);
        fractalHelpTextArea.setColumns(20);
        fractalHelpTextArea.setRows(5);
        fractalHelpTextArea.setText(bundle.getString("HelpDialog.fractalHelpTextArea.text")); // NOI18N
        fractalHelpTextArea.setToolTipText(bundle.getString("HelpDialog.fractalHelpTextArea.toolTipText")); // NOI18N
        fractalHelpPane.setViewportView(fractalHelpTextArea);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.fractalHelpPane.TabConstraints.tabTitle"), null, fractalHelpPane, bundle.getString("HelpDialog.fractalHelpPane.TabConstraints.tabToolTip")); // NOI18N

        criticHelpTextArea.setEditable(false);
        criticHelpTextArea.setColumns(20);
        criticHelpTextArea.setRows(5);
        criticHelpTextArea.setText(bundle.getString("HelpDialog.criticHelpTextArea.text")); // NOI18N
        criticHelpTextArea.setToolTipText(bundle.getString("HelpDialog.criticHelpTextArea.toolTipText")); // NOI18N
        CriticHelpPane.setViewportView(criticHelpTextArea);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.CriticHelpPane.TabConstraints.tabTitle"), null, CriticHelpPane, bundle.getString("HelpDialog.CriticHelpPane.TabConstraints.tabToolTip")); // NOI18N

        deepLearningHelpTextArea.setEditable(false);
        deepLearningHelpTextArea.setColumns(20);
        deepLearningHelpTextArea.setRows(5);
        deepLearningHelpTextArea.setText(bundle.getString("HelpDialog.deepLearningHelpTextArea.text")); // NOI18N
        deepLearningHelpTextArea.setToolTipText(bundle.getString("HelpDialog.deepLearningHelpTextArea.toolTipText")); // NOI18N
        deepLearningHelpPane.setViewportView(deepLearningHelpTextArea);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.deepLearningHelpPane.TabConstraints.tabTitle"), null, deepLearningHelpPane, bundle.getString("HelpDialog.deepLearningHelpPane.TabConstraints.tabToolTip")); // NOI18N

        rhythmHelperHelpTextPane.setColumns(20);
        rhythmHelperHelpTextPane.setRows(5);
        rhythmHelperHelpTextPane.setText(bundle.getString("HelpDialog.rhythmHelperHelpTextPane.text")); // NOI18N
        rhythmHelperHelpPane.setViewportView(rhythmHelperHelpTextPane);

        helpTabbedPane.addTab(bundle.getString("HelpDialog.rhythmHelperHelpPane.TabConstraints.tabTitle"), rhythmHelperHelpPane); // NOI18N

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(helpTabbedPane, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                HelpDialog dialog = new HelpDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CriticHelpPane;
    private javax.swing.JScrollPane SoloGenerator;
    private javax.swing.JTextPane alphaCommandList;
    private javax.swing.JScrollPane alphaCommandPane;
    private javax.swing.JScrollPane audioInputPane;
    private javax.swing.JTextArea audioInputPaneText;
    private javax.swing.JTextArea chordList;
    private javax.swing.JScrollPane chordListingPane;
    private javax.swing.JTextArea criticHelpTextArea;
    private javax.swing.JTextArea customSoloGenInstructions;
    private javax.swing.JScrollPane customSoloGenerator;
    private javax.swing.JScrollPane deepLearningHelpPane;
    private javax.swing.JTextArea deepLearningHelpTextArea;
    private javax.swing.JTextArea drawingHelp;
    private javax.swing.JScrollPane drawingHelpPane;
    private javax.swing.JScrollPane fractalHelpPane;
    private javax.swing.JTextArea fractalHelpTextArea;
    private javax.swing.JTextArea functionDocumentationTextArea;
    private javax.swing.JScrollPane guideToneHelpPane;
    private javax.swing.JTextArea guideToneHelpTextArea;
    private javax.swing.JScrollPane helpByTopic;
    private javax.swing.JTextPane helpByTopicList;
    private javax.swing.JTabbedPane helpTabbedPane;
    private javax.swing.JTextArea lickGenSettings;
    private javax.swing.JScrollPane lickGenSettingsPane;
    private javax.swing.JScrollPane melodyNotation;
    private javax.swing.JTextPane melodyNotationHelp;
    private javax.swing.JScrollPane rhythmHelperHelpPane;
    private javax.swing.JTextArea rhythmHelperHelpTextPane;
    private javax.swing.JTextArea roadmapHelp;
    private javax.swing.JScrollPane roadmapHelpPane;
    private javax.swing.JTextArea soloGenInstructions;
    private javax.swing.JTextArea styleHelpList1;
    private javax.swing.JScrollPane styleHelpPane;
    private javax.swing.JScrollPane transformFunctionsPane;
    private javax.swing.JScrollPane transformHelpPane;
    private javax.swing.JTextArea transformHelpTextArea;
    // End of variables declaration//GEN-END:variables
    public void showTransformationDocs()
    {
        helpTabbedPane.setSelectedComponent(transformFunctionsPane);
    }
}
