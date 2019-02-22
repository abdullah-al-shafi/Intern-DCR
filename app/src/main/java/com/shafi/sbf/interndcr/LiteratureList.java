
package com.shafi.sbf.interndcr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LiteratureList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("literature")
    @Expose
    private String literature;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

}
