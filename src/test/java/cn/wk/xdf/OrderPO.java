package cn.wk.xdf;

import lombok.Data;

import java.util.List;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/7/8 10:55
 * @ProjectName: emarketing
 * @Version: 1.0.0
 */
@Data
public class OrderPO {

    /**
     * 	订单Id
     */
    private Integer id;

    private String Code;

    private List<StudentInfoPO> StudentListInfo;

}
