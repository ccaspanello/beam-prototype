package org.pentaho.beam.app.transformation.step.csvoutput;

import org.apache.beam.sdk.extensions.sql.RowSqlType;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.Row;
import org.apache.beam.sdk.values.RowType;
import org.pentaho.beam.app.transformation.step.BaseStep;

/**
 * Created by ccaspanello on 5/9/18.
 */
public class CsvOutput extends BaseStep<CsvOutputMeta> {

  public CsvOutput( CsvOutputMeta meta ) {
    super( meta );
  }

  @Override
  public void apply() {

    RowType rowType =
      RowSqlType
        .builder()
        .withIntegerField( "movieId" )
        .withVarcharField( "title" )
        .withVarcharField( "genres" )
        .build();

    String path = getStepMeta().getPath();

    PCollection<Row> data = getIncoming().stream().findFirst().get().getData();
    data.apply( ParDo.of(new CsvOutputFn(rowType)) )
    .apply( TextIO.write().to(path).withoutSharding() );

  }
}