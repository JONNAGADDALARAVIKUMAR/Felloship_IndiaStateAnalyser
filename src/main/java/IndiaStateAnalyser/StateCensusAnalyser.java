package IndiaStateAnalyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.regex.PatternSyntaxException;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser { 
	int count = 0;
	
	public int getStatesCount(String FIle_PATH) throws IOException, StateCensusException { //Returns States Count and Loads CSV File into Iterator 
		try {
			Reader reader = Files.newBufferedReader(Paths.get(FIle_PATH));
			CSVReader read = new CSVReader(reader);
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();
			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			
			while(iterator.hasNext()) {
				iterator.next();
				count++;
			}
		} catch(NoSuchFileException e) {
			throw new StateCensusException("No Such File");
		}
		catch(PatternSyntaxException e) {
			throw new StateCensusException("No Suitable Delimeter");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public String[] getHeaders(String FIle_PATH) throws IOException, StateCensusException { //Returns States Count and Loads CSV File into Iterator 
		
		String[] headers = null;
		try {
			CSVReader read = new CSVReader(new FileReader(FIle_PATH));
			headers = read.readNext();
		}
		catch(NoSuchFileException e) {
			throw new StateCensusException("No Such File");
		}
		catch(FileNotFoundException e) {
			throw new StateCensusException("File Not Found");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return headers;
	}
	
	public boolean getStatesCountWhenTheDelimiterIsCorrect(String FIle_PATH) throws IOException, StateCensusException { //Returns States Count and Loads CSV File into Iterator 
		try {
			Reader reader = Files.newBufferedReader(Paths.get(FIle_PATH));
			CSVReader read = new CSVReader(reader);
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();
			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			
			while(iterator.hasNext()) {
				iterator.next().toString().split(",");
			}
		} catch(NoSuchFileException e) {
			throw new StateCensusException("No Such File");
		}
		catch(PatternSyntaxException e) {
			throw new StateCensusException("No Suitable Delimeter");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
