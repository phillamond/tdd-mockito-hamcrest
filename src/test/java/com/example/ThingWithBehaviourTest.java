package com.example;

import com.example.model.Combobulation;
import com.example.model.CombobulationConfig;
import com.example.service.CombobulationConvertor;
import com.example.service.LaunchParser;
import org.junit.Test;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ThingWithBehaviourTest {

    @Mock
    private CombobulationConvertor combobulationConvertor;

    @Mock
    private LaunchParser launchParser;

    @Test
    public void shouldCombobulateSuccesfully() {
        ThingWithBehaviour thing = new ThingWithBehaviour(launchParser, combobulationConvertor);
        CombobulationConfig combobulationConfig = new CombobulationConfig();
        when(launchParser.parse(anyString())).thenReturn(combobulationConfig);
        Combobulation givenCombobulation = new Combobulation();
        when(combobulationConvertor.convert(combobulationConfig)).thenReturn(givenCombobulation);

        Combobulation actualCombobulation = thing.combobulate();

        assertThat(actualCombobulation, is(sameInstance(givenCombobulation)));
    }
}
