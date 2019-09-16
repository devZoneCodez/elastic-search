package com.example.es;

import com.example.es.model.User;
import com.example.es.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ElasticSearchApplication.class})
public class ElasticSearchApplicationTests {

	@Autowired
	private UserService userService;

//	@Autowired
//	private ElasticsearchTemplate elasticsearchTemplate;

//	@Before
//	public void before() {
//		elasticsearchTemplate.deleteIndex(User.class);
//		elasticsearchTemplate.createIndex(User.class);
//		elasticsearchTemplate.putMapping(User.class);
//		elasticsearchTemplate.refresh(User.class);
//	}

	@Test
	public void contextLoads() {
	}

}
