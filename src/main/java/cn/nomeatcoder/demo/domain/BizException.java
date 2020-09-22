package cn.nomeatcoder.demo.domain;

import lombok.Data;

/**
 * 业务异常
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Data
public class BizException extends RuntimeException {

	private int code;
	private String message;

	public BizException(Integer code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
}
