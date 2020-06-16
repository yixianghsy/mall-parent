package com.e3mall.mapper.controller;
import com.e3mall.mansger.service.UploadService;
import com.e3mall.utils.JsonUtils;
import com.e3mall.utils.ResultUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传处理Controller
 * <p>Title: PictureController</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p>
 * @version 1.0
 */
@Controller
public class PictureController {

    @Reference
    private UploadService uploadService;

    @RequestMapping(value = "/getQintuToken", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "获取七牛云Token", notes = "获取七牛云Token")
    public ResultUtil getUpToken(
            @ApiParam(value = "hsymall", required = false) @RequestParam(required = false) String bucket
    ) {
        ResultUtil resultUtil = new ResultUtil();
        resultUtil = uploadService.getUpToken();
        return resultUtil;
    }

    @RequestMapping(value="/pic/upload", produces= MediaType.TEXT_PLAIN_VALUE+";charset=utf-8")
    @ResponseBody
    @ApiOperation(value = "上传文件到七牛云", notes = "上传文件到七牛云")
    public String uploadQiniu(
            @ApiParam(value = "file", required = false) @RequestParam(required = false) MultipartFile file
    )  {
        ResultUtil resultUtil = new ResultUtil();
        if (file.isEmpty()) {
            return "文件为空，请重新上传";
        }
        try {
            file.getBytes();
            //文件名
            String fileName = file.getOriginalFilename();
            resultUtil = uploadService.uploadFileQiniu(file.getBytes(),fileName);
            String url = resultUtil.getData().getFileUrl();
            System.out.println(url);
            //封装到map中返回
            Map result = new HashMap<>();
            result.put("error", 0);
            result.put("url", url);
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JsonUtils.objectToJson(result);
        }


    }
    //图片到byte数组
    public byte[] image2byte(MultipartFile file){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream((File) file);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

}
