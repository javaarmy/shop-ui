package io.pillopl.eventsource.shop.ui.events;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.Instant;
import java.util.UUID;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(name = ItemBought.TYPE, value = ItemBought.class),
        @JsonSubTypes.Type(name = ItemPaymentTimeout.TYPE, value = ItemPaymentTimeout.class),
        @JsonSubTypes.Type(name = ItemPaid.TYPE, value = ItemPaid.class)
})
public interface Event {

    String type();
    Instant when();
    UUID uuid();
}

