package xyz.bbear.infra.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * TestConfig.
 *
 * @author xiongliu wu 2018/12/14 12:20
 */
@Configuration
@ComponentScan("xyz.bbear.infra")
// @ImportResource(locations = "classpath*:spring.xml")
public class TestConfig {

  /**
   * config bean.
   *
   * @return MapperScannerConfigurer
   */
  @Bean
  public MapperScannerConfigurer mapperScannerConfigurer() {
    MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
    mapperScannerConfigurer.setBasePackage("xyz.bbear.infra.mapper");
    return mapperScannerConfigurer;
  }

  /**
   * config bean.
   *
   * @return DataSource
   */
  @Bean
  public DataSource dataSource() {
    HikariDataSource dataSource = new HikariDataSource();
    dataSource.setDriverClassName("org.h2.Driver");
    dataSource.setJdbcUrl(
        "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'classpath:db/schema-h2.sql'\\;"
            + "RUNSCRIPT FROM 'classpath:db/data-h2.sql'");
    dataSource.setUsername("root");
    dataSource.setPassword("test");
    return dataSource;
  }

  /**
   * config bean.
   *
   * @return MybatisSqlSessionFactoryBean
   */
  @Bean
  public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
    MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
    mybatisSqlSessionFactoryBean.setDataSource(dataSource());
    return mybatisSqlSessionFactoryBean;
  }
}
