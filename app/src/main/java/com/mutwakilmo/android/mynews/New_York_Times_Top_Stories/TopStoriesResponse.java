package com.mutwakilmo.android.mynews.New_York_Times_Top_Stories;

import com.google.gson.annotations.SerializedName;

import java.util.List;
/**
 * Created by Mutwakil Mo🐮🐮🐮 on 20/02/2020
 */
public class TopStoriesResponse{

	@SerializedName("copyright")
	private String copyright;

	@SerializedName("last_updated")
	private String lastUpdated;

	@SerializedName("section")
	private String section;

	@SerializedName("results")
	private List<com.mutwakilmo.android.mynews.New_York_Times_Top_Stories.TopStoriesResultsItem> results;

	@SerializedName("num_results")
	private int numResults;

	@SerializedName("status")
	private String status;

	public void setCopyright(String copyright){
		this.copyright = copyright;
	}

	public String getCopyright(){
		return copyright;
	}

	public void setLastUpdated(String lastUpdated){
		this.lastUpdated = lastUpdated;
	}

	public String getLastUpdated(){
		return lastUpdated;
	}

	public void setSection(String section){
		this.section = section;
	}

	public String getSection(){
		return section;
	}

	public void setResults(List<com.mutwakilmo.android.mynews.New_York_Times_Top_Stories.TopStoriesResultsItem> results){
		this.results = results;
	}

	public List<com.mutwakilmo.android.mynews.New_York_Times_Top_Stories.TopStoriesResultsItem> getResults(){
		return results;
	}

	public void setNumResults(int numResults){
		this.numResults = numResults;
	}

	public int getNumResults(){
		return numResults;
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
			"TopStoriesResponse{" + 
			"copyright = '" + copyright + '\'' + 
			",last_updated = '" + lastUpdated + '\'' + 
			",section = '" + section + '\'' + 
			",results = '" + results + '\'' + 
			",num_results = '" + numResults + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}