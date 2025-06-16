package com.faintful.casino.launcher.controller;

import com.faintful.casino.launcher.model.GameLaunchResponseDto;
import com.faintful.casino.launcher.model.GameLauncherRequestDto;
import com.faintful.casino.launcher.services.GameLaunchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping(GameLaunchController.LAUNCH_PATH)
public class GameLaunchController {
    public static final String LAUNCH_PATH = "/api/v1";

    private final GameLaunchService gameLaunchService;

    @GetMapping("/launch")
    public GameLaunchResponseDto launch(@RequestBody GameLauncherRequestDto gameLauncherRequestDto) {
        return gameLaunchService.launch(
                gameLauncherRequestDto.getMode(),
                gameLauncherRequestDto.getSession(),
                gameLauncherRequestDto.getGameId(),
                gameLauncherRequestDto.getPlayerId(),
                gameLauncherRequestDto.getDevice()
        );
    }
}
