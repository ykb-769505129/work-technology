package com.example.Controller;

//import com.example.util.Rs;
import com.example.pojo.*;
import com.example.service.TestService;
import com.example.util.SuperSimpleController;
import com.example.util.Url_MultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.bind.annotation.*;
import org.apache.http.entity.ContentType;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 76950
 */
@RestController
@Api(tags = "测试模块")
@RequestMapping("/admin")
public class TestController extends SuperSimpleController<TestService, Test> {

    @GetMapping("/getText")
    @ApiOperation(value = "测试get")
    public String getText(@RequestParam(value = "string") String string,
                            @RequestParam(value = "strings")String strings ) {
        System.out.println("string=>"+string);
        System.out.println("strings=>"+strings);
        Test test  = new Test();
        test.setName(string);
        test.setSex(strings);
        return string;
    }

//    @PostMapping("/postText")
//    @ApiOperation(value = "测试post")
//    public Safe2 postText(@RequestBody Safe2 safe){
//        return safe;
//    }


    @PostMapping("/postText")
    @ApiOperation(value = "对接post")
    public DeviceRes1 postDevice(@RequestBody Device device){
        System.out.println(device.toString());
        DeviceRes1 deviceRes1 = new DeviceRes1();
        deviceRes1.setMsg("成功");
        deviceRes1.setCode("0");
        Safe2 safe2 = new Safe2();
        safe2.setTotal(3365);
        DeviceResponse3 deviceResponse3 = new DeviceResponse3();
        deviceRes1.setData(safe2);
        List list = new ArrayList();
        list.add(deviceResponse3);
        list.add(deviceResponse3);
        safe2.setList(list);
        return deviceRes1;
    }

    public static void main(String[] args) throws Exception {
        MultipartFile fileItem = Url_MultipartFile.createFileItem("https://xiaoxijiyu.oss-cn-beijing.aliyuncs.com/2.jpg?Expires=1608735576&OSSAccessKeyId=TMP.3Kj9EenrjhbxCzRL1RuN4dwiomGfTUMmQBSnCrr2Nze5mjF4nX4PQWN6i1qk2BGL7wXsehgm6g5AmzdmqhYwQm5GbVBVe7&Signature=CbsxS5dsoKClhiY17DF8M7plIAc%3D&versionId=CAEQEBiBgMD2ycu_tBciIDdhNzg3NzE3MjY2MzRkMTg5OWI4NGFiZjBjNThjOWU3&response-content-type=application%2Foctet-stream", "2.jpg");
        System.out.println("fileItem{}"+fileItem);
    }

}
