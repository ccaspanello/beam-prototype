package org.pentaho.beam.app.transformation;


import org.apache.beam.sdk.Pipeline;

/**
 * TODO Make Thread Safe if used inside executors
 *
 * Created by ccaspanello on 2/4/18.
 */
public class TransContext {

  private final Pipeline pipeline;
  private final StepRegistry stepRegistry;

  public TransContext( Pipeline pipeline, StepRegistry stepRegistry ) {
    this.pipeline = pipeline;
    this.stepRegistry = stepRegistry;
  }

  public Pipeline getPipeline() {
    return pipeline;
  }

  public StepRegistry getStepRegistry() {
    return stepRegistry;
  }
}
