package cn.wk.xdf;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/7/4 13:19
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Slf4j
public class Demo {

    @Test
    public void test() {
        UserVO u1 = new UserVO(1l,"王琨","男");
        UserVO u2 = new UserVO(2l,"程嘉惠","女");
        PeopleVO p1 = new PeopleVO(1l,"王明明","上海","sh");
        PeopleVO p2 = new PeopleVO(2l,"哈哈","北京","bj");
        PeopleVO p3 = new PeopleVO(3l,"呵呵","广州","gz");
        List<UserVO> userVOS = Arrays.asList(u1, u2);
        List<PeopleVO> peopleVOS = Arrays.asList(p1, p2, p3);

        System.out.println("--------------------");
        System.out.println("以Object的类型返回");
        Map<String, Object> map = listToMap(userVOS,"id");
        Map<String, Object> map2 = listToMap(peopleVOS,"id");
        log.info("success:{}", JSON.toJSONString(map));
        log.info("success:{}", JSON.toJSONString(map2));

        System.out.println("--------------------");
        System.out.println("以具体的类型返回,class文件做参数");
        Map<String, UserVO> stringMap = listToMap2(userVOS, "id", UserVO.class);
        Map<String, PeopleVO> stringMap2 = listToMap2(peopleVOS, "id", PeopleVO.class);
        log.info("success:{}", JSON.toJSONString(stringMap));
        log.info("success:{}", JSON.toJSONString(stringMap2));
    }

    private <T> Map<String,T> listToMap2(List<? extends T> userVOS, String fieldName, Class<T> tClass) {
        HashMap<String, T> collect = userVOS.stream().collect(Collectors.toMap(
                e -> {
                    Class<?> c = e.getClass();
                    String key = "";
                    try {
                        Field id = c.getDeclaredField(fieldName);
                        id.setAccessible(true);
                        key = id.get(e) + "";
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    return key;
                },
                e -> e,
                (x, y) -> {
                    throw new AssertionError();
                },
                HashMap::new
        ));
        return collect;
    }


    /**
     * 通用的list转为map的方法, list的包含的是实体对象, map的key为实体的主键
     * @param userVOS
     * @param fieldName
     * @return
     */
    private Map<String,Object> listToMap(List<?> userVOS, String fieldName) {
        HashMap<String,Object> res = userVOS.stream().collect(Collectors.toMap(
                e -> {
                    Class<?> c = e.getClass();
                    String key = "";
                    try {
                        Field id = c.getDeclaredField(fieldName);
                        id.setAccessible(true);
                        key = id.get(e) + "";
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    return key;
                },
                e -> e,
                (x, y) -> {
                    throw new AssertionError();
                },
                HashMap::new
        ));
        return res;
    }
}
