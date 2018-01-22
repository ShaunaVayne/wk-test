package cn.wk.dao;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/9/18 下午9:13
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class Main2 {

    public static void main(String[] args) {
        int a  = 1;
        a = change(a);
        System.out.println(a);
    }

    private static int change(int a) {
        a = 1000;
        return a;
    }
}
