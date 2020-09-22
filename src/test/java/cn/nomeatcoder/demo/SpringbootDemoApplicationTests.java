package cn.nomeatcoder.demo;

import cn.nomeatcoder.demo.application.SpringbootDemoApplication;
import cn.nomeatcoder.demo.dao.StudentMapper;
import cn.nomeatcoder.demo.domain.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest(
	classes = SpringbootDemoApplication.class
)
public class SpringbootDemoApplicationTests {

	@Resource
	private StudentMapper studentMapper;

	private Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

	@Test
	public void testFindAll() {
		List<Student> list = studentMapper.findAll();
		System.out.println(gson.toJson(list));
	}

}
