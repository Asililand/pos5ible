package pos5ible;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.pos5ible.dao.ForumDao;
import com.edu.pos5ible.dao.UserDao;
import com.edu.pos5ible.entity.Content;
import com.edu.pos5ible.entity.Page;
import com.edu.pos5ible.entity.User;
import com.edu.pos5ible.exception.userException.UserException;
import com.edu.pos5ible.service.CheckEmailService;
import com.edu.pos5ible.service.ForumService;
import com.edu.pos5ible.util.JsonResult;
import com.edu.pos5ible.util.Util;
import com.edu.pos5ible.web.ForumController;
import com.edu.pos5ible.web.UserController;

public class TestCase {

	ClassPathXmlApplicationContext ctx;
	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-mvc.xml","spring-aop.xml","spring-service.xml");
	}
	
	@Test
	public void test1() {
		String userNick = "Aseliland";
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		User user = dao.findUserByNick(userNick);
		System.out.println(user);
	}
	
	@Test
	public void test2() {
		String email = "sh695777036@gmail.com";
		UserDao dao = ctx.getBean("userDao",UserDao.class);
		String md5 = new Util().getSaltMD5(email);
		System.out.println(md5);
	}
	
	@Test
	public void test3() {
		CheckEmailService service = ctx.getBean("checkEmailService",CheckEmailService.class);
		System.out.println(service);
	}
	
	@Test
	public void test4() {
		UserController uc = ctx.getBean("userController",UserController.class);
		System.out.println(uc);
		Object jr = uc.login("Asililand", "admin", null);
		System.out.println(jr);
	}
	
	@Test
	public void test5() {
		UserDao ud = ctx.getBean("userDao",UserDao.class);
		Page page = new Page(0,10,0);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", 2);
		map.put("number", page.getNumber());
		map.put("pagination", page.getPagination());
		List<Integer> list = ud.findFollow(2,page);
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	@Test
	public void test6() {
		ForumController fc = ctx.getBean("forumController",ForumController.class);
		Page page = new Page(0,10,0);
	}
	
	@Test
	public void test7() {
		ForumService fc = ctx.getBean("forumService",ForumService.class);
		Integer forumId = 1;
		Integer userId = 2;
		Integer isLike = 1;
		System.out.println(fc.isLikeForum(forumId, isLike, userId));
	}
}













