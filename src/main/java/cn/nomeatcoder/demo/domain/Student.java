package cn.nomeatcoder.demo.domain;

import lombok.Data;

import java.util.Date;

/**
 * 学生实体类
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Data
public class Student {
	private Long id;

	private Integer age;

	private Integer gender;

	private String name;

	private Date createTime;

	private Date modifiedTime;
}