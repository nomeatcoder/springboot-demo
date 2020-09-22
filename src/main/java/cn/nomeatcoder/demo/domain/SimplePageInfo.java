package cn.nomeatcoder.demo.domain;

import lombok.Data;

import java.util.List;

/**
 * 简要分页信息
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Data
public class SimplePageInfo<T> {
	private List<T> list;
	private long count;
	private int pageSize;
	private int page;
}
