package org.fightteam.next.test;

import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 抽象初始化测试类
 *
 * 提供了一些初始化spring的方法，方便单元测试
 *
 * @author faith
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, org.fightteam.next.test.DataSourceConfig.class})
@TransactionConfiguration(defaultRollback = true)
public abstract class AbstractIntegrationTest {

    static {
        //创建测试用的DataSource
        // 使用内嵌数据库
        EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
        DataSource dataSource = databaseBuilder.setType(EmbeddedDatabaseType.HSQL).build();
        try {
            SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
            builder.bind("java:/comp/env/jdbc/database", dataSource);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }



}
