package com.revature;

import org.springframework.web.client.RestTemplate;

import com.revature.models.Pokemon;

public class Driver {

	public static void main(String[] args) {
		
		String url = "https://pokeapi.co/api/v2/pokemon/";
		
		RestTemplate rt = new RestTemplate();
		
		Pokemon p = rt.getForObject(url+"34", Pokemon.class);
		
		System.out.println(p);
	}

}
