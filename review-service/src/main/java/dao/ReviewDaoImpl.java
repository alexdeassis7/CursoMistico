package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Review;

@Repository
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	ReviewJpaSpring review;
	
	//TAREA para la casa
	//implementar los metodos get...... utilizando el review que inyectamos en la linea 14 
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
	public List<Review> getReviewsByUSer(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Review getReview(Integer id) {
		// TODO Auto-generated method stub
	
		return null;
	}

	@Override
	public void addReview(Review reviewToSave) {
		System.out.println("Se agrego el reviews");
		review.save(reviewToSave);
	}

}
