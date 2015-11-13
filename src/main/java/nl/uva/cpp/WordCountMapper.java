package nl.uva.cpp;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.*;

public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	private final static IntWritable one = new IntWritable(1);
	private Text word = new Text();

	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String tokens[] = value.toString().split("\\s+");
		for (String tok: tokens) {
			word.set(tok);
			context.write(word, one);
		}
	}
} 