package IndiaStateAnalyser;

import org.junit.Test;

import IndiaStateAnalyser.StateCensusAnalyser;
import junit.framework.Assert;

public class StateCensusTest {
	private static final String FILE_PATH = "C:\\Users\\Admin\\workspace\\IndiaStateAnalyser\\src\\main\\resources\\IndiaStateCensusData.csv";
	
	@Test
	public void thisTestCasePasesWhenReturnValueEqualsTonumberOfStates() {
		StateCensusAnalyser analyser = new StateCensusAnalyser();
		int count = analyser.getStatesCount(FILE_PATH);
		Assert.assertEquals(29, count);
	}
}
