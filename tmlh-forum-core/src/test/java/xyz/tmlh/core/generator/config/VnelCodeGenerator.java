package xyz.tmlh.core.generator.config;

/**
 * <p>
 * Title: VnelCodeGenerator
 * </p>
 * <p>
 * Description: 定义配置常量
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月25日 下午9:18:28
 * @modified [who date description]
 * @check [who date description]
 */
public interface VnelCodeGenerator {

    String DRIVER_NAME = "vnel.code.generator.driverName";
    String USERNAME = "vnel.code.generator.username";
    String PASSWORD = "vnel.code.generator.password";
    String URL = "vnel.code.generator.url";
    String AUTHOR = "vnel.code.generator.author";
    String PAGE_PARENT = "vnel.code.generator.pageParent";
    String MODULE_NAME = "vnel.code.generator.moduleName";
    String SUPER_ENTITY_CLASS = "vnel.code.generator.superEntityClass";
    String SUPER_CONTROLLER_CLASS = "vnel.code.generator.superControllerClass";
    String TABLE_PREFIX = "vnel.code.generator.tablePrefix";
    String INCLUDE_TABLE_NAME = "vnel.code.generator.includeTableName";
    String EXCLUDE_TABLE_NAME = "vnel.code.generator.excludeTableName";
    
    String PAGE_ENTITY = "vnel.code.generator.pageEntity";
    String PAGE_SERVICE = "vnel.code.generator.pageService";
    String PAGE_SERVICE_IMPL = "vnel.code.generator.pageServiceImpl";
    String PAGE_CONTROLLER = "vnel.code.generator.pageController";
    String PAGE_MAPPER = "vnel.code.generator.pageMapper";
    
}
