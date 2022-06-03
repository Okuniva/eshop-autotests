
package alexheal.eshop.models.api.catalog;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@lombok.Data
public class Items {
    public Integer pageIndex;
    public Integer count;
    public List<Data> data;
    public Integer pageSize;
}
