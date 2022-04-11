package com.learn.boot.util;

import com.aspose.words.Document;
import com.aspose.words.License;
import com.aspose.words.SaveFormat;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class WordUtil {

    /**
     * <h2>word转pdf</h2>
     * date 2021-08-27 10:49
     *
     * @param wordFilePath word文件路径
     * @param pdfFilePath 转换的pdf文件路径
     * @return boolean 是否转换成功
     * @author YuanWenhao[www.ywh1421@163.com]
     * @since DistributionVersion
     */
    public static boolean wordToPDF(String wordFilePath,String pdfFilePath ){
        ByteArrayInputStream is = null;
        FileOutputStream out = null;
        try {
            String s = "<License><Data><Products><Product>Aspose.Total for Java</Product><Product>Aspose.Words for Java</Product></Products><EditionType>Enterprise</EditionType><SubscriptionExpiry>20991231</SubscriptionExpiry><LicenseExpiry>20991231</LicenseExpiry><SerialNumber>8bfe198c-7f0c-4ef8-8ff0-acc3237bf0d7</SerialNumber></Data><Signature>sNLLKGMUdF0r8O1kKilWAGdgfs2BvJb/2Xp8p5iuDVfZXmhppo+d0Ran1P9TKdjV4ABwAgKXxJ3jcQTqE/2IRfqwnPf8itN8aFZlV3TJPYeD3yWE7IT55Gz6EijUpC7aKeoohTb4w2fpox58wWoF3SNp6sK6jDfiAUGEHYJ9pjU=</Signature></License>";
            is = new ByteArrayInputStream(s.getBytes());
            License license = new License();
            license.setLicense(is);
            Document document = new Document(wordFilePath);
            out = new FileOutputStream(new File(pdfFilePath));
            document.save(out, SaveFormat.PDF);
            out.flush();
            out.close();
            is.close();
        } catch (Exception e) {
            return false;
        }finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

}
