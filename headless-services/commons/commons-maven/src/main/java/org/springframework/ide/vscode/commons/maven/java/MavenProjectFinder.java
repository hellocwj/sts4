/*******************************************************************************
 * Copyright (c) 2017 Pivotal, Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Pivotal, Inc. - initial API and implementation
 *******************************************************************************/
package org.springframework.ide.vscode.commons.maven.java;

import java.io.File;

import org.springframework.ide.vscode.commons.java.IJavaProject;
import org.springframework.ide.vscode.commons.languageserver.java.FileBasedJavaProjectFinder;
import org.springframework.ide.vscode.commons.maven.MavenCore;
import org.springframework.ide.vscode.commons.util.FileUtils;

/**
 * Finds Maven projects. Looks for <code>pom.xml</code> file
 * 
 * @author Alex Boyko
 *
 */
public class MavenProjectFinder extends FileBasedJavaProjectFinder {
	
	private MavenProjectCache cache;
	
	public MavenProjectFinder(MavenProjectCache cache) {
		this.cache = cache;
	}

	@Override
	public IJavaProject find(File file) {
		File pomFile = FileUtils.findFile(file, MavenCore.POM_XML);
		return cache.project(pomFile);
	}
}
