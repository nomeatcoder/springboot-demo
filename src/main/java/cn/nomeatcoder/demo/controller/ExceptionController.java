package cn.nomeatcoder.demo.controller;

import cn.nomeatcoder.demo.domain.BizException;
import cn.nomeatcoder.response.ServerResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ServerResponse<Void> exception(Exception e) {
		// 如果是业务异常,透传code和msg,
		if (e instanceof BizException) {
			return ServerResponse.error(((BizException) e).getCode(), e.getMessage());
		} else if (e instanceof IllegalArgumentException) {
			// 如果是参数异常
			return ServerResponse.error(1, "参数错误: " + e.getMessage());
		}
		// 否则使用通用code和错误信息
		return ServerResponse.error(1, "系统有点小问题~");
	}
}
