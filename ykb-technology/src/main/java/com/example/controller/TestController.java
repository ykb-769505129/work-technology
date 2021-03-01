package com.example.controller;

//import com.example.util.Rs;
import com.example.pojo.*;
import com.example.service.TestService;
import com.example.util.SuperSimpleController;
import com.example.util.Url_MultipartFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

}