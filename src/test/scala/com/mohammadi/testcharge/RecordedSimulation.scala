package com.mohammadi.testcharge

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://yahoo.fr")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("fr,fr-FR;q=0.8,en-US;q=0.5,en;q=0.3")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:90.0) Gecko/20100101 Firefox/90.0")





	val scn = scenario("RecordedSimulation")
		.exec(http("RecordedSimulation_0:GET_http://yahoo.fr/")
			.get("/")
			.check(status.is(302))
			.check(bodyBytes.is(RawFileBody("com/mohammadi/testcharge/recordedsimulation/0000_response.html"))))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}