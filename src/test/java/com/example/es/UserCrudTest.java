package com.example.es;

import com.example.es.model.User;
import com.example.es.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class UserCrudTest extends ElasticSearchApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private UserService userService;

    @Test
    public void testSimpleTest() {

        assertEquals("simple","simple");
    }

    @Ignore
    @Test
    public void testSave() {
        List<User> users = Arrays.asList(new User(1001L, "Sateesh Kumar", "D", 1234567890L)
                , new User(1002L, "Romit Kumar", "D", 1234567890L)
                , new User(1003L, "Rithika", "D", 1234567890L));

        users.forEach(user -> userService.save(user));

        log.info("Users = " + users);

        User source = users.get(0);
        User target = userService.findById(1001L);

        assertNotNull(target.getId());
        assertEquals(source.getFirstName(), target.getFirstName());
        assertEquals(source.getLastName(), target.getLastName());
        assertEquals(source.getPhone(), target.getPhone());
    }

    @Ignore
    @Test
    public void testFindById() {
        User target = userService.findById(1001L);
        log.info("Fetched User = " + target);
        assertNotNull(target.getId());
        assertEquals("Sateesh Kumar", target.getFirstName());
        assertEquals("D", target.getLastName());
        assertEquals(Long.valueOf(1234567890L), target.getPhone());
    }


    /* Life cycle methods goes here */
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
