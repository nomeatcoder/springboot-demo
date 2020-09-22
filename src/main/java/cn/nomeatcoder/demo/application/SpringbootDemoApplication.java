package cn.nomeatcoder.demo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@SpringBootApplication
@ComponentScan(
	//扫描bean
	basePackages = {
		"cn.nomeatcoder.demo.config"
	}
)
@EnableScheduling
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);
	}

}
