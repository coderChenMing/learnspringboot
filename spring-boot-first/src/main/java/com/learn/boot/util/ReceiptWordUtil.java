package com.learn.boot.util;

import cn.afterturn.easypoi.word.WordExportUtil;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ReceiptWordUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger(ReceiptWordUtil.class);
    
    public static void main(String[] args) throws Exception {
    	String templatePath="E:\\test\\receipt.docx";
    	String temDir = "E:\\test";
    	String fileNname="回执单.docx";
    	Map<String, Object> params =new HashMap<String,Object>();
    	params.put("number", "123");
    	params.put("userName", "peiguanghao");
    	params.put("year", "2021");
    	params.put("month", "08");
    	params.put("day", "27");
    	params.put("product", "测试产品");
    	params.put("model", "测试型号");
    	params.put("edition", "测试版本");
    	params.put("type", "测试类型");
    	params.put("level", "测试等级");
    	exportWord(templatePath,temDir,fileNname,params);

    	WordUtil.wordToPDF("E:\\test\\回执单.docx", "E:\\test\\回执单.pdf");
    }

    /**
     * 导出word
     * <p>第一步生成替换后的word文件，只支持docx</p>
     * <p>第二步下载生成的文件</p>
     * <p>第三步删除生成的临时文件</p>
     * 模版变量中变量格式：{{foo}}
     *
     * @param templatePath word模板地址
     * @param temDir       生成临时文件存放地址{最终输出路径+fileName}
     * @param fileName     文件名
     * @param params       替换的参数
     */
    public static void exportWord(String templatePath, String temDir, String fileName, Map<String, Object> params) throws Exception {
        Assert.notNull(templatePath, "模板路径不能为空");
        Assert.notNull(temDir, "临时文件路径不能为空");
        Assert.notNull(fileName, "导出文件名不能为空");
        Assert.isTrue(fileName.endsWith(".docx"), "word导出请使用docx格式");
        if (!temDir.endsWith(File.separator)) {
            temDir = temDir + File.separator;
        }
        File dir = new File(temDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            XWPFDocument doc = WordExportUtil.exportWord07(templatePath, params);
            String tmpPath = temDir + fileName;
            LOGGER.info("统计报告|输出路径="+tmpPath);
            FileOutputStream fos = new FileOutputStream(tmpPath);
            doc.write(fos);
            fos.flush();
            fos.close();
        } catch (Exception e) {
        	LOGGER.error("统计报告错误", e);
        }
    }

}
