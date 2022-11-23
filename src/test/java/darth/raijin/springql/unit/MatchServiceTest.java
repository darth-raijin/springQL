package darth.raijin.springql.unit;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import darth.raijin.springql.repositories.MatchRepository;
import darth.raijin.springql.services.MatchService;

@SpringBootTest
public class MatchServiceTest {
    @Mock
    private MatchRepository matchRepository;

    @Mock
    private MatchService matchService;
    
}
