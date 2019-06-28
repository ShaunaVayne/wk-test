package cn.wk.test;

import lombok.*;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/6/20 15:07
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {

    private Integer id;

    private Integer age;

    private String gender;

    private String fName;

    private String lName;
}
