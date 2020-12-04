package SaveToCsv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CSVReaderWriter {
	private FileWriter csvWriter = null;
	private FileReader csvReader = null;
	private BufferedReader reader = null;
	private String data[];
	private ArrayList<String> result;
	
	public CSVReaderWriter() {
		// TODO Auto-generated constructor stub
	}
	
	public void writeCSV(String filepath, String text) {
		try {
			csvWriter = new FileWriter(filepath,true);
			csvWriter.append(text);
			csvWriter.append("\n");			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				csvWriter.flush();
				csvWriter.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<String> readCSV(String filepath) {		
		try {
			csvReader = new FileReader(filepath);
			String row = "";
			reader = new BufferedReader(csvReader);
			result = new ArrayList<String>();
			
			while((row = reader.readLine()) != null) {
				data = row.split("#");
				for(String tempStr : data) {
					result.add(tempStr);
				}
			}
			csvReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
