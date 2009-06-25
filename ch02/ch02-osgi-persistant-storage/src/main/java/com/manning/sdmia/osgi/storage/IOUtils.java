/**
 * 
 */
package com.manning.sdmia.osgi.storage;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * @author ttemplier
 *
 */
public abstract class IOUtils {

	public static void closeWriter(Writer writer) {
		if (writer!=null) {
			try {
				writer.close();
			} catch(IOException ex) {}
		}
	}

	public static void closeReader(Reader reader) {
		if (reader!=null) {
			try {
				reader.close();
			} catch(IOException ex) {}
		}
	}

}
