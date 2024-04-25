package com.thaihoangchuong.topicservice.payload.request;

import java.util.UUID;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class PostRequest {

    private UUID TopicId;
    @Lob
    private byte[] Image;

    private Integer NumLike;
    private String Description;

    private UUID CreatedBy;


    private UUID UpdatedBy;
}
