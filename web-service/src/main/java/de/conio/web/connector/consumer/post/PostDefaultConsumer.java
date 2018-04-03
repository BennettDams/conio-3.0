package de.conio.web.connector.consumer.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.discovery.EurekaClient;

import de.conio.core.structure.Post;

@RefreshScope
@Service
public class PostDefaultConsumer {

	// @Autowired
	// private RestTemplate restTemplate;
	//
	// @Autowired
	// private EurekaClient eurekaClient;
	//
	// // @Value("${service.post-service.serviceId}")
	// private String postServiceId = "post-service";

	public @ResponseBody Iterable<Post> readAll() {
		// Application application = eurekaClient.getApplication(postServiceId);
		// InstanceInfo instanceInfo = application.getInstances().get(0);
		// String url = "http://" + instanceInfo.getIPAddr() + ":" +
		// instanceInfo.getPort() + "/" + "posts";
		// System.out.println("URL" + url);
		// Iterable<Post> list = restTemplate.getForObject(url, Iterable.class);
		// System.out.println("RESPONSE " + list);
		// return list;

		List<Post> list = new ArrayList<Post>();
		System.out.println("RESPONSE " + list);
		return list;

	}

}
