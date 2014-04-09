package com.example;

import com.example.model.Combobulation;
import com.example.model.CombobulationConfig;
import com.example.service.CombobulationConvertor;
import com.example.service.LaunchParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ThingWithBehaviourTest {

    @Mock
    private CombobulationConvertor combobulationConvertor;

    @Mock
    private LaunchParser launchParser;

    private ThingWithBehaviour thing;

    @Before
    public void setUp() {
        // subject under test
        thing = new ThingWithBehaviour(launchParser, combobulationConvertor);
    }

    @Test
    public void shouldCombobulateSuccesfully() {
        CombobulationConfig combobulationConfig = new CombobulationConfig();
        String configJson = "{\"some\":\"json\"}";
        Combobulation givenCombobulation = new Combobulation();

        // check that dependencies are called with the correct parameters
        when(launchParser.parse(configJson)).thenReturn(combobulationConfig);
        when(combobulationConvertor.convert(combobulationConfig)).thenReturn(givenCombobulation);

        // invoke the subject under test
        Combobulation actualCombobulation = thing.combobulate(configJson);

        // check invocation interactions with mocked dependencies
        verify(launchParser, times(1)).parse(configJson);
        verify(combobulationConvertor, times(1)).convert(combobulationConfig);

        // check that the same instance of a Combobulation is bubbled up by the SUT
        assertThat(actualCombobulation, is(sameInstance(givenCombobulation)));
    }
}
