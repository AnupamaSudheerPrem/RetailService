
package com.anu.poc.myretail.dto;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "video_url",
    "mime_type",
    "video_height_pixels"
})
public class VideoFile {

    @JsonProperty("video_url")
    private String videoUrl;
    @JsonProperty("mime_type")
    private String mimeType;
    @JsonProperty("video_height_pixels")
    private Integer videoHeightPixels;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("video_url")
    public String getVideoUrl() {
        return videoUrl;
    }

    @JsonProperty("video_url")
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @JsonProperty("mime_type")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("mime_type")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @JsonProperty("video_height_pixels")
    public Integer getVideoHeightPixels() {
        return videoHeightPixels;
    }

    @JsonProperty("video_height_pixels")
    public void setVideoHeightPixels(Integer videoHeightPixels) {
        this.videoHeightPixels = videoHeightPixels;
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
