package IndiaStateAnalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCensusAnalyser { 
	int count = 0;
	
	public int getStatesCount(String FIle_PATH) throws IOException, StateCensusException { //Returns States Count and Loads CSV File into Iterator 
		try {
			Reader reader = Files.newBufferedReader(Paths.get(FIle_PATH));
			CSVReader read = new CSVReader(reader);
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();;
			Iterator<CSVStateCensus> iterator = csvToBean.iterator();
			
			while(iterator.hasNext()) {
				iterator.next();
				count++;
			}
		} catch(NoSuchFileException e) {
			throw new StateCensusException("No Such File");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
}
