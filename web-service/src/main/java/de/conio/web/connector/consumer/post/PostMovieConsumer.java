package de.conio.web.connector.consumer.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import de.conio.core.structure.Movie;

/**
 * 
 * @author Jonas
 * 
 *         TODO: http://www.baeldung.com/spring-new-requestmapping-shortcuts
 */
@RefreshScope
@Service
public class PostMovieConsumer {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	// @Value("${service.post-service.serviceId}")
	private String postServiceId = "post-service";

	public Movie read(Long id) {
		Application application = eurekaClient.getApplication(postServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "movie/" + id;
		System.out.println("URL" + url);
		Movie object = restTemplate.getForObject(url, Movie.class);
		System.out.println("RESPONSE " + object);
		return object;
	}

	public Iterable<Movie> readAll() {
		Application application = eurekaClient.getApplication(postServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "movie/all";
		System.out.println("URL" + url);
		Iterable<Movie> list = restTemplate.getForObject(url, Iterable.class);
		System.out.println("RESPONSE " + list);
		return list;
	}
}