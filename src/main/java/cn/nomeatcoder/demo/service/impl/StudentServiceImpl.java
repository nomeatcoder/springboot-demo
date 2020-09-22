package cn.nomeatcoder.demo.service.impl;

import cn.nomeatcoder.demo.dao.StudentMapper;
import cn.nomeatcoder.demo.domain.BizException;
import cn.nomeatcoder.demo.domain.Student;
import cn.nomeatcoder.demo.domain.StudentQuery;
import cn.nomeatcoder.demo.service.StudentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * service
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

	@Resource
	private StudentMapper studentMapper;

	@Override
	public List<Student> findAll() {
		return studentMapper.findAll();
	}

	@Override
	public Student getById(Long id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Student> find(StudentQuery query) {
		return studentMapper.find(query);
	}

	@Override
	public PageInfo<Student> findByPage(StudentQuery query) {
		PageHelper.startPage(query.getCurrentPage(), query.getPageSize());
		List<Student> list = studentMapper.find(query);
		PageInfo<Student> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	@Override
	public void insert(Student student) {
		Student old = studentMapper.selectByPrimaryKey(student.getId());
		if (old != null) {
			throw new BizException(-1, "该记录已存在");
		}
		studentMapper.insert(student);
	}

	@Override
	public void update(Student student) {
		Student old = studentMapper.selectByPrimaryKey(student.getId());
		if (old == null) {
			throw new BizException(-1, "该记录不存在");
		}
		studentMapper.updateByPrimaryKeySelective(student);
	}

	@Override
	public void delete(Long id) {
		Student old = studentMapper.selectByPrimaryKey(id);
		if (old == null) {
			throw new BizException(-1, "该记录不存在");
		}
		studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteBatch(List<Long> ids) {
		StudentQuery query = new StudentQuery();
		query.setIds(ids);
		List<Student> list = studentMapper.find(query);
		if (list.size() != ids.size()) {
			throw new BizException(-1, "部分记录不存在");
		}
		studentMapper.deleteBatch(ids);
	}
}
