package cn.wk.domain;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/6/4 14:08
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Data
@ToString
public class TestCopy {

    private String name;

    private List<TestCopyList> testLists;
}
