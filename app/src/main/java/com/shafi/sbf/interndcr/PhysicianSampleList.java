
package com.shafi.sbf.interndcr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhysicianSampleList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("sample")
    @Expose
    private String sample;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

}
