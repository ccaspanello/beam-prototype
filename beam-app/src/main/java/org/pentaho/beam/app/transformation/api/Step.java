package org.pentaho.beam.app.transformation.api;


import org.apache.beam.sdk.Pipeline;
import org.pentaho.beam.app.transformation.StepRegistry;

import java.io.Serializable;
import java.util.Set;

/**
 * Step Interface
 * <p>
 * Interface for classes that hold step logic.
 * <p>
 * Created by ccaspanello on 1/29/2018.
 */
public interface Step extends Serializable {

  /**
   * Executes Step Logic
   */
  void apply();

  //<editor-fold desc="Getters & Setters">
  void setPipeline( Pipeline pipeline );

  Pipeline getPipeline();

  void setStepRegistry( StepRegistry stepRegistry );

  StepRegistry getStepRegistry();

  StepMeta getStepMeta();

  Set<Hop> getIncoming();

  Set<Hop> getOutgoing();

  Set<String> getResultFiles();

  boolean isTerminating();

  //</editor-fold>
}
