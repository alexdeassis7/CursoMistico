package service;

import java.util.List;

import model.Review;

public interface ServiceReview {

	public List<Review> getAllReviews();

	public List<Review> getReviewsByName(String name);

	public List<Review> getReviewsByUser(String User);

	public boolean addReview(Review review);

}
