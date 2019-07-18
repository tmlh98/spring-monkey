package xyz.tmlh.forum.core.config;
import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

/**
 * <p>
 *  MybatisPlus配置    
 * </p>
 *
 * @author TianXin
 * @since 2019年3月26日下午4:01:08
 */
@MapperScan("xyz.tmlh.forum.core.mapper")
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件 
     * @author TianXin
     * @created 2019年2月23日 上午10:53:09
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 打印 sql - 建议开发环境使用
     * @author TianXin
     * @created 2019年2月23日 上午10:53:20
     * @return
     */
//    @Bean
    @Profile("dev")
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // 格式化sql语句
        Properties properties = new Properties();
        properties.setProperty("format", "true");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }
    
    /**
     * sql 注入器
     * @author TianXin
     * @created 2019年2月25日 下午4:25:12
     * @return
     */
//    @Bean
//    public ISqlInjector sqlInjector() {
//        return new LogicSqlInjector();
//    }
    
    /**
     * 乐观锁
     * @author TianXin
     * @created 2019年2月25日 下午4:25:12
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }
    
    
}