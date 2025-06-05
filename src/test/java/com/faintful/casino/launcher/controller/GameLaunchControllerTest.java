package com.faintful.casino.launcher.controller;

import com.faintful.casino.launcher.model.GameLaunchResponseDTO;
import com.faintful.casino.launcher.services.GameLaunchService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Slf4j
@WebMvcTest(GameLaunchController.class)
public class GameLaunchControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GameLaunchService gameLaunchService;
    @TestConfiguration
    static class MockConfig {
        @Bean
        GameLaunchService gameLaunchService() {
            return Mockito.mock(GameLaunchService.class);
        }
    }

    @Test
    void shouldReturnLaunchResponseWhenValidQueryParametersAreProvided() throws Exception {
        //Arrange
        UUID gameId = UUID.randomUUID();
        UUID playerId = UUID.randomUUID();
        MockHttpServletRequestBuilder mockGetRequest = MockMvcRequestBuilders.get(GameLaunchController.LAUNCH_PATH + "/launch")
                .queryParam("mode", "RM")
                .queryParam("session", "abc123")
                .queryParam("gameId", String.valueOf(gameId))
                .queryParam("playerId", String.valueOf(playerId))
                .queryParam("device", "DESKTOP")
                .accept(MediaType.APPLICATION_JSON);

        GameLaunchResponseDTO gameLaunchResponseDTO = GameLaunchResponseDTO.builder()
                .url("https://example.com/play")
                .provider("A")
                .aamsId(UUID.randomUUID())
                .type("application/json")
                .clientId(UUID.randomUUID())
                .build();

        given(gameLaunchService.launch(any(), any(), any(), any(), any()))
                .willReturn(gameLaunchResponseDTO);

        //Act

        ResultActions resultActions = mockMvc.perform(mockGetRequest)

        //Assert
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.url").value("https://example.com/play"))
                .andExpect(jsonPath("$.provider").value("A"))
                .andExpect(jsonPath("$.aamsId").value(gameLaunchResponseDTO.getAamsId().toString()))
                .andExpect(jsonPath("$.type").value("application/json"))
                .andExpect(jsonPath("$.clientId").value(gameLaunchResponseDTO.getClientId().toString()));

        //Log
        MvcResult mvcResult = resultActions.andReturn();
        String jsonResponse = mvcResult.getResponse().getContentAsString();
        log.info(jsonResponse);
    }
}
