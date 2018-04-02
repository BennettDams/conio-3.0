package de.conio.web.connector.consumer.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import de.conio.core.structure.PostCategory;

@RefreshScope
@Service
public class PostCategoryConsumer {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	// @Value("${service.post-service.serviceId}")
	private String postServiceId = "post-service";

	public PostCategory read(Long id) {
		Application application = eurekaClient.getApplication(postServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "category/" + id;
		System.out.println("URL" + url);
		PostCategory object = restTemplate.getForObject(url, PostCategory.class);
		System.out.println("RESPONSE " + object);
		return object;
	}

	public Iterable<PostCategory> readAll() {
		Application application = eurekaClient.getApplication(postServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "category/all";
		System.out.println("URL" + url);
		Iterable<PostCategory> list = restTemplate.getForObject(url, Iterable.class);
		System.out.println("RESPONSE " + list);
		return list;
	}
}
