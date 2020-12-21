package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Test;
import org.mapstruct.Mapper;

@Mapper
public interface TestMapper extends BaseMapper<Test> {
}
