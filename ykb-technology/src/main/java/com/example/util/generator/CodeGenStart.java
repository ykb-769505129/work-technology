package com.example.util.generator;

public class CodeGenStart {

    public static void main(String[] args) {
        /**
         * mysql 的地址
         */
        String dbUrl = "jdbc:mysql://localhost:3306/github?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8";

        /**
         * 数据库 用户名
         */
        String dbUsername = "root";

        /**
         * 数据库 密码
         */
        String dbPassword = "123456";

        /**
         * 生成文件的存放地址
         */
        String packageName = "com.example";

        /**
         * 所要生成表的前缀 需要全部生成时请为 ""
         */
        String tablePrefix = "";

        CodeGenerator.gen(tablePrefix,dbUrl,dbUsername,dbPassword,packageName);

    }

}
