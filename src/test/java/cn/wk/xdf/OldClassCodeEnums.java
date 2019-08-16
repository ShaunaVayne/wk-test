package cn.wk.xdf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: WangKun
 * @Description: 旧班号判断规则枚举
 * @Date: Created in 2019/8/16 17:33
 * @ProjectName: ework
 * @Version: 1.0.0
 */
public enum OldClassCodeEnums {

    BCW("BCW","index"),
    VCW("VCW","index"),
    VCY("VCY","index"),
    VCT("VCT","index"),
    VCN("VCN","index"),
    GYV("GYV","index"),
    YSV("YSV","index"),
    XGNV("XGNV","index"),
    TSV("TSV","index"),
    QCV("QCV","index"),
    BCY("BCY","index"),
    QP("QP","contains"),
    BTF("BTF","contains"),
    ;

    private String key;
    private String val;

    OldClassCodeEnums(String key, String val) {
        this.key = key;
        this.val = val;
    }

    OldClassCodeEnums() {
    }

    public static String getVal(String key) {
        for (OldClassCodeEnums value : values()) {
            if(value.key.equals(key))
                return value.val;
        }
        return null;
    }
    public static List<String> getKeyS() {
        return Arrays.stream(values()).map(e -> e.key).collect(Collectors.toList());
    }
}
