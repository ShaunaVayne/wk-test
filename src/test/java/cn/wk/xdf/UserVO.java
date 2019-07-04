package cn.wk.xdf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/7/4 13:16
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO {

    private Long id;

    private String name;

    private String gender;
}
