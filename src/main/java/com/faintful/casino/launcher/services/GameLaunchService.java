package com.faintful.casino.launcher.services;

import com.faintful.casino.launcher.model.Device;
import com.faintful.casino.launcher.model.GameLaunchResponseDto;
import com.faintful.casino.model.GameMode;

public interface GameLaunchService {
    GameLaunchResponseDto launch(GameMode gameMode, String session, Integer gameId, Long playerId, Device device);
}
