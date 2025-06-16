package com.faintful.casino.launcher.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameLaunchResponseDto {
    private String url;
    private String provider;
    private String aamsId;
    private String type;
    private String clientId;
}
