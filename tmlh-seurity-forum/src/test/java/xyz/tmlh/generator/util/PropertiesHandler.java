package xyz.tmlh.generator.util;

import java.io.InputStream;
import java.util.Properties;

import xyz.tmlh.generator.config.CodeGeneratorPropertes;
import xyz.tmlh.generator.config.VnelCodeGenerator;

/**
 * <p>
 * Title: PropertiesUtil
 * </p>
 * <p>
 * Description:配置文件工具类
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月25日 下午9:03:06
 * @modified [who date description]
 * @check [who date description]
 */
public class PropertiesHandler {

    private String filePath;

    public PropertiesHandler(String filePath) {
        this.filePath = filePath;
    }

    public Properties getProperty() {
        Properties properties = new Properties();
        InputStream is = getClass().getClassLoader().getResourceAsStream(filePath);
        try {
            properties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public CodeGeneratorPropertes load() {
        Properties propertes = getProperty();
        CodeGeneratorPropertes codeGeneratorPropertes = new CodeGeneratorPropertes();
        codeGeneratorPropertes.setDriverName(propertes.getProperty(VnelCodeGenerator.DRIVER_NAME));
        codeGeneratorPropertes.setUrl(propertes.getProperty(VnelCodeGenerator.URL));
        codeGeneratorPropertes.setPassword(propertes.getProperty(VnelCodeGenerator.PASSWORD));
        codeGeneratorPropertes.setUsername(propertes.getProperty(VnelCodeGenerator.USERNAME));

        codeGeneratorPropertes.setAuthor(propertes.getProperty(VnelCodeGenerator.AUTHOR));
        codeGeneratorPropertes.setPageParent(propertes.getProperty(VnelCodeGenerator.PAGE_PARENT));
        codeGeneratorPropertes.setModuleName(propertes.getProperty(VnelCodeGenerator.MODULE_NAME));
        codeGeneratorPropertes.setSuperEntityClass(propertes.getProperty(VnelCodeGenerator.SUPER_ENTITY_CLASS));
        codeGeneratorPropertes.setSuperControllerClass(propertes.getProperty(VnelCodeGenerator.SUPER_CONTROLLER_CLASS));
        codeGeneratorPropertes.setTablePrefix(propertes.getProperty(VnelCodeGenerator.TABLE_PREFIX));

        codeGeneratorPropertes.setPageEntity(propertes.getProperty(VnelCodeGenerator.PAGE_ENTITY));
        codeGeneratorPropertes.setPageService(propertes.getProperty(VnelCodeGenerator.PAGE_SERVICE));
        codeGeneratorPropertes.setPageServiceImpl(propertes.getProperty(VnelCodeGenerator.PAGE_SERVICE_IMPL));
        codeGeneratorPropertes.setPageController(propertes.getProperty(VnelCodeGenerator.PAGE_CONTROLLER));
        codeGeneratorPropertes.setPageMapper(propertes.getProperty(VnelCodeGenerator.PAGE_MAPPER));

        codeGeneratorPropertes.setIncludeTableName(propertes.getProperty(VnelCodeGenerator.INCLUDE_TABLE_NAME).length() == 0 ? null : propertes.getProperty(
            VnelCodeGenerator.INCLUDE_TABLE_NAME));
        System.out.println();
        codeGeneratorPropertes.setExcludeTableName(propertes.getProperty(VnelCodeGenerator.EXCLUDE_TABLE_NAME).length() == 0 ? null : propertes.getProperty(
            VnelCodeGenerator.EXCLUDE_TABLE_NAME));

        return codeGeneratorPropertes;
    }

}
