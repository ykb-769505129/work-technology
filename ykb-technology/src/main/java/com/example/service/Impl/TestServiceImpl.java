package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.TestMapper;
import com.example.pojo.Test;
import com.example.service.TestService;
import org.springframework.stereotype.Service;

/**
 * @author 76950
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
}
