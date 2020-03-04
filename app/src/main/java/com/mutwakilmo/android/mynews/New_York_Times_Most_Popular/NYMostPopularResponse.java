
package com.mutwakilmo.android.mynews.New_York_Times_Most_Popular;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


/**
 * Created by Mutwakil Mo🐮🐮🐮 on 20/02/2020
 */
public class NYMostPopularResponse {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private List<NYMostPopularResult> results ;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<NYMostPopularResult> getResults() {
        return results;
    }

    public void setResults(List<NYMostPopularResult> results) {
        this.results = results;
    }
    @Override
    public String toString(){
        return
                "MostPopularResponse{" +
                        "copyright = '" + copyright + '\'' +
                        ",results = '" + results + '\'' +
                        ",num_results = '" + numResults + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
