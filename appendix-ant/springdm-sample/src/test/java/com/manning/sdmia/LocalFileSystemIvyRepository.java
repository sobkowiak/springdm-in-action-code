/**
 * 
 */
package com.manning.sdmia;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.osgi.test.provisioning.ArtifactLocator;

/**
 * @author acogoluegnes
 *
 */
public class LocalFileSystemIvyRepository implements ArtifactLocator {
	
	private String libDirectory = "./lib";
	
	private static final String fileSeparator = System.getProperty("file.separator");

	/* (non-Javadoc)
	 * @see org.springframework.osgi.test.provisioning.ArtifactLocator#locateArtifact(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Resource locateArtifact(String groupId, String artifactId, String version) {
		return new FileSystemResource(libDirectory+fileSeparator+artifactId+"-"+version+".jar");
	}

	/* (non-Javadoc)
	 * @see org.springframework.osgi.test.provisioning.ArtifactLocator#locateArtifact(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public Resource locateArtifact(String groupId, String artifactId, String version,
			String type) {
		return locateArtifact(groupId, artifactId, version, null);
	}
	
	public void setLibDirectory(String libDirectory) {
		this.libDirectory = libDirectory;
	}

}
