package cn.nomeatcoder.demo.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class CodeGenerator {
	public static void main(String[] args) {
		// ================= 需要修改的配置 =================

		// 数据源配置
		String jdbcUrl = "jdbc:mysql://129.211.14.122:3306/springboot-demo?characterEncoding=utf8&useSSL=false";
		String jdbcDriver = "com.mysql.jdbc.Driver";
		String jdbcUsername = "root";
		String jdbcPassword = "vQ1ip3UY273Cq2q";

		// 父级包名配置
		String parentPackage = "cn.nomeatcoder.demo";

		// 生成代码的 @author 值
		String author = "Chenzhe Mao";

		// 要生成代码的表名配置
		String[] tables = {
			"student"
		};

		// ==================================================

		AutoGenerator mpg = new AutoGenerator();
		// 全局配置
		GlobalConfig gc = new GlobalConfig();
		String projectPath = System.getProperty("user.dir");
		gc.setOutputDir(projectPath + "/src/main/java");
		gc.setAuthor(author);
		gc.setBaseResultMap(true);
		gc.setBaseColumnList(true);
		// 生成完毕后是否打开输出目录
		gc.setOpen(false);
		// 为true时生成entity将继承Model类，单类即可完成基于单表的业务逻辑操作，按需开启
		gc.setActiveRecord(false);
		mpg.setGlobalConfig(gc);

		// 数据源配置
		DataSourceConfig dsc = new DataSourceConfig();
		dsc.setUrl(jdbcUrl);
		dsc.setDriverName(jdbcDriver);
		dsc.setUsername(jdbcUsername);
		dsc.setPassword(jdbcPassword);
		mpg.setDataSource(dsc);

		// 包配置
		PackageConfig pc = new PackageConfig();
		// 父级包名，按需修改
		pc.setParent(parentPackage);
		// 设置模块名, 会在parent包下生成一个指定的模块包
		pc.setModuleName(null);
		pc.setEntity("domain");
		pc.setMapper("dao");
		pc.setXml("mapper");
		mpg.setPackageInfo(pc);


		// 策略配置
		StrategyConfig strategy = new StrategyConfig();
		strategy.setNaming(NamingStrategy.underline_to_camel);
		strategy.setColumnNaming(NamingStrategy.underline_to_camel);
		strategy.setRestControllerStyle(false);
		strategy.setInclude(tables);
		strategy.setSuperEntityColumns("id");
		// Controller驼峰连字符，如开启，则requestMapping由 helloWorld 变为 hello-world 默认false
		strategy.setControllerMappingHyphenStyle(false);
		strategy.setTablePrefix(pc.getModuleName() + "_");
		// 开启后将使用lombok注解代替set-get方法，false则生成set-get方法
		strategy.setEntityLombokModel(true);
		// 在实体类中移除is前缀
		strategy.setEntityBooleanColumnRemoveIsPrefix(true);
		mpg.setStrategy(strategy);
		mpg.setTemplateEngine(new FreemarkerTemplateEngine());
		mpg.execute();
	}
}
