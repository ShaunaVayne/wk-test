package cn.wk.xdf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: WangKun
 * @Description: 根据项目名称枚举科目
 * @Date: Created in 2019/8/16 14:54
 * @ProjectName: ework
 * @Version: 1.0.0
 */
public enum CourseEnums {

    TOEFL("TOEFL", Arrays.asList("阅读","听力","口语","写作")),
    IELTS("IELTS",Arrays.asList("阅读","听力","口语","写作")),
    GRE("GRE",Arrays.asList("语文","数学","写作")),
    GMAT("GMAT",Arrays.asList("语文","数学","写作","IR")),
    LSAT("LSAT",Arrays.asList("阅读","逻辑推理","分析推理","写作")),
    SAT("SAT",Arrays.asList("文科总分","阅读小分","文法小分","数学","写作")),
    ACT("ACT",Arrays.asList("阅读","数学","文法","科学","写作")),
    SSAT("SSAT",Arrays.asList("词汇","数学","阅读")),
    TOEFLJunior("TOEFLJunior",Arrays.asList("阅读","听力","语言形式和含义")),
    A_LEVEL("A-LEVEL",Arrays.asList("数学","高数","物理","化学","经济","生物","商务","历史","英语")),
    IGCSE("IGCSE",Arrays.asList("数学","物理","化学","经济","生物","商务","历史","英语")),
    GCSE("GCSE",Arrays.asList("数学","物理","化学","经济","生物","商务","历史","英语")),
    AP("AP",Arrays.asList("微积分BC","微积分AB","微观经济","宏观经济","物理1&2","物理C(力学/电磁)","统计学","英语","美国历史","语言与写作","心理学","欧洲/世界历史","计算机科学","美国政府与政治","艺术史","音乐理论")),
    AEAS("AEAS",Arrays.asList("阅读","听力","口语","写作","数学")),
    ;

    private String key;
    private List<String> val;

    CourseEnums(String key, List<String> val) {
        this.key = key;
        this.val = val;
    }

    CourseEnums() {}

    public static List<String> getKeyS() {
        return Arrays.stream(values()).map(e -> e.key).collect(Collectors.toList());
    }

    public static List<String> getVal(String key) {
        for (CourseEnums value : values()) {
            if(value.key.equals(key)) {
                return value.val;
            }
        }
        return null;
    }
}
