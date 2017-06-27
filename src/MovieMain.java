import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * Created by Celestial on 6/23/17.
 */
public class MovieMain {



    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {

//        FileHandler fh;
//
//
//        fh = new FileHandler("~/Desktop/Java_Logs/MyLogFile.log");
//        LOGGER.addHandler(fh);
//        SimpleFormatter formatter = new SimpleFormatter();
//        fh.setFormatter(formatter);


        //Setting job configurations
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "StockMeans");

        job.setJarByClass(MovieMain.class);
        job.setMapperClass(MovieMapper.class);
//        job.setCombinerClass(#.class);
        job.setReducerClass(MovieReducer.class);
//        job.setNumReduceTasks(0);
        //Setting output key and value class types
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(DoubleWritable.class);

        //Setting up input ad output directories
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        //Run the job and wait till its completed
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}


