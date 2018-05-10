package org.pentaho.beam.app;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.pentaho.beam.app.transformation.StepRegistry;
import org.pentaho.beam.app.transformation.TransContext;
import org.pentaho.beam.app.transformation.TransformationOptions;
import org.pentaho.beam.app.transformation.api.TransMeta;
import org.pentaho.beam.app.transformation.api.Transformation;
import org.pentaho.beam.app.transformation.gson.TransMetaConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * TODO Replace tutorial code with ETL program
 */
public class TransformationMain {

  private static final Logger LOG = LoggerFactory.getLogger( TransformationMain.class );

  public static void main( String[] args ) {
    TransformationOptions options = PipelineOptionsFactory
      .fromArgs( args )
      .withValidation()
      .as( TransformationOptions.class );
    Pipeline p = Pipeline.create( options );

    String transformationFile = options.getTransformationFile();
    TransMetaConverter converter = new TransMetaConverter();
    TransMeta transMeta = converter.fromJson( new File(transformationFile), options.getParameters() );
    StepRegistry stepRegistry = new StepRegistry();
    stepRegistry.init();
    TransContext transContext = new TransContext( p, stepRegistry );
    Transformation transformation = new Transformation( transContext, transMeta );
    transformation.execute();


    LOG.error( "-------------------------------------" );
    //LOG.info( "debug: {}", data3.toString() );
    LOG.error( "-------------------------------------" );

    p.run().waitUntilFinish();
  }
}
