package cn.wk.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/6/20 15:14
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dog {

    private String name;

    private Integer age;

    private String color;
}
