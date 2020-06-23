package com.cumpleanios.be.rest.call;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.cumpleanios.be.model.Poema;


@Service
@Slf4j
public class PoemaRestCall {

	@Value("${poema.url}")
	private String urlPoema;

	public List<Poema> getPoemas() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Poema>> result = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		String url = urlPoema;
		try {
			result = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Poema>>() {
			});
		} catch (ResourceAccessException e) {
			 log.info("[Error][getPoemas] ResourceAccessException..." + e);
		}
		return result.getBody();
	}

}
