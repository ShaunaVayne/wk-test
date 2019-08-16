package cn.wk.xdf;

import lombok.Data;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/8/12 14:41
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Data
public class ParseExcelInner {

    private String campusName;// 校区

    private String campusCode;// 校区code

    private String var_1;// 工作量

    private String var_2;// 环境卫生

    private String var_3;// 教学辅助

    private String var_4;// 教材管理

    private String var_5;// 学员打卡率

    private String var_6;// 异常考勤

    private String var_7;// 安全责任

    private String var_8;// 教师满意度

    private String var_9;// 客户满意度

    private String var_10;// 主管打分

    private String var_11;// 附加分

    private String var_12;// 附加分

    public ParseExcelInner() {
    }

    public ParseExcelInner(String campusName, String campusCode, String var_1, String var_2, String var_3, String var_4, String var_5, String var_6, String var_7, String var_8, String var_9, String var_10, String var_11, String var_12) {
        this.campusName = campusName;
        this.campusCode = campusCode;
        this.var_1 = var_1;
        this.var_2 = var_2;
        this.var_3 = var_3;
        this.var_4 = var_4;
        this.var_5 = var_5;
        this.var_6 = var_6;
        this.var_7 = var_7;
        this.var_8 = var_8;
        this.var_9 = var_9;
        this.var_10 = var_10;
        this.var_11 = var_11;
        this.var_12 = var_12;
    }
}
