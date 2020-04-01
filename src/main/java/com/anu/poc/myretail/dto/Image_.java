
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
    "base_url",
    "primary",
    "alternate_urls",
    "content_labels"
})
public class Image_ {

    @JsonProperty("base_url")
    private String baseUrl;
    @JsonProperty("primary")
    private String primary;
    @JsonProperty("alternate_urls")
    private List<String> alternateUrls = null;
    @JsonProperty("content_labels")
    private List<ContentLabel> contentLabels = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("base_url")
    public String getBaseUrl() {
        return baseUrl;
    }

    @JsonProperty("base_url")
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @JsonProperty("primary")
    public String getPrimary() {
        return primary;
    }

    @JsonProperty("primary")
    public void setPrimary(String primary) {
        this.primary = primary;
    }

    @JsonProperty("alternate_urls")
    public List<String> getAlternateUrls() {
        return alternateUrls;
    }

    @JsonProperty("alternate_urls")
    public void setAlternateUrls(List<String> alternateUrls) {
        this.alternateUrls = alternateUrls;
    }

    @JsonProperty("content_labels")
    public List<ContentLabel> getContentLabels() {
        return contentLabels;
    }

    @JsonProperty("content_labels")
    public void setContentLabels(List<ContentLabel> contentLabels) {
        this.contentLabels = contentLabels;
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
