import java.io.IOException;

import com.bazaarvoice.jolt.Chainr;
import com.bazaarvoice.jolt.JsonUtils;

public class JoltSample {

	public static void main(String[] args) throws IOException {
		Object chainrSpecJSON = JsonUtils.jsonToObject(JoltSample.class.getResourceAsStream("chainrSpec.json"));
		Chainr chainr = Chainr.fromSpec(chainrSpecJSON);
		Object inputJSON = JsonUtils.jsonToObject(JoltSample.class.getResourceAsStream("input.json"));
		Object transformedOutput = chainr.transform(inputJSON);
		System.out.println(JsonUtils.toJsonString(transformedOutput));
		
		Object caseDecisionChainrSpecJSON = JsonUtils.jsonToObject(JoltSample.class.getResourceAsStream("caseDecisionChainrSpec.json"));
		Chainr caseDecisionChainr = Chainr.fromSpec(caseDecisionChainrSpecJSON);
		Object caseDecisionInputJSON = JsonUtils.jsonToObject(JoltSample.class.getResourceAsStream("caseDecision.json"));
		Object caseDecisionTransformedOutput = caseDecisionChainr.transform(caseDecisionInputJSON);
		System.out.println(JsonUtils.toJsonString(caseDecisionTransformedOutput));
	}
}