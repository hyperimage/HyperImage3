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

package org.hyperimage.client.gui.lists;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import org.hyperimage.client.util.MetadataHelper;
import org.hyperimage.client.ws.HiProject;

/**
 * @author Jens-Martin Loebel
 */
public class ProjectListCellRenderer extends JPanel implements ListCellRenderer {

	private static final long serialVersionUID = 3829240390573554917L;

	
	JLabel projectLabel;
	
	public ProjectListCellRenderer() {
		projectLabel = new JLabel();
		this.setLayout(new BorderLayout());
		this.add(projectLabel, BorderLayout.CENTER);
		this.setBorder(new EmptyBorder(0,5,0,5));
	}
	
	
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {

		if (isSelected) {
            this.setBackground(list.getSelectionBackground());
            projectLabel.setForeground(list.getSelectionForeground());
        } else {
            this.setBackground(list.getBackground());
            projectLabel.setForeground(list.getForeground());
        }
        this.setEnabled(list.isEnabled());
        this.setOpaque(true);
		
		if ( ! list.isEnabled() )
			projectLabel.setForeground(Color.gray);
		
		HiProject project = (HiProject) value;
		
		String title = MetadataHelper.findValue(project, project.getDefaultLanguage().getLanguageId());
		if ( title == null )
			title = "Unbenanntes Project (P"+project.getId()+")";
		else if ( title.length() == 0 )
			title = "Unbenanntes Project (P"+project.getId()+")";
		projectLabel.setText(title);
		
		return this;
	}

}