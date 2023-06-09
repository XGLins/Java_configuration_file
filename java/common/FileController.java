package com.changjiang.score.common;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
public class FileController {
	
	public static final String PATH_KEY = "file.dirs";

	@Autowired
	private Environment environment;

    @RequestMapping("/upload")
    public Result<?> upload(MultipartFile file) throws Exception {
        // 获取文件的原始名
        String filename = file.getOriginalFilename();
        System.out.println(filename);
         String suffix = filename.substring(filename.lastIndexOf("."));
        // 生成一个新的文件名,防止文件名重复
         String newfileName = UUID.randomUUID().toString() + suffix;
        // 选择文件要添加的地址
        String realPath = environment.getProperty(PATH_KEY);
        // 往选中的地址中添加此文件
        file.transferTo(new File(realPath, newfileName));
        // 返回文件的原始名
        return Result.ok(newfileName);
    }
    
    @RequestMapping("/download/{filename}")
    public void download(@PathVariable("filename") String filename, HttpServletResponse response) throws Exception {
        // 获取文件的绝对路径
        String dir = environment.getProperty(PATH_KEY);
        String filepath = dir + filename;
        // 获取输入流对象(用于读文件)
        FileInputStream fis = new FileInputStream(new File(filepath));
        // 设置下载的类型,attachment表示以附件的形式下载,inline表示在线打开
        response.setHeader("content-disposition", "attachment;fileName=" + URLEncoder.encode(filename, "UTF-8"));
        // 获取输出流对象(用于写文件)
        ServletOutputStream os = response.getOutputStream();
        // 复制
        IOUtils.copy(fis, os);
        // 关闭资源
        fis.close();
        os.close();
    }
}
