package IndiaStateAnalyser;

import java.io.FileNotFoundException;
import java.io.FileReader;
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
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensus.class).build();
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
	
	public boolean checkFileExistOrNot(String FIle_PATH) throws StateCensusException, IOException {
		String[] headers = null;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(FIle_PATH));
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensusWrongHeader.class).build();
			Iterator<CSVStateCensusWrongHeader> iterator = csvToBean.iterator();
			iterator.next();
		} 
		catch (NoSuchFileException e) {
			throw new StateCensusException("No Such File");
		}
		return true;
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
				iterator.next();
			}
		} catch(RuntimeException e) {
			throw new StateCensusException("Invalid Delimiter Occured");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean getHeadersOtherClass(String FIle_PATH) throws StateCensusException {
		String[] headers = null;
		try {
			Reader reader = Files.newBufferedReader(Paths.get(FIle_PATH));
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(CSVStateCensusWrongHeader.class).build();
			Iterator<CSVStateCensusWrongHeader> iterator = csvToBean.iterator();
			iterator.next();
		} catch (IOException e) {
			e.printStackTrace();
		}
		catch (RuntimeException e) {
			throw new StateCensusException("Incorrect Header");
		}
		return true;
	}
	
	
	public int getMatchedStatesCount(String FIle_PATH_CODES, String FILE_PATH_CENSUS) throws IOException, StateCensusException { //Returns States Count and Loads CSV File into Iterator 
		int count = 0;
		try {
			Reader readerCodes = Files.newBufferedReader(Paths.get(FIle_PATH_CODES));
			CsvToBean csvToBeanStateCodes = new CsvToBeanBuilder(readerCodes).withType(IndianStateCodes.class).build();
			Iterator<IndianStateCodes> iteratorCodes = csvToBeanStateCodes.iterator();
			
			while(iteratorCodes.hasNext()) {
				String stateCode = iteratorCodes.next().getState();
				
				Reader readerCensus = Files.newBufferedReader(Paths.get(FILE_PATH_CENSUS));
				CsvToBean csvToBeanStateCensus = new CsvToBeanBuilder(readerCensus).withType(CSVStateCensus.class).build();
				Iterator<CSVStateCensus> iteratorCensus = csvToBeanStateCensus.iterator();
				
				while(iteratorCensus.hasNext()) {
					String stateCensus = iteratorCensus.next().getState();
					if(stateCensus.contains(stateCode))
						count++;
				}
			}
		} catch(NoSuchFileException e) {
			throw new StateCensusException("No Such File");
		} catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public boolean checkFileExistOrNotStateCodes(String FIle_PATH) throws StateCensusException, IOException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(FIle_PATH));
			CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(IndianStateCodes.class).build();
			Iterator<IndianStateCodes> iterator = csvToBean.iterator();
			iterator.next();
		} 
		catch (NoSuchFileException e) {
			throw new StateCensusException("No Such File");
		}
		return true;
	}
	
public String[] getHeadersStateCodes(String FIle_PATH) throws IOException, StateCensusException { 
		
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

	public boolean getStatesCountWhenTheDelimiterIsCorrectStateCodes(String FIle_PATH) throws IOException, StateCensusException { //Returns States Count and Loads CSV File into Iterator 
	try {
		Reader reader = Files.newBufferedReader(Paths.get(FIle_PATH));
		CSVReader read = new CSVReader(reader);
		CsvToBean csvToBean = new CsvToBeanBuilder(reader).withType(IndianStateCodes.class).build();
		Iterator<IndianStateCodes> iterator = csvToBean.iterator();
		
		while(iterator.hasNext()) {
			iterator.next();
		}
	} catch(RuntimeException e) {
		throw new StateCensusException("Invalid Delimiter Occured");
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return true;
}
}
