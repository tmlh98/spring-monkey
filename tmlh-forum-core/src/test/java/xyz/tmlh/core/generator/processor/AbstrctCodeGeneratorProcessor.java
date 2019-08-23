package xyz.tmlh.core.generator.processor;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import xyz.tmlh.core.generator.config.CodeGeneratorPropertes;

/**
 * <p>
 * Title: CodeGeneratorProcessor
 * </p>
 * <p>
 * Description: 代码生成器
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月26日 上午10:10:00
 * @modified [who date description]
 * @check [who date description]
 */
public abstract class AbstrctCodeGeneratorProcessor implements CodeGeneratorProcessor {

    protected CodeGeneratorPropertes propertes;

    protected String projectPath = System.getProperty(SYS_USER);

    public AbstrctCodeGeneratorProcessor(CodeGeneratorPropertes propertes) {
        this.propertes = propertes;
    }

    protected AutoGenerator initAutoGenerator() {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        mpg.setGlobalConfig(getGlobalConfig());
        mpg.setDataSource(getDataSourceConfig());
        mpg.setPackageInfo(getPackageConfig());
        mpg.setStrategy(getStrategyConfig());
        return mpg;
    }

    /**
     * 全局配置文件
     * 
     * @author TianXin
     * @created 2019年2月26日 上午11:15:50
     * @param propertes
     * @return
     */
    private GlobalConfig getGlobalConfig() {
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(propertes.getAuthor());// 作者
        gc.setIdType(IdType.AUTO); // 主键策略自动递增
        gc.setOpen(false);
        gc.setFileOverride(true);
        gc.setServiceName("%sService");
        gc.setEntityName("%sModel");
        gc.setBaseResultMap(true);
        gc.setBaseColumnList(true);
        return gc;
    }

    /**
     * 数据源配置
     * 
     * @author TianXin
     * @created 2019年2月26日 上午11:15:50
     * @param propertes
     * @return
     */
    private DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(propertes.getUrl());
        dsc.setDriverName(propertes.getDriverName());
        dsc.setUsername(propertes.getUsername());
        dsc.setPassword(propertes.getPassword());
        return dsc;
    }

    /**
     * 包配置
     * 
     * @author TianXin
     * @created 2019年2月26日 上午11:15:50
     * @param propertes
     * @return
     */
    private PackageConfig getPackageConfig() {
        PackageConfig pc = new PackageConfig();
        pc.setParent(propertes.getPageParent());
        pc.setModuleName(propertes.getModuleName());
        pc.setEntity(propertes.getPageEntity());
        pc.setService(propertes.getPageService());
        pc.setServiceImpl(propertes.getPageServiceImpl());
        pc.setController(propertes.getPageController());
        pc.setMapper(propertes.getPageMapper());
        return pc;
    }

    /**
     * 策略配置
     * 
     * @author TianXin
     * @created 2019年2月26日 上午11:15:50
     * @param propertes
     * @return
     */
    private StrategyConfig getStrategyConfig() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setSuperEntityClass(propertes.getSuperEntityClass());
        strategy.setEntityLombokModel(false);
        strategy.setRestControllerStyle(true);
        strategy.setSuperControllerClass(propertes.getSuperControllerClass());
        //生成的表
        strategy.setInclude(null !=propertes.getIncludeTableName()?propertes.getIncludeTableName().split(","):null);
        strategy.setExclude(null !=propertes.getExcludeTableName()?propertes.getExcludeTableName().split(","):null);
        System.out.println(propertes.getExcludeTableName());
        /*strategy.setSuperEntityColumns("id");*/
        strategy.setControllerMappingHyphenStyle(true);
        /*pc.getModuleName()+   设置表的前缀*/
        strategy.setTablePrefix(propertes.getTablePrefix());
        return strategy;
    }

    /**
     * 生成代码
     */
    public abstract void generatorCode();

}
