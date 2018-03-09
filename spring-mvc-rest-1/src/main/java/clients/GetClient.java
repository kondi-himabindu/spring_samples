package clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class GetClient {

	public static void main(String[] args){
	RestTemplate template = new RestTemplate();
	UriComponentsBuilder uribuilder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/spring-mvc-rest-1/").path("emp");
	ResponseEntity<String> resp = template.getForEntity(uribuilder.toUriString(),String.class);
	System.out.println(resp.getBody());

   HttpHeaders headers = new HttpHeaders();
   headers.add("Accept","application/xml");
   
   HttpEntity et = new HttpEntity<>(headers);
    ResponseEntity<String> resp1 =	template.exchange("http://localhost:8080/spring-mvc-rest-1/emp",HttpMethod.GET,et,String.class);
	System.out.println(resp1.getBody());
	//Employee e = new 
	
	}
}