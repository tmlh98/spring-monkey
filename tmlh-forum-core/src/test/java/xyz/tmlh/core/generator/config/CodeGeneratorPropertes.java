package xyz.tmlh.core.generator.config;

/**
 * <p>
 * Title: DataSourceConfig
 * </p>
 * <p>
 * Description: CodeGenerator配置
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月25日 下午8:41:15
 * @modified [who date description]
 * @check [who date description]
 */
public class CodeGeneratorPropertes {

    private String driverName;

    private String username;

    private String password;

    private String url;

    private String author;

    private String pageParent;

    private String moduleName;

    private String superEntityClass;

    private String superControllerClass;

    private String includeTableName;
    private String excludeTableName;

    private String tablePrefix;
    private String pageEntity;
    private String pageService;
    private String pageServiceImpl;
    private String pageController;
    private String pageMapper;
    

    public CodeGeneratorPropertes() {}

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPageParent() {
        return pageParent;
    }

    public void setPageParent(String pageParent) {
        this.pageParent = pageParent;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSuperEntityClass() {
        return superEntityClass;
    }

    public void setSuperEntityClass(String superEntityClass) {
        this.superEntityClass = superEntityClass;
    }

    public String getSuperControllerClass() {
        return superControllerClass;
    }

    public void setSuperControllerClass(String superControllerClass) {
        this.superControllerClass = superControllerClass;
    }
 

    public String getIncludeTableName() {
        return includeTableName;
    }

    public void setIncludeTableName(String includeTableName) {
        this.includeTableName = includeTableName;
    }

    public String getExcludeTableName() {
        return excludeTableName;
    }

    public void setExcludeTableName(String excludeTableName) {
        this.excludeTableName = excludeTableName;
    }

    public String getTablePrefix() {
        return tablePrefix;
    }

    public void setTablePrefix(String tablePrefix) {
        this.tablePrefix = tablePrefix;
    }
    

    public String getPageEntity() {
        return pageEntity;
    }

    public void setPageEntity(String pageEntity) {
        this.pageEntity = pageEntity;
    }

    public String getPageService() {
        return pageService;
    }

    public void setPageService(String pageService) {
        this.pageService = pageService;
    }

    public String getPageServiceImpl() {
        return pageServiceImpl;
    }

    public void setPageServiceImpl(String pageServiceImpl) {
        this.pageServiceImpl = pageServiceImpl;
    }

    public String getPageController() {
        return pageController;
    }

    public void setPageController(String pageController) {
        this.pageController = pageController;
    }

    public String getPageMapper() {
        return pageMapper;
    }

    public void setPageMapper(String pageMapper) {
        this.pageMapper = pageMapper;
    }

}
