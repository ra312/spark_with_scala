import org.apache.hadoop.fs.{FileSystem, Path}

val fs = FileSystem.get(sc.hadoopConfiguration)

val outPutPath = new Path("aktiv_arpu_data")

if (fs.exists(outPutPath))
  println("The file is found")

