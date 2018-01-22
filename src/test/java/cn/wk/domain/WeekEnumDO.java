package cn.wk.domain;

import java.io.Serializable;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/1/15 上午11:00
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public enum WeekEnumDO implements Serializable {

		SUN("0","sun"),
		MON("1","mon"),
		TUE("2","tue"),
		WED("3","wed"),
		THR("4","thr"),
		FRI("5","fri"),
		SAT("6","sat");

	private String strCode;

	private String strValue;

	public String getStrCode() {
		return strCode;
	}

	public String getStrValue() {
		return strValue;
	}

	WeekEnumDO(String strCode, String strValue) {
		this.strCode = strCode;
		this.strValue = strValue;
	}
}
