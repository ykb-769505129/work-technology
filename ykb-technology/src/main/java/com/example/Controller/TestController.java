package com.example.Controller;

//import com.example.util.Rs;
import com.example.pojo.Test;
import com.example.service.TestService;
import com.example.util.SuperSimpleController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @author 76950
 */
@RestController
@Api(tags = "测试模块")
@RequestMapping("/admin")
public class TestController extends SuperSimpleController<TestService, Test> {

    @GetMapping("/getText")
    @ApiImplicitParam(name = "string",value = "姓名",required = true)
    @ApiOperation(value = "测试get")
    public String getText(@RequestParam(value = "string") String string){
        System.out.println("string=>"+string);
        return string;
    }

    @PostMapping("/postText")
    @ApiImplicitParam(name = "user",value = "姓名",required = true)
    @ApiOperation(value = "测试post")
    public Test postText(@RequestBody Test u){
        System.out.println(u.toString());
        return u;
    }

}
