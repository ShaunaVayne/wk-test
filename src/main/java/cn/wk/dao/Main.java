package cn.wk.dao;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/9/17 下午12:15
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("5");
        list.add("8");
        list.add("16");

        HashSet<String> set = new HashSet<>();
        /*set.addAll(list);
        list.removeAll(list);
        System.out.println(set);
        list.addAll(set);
        System.out.println(list);*/


        for(int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
            list.remove(i);
        }
        set.add(list.get(0));
        list.remove(0);
        list.addAll(set);
       // System.out.println(set);
        System.out.println(list);

    }
}