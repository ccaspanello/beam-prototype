package org.pentaho.test.dataflow.runner;

import org.junit.Test;
import org.pentaho.beam.app.WordCountMain;

/**
 * Created by ccaspanello on 5/9/18.
 */
public class DataflowRunnerTest {


  @Test
  public void test() {
    String output = System.getProperty( "buildDirectory" ) + "/test/apex/counts";
    WordCountMain.main( new String[] {
      "--runner=DataflowRunner",
      "--project=dataflow-etl",
      "--gcpTempLocation=gs://pentaho-beam-app/temp/",
      "--inputFile=gs://apache-beam-samples/shakespeare/*",
      "--output=gs://pentaho-beam-app/counts"});
  }
}
