/* $Id: HIWSLoggedException.java 133 2009-08-25 12:05:53Z jmloebel $ */

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

package org.hyperimage.connector.exception;

/**
 * In the interests of security, the details of exceptions which have an unknown cause are not passed
 * to the calling application. They are instead written to the server log for analysis by authorised
 * personnel at a later date
 * 
 * @author Heinz-Günter Kuper
 */
public class HIWSLoggedException extends Exception {

	/**
	 * 03-09-2008
	 */
	private static final long serialVersionUID = -8017455482377475870L;

	public HIWSLoggedException(String message) {
		super(message);
	}
}
