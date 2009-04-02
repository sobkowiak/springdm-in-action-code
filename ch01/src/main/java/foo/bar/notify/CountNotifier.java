/**
 * 
 */
package foo.bar.notify;

/**
 * @author acogoluegnes
 *
 */
public class CountNotifier implements Notifier {

	private int count = 0;
	
	@Override
	public void notify(Object message) {
		count++;		
	}

	public int getCount() {
		return count;
	}
	
}
