package com.faintful.casino.launcher.services;

import com.faintful.casino.launcher.model.Device;
import com.faintful.casino.launcher.model.GameLaunchResponseDTO;
import com.faintful.casino.launcher.model.Mode;

import java.util.UUID;

public interface GameLaunchService {
    GameLaunchResponseDTO launch(Mode mode, String string, UUID gameId, UUID playerId, Device device);
}
