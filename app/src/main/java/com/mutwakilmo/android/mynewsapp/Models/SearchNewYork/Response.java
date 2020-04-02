package com.mutwakilmo.android.mynewsapp.Models.SearchNewYork;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mutwakil Mo on🐮🐮🐮
 */
public class Response {
    @SerializedName("docs")
    private List<DocsItem> docs;

    @SerializedName("meta")
    private Meta meta;

    public void setDocs(List<DocsItem> docs){
        this.docs = docs;
    }

    public List<DocsItem> getDocs(){
        return docs;
    }

    public void setMeta(Meta meta){
        this.meta = meta;
    }

    public Meta getMeta(){
        return meta;
    }

    @Override
    public String toString(){
        return
                "Response{" +
                        "docs = '" + docs + '\'' +
                        ",meta = '" + meta + '\'' +
                        "}";
    }
}
