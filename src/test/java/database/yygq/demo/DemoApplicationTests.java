package database.yygq.demo;

import cn.hutool.core.collection.CollUtil;
import com.yygq.demo.DemoApplication;
import com.yygq.demo.controller.UserController;
import com.yygq.demo.entity.User;
import com.yygq.demo.service.UserService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import javax.swing.*;

import java.util.Collections;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
@ContextConfiguration(classes = DemoApplication.class)
//@SpringBootTest(classes = DemoApplication.class)
class DemoApplicationTests {


	@Autowired
	private MockMvc mvc;

	@MockBean
	private UserService userService;

	@Test
	public void getUsersTest() throws Exception {
		System.out.println("test");
		List<User> userList = null;

		Mockito.when(userService.getAllUsers()).thenReturn(userList);

		mvc.perform(MockMvcRequestBuilders.get("/demo/user")).andDo(MockMvcResultHandlers.print());
	}
}
