package com.example.user.generate;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://14.103.203.44:3306/communicationOfStudy?useSSL=false", "root", "wd199604070010!")
            // 全局配置
            .globalConfig(builder -> {
                builder.author("YourName")      // 作者
                    .outputDir(System.getProperty("user.dir") + "/user/src/main/java") // 输出路径
                    .enableSwagger()            // 开启Swagger注解
                    .fileOverride();            // 覆盖已有文件
            })
            // 包路径配置
            .packageConfig(builder -> {
                builder.parent("com.example")   // 父包名
                    .moduleName("user")       // 模块名
                    .entity("entity")           // 实体类包名
                    .service("service")    // Service包名
                    .controller("controller"); // Controller包名
            })
            // 生成策略
            .strategyConfig(builder -> {
                builder.addInclude("permission")  // 指定需生成代码的表名
                    .addTablePrefix("t_")            // 过滤表前缀（如t_user→User）
                    .entityBuilder()                 // 实体类策略
                        .enableLombok()              // 启用Lombok
                        .enableTableFieldAnnotation() // 字段添加@TableId等注解
                    .controllerBuilder()             
                        .enableRestStyle();          // 生成@RestController
            })
            // 模板引擎（默认Freemarker）
            .templateEngine(new FreemarkerTemplateEngine())
            .execute();
    }
}
