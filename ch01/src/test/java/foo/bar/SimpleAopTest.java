/**
 * 
 */
package foo.bar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import foo.bar.aop.NotifierAspect;
import foo.bar.notify.CountNotifier;
import foo.bar.service.BusinessService;

/**
 * @author acogoluegnes
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SimpleAopTest {
	
	@Autowired
	private BusinessService service;
	
	@Autowired
	private CountNotifier notifier;

	@Test public void aop() {
		Assert.assertEquals(0,notifier.getCount());
		service.createUser(null);
		Assert.assertEquals(1,notifier.getCount());
	}
	
}
