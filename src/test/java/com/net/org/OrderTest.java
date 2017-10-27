package com.net.org;

import com.net.org.model.OrderInfo;
import com.net.org.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {
    @Mock
    private OrderService orderService;

    @Test
    public void orderTests() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(orderService.getOrderInfo(anyInt()))
                .thenReturn(
                        new OrderInfo(1, "아이폰8", 100, "김순철", "010-0000-0000", "서울시 을지로")
                );

        OrderInfo orderInfo = orderService.getOrderInfo(1);

        assertEquals("아이폰8", orderInfo.getGoodsName());
        assertEquals(new Integer(100), orderInfo.getPrice());
    }
}
