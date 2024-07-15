package eventhub.model;

interface ReviewModelInterface {
    public int getReviewId();
    public void setReviewId(int reviewId);
    public int getUserId();
    public void setUserId(int userId);
    public String getReviewData();
    public void setReviewData(String reviewData);
}

public class ReviewModel implements ReviewModelInterface {
	private int reviewId;
	private int userId;
    private String reviewData;

    public ReviewModel(int reviewId, int userId, String reviewData) {
    	this.reviewId = reviewId;
        this.userId = userId;
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

