package cn.wk.pwd;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * AES加密
 * 创建者
 * 创建时间 2015年2月7日
 *
 */
public class SecurityAESUtil {


    private SecurityAESUtil() {

    }
    private static String encoding = "UTF-8";
    private static String PASSWORD = "PASSWORD";

    public static void main(String[] args) {
		System.out.println(SecurityAESUtil.decrypt("RTA2MjlDM0U4NjU4Q0M0MUFFQzgyREQxRTlFQ0E0MUYwMTFFRUQxNTk5NUI4MjgxRTc1NUZCQTE0MUIwNzI1OEYzREIwNzNBRjNCNTI4MkY3NjlEMDkwQzgzRjZDRkY2"));

	}


    /**
     * AES加密
     * @Author
     * @param content
     * @return  String
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    public static String encryptAES(String content) {
        byte[] encryptResult = encrypt(content);
        if (encryptResult!= null) {
            String encryptResultStr = parseByte2HexStr(encryptResult);
            // BASE64位加密
            encryptResultStr = ebotongEncrypto(encryptResultStr);
            return encryptResultStr;
        } else {
            return null;
        }

    }
    /**
     * AES解密
     * @Author
     * @param encryptResultStr
     * @return  String
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    public static String decrypt(String encryptResultStr) {
        // BASE64位解密
        String decrpt = ebotongDecrypto(encryptResultStr);
        byte[] decryptFrom = parseHexStr2Byte(decrpt);
        byte[] decryptResult = decrypt(decryptFrom);
        return new String(decryptResult);
    }
    /**
     * 加密字符串
     * @Author
     * @param str
     * @return  String
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    public static String ebotongEncrypto(String str) {
        String result = str;
        if (str != null && str.length() > 0) {
            try {
                byte[] encodeByte = str.getBytes(encoding);
                result = Base64.encodeBase64String(encodeByte);
            } catch (Exception e) {
            }
        }
        //base64加密超过一定长度会自动换行 需要去除换行符
        if(result != null) {
            return result.replaceAll("\r\n", "").replaceAll("\r", "").replaceAll("\n", "");
        }else {
            return null;
        }
    }
    /**
     * 解密字符串
     * @Author
     * @param str
     * @return  String
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    public static String ebotongDecrypto(String str) {
        try {
            byte[] encodeByte = Base64.decodeBase64(str);
            return new String(encodeByte);
        } catch (Exception e) {
            return str;
        }
    }
    /**
     * 加密
     * @Author
     * @param content
     * @return  byte[]
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    private static byte[] encrypt(String content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //防止linux下 随机生成key
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(PASSWORD.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            byte[] byteContent = content.getBytes("utf-8");
            cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(byteContent);
            return result; // 加密
        } catch (Exception e) {
        }
        return null;
    }
    /**
     * 解密
     * @Author
     * @param content
     * @return  byte[]
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    private static byte[] decrypt(byte[] content) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            //防止linux下 随机生成key
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG" );
            secureRandom.setSeed(PASSWORD.getBytes());
            kgen.init(128, secureRandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
            byte[] result = cipher.doFinal(content);
            return result; // 加密
        } catch (Exception e) {

        }
        return null;
    }
    /**
     * 将二进制转换成16进制
     * @Author
     * @param buf
     * @return  String
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    public static String parseByte2HexStr(byte buf[]) {
        String str = "";
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            str += hex.toUpperCase();
        }
        return str;
    }
    /**
     * 将16进制转换为二进制
     * @Author
     * @param hexStr
     * @return  byte[]
     * @Date    2015年2月7日
     * 更新日志
     * 2015年2月7日   首次创建
     *
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length()/2];
        for (int i = 0;i< hexStr.length()/2; i++) {
            int high = Integer.parseInt(hexStr.substring(i*2, i*2+1), 16);
            int low = Integer.parseInt(hexStr.substring(i*2+1, i*2+2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }
}