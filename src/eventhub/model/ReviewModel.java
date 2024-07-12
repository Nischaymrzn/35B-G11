package eventhub.model;

public class ReviewModel {
	public final String reviewId;
	public final String userId;
    public final String reviewName;
    public final String reviewData;

    public ReviewModel(String reviewId, String userId, String reviewName, String reviewData) {
    	this.reviewId = reviewId;
        this.userId = userId;
        this.reviewName = reviewName;
        this.reviewData = reviewData;
    }
}

