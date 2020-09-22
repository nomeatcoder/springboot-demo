package cn.nomeatcoder.demo.service;

import cn.nomeatcoder.demo.domain.Student;
import cn.nomeatcoder.demo.domain.StudentQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * service
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
public interface StudentService {

	/**
	 * 查询所有学生
	 *
	 * @return
	 */
	List<Student> findAll();

	/**
	 * 根据id查询学生
	 *
	 * @param id
	 * @return
	 */
	Student getById(Long id);

	/**
	 * 根据条件查询学生
	 *
	 * @param query
	 * @return
	 */
	List<Student> find(StudentQuery query);

	/**
	 * 根据条件查询学生
	 *
	 * @param query
	 * @return
	 */
	PageInfo<Student> findByPage(StudentQuery query);

	/**
	 * 新增一个学生
	 *
	 * @param student
	 * @return
	 */
	void insert(Student student);

	/**
	 * 更新一个学生
	 *
	 * @param student
	 * @return
	 */
	void update(Student student);

	/**
	 * 删除一个学生
	 *
	 * @param id
	 * @return
	 */
	void delete(Long id);

	/**
	 * 批量删除学生
	 *
	 * @param ids
	 * @return
	 */
	void deleteBatch(List<Long> ids);

}
