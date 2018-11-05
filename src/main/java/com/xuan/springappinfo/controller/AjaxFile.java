package com.xuan.springappinfo.controller;

import com.xuan.springappinfo.utils.Result;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: 描述 </p>
 *
 * @Created with IDEA
 * @author: Yi-Xuan
 * @Date: 2018/11/5 0005
 * @Time: 14:10
 */
@RestController
@RequestMapping("/file")
public class AjaxFile {

    /**
     * 实现文件上传
     */
    @PostMapping("/getFile")
    @ResponseBody
    public Result fileUpload(@RequestParam(value = "file", required = false) MultipartFile file) {

        if (file.isEmpty()) {
            return Result.getCustomize(false, -1, "文件不存在");
        }

        //获取文件名字(包含文件格式的后缀)
        String fileName = file.getOriginalFilename();

        //获取文件大小
        double size = formatDouble((double) file.getSize());
        System.out.println(fileName + "--->" + size);

        //文件保存地址
        String path = "f:/test";

        //判断是否有文件同名情况
        fileName = ShowFile(path, fileName);

        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) {
            //判断文件父目录是否存在
            dest.getParentFile().mkdir();   //创建目录
        }

        try {
            file.transferTo(dest);

            Map<String, Object> map = new HashMap<>(16);

            map.put("versionSize", size);
            map.put("apkLocPath", path);
            map.put("apkFileName", fileName);

            return Result.getCustomize(true, -1, "文件上传成功", map);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Result.getCustomize(false, -1, "文件上传失败");
    }

    /**
     * 判断上传的文件名字是否有同名情况
     *
     * @param path     文件上传的路径
     * @param fileName 文件名称
     * @return
     */
    private static String ShowFile(String path, String fileName) {

        String name = fileName;

        File fi = new File(path);
        File[] file = fi.listFiles();
        //获取目录下所有file对象名称的数组
        if (file != null) {
            for (int i = 0; i < file.length; i++) {
                File f = file[i];
                if (!f.isDirectory()) {
                    //判断是否为目录 目录返回true 文件返回false
                    if (f.getName().equals(fileName)) {
                        //判断里面是否有文件和上传的文件名一样
                        int num = name.indexOf(".");
                        fileName = name.substring(0, num) + i + name.substring(num);
                    }
                }
            }
        }
        return fileName;
    }

    /**
     * <p>Description: 把获取的文件数据大小从字节转换成兆，并对double数据进行四舍五入 </p>
     *
     * @author Yat-Xuan
     * @params: [d]
     * @return: double
     * @Date: 2018/11/5 0005 14:13
     * @Modified By:
     */
    public static double formatDouble(double d) {
        // 旧方法，已经不再推荐使用
        // BigDecimal bg = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);

        //把字节数据转换成兆
        d = d / 1048576;

        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);

        return bg.doubleValue();
    }
}
