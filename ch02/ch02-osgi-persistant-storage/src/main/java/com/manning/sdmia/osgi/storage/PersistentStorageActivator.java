/**
 * 
 */
package com.manning.sdmia.osgi.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author ttemplier
 *
 */
public class PersistentStorageActivator implements BundleActivator {

	private void printDataFileInformation(BundleContext bundleContext) {
		System.out.println("");
		System.out.println("Print persistent storage information.");
		File directory = bundleContext.getDataFile("/data");
		if (!directory.exists()) {
			System.out.println("Directory data doesn't exist.");
			return;
		}
		
		File dataFile = bundleContext.getDataFile("/data/test.txt");
		if (!dataFile.exists()) {
			System.out.println("File /data/test.txt doesn't exist.");
			return;
		}

		BufferedReader reader = null;
		try {
		    reader = new BufferedReader(new FileReader(dataFile));
		    String line = null;
		    System.out.println("-- Data of file /data/test.txt");
		    while ((line = reader.readLine())!=null) {
		    	System.out.println(line + "\n");
		    }
		    System.out.println("------------------------------");
		} catch(IOException ex) {
		    ex.printStackTrace();
		} finally {
		    IOUtils.closeReader(reader);
		}
	}

	private void managePersistentStorage(BundleContext bundleContext) {
		System.out.println("");
		System.out.println("Updating persistent storage...");
		File directory = bundleContext.getDataFile("/data");
		if (!directory.exists()) {
		    directory.mkdir();
		}

		File file = bundleContext.getDataFile("/data/test.txt");
		FileWriter writer = null;
		try {
		    writer = new FileWriter(file, true);
		    writer.write("my content");
		    System.out.println("File /data/test.txt updated.");
		} catch(IOException ex) {
		    ex.printStackTrace();
		} finally {
		    IOUtils.closeWriter(writer);
		}
	}

	public void start(BundleContext bundleContext) throws Exception {
		printDataFileInformation(bundleContext);
		managePersistentStorage(bundleContext);
		printDataFileInformation(bundleContext);
	}

	private void cleanPersistentStorage(BundleContext bundleContext) {
		System.out.println("");
		System.out.println("Cleaning persistent storage...");

		File directory = bundleContext.getDataFile("/data");
		File dataFile = bundleContext.getDataFile("/data/test.txt");

		if (dataFile.exists()) {
			dataFile.delete();
		}
		
		if (directory.exists()) {
			directory.delete();
		}
	}
	
	public void stop(BundleContext bundleContext) throws Exception {
		//cleanPersistentStorage(bundleContext);
	}

}
