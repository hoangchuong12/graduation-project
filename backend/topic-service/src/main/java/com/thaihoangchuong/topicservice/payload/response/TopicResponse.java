package com.thaihoangchuong.topicservice.payload.response;

import java.sql.Timestamp;
import java.util.UUID;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TopicResponse {
    private UUID id;
    private String Name;
    private String Image;
    private String Description;
    private Timestamp CreatedAt;
    private Timestamp UpdatedAt;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
