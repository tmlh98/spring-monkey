package xyz.tmlh.core.generator;

import xyz.tmlh.core.generator.processor.CodeGeneratorProcessor;
import xyz.tmlh.core.generator.processor.VelocityCodeGeneratorProcessor;
import xyz.tmlh.core.generator.util.PropertiesHandler;

/**
 * <p>
 * Title: CodeGeneratorTest
 * </p>
 * <p>
 * Description: 代码生成器
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月26日 下午3:02:22
 * @modified [who date description]
 * @check [who date description]
 */
public class CodeGenerator {
    
    public static void main(String[] args) {
        String file = "xyz/tmlh/core/generator/code-generator.properties";
        PropertiesHandler propertiesHandler = new PropertiesHandler(file);
        CodeGeneratorProcessor codeGeneratorProcessor = 
            new VelocityCodeGeneratorProcessor(propertiesHandler.load());
        codeGeneratorProcessor.generatorCode();
        
    }

    

}

