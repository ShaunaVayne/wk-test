package cn.wk.test;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/4/25 上午1:11
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public class SingTonLan {

	private volatile static SingTonLan singTonLan;

	private SingTonLan() {

	}

	public static SingTonLan getInstance() {
		if(singTonLan == null) {
			synchronized (SingTonLan.class) {
				if(singTonLan == null) {
					singTonLan = new SingTonLan();
				}
			}
		}
		return singTonLan;
	}
}
