package cn.wk.test;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/4/25 上午1:17
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public class SingTonE {

	private static class SingTonE2 {
		private static final SingTonE SING_TON_E = new SingTonE();
	}
	private SingTonE() {

	}
	public static SingTonE getInstance() {
		return SingTonE2.SING_TON_E;
	}
}
