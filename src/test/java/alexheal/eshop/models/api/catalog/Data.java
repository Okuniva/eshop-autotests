package alexheal.eshop.models.api.catalog;

@lombok.Data
public class Data {
    public Integer id;
    public String name;
    public String description;
    public Double price;
    public String pictureFileName;
    public String pictureUri;
    public Integer catalogTypeId;
    public String catalogType;
    public Integer catalogBrandId;
    public String catalogBrand;
    public Integer availableStock;
    public Integer restockThreshold;
    public Integer maxStockThreshold;
    public Boolean onReorder;
}
