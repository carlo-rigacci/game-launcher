package com.faintful.casino.launcher.model;

import com.faintful.casino.model.GameMode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GameLauncherRequestDto {
    private GameMode mode;
    private String session;
    private Integer gameId;
    private Long playerId;
    private Device device;
}
