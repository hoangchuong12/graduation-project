package com.thaihoangchuong.topicservice.payload.response;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    private UUID id;
    private UUID TopicId;
    @Lob
    private byte[] Image;

    private Integer NumLike;
    private String Description;


    private LocalDateTime CreatedAt;

    private LocalDateTime UpdatedAt;

    private UUID CreatedBy;


    private UUID UpdatedBy;
}
