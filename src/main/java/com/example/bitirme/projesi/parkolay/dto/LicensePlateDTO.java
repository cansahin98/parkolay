package com.example.bitirme.projesi.parkolay.dto;

import com.example.bitirme.projesi.parkolay.entity.LicensePlate;
import lombok.Getter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
public class LicensePlateDTO {
    private long id;
    private String licensePlateData;

    public LicensePlateDTO() {
    }

    private LicensePlateDTO(Builder builder)
    {
        this.id = builder.id;
        this.licensePlateData = builder.licensePlateData;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public static class Builder {
        private long id;
        private String licensePlateData;

        private Builder() {
        }
        private Builder(LicensePlateDTO licensePlateDTO) {
            this.id = licensePlateDTO.id;
            this.licensePlateData = licensePlateDTO.licensePlateData;
        }

        public static Builder LicensePlateWith() {
            return new Builder();
        }
        public static Builder LicensePlateWith(LicensePlateDTO licensePlateDTO) {
            return new Builder(licensePlateDTO);
        }
        public Builder id(final Long id) {
            this.id = id;
            return this;
        }
        public Builder licensePlateData(final String licensePlateData) {
            this.licensePlateData = licensePlateData;
            return this;
        }

        public LicensePlate convertToEntity(LicensePlateDTO licensePlateDTO)
        {
            LicensePlate licensePlate = new LicensePlate();
            licensePlate.setId(licensePlateDTO.id);
            licensePlate.setLicensePlateData(licensePlateDTO.licensePlateData);

            return licensePlate;
        }

        public LicensePlateDTO build() {
            return new LicensePlateDTO(this);
        }

    }
}
