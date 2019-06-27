package cn.wk.test;

import cn.wk.dao.AddParameterConfigReq;
import cn.wk.domain.WeekEnumDO;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;


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
		List<String> strings = Arrays.asList("aaa", "bbb", "ccc", "aaa");
		Set<String> strings1 = new HashSet<>();
		strings1.addAll(strings);
		System.out.println(strings1);
	}

	@Test
	public void test6() {
		String str = "15452176890960001154571";
		String[] split = str.split(",");
		Arrays.stream(split).forEach(e -> {
			System.out.println(e);
		});
	}

	@Test
	public void test7() {
		String a = "1";
		String b = "2";
		String c = "3";
		StringBuffer sb = new StringBuffer();
		sb.append("{").append("\"a\":").append(a).append(",").append("\"b\":").append(b).append(",").append("\"c\":").append(c).append("}");
		String s = sb.toString();
		System.out.println(s);
	}

	@Test
	public void test8() {
		AddParameterConfigReq req1 = new AddParameterConfigReq("", "businessCategory", "业务分类", "BY", "工单字段", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req2 = new AddParameterConfigReq("", "adviser", "业务员", "yes", "工单字段", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req3 = new AddParameterConfigReq("", "mileageRequired", "进场里程是否必填", "yes", "工单字段", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req4 = new AddParameterConfigReq("", "maintenanceIntervalTime", "保养时间间隔", "90", "工单字段", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req5 = new AddParameterConfigReq("", "maintenanceIntervalMileage", "保养里程间隔", "5000", "工单字段", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req6 = new AddParameterConfigReq("", "defaultTechnician", "默认技师", "yes", "工单字段", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req7 = new AddParameterConfigReq("", "picking", "领料", "manual", "工单流程", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req8 = new AddParameterConfigReq("", "qc", "完工质检", "auto", "工单流程", "gd_setting", "工单设置", "业务接待", "order");
		AddParameterConfigReq req9 = new AddParameterConfigReq("", "amount", "工单应收金额为0时", "auto", "工单流程", "gd_setting", "工单设置", "业务接待", "order");

		AddParameterConfigReq req10 = new AddParameterConfigReq("", "businessCategory", "业务分类", "BY", "洗美单字段", "xmd_setting", "洗美单设置", "业务接待", "order");
		AddParameterConfigReq req11 = new AddParameterConfigReq("", "adviser", "业务员", "yes", "洗美单字段", "xmd_setting", "洗美单设置", "业务接待", "order");
		AddParameterConfigReq req12 = new AddParameterConfigReq("", "defaultTechnician", "默认技师", "yes", "洗美单字段", "xmd_setting", "洗美单设置", "业务接待", "order");
		AddParameterConfigReq req13 = new AddParameterConfigReq("", "qc", "完工质检", "manual", "洗美单流程", "xmd_setting", "洗美单设置", "业务接待", "order");
		AddParameterConfigReq req14 = new AddParameterConfigReq("", "amount", "洗美单应收金额为0时", "auto", "洗美单流程", "xmd_setting", "洗美单设置", "业务接待", "order");

		AddParameterConfigReq req15 = new AddParameterConfigReq("", "adviser", "业务员", "BY", "销售单字段", "xsd_setting", "销售单设置", "业务接待", "order");
		AddParameterConfigReq req16 = new AddParameterConfigReq("", "defaultPicking", "默认领料人", "yes", "销售单字段", "xsd_setting", "销售单设置", "业务接待", "order");
		AddParameterConfigReq req17 = new AddParameterConfigReq("", "amount", "销售单应收金额为0时", "auto", "销售单流程", "xsd_setting", "销售单设置", "业务接待", "order");

		List<AddParameterConfigReq> list = Arrays.asList(req1, req2, req3, req4, req5, req6, req7, req8, req9, req10, req11, req12, req13, req14, req15, req16, req17);
		System.out.println(JSONObject.toJSONString(list));
		//log.info("{} -> 返回响应: {}", funName, JSONObject.toJSONString("success"));
	}

	@Test
	public void test9() {
		String a = "京12345";
		String substring1 = a.substring(0, 1);
		String substring = a.substring(1);
		System.out.println(substring);
		System.out.println(substring1);
	}

	@Test
	public void test10() {

	}


}
