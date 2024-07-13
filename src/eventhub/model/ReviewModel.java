package eventhub.model;

public class ReviewModel {
	private String reviewId;
	private String userId;
    private String reviewName;
    private String reviewData;

    public ReviewModel(String reviewId, String userId, String reviewName, String reviewData) {
    	this.reviewId = reviewId;
        this.userId = userId;
        this.reviewName = reviewName;
        this.reviewData = reviewData;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewData(String reviewData) {
        this.reviewData = reviewData;
    }

    public String getReviewData() {
        return reviewData;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

}

