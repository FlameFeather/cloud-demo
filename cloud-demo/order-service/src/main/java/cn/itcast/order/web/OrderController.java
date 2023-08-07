package cn.itcast.order.web;

import cn.itcast.order.pojo.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
@RefreshScope
public class OrderController {

	@Autowired
	private OrderService orderService;

    @Value("${environment_name}")
    private String currentEnvironment;

	@Autowired
	private Environment environment;

	@GetMapping("getCurrent")
	public String getCurrent() {
		return environment.getProperty("environment_name");
	}

	@GetMapping("{orderId}")
	public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
		// 根据id查询订单并返回
		return orderService.queryOrderById(orderId);
	}
}
