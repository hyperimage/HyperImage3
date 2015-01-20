/*
 * CDDL HEADER START
 *
 * The contents of this file are subject to the terms of the
 * Common Development and Distribution License, Version 1.0 only
 * (the "License").  You may not use this file except in compliance
 * with the License.
 *
 * You can obtain a copy of the license at license/HYPERIMAGE.LICENSE
 * or http://www.sun.com/cddl/cddl.html.
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL HEADER in each
 * file and include the License file at license/HYPERIMAGE.LICENSE.
 * If applicable, add the following below this CDDL HEADER, with the
 * fields enclosed by brackets "[]" replaced with your own identifying
 * information: Portions Copyright [yyyy] [name of copyright owner]
 *
 * CDDL HEADER END
 */

/*
 * Copyright 2006-2009 Humboldt-Universitaet zu Berlin
 * All rights reserved.  Use is subject to license terms.
 */

/*
 * Copyright 2014 Leuphana Universität Lüneburg
 * All rights reserved.  Use is subject to license terms.
 */

package org.hyperimage.client.gui.dialogs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.hyperimage.client.Messages;
import org.hyperimage.client.xmlimportexport.XMLImporter;

/**
 *
 * @author Jens-Martin Loebel
 */
public class XMLImportProjectDialog extends javax.swing.JDialog {
    private final Frame parent;
    private final JFileChooser importXMLChooser;
    private File importXMLFile = null;
    private static final String PeTAL_Description = "PeTAL 3.0 / 2.0 XML";
    private static final String VRA4_Description = "VRA Core 4 XML";
    private static final FileFilter petalFileFilter = new FileNameExtensionFilter(PeTAL_Description, "xml");
    private static final FileFilter vra4FileFilter = new FileNameExtensionFilter(VRA4_Description, "xml");
    private XMLImporter.XMLFormat chosenFormat = XMLImporter.XMLFormat.UNRECOGNISED;

    public XMLImportProjectDialog(Frame parent) {
        super(parent);
        this.parent = parent;
        this.setModal(true);

        // setup file chooser
        importXMLChooser = new JFileChooser();
        importXMLChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        importXMLChooser.setMultiSelectionEnabled(true);
        importXMLChooser.setFileHidingEnabled(true);
        importXMLChooser.setAcceptAllFileFilterUsed(false);
        importXMLChooser.addChoosableFileFilter(petalFileFilter);
        // Default format preselected in dropdown:
        importXMLChooser.setFileFilter(petalFileFilter);

        initComponents();
    }

    public boolean displayImportDialog() {
        // set dialog size, center on screen
        this.setBounds(
                (parent.getWidth() / 2) - (this.getWidth() / 2),
                (parent.getHeight() / 2) - (this.getHeight() / 2),
                this.getWidth(),
                this.getHeight());

        // init import xml file
        this.importXMLFile = null;

        // update on-screen language
        updateLanguage();

        // display dialog
        this.setVisible(true);

        // check if user selected a valid import xml file
        if (importXMLFile != null) {
            return true;
        }
        return false;
    }

    public File getImportXMLFile() {
        return this.importXMLFile;
    }

    private void updateLanguage() {
        setTitle(Messages.getString("XMLImportProjectDialog.0")); // NOI18N
        infoLabel.setText("<html>" + Messages.getString("XMLImportProjectDialog.1") + "</html>"); // NOI18N
        importButton.setText(Messages.getString("XMLImportProjectDialog.2")); // NOI18N
        cancelButton.setText(Messages.getString("XMLImportProjectDialog.3")); // NOI18N
        ((TitledBorder) importPanel.getBorder()).setTitle(Messages.getString("XMLImportProjectDialog.5")); // NOI18N
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {



        importPanel = new JPanel();
        infoLabel = new JLabel();
        importButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Messages.getString("XMLImportProjectDialog.0")); // NOI18N
        importPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Lucida Grande", 0, 13), Color.blue)); // NOI18N
        infoLabel.setText(Messages.getString("XMLImportProjectDialog.1")); // NOI18N
        infoLabel.setVerticalAlignment(SwingConstants.TOP);

        GroupLayout importPanelLayout = new GroupLayout(importPanel);
        importPanel.setLayout(importPanelLayout);
        importPanelLayout.setHorizontalGroup(
            importPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(importPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel, GroupLayout.PREFERRED_SIZE, 634, Short.MAX_VALUE)
                .addContainerGap())
        );
        importPanelLayout.setVerticalGroup(
            importPanelLayout.createParallelGroup(Alignment.LEADING)
            .addGroup(importPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(infoLabel, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        importButton.setText(Messages.getString("XMLImportProjectDialog.2")); // NOI18N
        importButton.setActionCommand("import"); // NOI18N
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        cancelButton.setText(Messages.getString("XMLImportProjectDialog.3")); // NOI18N
        cancelButton.setActionCommand("cancel"); // NOI18N
        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                    .addComponent(importPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(importButton)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(importPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(importButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    /*
     * Handle GUI Events
     */
    private void buttonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        if (evt.getActionCommand().equalsIgnoreCase("cancel")) {
            importXMLFile = null;
            this.setVisible(false);
        } else if (evt.getActionCommand().equalsIgnoreCase("import")) {
            // select import file
            importXMLChooser.showOpenDialog(parent);
            importXMLFile = importXMLChooser.getSelectedFile();
            String strFileDescription = (importXMLChooser.getFileFilter()).getDescription();
            if( strFileDescription.equals(PeTAL_Description) ) {
                chosenFormat = XMLImporter.XMLFormat.PETAL_2_0_XML;
            } else if( strFileDescription.equals(VRA4_Description) ) { // not currently in use (filefilter inactive)
                chosenFormat = XMLImporter.XMLFormat.VRA_4_XML;
            } 

            if (!(importXMLFile == null)) {
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_buttonActionPerformed

    public boolean isPeTAL_Expected() {
        return chosenFormat == XMLImporter.XMLFormat.PETAL_2_0_XML;
    }
    
    public boolean isVRA4_Expected() {
        return chosenFormat == XMLImporter.XMLFormat.VRA_4_XML;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton cancelButton;
    private JButton importButton;
    private JPanel importPanel;
    private JLabel infoLabel;
    // End of variables declaration//GEN-END:variables

}
