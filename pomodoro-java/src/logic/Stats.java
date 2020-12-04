package logic;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import SaveToCsv.CSVReaderWriter;

public class Stats {
	private ArrayList<String> data = null;
	private int result[];
	private String dayName;
	private String status;

	public Stats() {
		// TODO Auto-generated constructor stub
	}
	
	public int[] getData() {
		File file = new File("log.csv");
		CSVReaderWriter readerWriter = new CSVReaderWriter();
		data = readerWriter.readCSV(file.getAbsolutePath());
		result = new int[7];
		for (String data : data) {
			status = data.substring(24);
			dateToDayName(data);
			if(status.equals("Done Longbreak") == true) {
				if (dayName.equals("Mon") == true) {
					result[0]++;
				}else if (dayName.equals("Tue") == true) {
					result[1]++;
				}else if (dayName.equals("Wed") == true) {
					result[2]++;
				}else if (dayName.equals("Thu") == true) {
					result[3]++;
				}else if (dayName.equals("Fri") == true) {
					result[4]++;
				}else if (dayName.equals("Sat") == true) {
					result[5]++;
				}else if (dayName.equals("Sun") == true) {
					result[6]++;
				}
			}
		}
		
		return result;
	}
	
	public void dateToDayName(String data) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			dayName = formatter.parse(data.substring(0, 10)).toString().substring(0,3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
