package cn.nomeatcoder.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 服务层配置类
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Configuration
@ComponentScan(
	basePackages = {
		"cn.nomeatcoder.demo.service",
		"cn.nomeatcoder.demo.schedule",
	}
)
public class coreConfig {
}
