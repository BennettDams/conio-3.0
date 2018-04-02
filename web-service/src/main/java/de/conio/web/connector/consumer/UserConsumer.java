package de.conio.web.connector.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import de.conio.core.structure.User;

@RefreshScope
@Service
public class UserConsumer {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	//@Value("${service.user-service}")
	private String userServiceId = "user-service";

	public User findOneByUsername(String name) {
		Application application = eurekaClient.getApplication(userServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "user/name/" + name;
		System.out.println("URL: " + url);
		User object = restTemplate.getForObject(url, User.class);
		System.out.println("RESPONSE " + object);
		return object;
	}
}