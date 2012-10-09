package udf;


import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

public final class Lower extends UDF {
	
  public Text evaluate(final Text s) {
	  System.out.println("456789");
    if (s == null) { return null; }
    return new Text(s.toString().toLowerCase());
    
    
  }
  
  
}