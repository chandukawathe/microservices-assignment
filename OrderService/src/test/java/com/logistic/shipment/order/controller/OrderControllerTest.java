package com.logistic.shipment.order.controller;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.logistic.shipment.order.model.Order;
import com.logistic.shipment.order.repository.OrderRepository;
import com.logistic.shipment.order.service.OrderService;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Mock
	OrderRepository orderRepository;

	@InjectMocks
	OrderController controller;

	MockMvc mockMvc;

	@Mock
	EntityManager entityManager;

	@Mock
	OrderService orderedService;

	public OrderControllerTest() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void testOrderService() throws Exception {

		Order order = Mockito.mock(Order.class);
		String jsonasstring = "{\r\n" + "  \"source_address\": \"Bankok\",\r\n" + "  \"dest_address\": \"Newyork\",\r\n"
				+ "  \"order_date\": \"2019-02-11\",\r\n" + "  \"shipment_date\": \"2019-04-11\",\r\n"
				+ "	\"product\": [\r\n" + "    {\r\n" + "      \"product_id\":\"5\",\r\n"
				+ "      \"product_name\": \"Detergent\",\r\n" + "      \"product_price\": \"333.0\"\r\n" + "    },\r\n"
				+ "    {\r\n" + "      \"product_id\":\"6\",\r\n" + "      \"product_name\": \"Detergent\",\r\n"
				+ "      \"product_price\": \"333.0\"\r\n" + "    }\r\n" + "  ]\r\n" + "}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/1/placeOrder").accept(MediaType.APPLICATION_JSON)
				.content(jsonasstring).contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		Mockito.when(orderedService.save(order, 1)).thenReturn(1L);

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.SC_OK, response.getStatus());

	}

}
