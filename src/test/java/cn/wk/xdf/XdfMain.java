package cn.wk.xdf;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/7/16 15:06
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public class XdfMain {

    private List<String> list1 = Arrays.asList("1111","2222","3333");

    private List<String> list2 = Arrays.asList("1111","2222","3333","4444");



    @Test
    public void jiaoJi() {
        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到交集 intersection---");
        intersection.parallelStream().forEach(System.out :: println);
    }

    @Test
    public void chaJi() {
        // 差集 (list1 - list2)
        List<String> reduce1 = list1.stream().filter(item -> !list2.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce1 (list1 - list2)---");
        reduce1.parallelStream().forEach(System.out :: println);
    }

    @Test
    public void chaJi2() {
        // 差集 (list2 - list1)
        List<String> reduce2 = list2.stream().filter(item -> !list1.contains(item)).collect(Collectors.toList());
        System.out.println("---得到差集 reduce2 (list2 - list1)---");
        reduce2.parallelStream().forEach(System.out :: println);
    }

    @Test
    public void bingJi() {
        // 并集
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        List<String> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        System.out.println("---得到并集 listAll---");
        listAll.parallelStream().forEach(System.out :: println);
    }

    @Test
    public void distintBingJi() {
        List<String> listAll = list1.parallelStream().collect(Collectors.toList());
        // 去重并集
        List<String> listAllDistinct = listAll.stream().distinct().collect(Collectors.toList());
        System.out.println("---得到去重并集 listAllDistinct---");
        listAllDistinct.parallelStream().forEach(System.out :: println);

        System.out.println("---原来的List1---");
        list1.parallelStream().forEach(System.out :: println);
        System.out.println("---原来的List2---");
        list2.parallelStream().forEach(System.out :: println);
    }

    @Test
    public void test() {
        PeopleVO p1 = new PeopleVO(1l,"王明明","上海","sh",20);
        PeopleVO p2 = new PeopleVO(null,"哈哈","北京","bj",30);
        PeopleVO p3 = new PeopleVO(3l,"呵呵","广州","gz",40);
        List<PeopleVO> peopleVOS = Arrays.asList(p1, p2, p3);
        List<PeopleVO> noIds = peopleVOS.stream().filter(e -> {
            return e.getId() == null;
        }).collect(Collectors.toList());
        List<PeopleVO> havaIds = peopleVOS.stream().filter(e -> !noIds.contains(e)).collect(Collectors.toList());
        //noIds.parallelStream().forEach(System.out ::println);
        havaIds.parallelStream().forEach(System.out ::println);
    }

    @Test
    public void test3() {
        String s = "09:30-18:00";
        String[] split = s.split("-");
        System.out.println(split[0]);
        System.out.println(split[1]);
    }

    public enum KV{
        VAR_1("var_1","工作量"),
        VAR_2("var_2","环境卫生"),
        VAR_3("var_3","教学辅助"),
        VAR_4("var_4","教材管理"),
        VAR_5("var_5","学员打卡率"),
        VAR_6("var_6","异常考勤"),
        VAR_7("var_7","安全责任"),
        VAR_8("var_8","教师满意度"),
        VAR_9("var_9","客户满意度"),
        VAR_10("var_10","主管打分"),
        VAR_11("var_11","附加分1"),
        VAR_12("var_12","附加分2"),
        ;
        private String k;
        private String v;

        KV() {}

        KV(String k, String v) {
            this.k = k;
            this.v = v;
        }

        public static String getValue(String k) {
            for (KV value : values()) {
                if(value.k.equals(k))
                    return value.v;
            }
            return null;
        }
    }

    @Test
    public void test4() {
        ParseExcelInner inner = new ParseExcelInner();
        inner.setVar_1("10");
        inner.setVar_2("20");
        inner.setVar_3("30");
        inner.setVar_4("40");
        inner.setVar_5("50");
        Class<? extends ParseExcelInner> clazz = inner.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String fieldName = declaredField.getName();
            if(fieldName.startsWith("var_")) {
                System.out.println(fieldName);
                try {
                    declaredField.setAccessible(true);
                    String s = declaredField.get(inner) + "";
                    System.out.println(s);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(KV.getValue(fieldName));
            }
        }

    }

    @Test
    public void test6() {
        Class<ParseExcelInner> clazz = ParseExcelInner.class;
        int j = 0;
        for (Field declaredField : clazz.getDeclaredFields()) {
            String fieldName = declaredField.getName();
            if(fieldName.startsWith("var_")) {
                Integer s = Integer.valueOf(fieldName.split("_")[1]);
                if(s > j) {
                    j = s;
                }
            }
        }
        System.out.println(j);
    }

    @Test
    public void test7() {
        String classCode = "GXV136N";
        char c = classCode.charAt(3);
        System.out.println(c);
        System.out.println(OldClassCodeEnums.getKeyS());
    }


}
