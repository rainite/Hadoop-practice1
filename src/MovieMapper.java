import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;


public class MovieMapper extends Mapper<Object, Text, Text, DoubleWritable> {


    private DoubleWritable price;
    private Text stock;

    public void map(Object key, Text value, Context context
    ) throws IOException, InterruptedException {


        Logger LOGGER = new Logger();

        String[] res = value.toString().split(",");

        String stockName = res[1];
//        LOGGER.logmap(stockName);
        String stockPrice = res[4];
//        LOGGER.logmap(stockPrice);

        try
        {
            price = new DoubleWritable(Double.parseDouble(stockPrice));
        }
        catch( NumberFormatException e )
        {
            price = new DoubleWritable(0.0);
        }

        stock = new Text(stockName);
        context.write(stock,price);

//        while (tokenLine.hasMoreTokens()) {
//
//           String[] res = tokenLine.nextToken().split(",");
//           String stockName = res[1];
//           LOGGER.logmap(stockName);
//           String stockPrice = res[4];
//           LOGGER.logmap(stockPrice);
//
//           stock = new Text(stockName);
//           price = new DoubleWritable(Double.parseDouble(stockPrice));
//
//           context.write(stock,price);
//        }

    }


}
