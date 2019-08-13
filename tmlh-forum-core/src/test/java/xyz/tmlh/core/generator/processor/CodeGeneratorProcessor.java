package xyz.tmlh.core.generator.processor;

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
public interface CodeGeneratorProcessor {

    String SYS_USER = "user.dir";
    
    /**
     * 生成代码
     */
    void  generatorCode();
    
    
}
