
package com.mutwakilmo.android.mynews.New_York_Times_Most_Popular;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mutwakil Mo🐮🐮🐮 on 20/02/2020
 */
public class Medium {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("approved_for_syndication")
    @Expose
    private Integer approvedForSyndication;
    @SerializedName("media-metadata")
    @Expose
    private List<com.mutwakilmo.android.mynews.New_York_Times_Most_Popular.MediaMetadatum> mediaMetadata = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Integer getApprovedForSyndication() {
        return approvedForSyndication;
    }

    public void setApprovedForSyndication(Integer approvedForSyndication) {
        this.approvedForSyndication = approvedForSyndication;
    }

    public List<com.mutwakilmo.android.mynews.New_York_Times_Most_Popular.MediaMetadatum> getMediaMetadata() {
        return mediaMetadata;
    }

    public void setMediaMetadata(List<com.mutwakilmo.android.mynews.New_York_Times_Most_Popular.MediaMetadatum> mediaMetadata) {
        this.mediaMetadata = mediaMetadata;
    }

    @Override
    public String toString(){
        return
                "MediaItem{" +
                        "copyright = '" + copyright + '\'' +
                        ",media-metadata = '" + mediaMetadata + '\'' +
                        ",subtype = '" + subtype + '\'' +
                        ",caption = '" + caption + '\'' +
                        ",type = '" + type + '\'' +
                        ",approved_for_syndication = '" + approvedForSyndication + '\'' +
                        "}";
    }


}
