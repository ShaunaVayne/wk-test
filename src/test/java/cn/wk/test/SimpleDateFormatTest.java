package cn.wk.test;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/4/26 3:47 PM
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public class SimpleDateFormatTest {

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");



	public static String formatDate2(LocalDateTime date) {
		return formatter.format(date);
	}

	public static LocalDateTime parse2(String dateNow) {
		return LocalDateTime.parse(dateNow, formatter);
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService service = Executors.newFixedThreadPool(100);
		// 20个线程
		AtomicInteger atomicInteger = new AtomicInteger();
		for (int i = 0; i < 20; i++) {
			service.execute(() -> {
				for (int j = 0; j < 10; j++) {
					try {
						System.out.println(parse2(formatDate2(LocalDateTime.now())));
						atomicInteger.incrementAndGet();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		// 等待上述的线程执行完
		service.shutdown();
		service.awaitTermination(1, TimeUnit.DAYS);
		System.out.println(atomicInteger.get());
	}

}
