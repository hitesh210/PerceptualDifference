import javax.annotation.Generated;

import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Products {
    @Expose
    private String mnsProductSubType;
    @Expose
    private String id;

    public String getMnsProductSubType() {
        return mnsProductSubType;
    }

    public void setMnsProductSubType(
            String mnsProductSubType) {
        this.mnsProductSubType = mnsProductSubType;
    }

    public String getId() {
        return id;
    }

    public void setId(
            String id) {
        this.id = id;
    }

}
