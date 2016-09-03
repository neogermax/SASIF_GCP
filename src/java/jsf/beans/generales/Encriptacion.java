/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans.generales;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author saflap
 */
public class Encriptacion {
    private final static char[] CONSTS_HEX = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public static String md5(String password) {
        try {
            MessageDigest msgd = MessageDigest.getInstance("MD5");
            byte[] bytes = msgd.digest(password.getBytes());
            StringBuilder stringMD5 = new StringBuilder(2*bytes.length);
            for(byte b : bytes) {
                int s = (int)(b&0x0f);
                int h = (int)((b&0xf0)>>4);
                stringMD5.append(CONSTS_HEX[h]);
                stringMD5.append(CONSTS_HEX[s]);
            }
            return stringMD5.toString();
        } catch(NoSuchAlgorithmException e) {
            return null;
        }
    }
}
