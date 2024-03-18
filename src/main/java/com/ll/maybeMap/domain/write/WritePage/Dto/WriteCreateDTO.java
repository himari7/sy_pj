package com.ll.maybeMap.domain.write.WritePage.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WriteCreateDTO{

    private Long memberId;

    private String title;

    private String body;

    private Long wishCounter;

    private String place;


}