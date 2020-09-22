package cn.nomeatcoder.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;

@Data
public class ServerResponse<T> implements Serializable {

	private Integer code;
	private String msg;
	private T data;

	public ServerResponse(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> ServerResponse success(T data) {
		return success("操作成功", data);
	}

	public static ServerResponse success(String msg) {
		return success(msg, null);
	}

	public static <T> ServerResponse success(String msg, T data) {
		return new ServerResponse(0, msg, data);
	}

	public static ServerResponse success() {
		return new ServerResponse(0, "操作成功", null);
	}

	public static ServerResponse error(String msg) {
		return error(1, msg);
	}

	public static ServerResponse error() {
		return error(1, "操作失败");
	}

	public static ServerResponse error(String msg, Object data) {
		return error(1, msg, data);
	}

	public static ServerResponse error(Integer code, String msg) {
		return new ServerResponse(code, msg, null);
	}

	public static ServerResponse error(Integer code, String msg, Object data) {
		return new ServerResponse(code, msg, data);
	}

	@JsonIgnore
	public boolean isSuccess() {
		return this.code.equals(200);
	}

}
