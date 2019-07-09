package cn.wk.xdf;

import lombok.Data;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/7/8 10:58
 * @ProjectName: emarketing
 * @Version: 1.0.0
 */
@Data
public class StudentInfoPO {

    /**
     *学员顺序Id
     */
    private Integer StudentId;

    /**
     *学员编号
     */
    private String code;

    /**
     *姓名
     */
    private String name;
}
