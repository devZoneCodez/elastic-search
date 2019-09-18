package com.example.es;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(value = {
        ProductCrudTest.class
        , UserCrudTest.class
})
public class ElasticSearchApplicationTests {

}
