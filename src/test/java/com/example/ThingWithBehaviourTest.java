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
import static org.mockito.Mockito.when;

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
        when(launchParser.parse(configJson)).thenReturn(combobulationConfig);
        Combobulation givenCombobulation = new Combobulation();
        when(combobulationConvertor.convert(combobulationConfig)).thenReturn(givenCombobulation);

        Combobulation actualCombobulation = thing.combobulate(configJson);

        assertThat(actualCombobulation, is(sameInstance(givenCombobulation)));
    }
}
