package de.conio.web.connector.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import de.conio.core.structure.Role;

@RefreshScope
@Service
public class RoleConsumer {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private EurekaClient eurekaClient;

	private String userServiceId = "user-service";

	public Role read(Long id) {
		Application application = eurekaClient.getApplication(userServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "role/" + id;
		System.out.println("URL" + url);
		Role object = restTemplate.getForObject(url, Role.class);
		System.out.println("RESPONSE " + object);
		return object;
	}
	
	public List<String> findAllWithNameOnly(){
		Application application = eurekaClient.getApplication(userServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "role/nameOnly";
		System.out.println("URL" + url);
		List<String> list = convert2List(restTemplate.getForObject(url, Iterable.class));
		System.out.println("RESPONSE " + list);
		return list;
	}
	
	public Role findOneByName(String name) {
		Application application = eurekaClient.getApplication(userServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/" + "role/" + name;
		System.out.println("URL" + url);
		Role object = restTemplate.getForObject(url, Role.class);
		System.out.println("RESPONSE " + object);
		return object;
	}
	
	private <E> List<E> convert2List(Iterable<E> iter) {
	    List<E> list = new ArrayList<E>();
	    for (E item : iter) {
	        list.add(item);
	    }
	    return list;
	}

}
