package com.ll.maybeMap.domain.write.WritePage.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Write{

    @Id
    private Long id;

    private Long memberId;

}