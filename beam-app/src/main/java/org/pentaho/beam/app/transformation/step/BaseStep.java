package org.pentaho.beam.app.transformation.step;


import org.apache.beam.sdk.Pipeline;
import org.pentaho.beam.app.transformation.StepRegistry;
import org.pentaho.beam.app.transformation.api.Hop;
import org.pentaho.beam.app.transformation.api.HopType;
import org.pentaho.beam.app.transformation.api.Step;
import org.pentaho.beam.app.transformation.api.StepMeta;

import java.util.HashSet;
import java.util.Set;

/**
 * Common Base Step Logic
 * <p>
 * Created by ccaspanello on 1/29/2018.
 */
public abstract class BaseStep<E extends StepMeta> implements Step {

  private final E meta;

  private Pipeline pipeline;
  private StepRegistry stepRegistry;
  private Set<Hop> incoming;
  private Set<Hop> outgoing;
  private Set<String> resultFiles;

  public BaseStep( E meta ) {
    this.incoming = new HashSet<>(  );
    this.outgoing = new HashSet<>(  );
    this.resultFiles = new HashSet<>(  );
    this.meta = meta;
  }

  public Hop outgoingHop( HopType hopType ) {
    return outgoing.stream().filter( hop -> hop.getHopMeta().getHopType().equals( hopType ) ).findFirst().get();
  }

  //<editor-fold desc="Getters & Setters">
  public Set<Hop> getIncoming() {
    return incoming;
  }

  public Set<Hop> getOutgoing() {
    return outgoing;
  }

  public Pipeline getPipeline() {
    return pipeline;
  }

  public void setPipeline( Pipeline pipeline ) {
    this.pipeline = pipeline;
  }

  public StepRegistry getStepRegistry() {
    return stepRegistry;
  }

  public void setStepRegistry( StepRegistry stepRegistry ) {
    this.stepRegistry = stepRegistry;
  }

  public E getStepMeta() {
    return meta;
  }

  public Set<String> getResultFiles(){
    return resultFiles;
  }

  public boolean isTerminating(){
    return incoming.size() > 0 && outgoing.size() == 0;
  }
  //</editor-fold>
}
