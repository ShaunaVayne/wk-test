package cn.wk.common;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: WangKun
 * @Description:
 * @Date: Created in 2017/12/8 下午1:56
 * @ProjectName: SpringBootTest2
 * @Version: 1.0.0
 */
public class FtpUtil {

	/**
	 * Description: 向FTP服务器上传文件
	 *
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param path
	 *            FTP服务器保存目录
	 * @param filename
	 *            上传到FTP服务器上的文件名
	 * @param input
	 *            输入流
	 * @return 成功返回true，否则返回false
	 */
	public static boolean uploadFile(String url, int port, String username,
									 String password, String path, String filename, InputStream input) {
		// 初始表示上传失败
		boolean success = false;
		FTPClient ftp = null;
		String proxySet = System.getProperty("proxySet");
		//true表示有设置代理
		// 创建FTPClient对象
		if("true".equals(proxySet)) {
			ftp = new FTPHTTPClient(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")));
		} else {
			ftp = new FTPClient();
		}

		try {
			int reply;
			// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.connect(url, port);
			// 登录ftp
			ftp.login(username, password);
			// 看返回的值是不是230，如果是，表示登陆成功
			reply = ftp.getReplyCode();
			// 以2开头的返回值就会为真
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			// 转到指定上传目录
			ftp.changeWorkingDirectory(path);
			//如果有配置代理参数时，需要设置如下模式
			if("true".equals(proxySet)) {
				ftp.enterLocalPassiveMode();
			}
			// 将上传文件存储到指定目录
			ftp.storeFile(filename, input);
			// 关闭输入流
			input.close();
			// 退出ftp
			ftp.logout();
			// 表示上传成功
			success = true;
		} catch (Exception e) {
//          e.printStackTrace();
			//log.error("in FtpUtil.uploadFile has an error,proxySet is {},and e is {}",new Object[]{proxySet,e});
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (Exception ioe) {
				}
			}
		}
		return success;
	}


	/**
	 * Description: 从FTP服务器下载文件
	 *
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */
	public static boolean downFile(String url, int port, String username,
								   String password, String remotePath, String fileName,
								   String localPath) {
		// 初始表示下载失败
		boolean success = false;
		FTPClient ftp = null;
		String proxySet = System.getProperty("proxySet");
		//true表示有设置代理
		// 创建FTPClient对象
		if("true".equals(proxySet)) {
			ftp = new FTPHTTPClient(System.getProperty("http.proxyHost"), Integer.parseInt(System.getProperty("http.proxyPort")));
		} else {
			ftp = new FTPClient();
		}

		try {
			int reply;
			// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.connect(url, port);
			// 登录ftp
			ftp.login(username, password);
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			} // 转到指定下载目录
			ftp.changeWorkingDirectory(remotePath);
			//如果有配置代理参数时，需要设置如下模式
			if("true".equals(proxySet)) {
				ftp.enterLocalPassiveMode();
			}
			// 列出该目录下所有文件
			FTPFile[] fs = ftp.listFiles();
			// 遍历所有文件，找到指定的文件
			for (FTPFile ff : fs) {
				if (ff.getName().equals(fileName)) {
					File dir = new File(localPath);
					if (!dir.exists()) {
						if (!dir.mkdirs()) {
							throw new Exception("创建保存目录失败");
						}
					}

					// 根据绝对路径初始化文件
					File localFile = new File(localPath + "/" + ff.getName());
					// 输出流
					OutputStream is = new FileOutputStream(localFile);
					// 下载文件
					ftp.retrieveFile(ff.getName(), is);
					is.close();
				}
			}
			// 退出ftp
			ftp.logout();
			// 下载成功
			success = true;
		} catch (Exception e) {
//          e.printStackTrace();
			//log.error("in FtpUtil.downFile has an error,proxySet is {},and e is {}",new Object[]{proxySet,e});
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (Exception ioe) {
				}
			}
		}
		return success;
	}
}
