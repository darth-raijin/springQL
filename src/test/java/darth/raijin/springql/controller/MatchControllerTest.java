package darth.raijin.springql.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import darth.raijin.springql.repositories.MatchRepository;
import darth.raijin.springql.services.MatchService;

@WebMvcTest
public class MatchControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private MatchRepository matchRepository;

    @Mock
    private MatchService matchService;

    @Test
    public void responseBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .post("/match/player")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
