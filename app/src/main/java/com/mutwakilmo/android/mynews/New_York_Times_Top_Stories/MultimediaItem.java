package com.mutwakilmo.android.mynews.New_York_Times_Top_Stories;

import com.google.gson.annotations.SerializedName;
/**
 * Created by Mutwakil Mo🐮🐮🐮 on 20/02/2020
 */
public class MultimediaItem{

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("subtype")
	private String subtype;

	@SerializedName("format")
	private String format;

	@SerializedName("width")
	private int width;

	@SerializedName("caption")
	private String caption;

	@SerializedName("type")
	private String type;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setSubtype(String subtype){
		this.subtype = subtype;
	}

	public String getSubtype(){
		return subtype;
	}

	public void setFormat(String format){
		this.format = format;
	}

	public String getFormat(){
		return format;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}

	public String getCaption(){
		return caption;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"MultimediaItem{" + 
			"copyright = '" + copyright + '\'' + 
			",subtype = '" + subtype + '\'' + 
			",format = '" + format + '\'' + 
			",width = '" + width + '\'' + 
			",caption = '" + caption + '\'' + 
			",type = '" + type + '\'' + 
			",url = '" + url + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}