package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	
	static public String getSha256(String inputVal)  {
		MessageDigest myDigest=null;
		try {
			myDigest = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myDigest.update(inputVal.getBytes());
		byte[] dataBytes = myDigest.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < dataBytes.length; i++) {
			sb.append(Integer.toString((dataBytes[i])).substring(1));
		}
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < dataBytes.length; i++) {
			String hex = Integer.toHexString(0xff & dataBytes[i]);
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		String retParam = hexString.toString();
		return retParam;
	}
	
//    /**
//     * 
//     * @param txt, text in plain format
//     * @param hashType MD5 OR SHA1
//     * @return hash in hashType 
//     */
//    public static String getHash(String txt, String hashType) {
//        try {
//                    java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
//                    byte[] array = md.digest(txt.getBytes());
//                    StringBuffer sb = new StringBuffer();
//                    for (int i = 0; i < array.length; ++i) {
//                        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
//                 }
//                    return sb.toString();
//            } catch (java.security.NoSuchAlgorithmException e) {
//                //error action
//            }
//            return null;
//    }
//
//    public static String md5(String txt) {
//        return Hash.getHash(txt, "MD5");
//    }
//
//    public static String sha1(String txt) {
//        return Hash.getHash(txt, "SHA1");
//    }
}
