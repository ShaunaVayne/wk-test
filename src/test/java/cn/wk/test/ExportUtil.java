package cn.wk.test;

import org.apache.poi.hssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/6/12 11:01
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public class ExportUtil {

    /**
     * @param name       //报表名称
     * @param arr        //报表各列名称存放的String[]数组
     * @param list<.Dto> //报表每条数据对应的Dto集合
     * @功能：Excel报表导出
     */
    public static void exportExcel(String name, String[] arr, List list) {
        // 第一步，创建一个webbook，对应一个Excel文件
        HSSFWorkbook wb = new HSSFWorkbook();
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(name);
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
        HSSFRow row = sheet.createRow((int) 0);
        // 第四步，创建单元格，并设置值表头 设置表头居中
        HSSFCellStyle style = wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式
        HSSFCell cell = row.createCell((short) 0);
        for (int i = 0; i < arr.length; i++) {
            cell = row.createCell((short) i);
            cell.setCellValue(arr[i]);
            cell.setCellStyle(style);
        }
        // 第五步，写入封装数据
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow((int) i + 1);
            java.lang.reflect.Field[] fields = list.get(i).getClass().getDeclaredFields();//获取i对象的所有字段
            for (int j = 0; j < fields.length; j++) {
                fields[j].setAccessible(true);
                Object value = null;
                try {
                    value = fields[j].get(list.get(i));//获取字段值
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                System.out.println(value);
                cell = row.createCell((short) j);
                // 定义单元格为字符串类型，这个字符串类型也可在创建单元格里面设置。
                cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                cell.setCellValue(String.valueOf(value));
                cell.setCellStyle(style);
            }
        }
        // 第六步，将文件存到指定位置
        try {
            FileOutputStream fout = new FileOutputStream("D:/temp/we/expport.xls");
            wb.write(fout);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //以下为测试
    private static List<Student> getStudent() throws Exception {
        List list = new ArrayList();
        Student user1 = new Student(1, "张三", 16, "1997-05-06");
        Student user2 = new Student(2, "李四", 17, "1996-08-12");
        Student user3 = new Student(3, "王五", 26, "1985-11-12");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }

    public static void main(String[] args) throws Exception {
        String name = "报表测试";
        String arr[] = {"学号", "姓名", "年龄", "生日"};
        List list = new ArrayList();
        Student user1 = new Student(1, "张三", 16, "1997-05-06");
        Student user2 = new Student(2, "李四", 17, "1996-08-12");
        Student user3 = new Student(3, "王五", 26, "1985-11-12");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        //
        ExportUtil.exportExcel(name, arr, list);
    }
}
