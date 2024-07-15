package eventhub.model;

interface ReviewModelInterface {
    public int getReviewId();
    public void setReviewId(int reviewId);
    public int getUserId();
    public void setUserId(int userId);
    public String getReviewName();
    public void setReviewName(String reviewName);
    public String getReviewData();
    public void setReviewData(String reviewData);
}

public class ReviewModel implements ReviewModelInterface {
	private int reviewId;
	private int userId;
    private String reviewName;
    private String reviewData;

    public ReviewModel(int reviewId, int userId, String reviewName, String reviewData) {
    	this.reviewId = reviewId;
        this.userId = userId;
        this.reviewName = reviewName;
        this.reviewData = reviewData;
    }
    @Override
    public int getReviewId() {
        return reviewId;
    }
    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }
    @Override
    public int getUserId() {
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
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

}

