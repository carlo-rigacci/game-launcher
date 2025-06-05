package com.faintful.casino.launcher.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GameLaunchResponseDTO {
    private String url;
    private String provider;
    private UUID aamsId;
    private String type;
    private UUID clientId;
}
