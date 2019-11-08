package com.example.es;

import com.example.es.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import static org.junit.Assert.assertEquals;

@Slf4j
public class ProductCrudTest extends ElasticSearchApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ProductService productService;

    @Test
    public void testSimple() {

        assertEquals("simple","simple");
    }

    /*Life cycle methods goes here*/
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

}
