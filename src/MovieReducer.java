import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Celestial on 6/20/17.
 */
public class MovieReducer extends Reducer<Text,DoubleWritable,Text,DoubleWritable> {

    private static final Logger LOGGER = Logger.getLogger(MovieReducer.class.getName());


    private DoubleWritable result = new DoubleWritable(0.0);

    public void reduce(Text key, Iterable<DoubleWritable> values,
                       Context context
    ) throws IOException, InterruptedException {

        double sum = 0;
        int count = 0;

        for (DoubleWritable val : values) {
            sum += val.get();
            count++;
        }

        double average = (double) sum / count;

        result.set(average);
        context.write(key, result);
    }
}

