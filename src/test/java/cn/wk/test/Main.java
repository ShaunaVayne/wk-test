package cn.wk.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/5 下午5:33
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
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
}
