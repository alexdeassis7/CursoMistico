package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ReviewDao;
import model.Review;

@Service
public class ServiceReviewImpl implements ServiceReview {

	@Autowired
	ReviewDao dao;

	// TAREA IMPLEMENTAR LOS METODOS GET*.....
	@Override
	public List<Review> getAllReviews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> getReviewsByUser(String User) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addReview(Review review) {
		if (dao.getReview(review.getIdReview()) == null) {
			dao.addReview(review);
			return true;
		}
		return false;
	}

}
