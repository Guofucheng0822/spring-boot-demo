package com.ps.gfc.tv.controller;

import com.pers.guofucheng.config.SSHHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * SSHController
 *
 * @author guofucheng
 * @date 2021/07/13
 */
@RestController
@RequestMapping("/ssh")
public class SSHController {

    private static final Logger logger= LoggerFactory.getLogger(SSHController.class);

    /**
     * 备份前端文件
     */
    private static final String EXEC_CMD1 ="mv /app/front3.0/dist.zip /app/front3.0/dist.zip-bak"+System.currentTimeMillis();
    /**
     * 删除前端文件
     */
    private static final String EXEC_CMD2 = "rm -rf /app/front3.0/dist";
    /**
     * 解压新上传前端文件
     */
    private static final String EXEC_CMD3 = "unzip -d /app/front3.0 /app/front3.0/dist.zip";
    /**
     * 钉钉机器人通知
     */
    private static final String EXEC_CMD4 = "curl -i -k  -H \"Content-type: application/json\" -X POST -d '{\"msgtype\":\"text\",\"text\":{\"content\":\"[长株潭]......\"},\"at\":{\"atMobiles\":[\"15760937543\"],\"isAtAll\":false}}' https://oapi.dingtalk.com/robot/send?access_token=03b326ab4c8abaab8ff17ea55437bf27c7972fafec2414300390981d10ceaa6f";
    /**
     * 文件上传路径
     */
    @Value("${file.upload.path:/app/front3.0}")
    private String uploadPath;

    private final SSHHelper sshHelper;

    @Autowired
    public SSHController(SSHHelper sshHelper) {
        this.sshHelper = sshHelper;
    }


    /**
     * 上传前端文件并发布接口
     * 1.先备份之前的文件
     * 2.上传文件
     * 3.解压缩文件
     */
    @RequestMapping(value = "/uploadFile")
    public Object uploadFile(MultipartFile file) {
        logger.info("开始执行上传前端文件并发布接口。。。");
        sshHelper.exec(EXEC_CMD1);
        sshHelper.exec(EXEC_CMD2);
        String fileName = file.getOriginalFilename();
        if (StringUtils.isEmpty(fileName)){
            fileName="dist.zip";
        }
        Map<String,Object> m = new HashMap(16);
        Map<String, Object> map = new HashMap<>(16);
        File dFile = new File(uploadPath);
        File targetFile = new File(dFile, fileName);
        try {
            if (!dFile.exists()) {
                dFile.mkdirs();
            }
            if (!targetFile.exists()) {
                targetFile.createNewFile();
            }
            FileCopyUtils.copy(file.getBytes(), targetFile);
            m.put("filename",file.getOriginalFilename());
            m.put("isSuccess", true);
            m.put("comID", "fileImport");
            m.put("ftype", "file");
            m.put("obj", map);
        } catch (Exception e) {
            logger.error("文件上传出现异常",e);
            return "error";
        }
        sshHelper.exec(EXEC_CMD3);
        return "success";
    }


    /**
     * 自定义设置并执行SSHCmd
     *
     * @param command 命令
     * @return {@link String}
     */
    @GetMapping("setSSHCmd")
    public String setSSHCmd(@RequestParam("command") String command){
        System.out.println("setSSHCmd:"+command);
        sshHelper.exec(command);
        return "success";
    }

}
