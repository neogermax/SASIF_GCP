/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documentos.utilerias;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.List;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 *
 * @author analista03
 */
public class UtileriasDocumentos {
    private final static FTPClient ftpClient = new FTPClient();
    private final static String SERVER   = "sistemassasif.com";
    private final static String USER     = "cgpluis";
    private final static String PASSWORD = "Sasif01%";
    
    public static void copyFile(String fileOr, String fileDes) throws FileNotFoundException, IOException {
        File forg = new File(fileOr);
        File fdes = new File(fileDes);
        copyFile(forg, fdes);
    }
    
    public static void copyFile(File fileOr, File fileDes) throws FileNotFoundException, IOException {
        InputStream in = new FileInputStream(fileOr);
        copyFile(in, fileDes);
    }
    
    public static void copyFile(InputStream in, String fileDes) throws IOException {
        File fdes = new File(fileDes);
        copyFile(in, fdes);
    }
    
    public static void copyFile(InputStream in, File fileDes) throws IOException {
        OutputStream out = new FileOutputStream(fileDes);
        int read = 0;
        byte[] bytes = new byte[1024];
        while((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        in.close();
        out.flush();
        out.close();
    }
    
    public static void copyFTP(String fileOr, String fileDes) throws SocketException, IOException {
        ftpClient.connect(SERVER);
        ftpClient.login(USER, PASSWORD);

        int reply = ftpClient.getReplyCode();

        FTPReply.isPositiveCompletion(reply);

        ftpClient.changeWorkingDirectory("/");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        
        BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(fileOr)); 
        ftpClient.enterLocalPassiveMode();
        ftpClient.storeFile(fileDes, buffIn);
        buffIn.close();
        
        ftpClient.logout();
        ftpClient.disconnect();
    }
    
    public static void deleteDocument(String file) {
        try {
            ftpClient.connect(SERVER);
            ftpClient.login(USER, PASSWORD);

            ftpClient.deleteFile(file);
            
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void deleteDocument(List<String> files) {
        try {
            ftpClient.connect(SERVER);
            ftpClient.login(USER, PASSWORD);
            
            for(String file : files) {
                ftpClient.deleteFile(file);
            }
            
            ftpClient.logout();
            ftpClient.disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
