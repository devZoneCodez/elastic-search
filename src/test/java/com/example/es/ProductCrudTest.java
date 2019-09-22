package com.example.es;

import com.example.es.model.Product;
import com.example.es.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticSearchApplication.class})
@Slf4j
public class ProductCrudTest {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ProductService productService;

    @Test
    public void contextLoads() {
        /*elasticsearchTemplate.deleteIndex(Product.class);
        elasticsearchTemplate.createIndex(Product.class);
        elasticsearchTemplate.putMapping(Product.class);
        elasticsearchTemplate.refresh(Product.class);*/
    }

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
