package cn.wk.test;

import cn.wk.domain.TestCopy;
import cn.wk.domain.TestList;
import cn.wk.xdf.OrderPO;
import cn.wk.xdf.UserVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/5 下午5:33
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
@Slf4j
public class Main {
	public static void main(String[] args) {
		/*System.out.println(String.valueOf(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())) - 1));*/
		/*String arg = "20170714162353_1.jpg#M00/01/3B/rBGkFVlof5mAXmq-AAbiROnKH00276.jpg#group1,20170714162353_2.jpg#M00/01/3B/rBGkFVlof5mANBNtAAOQJaJvykw212.jpg#group1\n";
		String[] str1s = arg.split(",");
		if(str1s.length == 2) {
			for (String str : str1s) {
				String[] str2s = str.split("#");
				System.out.println(str2s[1]);
				System.out.println(str2s[2]);
			}
		}*/

	}


	@Test
	public void test1() {
		String a = "M00/01/3B/rBGkFVlof5mAXmq-AAbiROnKH00276.jpg";
		String[] strings = a.split("\\.");
		for (String string : strings) {
			System.out.println(string);
		}
	}

	@Test
	public void test2() {
		String arg1 = "20170901171521_1.jpg#M00/01/67/rBGkFVmpJSqAEZ_wAALz_JSKkzI196.jpg#group1,20170901171522_2.jpg#M00/01/67/rBGkFVmpJSqAO6foAALz_JSKkzI891.jpg#group1";
		String arg = "20160725182531_1.png#M00/00/AF/rBGi81eV6RuATYX8AABubQk-IZc307.png,20160725182531_2.png#M00/00/AF/rBGi81eV6RuAdpNNAABubQk-IZc455.png";
		String[] str1s = arg.split(",");
		if(str1s.length == 2) {
			for (String str : str1s) {
				String[] str2s = str.split("#");
				System.out.println(str2s.length);
				System.out.println(str2s[0]);
				System.out.println(str2s[1]);

			}
		}
	}

	@Test
	public void test3() {
		String a = "2017080700066861|2017080700071382|8月|现款转账|2017/8/07|测试张鹏飞生产|翼支付卡电子卡|100|1|100|0%|0|100| | | | | | | |";
		String b = "2017081100066864|2017081100071384|8月|现款转账|2017/8/11|tyz|翼支付卡电子卡|100|10|1000|0%|0|1000|10000|2017-08-11|10000.00|9999|324660250919|niahao|niahao";
		String[] as = a.split("\\|");
		String[] bs = b.split("\\|");
		System.out.println(as.length == bs.length);
		System.out.println(String.valueOf(Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(new Date())) - 1));
	}

	@Test
	public void test4() {
		IntStream.range(0, 5).forEach(e -> {
			System.out.println(e);
		});
	}

	@Test
	public void test_4() {
		cn.wk.domain.Test test = new cn.wk.domain.Test();
		test.setName("a");
		TestList testList = new TestList();
		testList.setHobby("1");
		TestList testList2 = new TestList();
		testList2.setHobby("2");
		List<TestList> testLists = Arrays.asList(testList, testList2);
		test.setTestLists(testLists);
		TestCopy testCopy = new TestCopy();
		BeanUtils.copyProperties(test,testCopy);
		System.out.println(testCopy);

	}

	@Test
	public void test5() {
        String s = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        System.out.println(s);
    }

    @Test
    public void test6() {
         try {
        	checkException();
         } catch (Exception e) {
            System.out.println(e.getMessage());
         }
    }

	private void checkException() {
		 /*try {
			 throw new RuntimeException("test");
		 } catch (Exception e) {

		 }*/
		Boolean aBoolean = StringUtils.equals("sd", null);
		System.out.println(aBoolean);

		try {
			 throw new RuntimeException("test");
		 }finally {
		 	System.out.println("dddd");
		 }

	}

	@Test
	public void test7() throws ParseException {
		String DateStr1 = "2011-10-08 10:20:16";
		String DateStr2 = "2011-10-07 15:50:35";
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dateTime1 = dateFormat.parse(DateStr1);
		Date dateTime2 = dateFormat.parse(DateStr2);
		int i = dateTime1.compareTo(dateTime2);
		System.out.println(i);
	}

	@Test
	public void test8() {
		List<String> list = Arrays.asList("a", "b", "z");

		List<String> query = Arrays.asList("x", "y", "z");

		Collection listC = new ArrayList<>(list);
		Collection queryC = new ArrayList<>(query);
		listC.retainAll(queryC);
		Set result = new HashSet();
		result.addAll(list);
		result.addAll(query);
		Collection aa = new ArrayList(listC);
		Collection bb = new ArrayList(result);
		bb.removeAll(aa);
		System.out.println("最终结果：" + bb);
		bb.stream().forEach(e -> {
			if(list.contains(e)) {
				//新增
				System.out.println("新增：" + e);
			}else {
				//删除
				System.out.println("删除：" + e);
			}
		});



		/**
		 * 判断新增
		 */
		/*List<String> add = checkAdd(list, query);
		System.out.println(add);*/
	}

	private List<String> checkAdd(List<String> list, List<String> query) {
		List<String> result = new ArrayList<>();
		for (String s : list) {
			for (String s1 : query) {
				if(!s.equals(s1)){
					result.add(s);
				}
			}
		}
		return result;
	}

	@Test
	public void test9() {

// 注意：一定要使用创建对象的格式创建数组
		Integer[] a = new Integer[]{6, 3, 9, 3, 2, 4, 5, 7};
		Integer[] b = new Integer[]{5, 8, 6, 2, 1, 9};
		List _a = Arrays.asList(a);
		List _b = Arrays.asList(b);
// 创建集合
		Collection realA = new ArrayList<Integer>(_a);
		Collection realB = new ArrayList<Integer>(_b);
// 求交集
		realA.retainAll(realB);
		System.out.println("交集结果：" + realA);
		Set result = new HashSet();
// 求全集
		result.addAll(_a);
		result.addAll(_b);
		System.out.println("全集结果：" + result);
// 求差集：结果
		Collection aa = new ArrayList(realA);
		Collection bb = new ArrayList(result);
		bb.removeAll(aa);

		System.out.println("最终结果：" + bb);
	}


	@Test
	public void test10() {
		String fileName = "set.text";
	    String suffix=fileName.substring(fileName.lastIndexOf("."));
	    System.out.println(suffix);
	}

	@Test
	public void test11() {
		StringBuffer sb = new StringBuffer();
		List<String> strings = Arrays.asList("aaa", "bbb");
		strings.stream().forEach(e -> {
			sb.append(e).append(";");
		});
		System.out.println(sb.toString());
		System.out.println(sb.toString().substring(0,sb.toString().length() - 1));
	}

	@Test
	public void test12() {
		List<Dog> dogs = Arrays.asList(new Dog("黄一", 11,""), new Dog("黄一", 22,""), new Dog("黄三", 33,""));
		//System.out.printf("list :%s", dogs);
		/*dogs.stream().collect(Collectors.groupingBy(dog -> dog.getName())).entrySet().stream().collect(Collectors.toList());*/


		List<String> list =dogs.stream().
				collect(Collectors.groupingBy(dog->dog.getName(),Collectors.counting()))
				.entrySet().stream()
				.filter(entry->entry.getValue()>1)
				.map(entry->entry.getKey())
				.collect(Collectors.toList());
		System.out.printf("list :%s", list);
	}

	@Test
	public void test13() {
		List<Dog> dogs = Arrays.asList(new Dog("黄一", 11,""), new Dog("黄一", 22,""), new Dog("黄三", 33,""));
		dogs = dogs.stream().filter(e -> {
			if(e.getAge() == 11){
				e.setColor("black");
			}else {
				e.setColor("red");
			}
			return true;
		}).collect(Collectors.toList());
		System.out.printf("list :%s", dogs);
	}

	@Test
	public void test14() {

		String[] split = "1".split(",");
		List<Long> collect = Stream.of(split).map(e -> Long.valueOf(e)).collect(Collectors.toList());
		System.out.printf("list :%s", collect);
	}

	@Test
	public void test15() {
		Calendar todayEnd = Calendar.getInstance();
		Date dateByString = getDateByString("2019-06-24 11:59:21");
		todayEnd.setTime(dateByString);
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		Date time = todayEnd.getTime();
		System.out.println(getDateString(time));
	}

	@Test
	public void test16() {
		Boolean res = true;
	     try {
	     	int i = 10 / 2;
	     } catch (Exception e) {
			 res = false;
	     }
	     System.out.println(res);
	}

	@Test
	public void test17() {
		List a = new ArrayList();
		List list = test17_02(a);
		System.out.println(list);
		System.out.println(list.stream().findFirst().get());

	}

	private List test17_02(List a) {
		return Optional.ofNullable(a).map(e ->{
				e.add("sss");
				e.add("ddd");
				return e;
		}).orElse(null);
	}

	@Test
	public void test18() {
		String test = " {\n" +
				"        \"Id\": 185248,\n" +
				"        \"Code\": \"R001699269620\",\n" +
				"        \"SchoolId\": 1,\n" +
				"        \"SchoolName\": \"北京学校\",\n" +
				"        \"OrderState\": 5,\n" +
				"        \"PayState\": 0,\n" +
				"        \"PayMoney\": 1130,\n" +
				"        \"PaidMoney\": 0,\n" +
				"        \"PayTime\": \"1901-01-01 00:00:00\",\n" +
				"        \"PayOrderId\": 0,\n" +
				"        \"BankId\": 0,\n" +
				"        \"BankName\": \"\",\n" +
				"        \"PayOrderCode\": null,\n" +
				"        \"BankReturnCode\": null,\n" +
				"        \"HasInvoice\": false,\n" +
				"        \"InvoiceTitle\": \"\",\n" +
				"        \"CreateTime\": \"2016-10-25 15:53:17\",\n" +
				"        \"InAccount\": false,\n" +
				"        \"ErrorMessage\": \"\",\n" +
				"        \"UserId\": \"xdf0050050485\",\n" +
				"        \"SystemSource\": \"mobilePay\",\n" +
				"        \"MarketingSource\": \"\",\n" +
				"        \"MarketingSourceExt\": \"\",\n" +
				"        \"AppId\": \"iPocketXDFApp\",\n" +
				"        \"CreditCardNo\": null,\n" +
				"        \"OriginalFee\": 1300,\n" +
				"        \"DeliverFee\": 20,\n" +
				"        \"VoucherFee\": 190,\n" +
				"        \"StudentListInfo\": [\n" +
				"            {\n" +
				"                \"StudentId\": 1,\n" +
				"                \"Code\": \"BJ1267941\",\n" +
				"                \"Name\": \"杨立彬\",\n" +
				"                \"Gender\": 1,\n" +
				"                \"IdCard\": \"111111\",\n" +
				"                \"Mobile\": \"15210812369\",\n" +
				"                \"Phone\": \"\"\n" +
				"            }\n" +
				"        ]\n" +
				" }       ";

		OrderPO orderPO = JSON.parseObject(test, OrderPO.class);
		log.info(JSON.toJSONString(orderPO));
	}

	@Test
	public void test19() {
		UserVO userVO = new UserVO();
		/*if(userVO.getClass() instanceof UserVO) {
			System.out.println(true);
		}*/
		if(UserVO.class.isInstance(userVO.getClass())) {
			System.out.println(true);
		}
		if(Object.class.isInstance(userVO)) {
			Object o = userVO;
			System.out.println(true);
		}
	}

	@Test
	public void test20() {
		Map<String,Long> m1 = new HashMap<>();
		Map<String,Long> m2 = new HashMap<>();
		Map<String,Long> m3 = new HashMap<>();
		m1.put("a",1l);
		m1.put("b",2l);
	}


	@Test
	public void test() {
		//System.out.println(getNonce_str());
		System.out.println(getRandom());
	}

	private static final String SYMBOLS = "0123456789";
	private static final Random RANDOM = new SecureRandom();
	/**
	 * 获取长度为 6 的随机数字
	 * @return 随机数字
	 * @date 修改日志：由 space 创建于 2018-8-2 下午2:43:51
	 */
	public static String getNonce_str() {

		// 如果需要4位，那 new char[4] 即可，其他位数同理可得
		char[] nonceChars = new char[6];

		for (int index = 0; index < nonceChars.length; ++index) {
			nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
		}

		return new String(nonceChars);
	}

	public static String getRandom() {
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < 6; i++) {
			sb.append((int) Math.floor(Math.random() * 9 + 1));
		}
		return sb.toString();
	}


	public static Date getDateByString(String date) {
		Date parse = null;
		try {
			parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parse;
	}
	public static String getDateString(Date date) {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
	}
}
