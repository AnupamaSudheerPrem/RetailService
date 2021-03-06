
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
    "title",
    "downstream_description",
    "bullet_description",
    "soft_bullets"
})
public class ProductDescription {

    @JsonProperty("title")
    private String title;
    @JsonProperty("downstream_description")
    private String downstreamDescription;
    @JsonProperty("bullet_description")
    private List<String> bulletDescription = null;
    @JsonProperty("soft_bullets")
    private SoftBullets softBullets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("downstream_description")
    public String getDownstreamDescription() {
        return downstreamDescription;
    }

    @JsonProperty("downstream_description")
    public void setDownstreamDescription(String downstreamDescription) {
        this.downstreamDescription = downstreamDescription;
    }

    @JsonProperty("bullet_description")
    public List<String> getBulletDescription() {
        return bulletDescription;
    }

    @JsonProperty("bullet_description")
    public void setBulletDescription(List<String> bulletDescription) {
        this.bulletDescription = bulletDescription;
    }

    @JsonProperty("soft_bullets")
    public SoftBullets getSoftBullets() {
        return softBullets;
    }

    @JsonProperty("soft_bullets")
    public void setSoftBullets(SoftBullets softBullets) {
        this.softBullets = softBullets;
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
