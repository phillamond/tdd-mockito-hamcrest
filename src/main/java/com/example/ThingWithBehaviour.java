package com.example;

import com.example.model.Combobulation;
import com.example.service.CombobulationConvertor;
import com.example.service.LaunchParser;

public class ThingWithBehaviour {
    private final LaunchParser launchParser;
    private final CombobulationConvertor combobulationConvertor;

    public ThingWithBehaviour(LaunchParser launchParser, CombobulationConvertor combobulationConvertor) {
        this.launchParser = launchParser;
        this.combobulationConvertor = combobulationConvertor;
    }

    public Combobulation combobulate() {
        return null;
    }
}
