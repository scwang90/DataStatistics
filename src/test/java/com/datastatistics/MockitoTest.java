package com.datastatistics;

import com.datastatistics.dao.DsDeployDao;
import com.datastatistics.dao.impl.DsDeployDaoImpl;
import com.datastatistics.service.DsDeployService;
import com.datastatistics.service.impl.DsDeployServiceImpl;
import com.datastatistics.util.AfReflecter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by Administrator on 2015/8/25.
 */
//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-*.xml")
public class MockitoTest {

        @Mock
//    @Spy
//    @Autowired
    private DsDeployDao dao;

    @InjectMocks
    private DsDeployServiceImpl service = new DsDeployServiceImpl();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
//        dao = mock(DsDeployDao.class);
        when(dao.countAll()).thenReturn(1000000);
//        when(dao.countAll()).thenThrow(new Exception("1111111111111"));
    }

    @Test
    public void helloMockito() throws Exception {
//        DsDeployService service = new DsDeployServiceImpl();
//        AfReflecter.setMemberNoException(service, "dao", dao);
        System.out.println(service.countAll());
    }

    @Test
    public void mockList() {
//        // 模拟创建
//        List mockedList = mock(List.class);
//        // 使用模拟对象
//        mockedList.add("one0");
//        mockedList.clear();
//        // 验证选择性和显式调用
//        verify(mockedList).add(anyString());
//        verify(mockedList).clear();

//        doNothing().doThrow(new RuntimeException("void exception")).when(mockedList).clear();

//        mockedList.clear();
//        mockedList.clear();
//        verify(mockedList,times(3)).clear();

//        List<String> list = mock(List.class);
//        when(list.get(anyInt())).thenReturn("hello","world");
//        String result = list.get(0)+list.get(1);
//        System.out.println(result);
//        assertEquals("helloworld", result);

        Map<Integer,String> map = mock(Map.class);
        when(map.put(anyInt(),anyString())).thenReturn("hello");//anyString()替换成"hello"就会报错
        map.put(1, "world");
        verify(map).put(eq(1), "world"); //eq("world")替换成"world"也会报错
//        verify(map).put(eq(1), eq("world")); //eq("world")替换成"world"也会报错
    }
}
