package cn.nomeatcoder.demo.request;

import lombok.Data;

import java.util.List;

/**
 * 请求
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Data
public class StudentRequest {

	private Long id;

	private Integer age;

	private Integer gender;

	private String name;

	private Integer pageSize;

	private Integer currentPage;

	private List<Long> ids;

}
