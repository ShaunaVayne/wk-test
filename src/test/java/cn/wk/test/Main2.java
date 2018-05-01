package cn.wk.test;

import cn.wk.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import sun.rmi.runtime.Log;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/14 下午4:24
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
@Slf4j
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
		BigDecimal bd = new BigDecimal("2");
		BigDecimal pow = bd.pow(64);
		System.out.println(pow);
	}

	@Test
	public void test14() {
		int[] resource = new int[10000000];
		int[] target = new int[10000000];
		for(int i = 0; i < resource.length; i++) {
			resource[i] = i;
		}
		long start = System.currentTimeMillis();
		System.arraycopy(resource,0,target,0, 10000000);
		long end = System.currentTimeMillis();
		System.out.println(end - start);

		long start1 = System.currentTimeMillis();
		int[] target2 = new int[10000000];
		for(int i = 0; i < target2.length; i++) {
			target2[i] = resource[i];
		}
		long end2 = System.currentTimeMillis();
		System.out.println(end2 - start1);

	}

	@Test
	public void test15() {
		String a = "0.46";
		Double a2 = Double.valueOf(a);
		a2 = a2 * 10;
		Integer i = a2.intValue();
		System.out.println(a2);
		System.out.println(i);
	}

	@Test
	public void test16() {
		String s = "天翼电子商务有限公司上海分公司|中国电信股份有限公司安徽号百分公司|B20171220163458725|20180213|21|421121|2|202001|1|211000|1|2000|4|217000 ";

		String[] header = string2array(s, "\\|");

		System.out.println(header.length);

		int a = 1;

		ArrayList arrayList = new ArrayList();

		arrayList.add(2);



	}

	@Test
	public void test17() {
		String s1 = "天翼电子商务有限公司上海分公司|中国电信股份有限公司甘肃分公司|9918102873|20180224|20|4400|0|0|0|0|0|0|0|0";
		String s2 = "20180224001_SC011_001999900000000_002620000000000_9918102873.txt";
		String[] s1s = s1.split("\\|");
		String[] s2s = s2.split("_");
		String s11 = s1s[3];
		String s21 = s2s[0];
		s21 = s21.substring(0, 8);
		System.out.println(s11);
		System.out.println(s21);
	}

	private String[] string2array(String str, String regex) {
		if (str != null)
			return str.split(regex);
		return null;
	}

	@Test
	public void test19() {
		String s = "hello";
		s = s + "world";
		String s3 = s.intern();
		String s2  = "helloworld";
		System.out.println(s == s2);
	}
	@Test
	public void test20() {
		String s = "hello";
		s = s + "world";
		String s2  = "helloworld";
		System.out.println(s == s2);
	}

	@Test
	public void test18() {
		String a = new String("hello");
		set(a);
		String b = "hello";
		set(b);
		System.out.println(a == b);
		System.out.println(b.hashCode());
		System.out.println(a.hashCode());
	}

	@Test
	public void test21() {
		String s = "2020-03-13";
		String replace = s.replace("-", "");
		System.out.println(replace);

		String s2 = "20200330";
		System.out.println(s2.length());
		String sb1 = s2.substring(0, 4);
		System.out.println(sb1);

		String sb2 = s2.substring(4, 6);
		System.out.println(sb2);
		String sb3 = s2.substring(6);
		System.out.println(sb3);
		StringBuffer stringBuffer = new StringBuffer().append(sb1).append("-").append(sb2).append("-").append(sb3);
		System.out.println(stringBuffer.toString());


	}

	@Test
	public void test22() throws ParseException {
		Map<String, String> map = new HashMap<>();
		map.put("idDeadline","20200330");
		map.put("idDeadline1","20200329");
		map.put("idDeadline2","20200328");
		map.put("idDeadline3","20200327");
		map.put("licenseDeadline","");
		changeDate(map).entrySet().forEach(e -> {
			System.out.println(e.getKey() +"--------------"+ e.getValue());
		});
		System.out.println("*****");
		changeDate2(map).entrySet().forEach(e -> {
			System.out.println(e.getKey() +"--------------"+ e.getValue());
		});
	}


	@Test
	public void test23() {
		Book book = new Book("王琨", 23.3);
		log.info("参数值:{}",book.toString());
	}

	@Test
	public void test24() {
		System.out.println("MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEAvvR9BDrjsnHv4hYYQMx3IXY/+g5K1Vmu41hptzZ8Tyk0ANXCcCyje17ksjM9lxLb6INq6Wn8sAJ+vNqBK+O2lQIDAQABAkEAs+65JpU/HVSTT5y2OcjwsI02d6+kACnDy+Hxq3wh4ow2Cvjj7zqRa41U63J1PD8YBW3FEuRzMvE9p1KSFHJOAQIhAN9pzWNMim4wsX8vf8X9Up4FX0+ibnZRkhcbMzWbWknVAiEA2s6z3+wVBMoBvQ9TnNDXz9S1FIiy2q6k3hcirwkLWcECIE7x3ge2pjvlrPLaX/YgW69HCrTjGtFoZY0QqXnJ2Y+5AiEA0GyTJNqCDwTJcSjXUYoR+NO6BaxNCkfPngpVrHumB0ECIDb4KJZTHMcxLSLZimSmobKGSFRTIwKjpy0W5PHf8QxO".length());
	}

	private Map<String,Object> changeDate(Map<String, String> map) {
		Map<String, Object> map2 = map.entrySet().stream().collect(Collectors.toMap(
				e -> e.getKey(),
				e -> {
					if(StringUtils.isNotBlank(e.getValue())) {
						try {
							return new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyyMMdd").parse(e.getValue()));
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
					return "";
				},
				(x, y) -> {
					throw new AssertionError();
				},
				HashMap::new
		));
		return map2;
	}

	private Map<String,Object> changeDate2(Map<String, String> map) {
		HashMap<String, Object> map1 = new HashMap<>();
		map.entrySet().stream().forEach(e -> {
			if(StringUtils.isNotBlank(e.getValue())) {
				try {
					Date parse = new SimpleDateFormat("yyyyMMdd").parse(e.getValue());
					SimpleDateFormat sdf2 =   new SimpleDateFormat( "yyyy-MM-dd" );
					String format = sdf2.format(parse);
					map1.put(e.getKey(), format);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}else {
				map1.put(e.getKey(),"");
			}
		});
		return map1;
	}

	@Test
	public void test25() {
		String amout = "95.40";
		Double d = Double.valueOf(amout);
		System.out.println(d);
		Integer a2 = d.intValue();
		String s = String.valueOf(a2);
		System.out.println(s);
	}

	@Test
	public void test26() {
		String a = "111";
		String c = new StringBuilder().append("111").toString();
		System.out.println(a == c);
	}

	@Test
	public void test27() throws Exception {
		ArrayList<String> list = null;
		String flag = "b";
		if("b".equals(flag)) {
			list = new ArrayList<>();
		}
		Optional.ofNullable(list).orElseThrow(() -> new Exception("集合为空"));
		System.out.println("ok?");
	}

	@Test
	public void test29() {
		String a = "";
		try {
			System.out.println(Optional.ofNullable(a).isPresent());
			if(Optional.ofNullable(a).isPresent()) {
				String s = Optional.ofNullable(a).get();
				System.out.println(s);
				if(s.equals("")) {
					Optional.ofNullable(a).orElseThrow(() -> new Exception("参数为空"));
				}
			}
			Optional.ofNullable(a).orElseThrow(() -> new Exception("参数为空"));
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test30() {
		String pwd1 = "aa";
		String pwd2 = "   ";
		try {
			boolean flag = matcher(pwd1, pwd2);
			if(flag) {
				System.out.println("ok");
			}else {
				System.out.println("not ok");
			}
		}catch(MyselfException e) {
			log.error("校验失败,错误码:{}",e.getErrorCode());
			log.error("校验失败,错误信息:{}",e.getMessage());
		}
	}

	@Test
	public void test31() {
	/*List<Integer> list = Arrays.asList(100, 200, 300, 400, 500);
			list.stream().map((e) -> e + .12 * e).forEach(System.out::println);*/

	}

	@Test
	public void test32() {
		Integer a = Double.valueOf("100.50").intValue();
		a = a * 100;
		System.out.println(a);
	}

	@Test
	public void test33() {
		Customer customer = new Customer() {
			@Override
			public int foo(int a) {
				return 100 * a;
			}
		};
		System.out.println(customer.foo(1));
		System.out.println(customer.foo2(2));

	}



	/**
	 * pwd1 明文, pwd2 密文
	 * @param pwd1
	 * @param pwd2
	 * @return
	 */
	private boolean matcher(String pwd1, String pwd2) {
		if(StringUtils.isBlank(pwd2)) {
			throw new MyselfException("用户表中的密码为空","-1");
		}
		if(StringUtils.isBlank(pwd1)) {
			throw new MyselfException("用户输入的密码为空","-2");
		}
		try {
		    return checkPwd(pwd1,pwd2);
		}catch(MyselfException e) {
		    log.error(e.getMessage());
		}
		return false;
	}

	private boolean checkPwd(String pwd1, String pwd2) {
		return false;
	}


	@Test
	public void test28() {
		String str = "2018-04-10 00:00:00";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(str);
			System.out.println(date);
			String hmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(date);
			System.out.println(hmmss);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void set(String a) {
		a += "world";
	}

	static int getNum(int i) {
		if(i <= 1) {
			return 1;
		}
		return getNum(i - 1) + getNum(i - 2);
	}

	public static void main(String[] args) {
		Map map = new HashMap<>();
		map.put("PAY_SUM","19200000");
		map.put("DISC_RATE","0");
		map.put("SETTLE_RATE","0");
		Map map1 = new HashMap<>();
		map1.put("PAY_SUM","950000");
		map1.put("DISC_RATE","0");
		map1.put("SETTLE_RATE","100");
		Map map2 = new HashMap<>();
		map2.put("PAY_SUM","0");
		map2.put("DISC_RATE","0");
		map2.put("SETTLE_RATE","0");
		
		
		List<Map> list = Arrays.asList(map, map1,map2);
		String s = computeNoNeedOrderDetailSums(list);
		System.out.println(s);

		BigDecimal noNeedDetailRealSum=new BigDecimal(s);

		//20300000
		BigDecimal freezeSum=new BigDecimal("20300000");

		BigDecimal receSum=new BigDecimal("20300000");
		Map map3 = new HashMap<>();
		map3.put("REAL_SUM","19200000");
		List<Map> list1 = Arrays.asList(map3);
		String s1 = computeOrderDetailSums(list1);
		BigDecimal detailRealSum = new BigDecimal(computeOrderDetailSums(list1));
		BigDecimal times = new BigDecimal("100");

		String string = receSum.subtract(freezeSum.subtract(detailRealSum)).divide(times).toString();
		System.out.println(string);


	}

	public static String  computeOrderDetailSums(List<Map> lists){
		BigDecimal sum=new BigDecimal("0");
		if(lists!=null&&lists.size()>0){
			for(Map map:lists){
				String realSum=map.get("REAL_SUM")==null?"0":map.get("REAL_SUM").toString();
				sum=sum.add(new BigDecimal(realSum));
			}

		}else{
			throw new NullPointerException("orderSeq为null");
		}
		return sum.toString();
	}


	/**
	 * 计算无需支付订单明细金额 仅适合t_scd_order_detail
	 * @return
	 */
	public static String  computeNoNeedOrderDetailSums(List<Map> lists){
		BigDecimal sum=new BigDecimal("0");
		if(lists!=null&&lists.size()>0){
			for(Map map:lists){
				BigDecimal paySum=new BigDecimal(map.get("PAY_SUM")==null?"0":map.get("PAY_SUM").toString());
				BigDecimal times = new BigDecimal("100");
				BigDecimal discRate=new BigDecimal(map.get("DISC_RATE")==null?"0":map.get("DISC_RATE").toString());
				BigDecimal settleRate=new BigDecimal(map.get("SETTLE_RATE")==null?"0":map.get("SETTLE_RATE").toString());
				BigDecimal discSum=paySum.multiply(discRate).divide(times);//费率金额
				BigDecimal settleSum=paySum.multiply(settleRate).divide(times);//运营金额
				BigDecimal realSum=paySum.subtract(discSum).subtract(settleSum);
				sum=sum.add(realSum);
			}

		}else{
			throw new NullPointerException("orderSeq为null");
		}
		return sum.toString();
	}
}
