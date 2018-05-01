package cn.wk.test;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2018/4/16 下午2:55
 * @ProjectName: wk-test
 * @Version: 1.0.0
 */
public class MyselfException extends RuntimeException {

	private final String errorCode;

	public MyselfException(Exception ex){
		super(ex);
		errorCode = "0";
	}

	public MyselfException(){
		super("对不起,系统繁忙,请稍候再试!");
		errorCode = "0";
	}

	public MyselfException(String msg){
		super(msg);
		errorCode = "0";
	}

	public MyselfException(String msg,Exception ex){
		super(msg,ex);
		errorCode = "0";
	}


	public MyselfException(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}



	public String getErrorCode() {
		return errorCode;
	}
}
