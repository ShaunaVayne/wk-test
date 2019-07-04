package cn.wk.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.scheduling.annotation.Async;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/6/27 11:06 PM
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Slf4j
public class AsyncTest {

	@Test
	public void test() {
		log.info("外部方法调用开始:{}",System.currentTimeMillis());
		testAsync();
		log.info("外部方法调用结束:{}",System.currentTimeMillis());
	}

	@Async
	public void testAsync() {
		log.info("调用内部方法开始:",System.currentTimeMillis());
		try {
			Thread.sleep(3000l);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("调用内部方法结束:",System.currentTimeMillis());
	}
}
