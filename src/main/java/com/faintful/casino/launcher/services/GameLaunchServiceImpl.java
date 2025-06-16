package com.faintful.casino.launcher.services;

import com.faintful.casino.client.SessionClient;
import com.faintful.casino.launcher.model.Device;
import com.faintful.casino.launcher.model.GameLaunchResponseDto;
import com.faintful.casino.model.GameMode;
import com.faintful.casino.model.OpenSessionRequestDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameLaunchServiceImpl implements GameLaunchService {

    private  final SessionClient sessionClient;
    @Override
    public GameLaunchResponseDto launch(GameMode gameMode, String session, Integer gameId, Long playerId, Device device) {
        sessionClient.openSession(OpenSessionRequestDto.builder()
                .playerId(playerId)
                .gameId(gameId)
                .deviceId(device.ordinal())
                //TODO: Implement
//                        .ip()
//                        .currency()
                .mode(gameMode)
                .build());
        return GameLaunchResponseDto.builder().build();
    }
}
