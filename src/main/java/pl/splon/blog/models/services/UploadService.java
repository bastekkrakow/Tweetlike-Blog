package pl.splon.blog.models.services;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Service
public class UploadService {
    private final static String LOGIN = "";
    private final static String PASSWORD = "";
    private final static String IP = "";
    private final static int PORT = 21;

    private FTPClient ftpClient;

    public UploadService() {
        ftpClient = new FTPClient();
    }

    @Async
    public void upload(byte[] data, String name){
        try {
            ftpClient.connect(IP, PORT);
            ftpClient.login(LOGIN, PASSWORD);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.storeFile(name, new ByteArrayInputStream(data));
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
