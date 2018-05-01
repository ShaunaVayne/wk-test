package cn.wk.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/3/25 下午2:04
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
@Data
@AllArgsConstructor
public class Book {

	private String name;

	private Double price;
}
