package eventhub.model;

interface ReviewModelInterface {
    public String getReviewId();
    public void setReviewId(String reviewId);
    public String getUserId();
    public void setUserId(String userId);
    public String getReviewName();
    public void setReviewName(String reviewName);
    public String getReviewData();
    public void setReviewData(String reviewData);
}

public class ReviewModel implements ReviewModelInterface {
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
    @Override
    public String getReviewId() {
        return reviewId;
    }
    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String getUserId() {
        return userId;
    }
    @Override
    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }
    @Override
    public String getReviewName() {
        return reviewName;
    }
    @Override
    public void setReviewData(String reviewData) {
        this.reviewData = reviewData;
    }
    @Override
    public String getReviewData() {
        return reviewData;
    }
    @Override
    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

}

