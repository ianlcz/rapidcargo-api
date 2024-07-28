package io.ianlcz.rapidcargo_api.model;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movements")
public class Movement {
    @Id
    private String id = UUID.randomUUID().toString();
    private LocalDateTime creationDate = LocalDateTime.now();
    private String createdBy;
    private LocalDateTime movementDate;
    private String location = "RapidCargo CDG";
    private MovementType type;
    private CargoInfo cargoInfo;
    private String customsStatus;
    private CustomsDocument customsDocument;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getMovementDate() {
        return movementDate;
    }

    public void setMovementDate(LocalDateTime movementDate) {
        this.movementDate = movementDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public CargoInfo getCargoInfo() {
        return cargoInfo;
    }

    public void setCargoInfo(CargoInfo cargoInfo) {
        this.cargoInfo = cargoInfo;
    }

    public String getCustomsStatus() {
        return customsStatus;
    }

    public void setCustomsStatus(String customsStatus) {
        this.customsStatus = customsStatus;
    }

    public CustomsDocument getCustomsDocument() {
        return customsDocument;
    }

    public void setCustomsDocument(CustomsDocument customsDocument) {
        this.customsDocument = customsDocument;
    }
}

