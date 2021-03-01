package com.example.controller;

import com.example.pojo.RanDom;
import com.example.service.RanDomService;
import com.example.util.SuperSimpleController;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 随机算法
 * @author 76950
 */
@RestController
@Api(tags = "项目一，随机算法")
@RequestMapping("/admin/randDom")
public class RanDomController extends SuperSimpleController<RanDomService, RanDom> {



}
