package cn.wk.xdf;

/**
 * @Author: WangKun
 * @Description: 若是新班号根据第三个字母判断科目
 * @Date: Created in 2019/8/16 11:31
 * @ProjectName: ework
 * @Version: 1.0.0
 */
public enum SubjectEnums {

    SUBJECT_T("T","TOEFL"),
    SUBJECT_J("J","TOEFLJunior"),
    SUBJECT_A("A","SSAT"),
    SUBJECT_S("S","SAT"),
    SUBJECT_C("C","ACT"),
    SUBJECT_R("R","GRE"),
    SUBJECT_M("M","GMAT"),
    SUBJECT_L("L","LSAT"),
    SUBJECT_I("I","IELTS"),
    SUBJECT_P("P","AP"),
    SUBJECT_V("V","A-LEVEL"),
    SUBJECT_E("E","AEAS"),
    SUBJECT_Y("Y","PTE"),
    SUBJECT_K("K","美国同步课程"),
    SUBJECT_D("D","GED"),
    SUBJECT_B("B","IB"),
    SUBJECT_G("G","GCSE"),
    SUBJECT_F("F","国际学校备考班"),
    SUBJECT_W("W","AMC"),
    SUBJECT_N("N","听口能力进阶"),
    SUBJECT_X("X","综合英语进阶课"),
    SUBJECT_Z("Z","职场英语进阶"),
    ;

    private String key;

    private String value;

    SubjectEnums(String key, String value) {
        this.key = key;
        this.value = value;
    }

    SubjectEnums() {}

    public static String getVal(String key) {
        for (SubjectEnums value : values()) {
            if(value.key.equals(key)) {
                return value.value;
            }
        }
        return null;
    }
}
