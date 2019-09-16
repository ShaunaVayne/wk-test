package cn.wk.xdf;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Tool {
	
	public static String getMd5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            /*System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));*/
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
	
	/**
    *
    * @param plainText
    *            明文
    * @return 32位密文
    */
   public static String get32md5(String plainText) {
       String re_md5 = new String();
       try {
           MessageDigest md = MessageDigest.getInstance("MD5");
           md.update(plainText.getBytes());
           byte b[] = md.digest();

           int i;

           StringBuilder sb = new StringBuilder("");
           for (int offset = 0; offset < b.length; offset++) {
               i = b[offset];
               if (i < 0)
                   i += 256;
               if (i < 16)
                   sb.append("0");
               sb.append(Integer.toHexString(i));
           }
           re_md5 = sb.toString();

       } catch (NoSuchAlgorithmException e) {
           e.printStackTrace();
       }
       return re_md5;
   }
   
   /**
    * 获取加密串
    * @param src
    * @return
    */
   public static String encodeByMD5(String src){
       if(src !=null){
           try {
               MessageDigest md = MessageDigest.getInstance("MD5");
               byte[] bytes = md.digest(src.getBytes());
               return byteArrayToHex(bytes).toUpperCase();
           }
           catch (NoSuchAlgorithmException e) {
               e.printStackTrace();
           }
       }
       return null;
   }

    /**
     * 短信平台MD5编码
     * @param s
     * @return
     */
    public  static String getSmsMd5(String s) {
        try {
            byte[] strTemp = s.getBytes("UTF-8");
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            return Hex.encodeHexString(md).toUpperCase();
        } catch (Exception e) {
            return "";
        }
    }

    public static String byteToHex(byte b){
       String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
       int n = b;
       if(n<0){
           n = 256+n;
       }
       int d1 = n/16;
       int d2 = n%16;
       return hexDigits[d1] + hexDigits[d2];
   }
   
   public static String byteArrayToHex(byte[] bytes){
       StringBuilder sb = new StringBuilder();
       for(int i=0;i<bytes.length;i++){
           sb.append(byteToHex(bytes[i]));
       }
       return sb.toString();
   }
   
   
   
   


}
