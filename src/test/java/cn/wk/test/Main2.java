package cn.wk.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/14 下午4:24
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class Main2 {

	@Test
	public void test() {
		String time = String.valueOf(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())) - 1);
		System.out.println(time);
	}

	@Test
	public void test2() {
		String secretKey = null;
		/*if(secretKey!=null && !"".equals(secretKey)){
			System.out.println("1");
			*//*mailStrs = props.get("SUCC_EMAIL_NEW").replace("$(client)", contact).replace(
					"$(date)", day.substring(0, 8)).replace("$(order)", extId).replace("$(secretKey)",secretKey).replace("$(downLink)",
					downLink);*//*
		}else{
			System.out.println("2");
			*//*mailStrs = props.get("SUCC_EMAIL").replace("$(client)", contact).replace(
					"$(date)", day.substring(0, 8)).replace("$(order)", extId).replace("$(downLink)",downLink);*//*
		}*/

		if(secretKey!=null&&!"".equals(secretKey)){
			System.out.println("1");
			/*mailStrs = props.get("SUCC_EMAIL_NEW").replace("$(client)", contact).replace(
					"$(date)", day.substring(0, 8)).replace("$(order)", extId).replace("$(secretKey)",secretKey).replace("$(downLink)",
					downLink);*/
		}else{
			System.out.println("2");
			/*mailStrs = props.get("SUCC_EMAIL").replace("$(client)", contact).replace(
					"$(date)", day.substring(0, 8)).replace("$(order)", extId).replace("$(downLink)",downLink);*/
		}
	}

	@Test
	public void test3() {
		String name = "1.12.123.txt";
		String s = name.substring(name.lastIndexOf(".") + 1);
		System.out.println(s);

	}

	@Test
	public void test4() {
		String s1 = "sss111";
		String s3 = "sss" + "111";
		System.out.println(s1 == s3);
	}


	@Test
	public void test5() {
		loop();
		endLessLoop();
	}

	private void endLessLoop() {
		while (true) {
			System.out.println("hello world loop!");
		}
	}

	private void loop() {
		for (int i = 0; i < 100000; i++) {
			System.out.println("hello world! endLessLoop!");
		}
	}

	@Test
	public void test6() {
		String s1 = new String("111");
		String s2 = "sss111";
		String s3 = "sss" + "111";
		String s4 = "sss" + s1;
		System.out.println(s2 == s3);	//true
		System.out.println(s2 == s4);	//false
		System.out.println(s2 == s4.intern());	//true
	}

	@Test
	public void test7() {
		String s1 = new String("sss111");
		s1 = s1.intern();
		String s2 = "sss111";
		System.out.println(s1 == s2);
	}

	@Test
	public void test8() {
		String s1 = new String("2");
		s1.intern();
		String s2 = "2";
		System.out.println(s1 == s2);

		String s3 = new String("2") + new String("2");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);
	}

	@Test
	public void test9() {
		String str2 = "SEUCalvin";//新加的一行代码，其余不变
		String str1 = new String("SEU")+ new String("Calvin");
		System.out.println(str1.intern() == str1);
		System.out.println("");
		System.out.println(str1 == "SEUCalvin");
	}

	static final int MAX = 100000;
	static final String[] arr = new String[MAX];

	@Test
	public void test10() {
		//为长度为10的Integer数组随机赋值
		Integer[] sample = new Integer[10];
		Random random = new Random(1000);
		for (int i = 0; i < sample.length; i++) {
			sample[i] = random.nextInt();
		}
		//记录程序开始时间
		long t = System.currentTimeMillis();
		//使用/不使用intern方法为10万个String赋值，值来自于Integer数组的10个数
		for (int i = 0; i < MAX; i++) {
			//arr[i] = new String(String.valueOf(sample[i % sample.length]));
			arr[i] = new String(String.valueOf(sample[i % sample.length])).intern();
		}
		System.out.println((System.currentTimeMillis() - t) + "ms");
		System.gc();
	}

	@Test
	public void test11() {

		String s = new String("1");
		s.intern();
		String s2 = "1";
		System.out.println(s == s2);

		String s3 = new String("1") + new String("1");
		s3.intern();
		String s4 = "11";
		System.out.println(s3 == s4);


	}

	@Test
	public void test12() {
		String s = new String("1");
		String s2 = "1";
		s.intern();
		System.out.println(s == s2);

		String s3 = new String("1") + new String("1");
		String s4 = "11";
		s3.intern();
		System.out.println(s3 == s4);
	}

	@Test
	public void test13() {

	}

}
