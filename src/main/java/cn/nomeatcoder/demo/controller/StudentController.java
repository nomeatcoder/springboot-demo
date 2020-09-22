package cn.nomeatcoder.demo.controller;

import cn.nomeatcoder.demo.domain.SimplePageInfo;
import cn.nomeatcoder.demo.domain.Student;
import cn.nomeatcoder.demo.domain.StudentQuery;
import cn.nomeatcoder.demo.request.StudentRequest;
import cn.nomeatcoder.demo.service.StudentService;
import cn.nomeatcoder.demo.vo.StudentVO;
import cn.nomeatcoder.response.ServerResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * controller
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@RestController
@RequestMapping("student")
public class StudentController {

	@Resource
	private StudentService studentService;

	@GetMapping("findAll")
	public ServerResponse<List<StudentVO>> findAll() {
		List<StudentVO> list = studentService.findAll().stream()
			.map(v -> convertStudent2VO(v))
			.collect(Collectors.toList());
		if (CollectionUtils.isEmpty(list)) {
			return ServerResponse.error("记录不存在");
		}
		return ServerResponse.success(list);
	}

	@PostMapping("getById")
	public ServerResponse<StudentVO> getById(@RequestBody StudentRequest request) {
		Assert.notNull(request, "request is null");
		Assert.notNull(request.getId(), "id is null");
		Student student = studentService.getById(request.getId());
		if (student == null) {
			return ServerResponse.error("记录不存在");
		}
		return ServerResponse.success(convertStudent2VO(student));
	}

	@PostMapping("find")
	public ServerResponse<StudentVO> find(@RequestBody StudentRequest request) {
		Assert.notNull(request, "request is null");
		StudentQuery query = new StudentQuery();
		BeanUtils.copyProperties(request, query);
		List<StudentVO> list = studentService.find(query).stream()
			.map(v -> convertStudent2VO(v))
			.collect(Collectors.toList());
		if (CollectionUtils.isEmpty(list)) {
			return ServerResponse.error("记录不存在");
		}
		return ServerResponse.success(list);
	}

	@PostMapping("findByPage")
	public ServerResponse<StudentVO> findByPage(@RequestBody StudentRequest request) {
		Assert.notNull(request, "request is null");
		if (request.getPageSize() == null) {
			request.setPageSize(5);
		}
		if (request.getCurrentPage() == null) {
			request.setCurrentPage(0);
		}
		StudentQuery query = new StudentQuery();
		BeanUtils.copyProperties(request, query);
		PageInfo<Student> pageInfo = studentService.findByPage(query);
		if (CollectionUtils.isEmpty(pageInfo.getList())) {
			return ServerResponse.error("记录不存在");
		}
		SimplePageInfo<StudentVO> simplePageInfo = new SimplePageInfo<>();
		simplePageInfo.setList(
			pageInfo.getList().stream()
				.map(v -> convertStudent2VO(v))
				.collect(Collectors.toList())
		);
		simplePageInfo.setCount(pageInfo.getTotal());
		simplePageInfo.setPage(pageInfo.getPages());
		simplePageInfo.setPageSize(pageInfo.getPageSize());
		return ServerResponse.success(simplePageInfo);
	}

	@PostMapping("insert")
	public ServerResponse<Void> insert(@RequestBody StudentRequest request) {
		Assert.notNull(request, "request is null");
		Assert.notNull(request.getName(), "name is null");
		Assert.notNull(request.getAge(), "age is null");
		Assert.notNull(request.getGender(), "gender is null");
		Student student = new Student();
		BeanUtils.copyProperties(request, student);
		studentService.insert(student);
		return ServerResponse.success();
	}

	@PostMapping("update")
	public ServerResponse<Void> update(@RequestBody StudentRequest request) {
		Assert.notNull(request, "request is null");
		Assert.notNull(request.getId(), "id is null");
		Student student = new Student();
		BeanUtils.copyProperties(request, student);
		studentService.update(student);
		return ServerResponse.success();
	}

	@PostMapping("delete")
	public ServerResponse<Void> delete(@RequestBody StudentRequest request) {
		Assert.notNull(request, "request is null");
		Assert.notNull(request.getId(), "id is null");
		studentService.delete(request.getId());
		return ServerResponse.success();
	}

	@PostMapping("deleteBatch")
	public ServerResponse<Void> deleteBatch(@RequestBody StudentRequest request) {
		Assert.notNull(request, "request is null");
		Assert.isTrue(!CollectionUtils.isEmpty(request.getIds()), "ids is null");
		studentService.deleteBatch(request.getIds());
		return ServerResponse.success();
	}

	@GetMapping("test")
	public ServerResponse<Void> test() {
//		throw new BizException(1,"哈哈");
		int i = 1 / 0;
		return ServerResponse.success();
	}

	private StudentVO convertStudent2VO(Student student) {
		StudentVO vo = new StudentVO();
		vo.setId(student.getId());
		vo.setAge(student.getAge());
		vo.setGender(student.getGender());
		vo.setName(student.getName());
		return vo;
	}


}
