
package com.shafi.sbf.interndcr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProductGroupList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("product_group")
    @Expose
    private String productGroup;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductGroup() {
        return productGroup;
    }

    public void setProductGroup(String productGroup) {
        this.productGroup = productGroup;
    }

}
