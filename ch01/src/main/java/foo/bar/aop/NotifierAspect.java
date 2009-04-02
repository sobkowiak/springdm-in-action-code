/**
 * 
 */
package foo.bar.aop;

import foo.bar.notify.Notifier;

/**
 * @author acogoluegnes
 *
 */
public class NotifierAspect {

	private Notifier notifier;

	public void userCreated() {
		notifier.notify("User created");
	}

	public void setNotifier(Notifier notifier) {
		this.notifier = notifier;
	}
	
}
