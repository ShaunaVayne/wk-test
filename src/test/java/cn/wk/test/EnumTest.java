package cn.wk.test;

import cn.wk.domain.WeekEnumDO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/1/15 上午10:48
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class EnumTest {

	@Test
	public void test() {
		String friStrCode = WeekEnumDO.FRI.getStrCode();
		String monStrCode = WeekEnumDO.MON.getStrCode();
		String monStrValue = WeekEnumDO.MON.getStrValue();
		System.out.println("friStrCode:" +friStrCode+ ",friStrValue:" + friStrCode);
		System.out.println("monStrCode:" +monStrCode+ ",monStrValue:" + monStrValue);
	}

	@Test
	public void test2() {
		String sql3 = "SELECT t2.ORDER_SEQ, t1.BANK_ID t1.PAY_TYPE FROM t_scd_order_payinfo t1, T_SCD_ORDER t2 WHERE t1.PAYINFO_SEQ = t2.PAYINFO_SEQ AND t1.PAYINFO_SEQ = ?";
		System.out.println(sql3);
	}

	@Test
	public void test3() {
		String sql2 = "SELECT COUNT(1) AS rowCount\n" +
				"FROM (\n" +
				"  SELECT\n" +
				"    t2.ORDER_SEQ,\n" +
				"    t1.PAYINFO_SEQ,\n" +
				"    t2.OPER_STAT  AS FKSTAT,\n" +
				"    t2.ORDER_STAT AS DDSTAT,\n" +
				"    t1.BANK_ID,\n" +
				"    t1.ORDER_STAT AS CKSTAT\n" +
				"  FROM t_scd_order_payinfo t1, T_SCD_ORDER t2\n" +
				"  WHERE\n" +
				"    t1.PAYINFO_SEQ = t2.PAYINFO_SEQ AND t1.PAYINFO_SEQ = ? AND t2.OPER_STAT IN ('S0B', 'S0C', 'S0F') AND\n" +
				"    t1.PAY_TYPE = ?)";
		String s = "SELECT COUNT(1) AS rowCount FROM (SELECT t2.ORDER_SEQ, t1.PAYINFO_SEQ, t2.OPER_STAT  AS FKSTAT, t2.ORDER_STAT AS DDSTAT, t1.BANK_ID, t1.ORDER_STAT AS CKSTAT FROM t_scd_order_payinfo t1, T_SCD_ORDER t2 WHERE t1.PAYINFO_SEQ = t2.PAYINFO_SEQ AND t1.PAYINFO_SEQ = ? AND t2.OPER_STAT IN ('S0B', 'S0C', 'S0F') AND t1.PAY_TYPE = ?)";
		System.out.println(sql2);
	}

	@Test
	public void test4() {
		Map<String, WeekEnumDO> weekMap = WeekEnumDO.WEEK_MAP;
		weekMap.entrySet().stream().forEach(e -> {
			System.out.println(e.getKey() +"-------------"+ e.getValue());
		});
		WeekEnumDO weekEnumDO = WeekEnumDO.WEEK_MAP.get("1");
		System.out.println(weekEnumDO);
	}

	@Test
	public void test5() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "a");
		map.put("2", "b");
		System.out.println(JSON.toJSONString(map));
		System.out.println("sss");
	}


	@Test
	public void test6() {
		Object[] o = new Object[2];
		o[0] = "aaa";
		o[1] = 22;
		System.out.println(JSON.toJSONString(o));
	}

	@Test
	public void test7() {
		Tree t1 = new Tree();
		t1.setId(1); t1.setName("a");
		Tree t2 = new Tree();
		t2.setId(2); t2.setName("b");
		Tree t3 = new Tree();
		t3.setId(3); t3.setName("c");
		Tree t4 = new Tree();
		t4.setId(4); t4.setName("d");


		List<Tree> treeList1 = Arrays.asList(t1, t2, t3, t4);
		List<Tree> treeList2 = Arrays.asList(t1, t2);
		List<Integer> idList = treeList2.stream().map(Tree::getId).collect(Collectors.toList());
		treeList1.stream().filter(tree -> idList.contains(tree.getId())).collect(Collectors.toList())
				.stream().forEach(s -> {
			s.setFlag(Boolean.TRUE);
		});
		System.out.println(treeList1);

	}



}
