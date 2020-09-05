import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;



object App {
  def main() {
    val args = sc.getConf.get("spark.driver.args").split(",")
    
    // sc is the default spark context
    val fs = FileSystem.get(sc.hadoopConfiguration)
    val hadoop_path : String = "hdfs:///user/"+args(0)+"/"+args(1)
    val outputPath = new Path(hadoop_path)
    val outputFile = fs.create(outputPath)
    val writer = new PrintWriter(outputFile)
    val lines = new String(Files.readAllBytes(Paths.get("spark-app.py")))
    writer.write(lines)
    writer.close()
    sys.exit;
  }
}


