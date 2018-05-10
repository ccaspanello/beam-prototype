package org.pentaho.beam.app.transformation.step.csvinput;

import org.pentaho.beam.app.transformation.step.BaseStepMeta;

/**
 * Created by ccaspanello on 5/9/18.
 */
public class CsvInputMeta extends BaseStepMeta {

  private String path;

  public CsvInputMeta( String name ) {
    super( name );
  }

  public String getPath() {
    return path;
  }

  public void setPath( String path ) {
    this.path = path;
  }
}
