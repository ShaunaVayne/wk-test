package cn.wk.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2019/4/3 2:14 PM
 * @ProjectName: service-order
 * @Version: 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddParameterConfigReq {

	private String id;

	/**
	 * 参数配置关键字
	 */
	private String parameterKey;

	/**
	 * 参数配置名称
	 */
	private String parameterName;

	/**
	 * 参数配置值
	 */
	private String parameterValue;

	/**
	 * 参数配置描述
	 */
	private String description;

	/**
	 * 参数设置code
	 */
	private String parameterSettingCode;

	/**
	 * 参数设置名称
	 */
	private String parameterSettingName;

	/**
	 * 路由名称
	 */
	private String routingName;

	/**
	 * 路由code
	 */
	private String routingCode;
}
