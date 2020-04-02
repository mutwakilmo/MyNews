package com.mutwakilmo.android.mynewsapp.Models.SearchNewYork;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class ArticleSearchResponse {
    @SerializedName("copyright")
    private String copyright;

    @SerializedName("response")
    private Response response;

    @SerializedName("status")
    private String status;


    public void setCopyright(String copyright){
        this.copyright = copyright;
    }

    public String getCopyright(){
        return copyright;
    }

    public void setResponse(Response response){
        this.response = response;
    }

    public Response getResponse(){
        return response;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    @Override
    public String toString(){
        return
                "ArticleSearchResponse{" +
                        "copyright = '" + copyright + '\'' +
                        ",response = '" + response + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}
