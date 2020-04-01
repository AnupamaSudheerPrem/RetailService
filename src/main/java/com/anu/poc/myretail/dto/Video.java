
package com.anu.poc.myretail.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "video_sequence",
    "video_title",
    "video_poster_image",
    "video_length_seconds",
    "video_files",
    "video_captions"
})
public class Video {

    @JsonProperty("video_sequence")
    private Integer videoSequence;
    @JsonProperty("video_title")
    private String videoTitle;
    @JsonProperty("video_poster_image")
    private String videoPosterImage;
    @JsonProperty("video_length_seconds")
    private Integer videoLengthSeconds;
    @JsonProperty("video_files")
    private List<VideoFile> videoFiles = null;
    @JsonProperty("video_captions")
    private List<VideoCaption> videoCaptions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("video_sequence")
    public Integer getVideoSequence() {
        return videoSequence;
    }

    @JsonProperty("video_sequence")
    public void setVideoSequence(Integer videoSequence) {
        this.videoSequence = videoSequence;
    }

    @JsonProperty("video_title")
    public String getVideoTitle() {
        return videoTitle;
    }

    @JsonProperty("video_title")
    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    @JsonProperty("video_poster_image")
    public String getVideoPosterImage() {
        return videoPosterImage;
    }

    @JsonProperty("video_poster_image")
    public void setVideoPosterImage(String videoPosterImage) {
        this.videoPosterImage = videoPosterImage;
    }

    @JsonProperty("video_length_seconds")
    public Integer getVideoLengthSeconds() {
        return videoLengthSeconds;
    }

    @JsonProperty("video_length_seconds")
    public void setVideoLengthSeconds(Integer videoLengthSeconds) {
        this.videoLengthSeconds = videoLengthSeconds;
    }

    @JsonProperty("video_files")
    public List<VideoFile> getVideoFiles() {
        return videoFiles;
    }

    @JsonProperty("video_files")
    public void setVideoFiles(List<VideoFile> videoFiles) {
        this.videoFiles = videoFiles;
    }

    @JsonProperty("video_captions")
    public List<VideoCaption> getVideoCaptions() {
        return videoCaptions;
    }

    @JsonProperty("video_captions")
    public void setVideoCaptions(List<VideoCaption> videoCaptions) {
        this.videoCaptions = videoCaptions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
