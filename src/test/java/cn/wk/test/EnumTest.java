package cn.wk.test;

import cn.wk.domain.WeekEnumDO;
import org.junit.Test;


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

}
