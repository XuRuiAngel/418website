package com.sza.website;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class SzaCode {

    public static void main(String[] args) {

        // 构建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        // 配置策略

        // 1. 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("hzw");
        gc.setOpen(false);
        gc.setFileOverride(false); // 是否覆盖
        gc.setServiceName("%sService"); // 去除Service的i前缀
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        // gc.setSwagger2(true);

        autoGenerator.setGlobalConfig(gc);

        // 2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://192.168.99.253:3306/website?useSSL=true&useUnicode=true&characterEncoding=UTF-8");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setDbType(DbType.MYSQL);

        autoGenerator.setDataSource(dsc);


        // 3.设置包
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("website");
        pc.setParent("com.sza");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setController("controller");

        autoGenerator.setPackageInfo(pc);

        // 4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("project_group"); // 要映射的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setLogicDeleteFieldName("deleted");
        // 自动填充
        TableFill create_time = new TableFill("create_time", FieldFill.INSERT);
        TableFill update_time = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(create_time);
        tableFills.add(update_time);
        strategy.setTableFillList(tableFills);
        // 乐观锁
        // strategy.setVersionFieldName("version");

        strategy.setRestControllerStyle(true); // Rest接口
        strategy.setControllerMappingHyphenStyle(true);

        autoGenerator.setStrategy(strategy);


        autoGenerator.execute();


    }
}
