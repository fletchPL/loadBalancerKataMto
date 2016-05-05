package edu.iis.mto.serverloadbalancer;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.Matcher;
import org.junit.Test;

public class ServerLoadBalancerTest {
	@Test
	public void itCompiles() {
		assertThat(true, equalTo(true));
	}

	@Test
	public void balancingServerWithNoVms_serverStayEmpty()
	{
		Server theServer = a(server().withCapacity(1));
		
		balance(aListOfServerWith(theServer), anEmptyListOfVms());
		
		assertThat(theServer, hasLoadPercentageOf(0.0d));
	}



	private Matcher<? super Server> hasLoadPercentageOf(double expectedloadPercentagle) {
		// TODO Auto-generated method stub
		return new CurrentLoadPercentageMatcher(expectedloadPercentagle);
	}

	private void balance(Server[] servers, Vm[] vms) {
		// TODO Auto-generated method stub
		new ServerLoadBalancer().balance(servers, vms);
		
	}

	private Vm[] anEmptyListOfVms() {
		// TODO Auto-generated method stub
		return new Vm[0];
	}

	private Server[] aListOfServerWith(Server... servers) {
		// TODO Auto-generated method stub
		return servers;
	}

	private Server a(ServerBuilder builder) {
		// TODO Auto-generated method stub
		return builder.build();
	}

	private ServerBuilder server() {
		// TODO Auto-generated method stub
		return new ServerBuilder();
	}
}
