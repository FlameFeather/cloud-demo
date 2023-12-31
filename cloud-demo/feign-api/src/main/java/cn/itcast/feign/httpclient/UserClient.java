package cn.itcast.feign.httpclient;

import cn.itcast.feign.config.FeignConfig;

import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "UserServer", configuration = FeignConfig.class)
public interface UserClient {
	@GetMapping("/user/{id}")
	User findById(@PathVariable("id") Long id);
}