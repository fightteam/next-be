package org.fightteam.next.test;

import org.fightteam.next.config.ApplicationConfig;
import org.fightteam.next.config.DataSourceConfig;
import org.fightteam.next.config.WebSpringConfig;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 抽象初始化测试类
 * <p/>
 * 提供了测试rest的公共方法，方便reset api的单元测试
 *
 * @author faith
 * @since 0.0.1
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, DataSourceConfig.class, WebSpringConfig.class})
@TransactionConfiguration(defaultRollback = true)
@WebAppConfiguration
public abstract class AbstractWebIntegrationTest {
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

}
