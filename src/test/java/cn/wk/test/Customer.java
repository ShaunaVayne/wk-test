package cn.wk.test;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/4/20 下午1:57
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public interface Customer {

	int foo(int a);

	default int foo2(int b) {
		return b;
	}
}
