package cn.nomeatcoder.demo.config;

import cn.nomeatcoder.demo.interceptor.Interceptor1;
import cn.nomeatcoder.demo.interceptor.Interceptor2;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web配置
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Configuration
@ComponentScan(
	basePackages = {
		"cn.nomeatcoder.demo.controller"
	}
)
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器，order越小越优先，拦截路径为所有路径
		registry.addInterceptor(new Interceptor1()).order(1).addPathPatterns("/**");
		registry.addInterceptor(new Interceptor2()).order(2).addPathPatterns("/**");
	}

}
