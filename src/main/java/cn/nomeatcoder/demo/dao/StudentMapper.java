package cn.nomeatcoder.demo.dao;

import cn.nomeatcoder.demo.domain.Student;
import cn.nomeatcoder.demo.domain.StudentQuery;

import java.util.List;

/**
 * mapper
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
public interface StudentMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);

	List<Student> findAll();

	List<Student> find(StudentQuery query);

	int deleteBatch(List<Long> ids);
}