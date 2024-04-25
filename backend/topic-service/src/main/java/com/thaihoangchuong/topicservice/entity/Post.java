package com.thaihoangchuong.topicservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.UUID;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "TOPIC_ID")
    private UUID TopicId;

    @Column(name = "IMAGE")
    @Lob
    private byte[] Image;

    @Column(name ="Num_LIKE")
    private Integer  NumLike;

    @Column(name ="DESCRIPTION")
    private String Description;

    @Column(name = "CREATED_AT")
    private LocalDateTime CreatedAt;

    @Column(name = "UPDATED_AT")
    private LocalDateTime UpdatedAt;

    @Column(name = "CREATED_BY")
    private UUID CreatedBy;

    @Column(name = "UPDATED_BY")
    private UUID UpdatedBy;
}
