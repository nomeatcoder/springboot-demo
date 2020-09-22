package cn.nomeatcoder.demo.domain;

import lombok.Data;

import java.util.List;

/**
 * 学生实体类
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Data
public class StudentQuery {
	private Long id;

	private Integer age;

	private Integer gender;

	private String name;

	private Integer pageSize;

	private Integer currentPage;

	private List<Long> ids;
}