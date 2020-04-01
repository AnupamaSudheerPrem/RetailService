
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
    "tcin",
    "product_description_title",
    "enrichment"
})
public class ParentItem {

    @JsonProperty("tcin")
    private String tcin;
    @JsonProperty("product_description_title")
    private String productDescriptionTitle;
    @JsonProperty("enrichment")
    private Enrichment enrichment;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tcin")
    public String getTcin() {
        return tcin;
    }

    @JsonProperty("tcin")
    public void setTcin(String tcin) {
        this.tcin = tcin;
    }

    @JsonProperty("product_description_title")
    public String getProductDescriptionTitle() {
        return productDescriptionTitle;
    }

    @JsonProperty("product_description_title")
    public void setProductDescriptionTitle(String productDescriptionTitle) {
        this.productDescriptionTitle = productDescriptionTitle;
    }

    @JsonProperty("enrichment")
    public Enrichment getEnrichment() {
        return enrichment;
    }

    @JsonProperty("enrichment")
    public void setEnrichment(Enrichment enrichment) {
        this.enrichment = enrichment;
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
