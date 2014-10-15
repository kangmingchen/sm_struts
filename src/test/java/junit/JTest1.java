package junit;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.x.base.model.A;
import com.x.base.model.PageInfo;
import com.x.base.service.AService;

/**
 * <p>
 * Title:JTest1
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @Author Chenkangming @Date 2013-11-21
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring*.xml" })
public class JTest1 {

	@Autowired
	AService t1;

	@Test
	public void test() {
		// try {
		t1.insert();
//		t1.update();
		// t2.insert();
		// } catch (Exception e) {
		// System.out.println(e);
		// }
		
		PageInfo pageInfo=t1.pageInfo();

		List<A> list = t1.list(pageInfo);
		for (A a : list) {
			System.out.println(a.getValue1());
		}
		
		
//		t1.delete();
	}
}
