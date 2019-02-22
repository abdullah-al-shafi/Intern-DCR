
package com.shafi.sbf.interndcr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GiftList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("gift")
    @Expose
    private String gift;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

}
