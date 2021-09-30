package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Review;
import service.ServiceReview;

@RestController
@CrossOrigin(origins = "*")
public class ReviewController {

	@Autowired
	ServiceReview service;

	
	@PostMapping(value = "review/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
	public String addReview(@RequestBody Review review) {
		return String.valueOf(service.addReview(review));
	}

}
