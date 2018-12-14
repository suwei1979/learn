package com.bocsoft.metis.commons.mapper;

import com.bocsoft.metis.commons.utils.TargetObject;
import com.bocsoft.metis.commons.utils.TestObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.suw.learn.metis.commons.mapper.BeanMapper;

import static org.assertj.core.api.Assertions.*;


/**
 * Created by zion on 11/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean-mapper.xml")
public class BeanMapperIT {

  private TestObject object = new TestObject();

  @Before
  public void init() {
    object.setName("name");
    object.setProperty("property");
    object.setValue("value");
  }

  @Test
  public void mapWithoutSpringContext() {
    TargetObject t = BeanMapper.map(object, TargetObject.class);
    assertThat(t.getName()).isEqualTo("name");
  }
}
