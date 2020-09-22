package cn.nomeatcoder.demo.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 *
 * @author Chenzhe Mao
 * @date 2020-09-22
 */
@Component
public class HelloTask {
	@Scheduled(cron = "0/10 * * * * ? ")
	public void test() {
		System.out.println("----------我是定时任务，每隔10秒执行一次----------");
	}
}
