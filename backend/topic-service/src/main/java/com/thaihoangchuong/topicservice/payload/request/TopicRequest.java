package com.thaihoangchuong.topicservice.payload.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import jakarta.persistence.Lob;



@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class TopicRequest {
    private String Name;
    @Lob
    private byte[] Image;
    private String Description;
    private UUID CreatedBy;
    private UUID UpdatedBy;
}
