package eventhub.model;

interface CategoryModelInterface {
    public int getCategoryId();
    public void setCategoryId(int categoryId);
    public String getCategoryName();
    public void setCategoryName(String categoryName);
}

public class CategoryModel  implements  CategoryModelInterface{
    private int categoryId;
    private String categoryName;

    public CategoryModel(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public int getCategoryId() {
        return categoryId;
    }
    @Override
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override

    public String getCategoryName() {
        return categoryName;
    }
    @Override
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
