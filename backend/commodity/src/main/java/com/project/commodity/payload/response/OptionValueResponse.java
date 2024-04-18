package com.project.commodity.payload.response;

import java.sql.Timestamp;
import java.util.UUID;

import com.project.commodity.entity.Option;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionValueResponse {
    private UUID id;
    private Option OptionId;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
