
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
    "hold",
    "ship_to_guest",
    "ship_to_store",
    "scheduled_delivery"
})
public class EligibilityRules {

    @JsonProperty("hold")
    private Hold hold;
    @JsonProperty("ship_to_guest")
    private ShipToGuest shipToGuest;
    @JsonProperty("ship_to_store")
    private ShipToStore shipToStore;
    @JsonProperty("scheduled_delivery")
    private ScheduledDelivery scheduledDelivery;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("hold")
    public Hold getHold() {
        return hold;
    }

    @JsonProperty("hold")
    public void setHold(Hold hold) {
        this.hold = hold;
    }

    @JsonProperty("ship_to_guest")
    public ShipToGuest getShipToGuest() {
        return shipToGuest;
    }

    @JsonProperty("ship_to_guest")
    public void setShipToGuest(ShipToGuest shipToGuest) {
        this.shipToGuest = shipToGuest;
    }

    @JsonProperty("ship_to_store")
    public ShipToStore getShipToStore() {
        return shipToStore;
    }

    @JsonProperty("ship_to_store")
    public void setShipToStore(ShipToStore shipToStore) {
        this.shipToStore = shipToStore;
    }

    @JsonProperty("scheduled_delivery")
    public ScheduledDelivery getScheduledDelivery() {
        return scheduledDelivery;
    }

    @JsonProperty("scheduled_delivery")
    public void setScheduledDelivery(ScheduledDelivery scheduledDelivery) {
        this.scheduledDelivery = scheduledDelivery;
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
