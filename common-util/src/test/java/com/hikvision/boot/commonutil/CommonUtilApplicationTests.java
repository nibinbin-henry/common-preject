package com.hikvision.boot.commonutil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonUtilApplicationTests {

	@Test
	public void contextLoads() {
		List<String> values = new ArrayList<>();
		values.add("filed1");
		values.add("filed2");

		String value = "{\"filed1\":\"dfdf\",[{\"gfg\":null,\"filed1\":null" +
				",\"filed12\":34}],\"tessd\":34,\"filed2\":4545}";
		String regex = "(?<=filed1|filed2)\\\":\\\"?.+?\\\"?(?=[,|\\}])";
		System.out.println(value.replaceAll(regex, "\\\":\\\"\\\""));
	}

}
