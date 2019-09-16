package cn.wk.xdf;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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

    private final List<String> index_list = OldClassCodeEnums.getByVal("index");

    private final List<String> contains_list = OldClassCodeEnums.getByVal("contains");

    @Test
    public void test7() {
        //1.先判断是否为老班号
        //2.若是老班号,取projectName到枚举中拿科目
        //3.若是新班号,判断第三个字母,再取枚举中拿科目
        String classCode = "GATBBW441356B";
        String projectName = "TOEFL";
        //List<String> keyS = OldClassCodeEnums.getKeyS();
        System.out.println(index_list);
        System.out.println(contains_list);
        String preffix_3 = classCode.substring(0, 3);
        String preffix_4 = classCode.substring(0, 4);
        if(index_list.contains(preffix_3) || index_list.contains(preffix_4)) {
            System.out.println("是老班号"+classCode);
            if(projectName.equals("新SAT"))
                projectName = "SAT";
            List<String> val = CourseEnums.getVal(projectName);
            System.out.println("xxxx" + val);
        }
        /*else {
            System.out.println("不是老班号");
        }*/
        for (String contains : contains_list) {
            if(classCode.contains(contains)) {
                System.out.println("是老班号"+classCode);
                if(projectName.equals("新SAT"))
                    projectName = "SAT";
                List<String> val = CourseEnums.getVal(projectName);
                System.out.println("xxxx" + val);
            }
        }
        // 代码执行到这里表示是一个新的班号
        String index_3 = classCode.substring(2,3);
        List<String> val = CourseEnums.getVal(SubjectEnums.getVal(index_3));
        System.out.println("xxxx" + val);
    }

    //private static final String[] xg = new String[]{"gw_xg","gw_xgzg"};
    private static final String res_regex = "^[0-9]+$";

    @Test
    public void test8() {
        int index = Arrays.binarySearch(xg, null);
        System.out.println(index);
    }

    @Test
    public void test9() {
        String in = "";
        String out = "";
        if(in.matches(res_regex)) {
            in = Integer.valueOf(in) + "";
            System.out.println(in);
        }else {
            System.out.println(2);
        }
    }

    @Test
    public void test11() {
        String str = "2019-08-26 00:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse(str);
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test10() {
        System.out.println(average(0,999));
    }

    private double average(double... doubles) {
        double sum = 0;
        for (double aDouble : doubles) {
            sum += aDouble;
        }
        return sum / doubles.length;
        /*int x = ints[0];
        if (ints.length==1)
            return x;
        int y = ints[1];
        int[] e = new int[ints.length-1];
        e[0] = (x&y)+((x^y)>>1);
        for (int i = 1; i < e.length; i++) {
            e[i] = ints[i+1];
        }
        return average(e);*/
    }

    @Test
    public void test12() {
        String s = "2019-03-02 00:00:00";
        String substring = s.substring(0, 10);
        System.out.println(substring);
    }

    public void echarts(String classCode, String studentCode, String courseName, String type) {
        if(StringUtils.isNotEmpty(classCode)
                && StringUtils.isNotEmpty(type)
                && (StringUtils.isEmpty(studentCode) || StringUtils.isEmpty(courseName))) {
            System.out.println("1");
        }
    }

    @Test
    public void test13() {
        String dateString = Date2StringUtils.getDateString(new Date());
        StringBuffer sb = new StringBuffer();
        sb.append("A636551820FCFB3FB919E4B0384EA109");
        sb.append("appId").append("91CALLTEST");
        sb.append("method").append("crmDataServiceImpl.getStudentExamMsg");
        sb.append("timestamp").append(dateString);
        sb.append("A636551820FCFB3FB919E4B0384EA109");
        String md5 = Md5Tool.getMd5(sb.toString());
        md5 = md5.toUpperCase();
        System.out.println(md5);
        System.out.println(dateString);
    }

    private static  String[] xg = new String[]{"gw_xg","gw_xgzg","aaa2222","sss"};

    @Test
    public void test14() {
        int gw_admin = Arrays.binarySearch(xg, "aaa2222");
        System.out.println(gw_admin);
    }

    @Test
    public void test15() {
        String str = "听力:5,阅读:4,口语:3,写作:3";
        String[] strLiist = str.split(",");
        List<CourseInner> collect = Arrays.stream(strLiist).map(e -> {
            String[] single = e.split(":");
            CourseInner courseInner = new CourseInner();
            courseInner.setCourse(single[0]);
            courseInner.setScore(single[1]);
            return courseInner;
        }).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void test16() {
        List<String> strings = Arrays.asList("a", "aa", "ab");
        List<String> strings2 = Arrays.asList("王琨", "林涛", "林涛儿子");
        for (String string : strings2) {
            System.out.println(string + "------------" + string.hashCode());
        }
    }

    @Data
    public static class CourseInner{
        private String course;
        private String score;
    }
}
