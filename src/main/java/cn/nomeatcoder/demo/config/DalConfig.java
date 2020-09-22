package cn.nomeatcoder.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 数据层配置类
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Configuration
@MapperScan(
	// 扫描dao
	basePackages = {
		"cn.nomeatcoder.demo.dao"
	}
)
public class DalConfig {
}
