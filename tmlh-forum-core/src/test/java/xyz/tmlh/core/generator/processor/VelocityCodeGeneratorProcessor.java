package xyz.tmlh.core.generator.processor;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import xyz.tmlh.core.generator.config.CodeGeneratorPropertes;

/**
 * <p>
 * Title: VelocityCodeGeneratorProcessor
 * </p>
 * <p>
 * Description: Velocity模板的代码生成器
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月26日 上午11:08:52
 * @modified [who date description]
 * @check [who date description]
 */
public class VelocityCodeGeneratorProcessor extends AbstrctCodeGeneratorProcessor {

    public VelocityCodeGeneratorProcessor(CodeGeneratorPropertes propertes) {
        super(propertes);
    }

    @Override
    public void generatorCode() {
        // 代码生成器
        AutoGenerator mpg = initAutoGenerator();
        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名
                return projectPath + "/src/main/resources/mapper/" + propertes.getModuleName() + "/" + tableInfo.getEntityName() + "Mapper"
                    + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        mpg.setTemplateEngine(new VelocityTemplateEngine());
        mpg.execute();

    }

}