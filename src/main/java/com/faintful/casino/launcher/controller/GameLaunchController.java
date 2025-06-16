package com.faintful.casino.launcher.controller;

import com.faintful.casino.launcher.model.Device;
import com.faintful.casino.launcher.model.GameLaunchResponseDTO;
import com.faintful.casino.launcher.model.Mode;
import com.faintful.casino.launcher.services.GameLaunchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(GameLaunchController.LAUNCH_PATH)
public class GameLaunchController {
    public static final String LAUNCH_PATH = "/api/v1";

    private final GameLaunchService gameLaunchService;

    //TODO: Use DTO instead of @RequestParam
    @GetMapping("/launch")
    public GameLaunchResponseDTO launch(@RequestParam Mode mode,
                                        @RequestParam String session,
                                        @RequestParam UUID gameId,
                                        @RequestParam UUID playerId,
                                        @RequestParam Device device) {
        return gameLaunchService.launch(mode, session, gameId, playerId, device);
    }

}
