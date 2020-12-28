package com.example.util.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.enums.SqlLike;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {

    private static String AUTHOR = "auto";

    private static String BASE_DIR = "autoGenCode";

    private static String DB_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    public static void gen(String tablePrefix, String dbUrl, String dbUsername, String dbPassword, String packageName) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = BASE_DIR;
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(AUTHOR);
        gc.setOpen(false);
        // 实体属性 Swagger2 注解
        gc.setSwagger2(true);
        gc.setIdType(IdType.AUTO);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        dsc.setDriverName(DB_DRIVER_NAME);
        dsc.setUsername(dbUsername);
        dsc.setPassword(dbPassword);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName(tablePrefix);
        pc.setParent(packageName);
        pc.setEntity("pojo");
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });


        String dtoPath = gc.getOutputDir() + "/" + packageName.replace(".", "/") + "/" + pc.getModuleName() + "/entity/dto/";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/entitySaveDTO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return dtoPath + tableInfo.getEntityName() + "SaveDTO" + StringPool.DOT_JAVA;
            }
        });
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/entityUpdateDTO.java.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return dtoPath + tableInfo.getEntityName() + "UpdateDTO" + StringPool.DOT_JAVA;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);

            strategy.setSuperEntityClass("com.example.util.generator.entity.Entity");
        strategy.setSuperEntityColumns("id","created_time","create_user_id","update_time","update_user_id");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setSuperControllerClass("com.example.util.generator.controller.SuperSimpleController");
        strategy.setTablePrefix(pc.getModuleName() + "_");
        strategy.setLikeTable(new LikeTable(pc.getModuleName(), SqlLike.DEFAULT));
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }

}
