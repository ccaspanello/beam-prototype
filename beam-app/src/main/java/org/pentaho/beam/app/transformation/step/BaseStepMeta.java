package org.pentaho.beam.app.transformation.step;

import org.pentaho.beam.app.transformation.api.StepMeta;

/**
 *  Common Base Step Meta-data
 *
 * Created by ccaspanello on 1/29/2018.
 */
public class BaseStepMeta implements StepMeta {

    private final String name;

    public BaseStepMeta(String name) {
        this.name = name;
    }

    //<editor-fold desc="Getters & Setters">
    @Override
    public String getName() {
        return name;
    }
    //</editor-fold>
}
