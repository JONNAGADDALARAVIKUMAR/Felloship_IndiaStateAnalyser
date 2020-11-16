package IndiaStateAnalyser;

import java.io.IOException;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import IndiaStateAnalyser.StateCensusAnalyser;
import junit.framework.Assert;

public class StateCensusTest {
	private static final String FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	private static final String WRONG_FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaCensusData.csv";
	
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
	public void thisTestCaseExpectsNoSuchFileExceptionWhenWorngFilePathGiven() { //Sad test Case
		
		try {
			StateCensusAnalyser analyser = new StateCensusAnalyser();
			ExpectedException exception = ExpectedException.none();
			exception.expect(StateCensusException.class);
			int count = analyser.getStatesCount(WRONG_FILE_PATH);
			Assert.assertEquals(29, count);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (StateCensusException e) {
			e.printStackTrace();
		}
	}
}
