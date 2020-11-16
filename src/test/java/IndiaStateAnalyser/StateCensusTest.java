package IndiaStateAnalyser;

import java.io.IOException;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import IndiaStateAnalyser.StateCensusAnalyser;
import junit.framework.Assert;

public class StateCensusTest {
	private static final String FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	private static final String WRONG_FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaCensusData.csv";
	private static final String FILE_PATH_WRONG_EXTENSION = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaStateCensusData.json";
	private static final String FILE_PATH_DELIMITER = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaStateCensusData2.csv";
	
	private static final String STATE_CODES_FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaStateCode.csv";
	private static final String STATE_CODES_FILE_PATH_WRONG_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaCode.csv";

	@Test
	public void thisTestCasePasesWhenReturnValueEqualsTonumberOfStates() { 
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		int count;
		try {		
			count = analyser.getStatesCount(FILE_PATH);
			Assert.assertEquals(29, count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (StateCensusException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void thisTestCaseExpectsNoSuchFileExceptionWhenWorngFilePathGiven() throws IOException { //Sad test Case
		
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser();
			ExpectedException exception = ExpectedException.none();
			exception.expect(StateCensusException.class);
			boolean result = analyser.checkFileExistOrNot(WRONG_FILE_PATH);
			Assert.assertTrue(result);
		} catch (StateCensusException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void thisTestCaseExpectsHeadersOrFileExtensionWrongException() throws StateCensusException { //Sad test Case
		
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser();
			ExpectedException exception = ExpectedException.none();
			exception.expect(StateCensusException.class);
			String[] headers = analyser.getHeaders(FILE_PATH_WRONG_EXTENSION);
			Assert.assertEquals("State", headers[0]);
			Assert.assertEquals("Population", headers[1]);
			Assert.assertEquals("AreaInSqKm", headers[2]);
			Assert.assertEquals("DensityPerSqKm", headers[3]);
		} catch (StateCensusException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void thisTestCasePasesWhenDelimiterCorrectReturnValueTrue() { 
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		boolean result;
		try {	
			ExpectedException exception = ExpectedException.none();
			exception.expect(StateCensusException.class);
			result = analyser.getStatesCountWhenTheDelimiterIsCorrect(FILE_PATH_DELIMITER);
			Assert.assertTrue(result);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (StateCensusException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void thisTestCaseReceivesHeadersIfIncorrectExpectsException() { //Sad test Case
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser();
			ExpectedException exception = ExpectedException.none();
			exception.expect(StateCensusException.class);
			boolean result = analyser.getHeadersOtherClass(FILE_PATH);
			Assert.assertTrue(result);
		} catch(StateCensusException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void thisTestCasePasesWhenReturnMatchedStatesCountEqualsTonumberOfMatchingStates() { 
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		int count;
		try {		
			count = analyser.getMatchedStatesCount(STATE_CODES_FILE_PATH, FILE_PATH);
			Assert.assertEquals(29, count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (StateCensusException e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	public void thisTestCaseExpectsNoSuchFileExceptionWhenWorngFilePathGivenStateCodes() throws IOException { //Sad test Case
		
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser();
			ExpectedException exception = ExpectedException.none();
			exception.expect(StateCensusException.class);
			boolean result = analyser.checkFileExistOrNotStateCodes(STATE_CODES_FILE_PATH_WRONG_PATH);
			Assert.assertTrue(result);
		} catch (StateCensusException e) {
			e.printStackTrace();
		}
	}
}
