package com.opendatapolicing.enus.trafficstop;

import com.opendatapolicing.enus.page.PageLayout;
import com.opendatapolicing.enus.config.SiteConfig;
import com.opendatapolicing.enus.request.SiteRequestEnUS;
import com.opendatapolicing.enus.context.SiteContextEnUS;
import com.opendatapolicing.enus.user.SiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import com.opendatapolicing.enus.search.SearchList;
import com.opendatapolicing.enus.wrap.Wrap;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.OperationRequest;
import io.vertx.core.json.JsonArray;
import java.net.URLDecoder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import org.apache.solr.common.util.SimpleOrderedMap;
import java.util.stream.Collectors;
import java.util.Arrays;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import org.apache.commons.collections.CollectionUtils;
import java.util.Objects;
import org.apache.solr.client.solrj.SolrQuery.SortClause;


/**
 * Translate: false
 **/
public class TrafficStopGenPage extends TrafficStopGenPageGen<PageLayout> {

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listTrafficStop(Wrap<SearchList<TrafficStop>> c) {
	}

	protected void _trafficStop_(Wrap<TrafficStop> c) {
		if(listTrafficStop != null && listTrafficStop.size() == 1)
			c.o(listTrafficStop.get(0));
	}

	@Override protected void _pageH1(Wrap<String> c) {
			c.o("report cards");
	}

	@Override protected void _pageH2(Wrap<String> c) {
		if(trafficStop_ != null && trafficStop_.getTrafficStopCompleteName() != null)
			c.o(trafficStop_.getTrafficStopCompleteName());
	}

	@Override protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	@Override protected void _pageTitle(Wrap<String> c) {
		if(trafficStop_ != null && trafficStop_.getTrafficStopCompleteName() != null)
			c.o(trafficStop_.getTrafficStopCompleteName());
		else if(trafficStop_ != null)
			c.o("report cards");
		else if(listTrafficStop == null || listTrafficStop.size() == 0)
			c.o("no report card found");
		else
			c.o("report cards");
	}

	@Override protected void _pageUri(Wrap<String> c) {
		c.o("/trafficstop");
	}

	@Override protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/trafficstop-999.png");
	}

	@Override protected void _contextIconGroup(Wrap<String> c) {
			c.o("regular");
	}

	@Override protected void _contextIconName(Wrap<String> c) {
			c.o("newspaper");
	}

	@Override public void initDeepTrafficStopGenPage() {
		initTrafficStopGenPage();
		super.initDeepPageLayout();
	}

	@Override public void htmlScriptsTrafficStopGenPage() {
		e("script").a("src", staticBaseUrl, "/js/enUS/TrafficStopPage.js").f().g("script");
	}

	@Override public void htmlScriptTrafficStopGenPage() {
		l("$(document).ready(function() {");
		tl(1, "document.onkeydown = function(evt) {");
		tl(2, "evt = evt || window.event;");
		tl(2, "var isEscape = false;");
		tl(2, "if ('key' in evt) {");
		tl(3, "isEscape = (evt.key === 'Escape' || evt.key === 'Esc');");
		tl(2, "} else {");
		tl(3, "isEscape = (evt.keyCode === 27);");
		tl(2, "}");
		tl(2, "if (isEscape) {");
		tl(3, "$('.w3-modal:visible').hide();");
		tl(2, "}");
		tl(1, "};");
		tl(1, "window.eventBus = new EventBus('/eventbus');");
		tl(1, "var pk = ", Optional.ofNullable(siteRequest_.getRequestPk()).map(l -> l.toString()).orElse("null"), ";");
		tl(1, "if(pk != null) {");
		tl(1, "}");
		tl(1, "websocketTrafficStop(websocketTrafficStopInner);");
		l("});");
	}

	public void htmlFormPageTrafficStop(TrafficStop o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Page");
			o.htmCreated("Page");
			o.htmModified("Page");
			o.htmObjectId("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Page");
			o.htmDeleted("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTrafficStopStartYear("Page");
			o.htmTrafficStopEndYear("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgencyKey("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsIndigenousMale("Page");
			o.htmPupilsIndigenousFemale("Page");
			o.htmPupilsIndigenousTotal("Page");
			o.htmPupilsIndigenousPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("Page");
			o.htmPupilsAsianFemale("Page");
			o.htmPupilsAsianTotal("Page");
			o.htmPupilsAsianPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsLatinxMale("Page");
			o.htmPupilsLatinxFemale("Page");
			o.htmPupilsLatinxTotal("Page");
			o.htmPupilsLatinxPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("Page");
			o.htmPupilsBlackFemale("Page");
			o.htmPupilsBlackTotal("Page");
			o.htmPupilsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("Page");
			o.htmPupilsWhiteFemale("Page");
			o.htmPupilsWhiteTotal("Page");
			o.htmPupilsWhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("Page");
			o.htmPupilsPacificIslanderFemale("Page");
			o.htmPupilsPacificIslanderTotal("Page");
			o.htmPupilsPacificIslanderPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("Page");
			o.htmPupilsMultiRacialFemale("Page");
			o.htmPupilsMultiRacialTotal("Page");
			o.htmPupilsMultiRacialPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("Page");
			o.htmTeachersMale("Page");
			o.htmTeachersFemale("Page");
			o.htmTeachersTotal("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("Page");
			o.htmTeachersWhitePercent("Page");
			o.htmTeachersBlackTotal("Page");
			o.htmTeachersBlackPercent("Page");
			o.htmTeachersOtherTotal("Page");
			o.htmTeachersOtherPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("Page");
			o.htmDelinquentComplaintsAtSchool("Page");
			o.htmDelinquentComplaintsAtSchoolPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("Page");
			o.htmDelinquentComplaintsAsianPercent("Page");
			o.htmDelinquentComplaintsBlack("Page");
			o.htmDelinquentComplaintsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsLatinx("Page");
			o.htmDelinquentComplaintsLatinxPercent("Page");
			o.htmDelinquentComplaintsMultiRacial("Page");
			o.htmDelinquentComplaintsMultiRacialPercent("Page");
			o.htmDelinquentComplaintsIndigenous("Page");
			o.htmDelinquentComplaintsIndigenousPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("Page");
			o.htmDelinquentComplaintsWhitePercent("Page");
			o.htmDelinquentComplaintsPacificIslander("Page");
			o.htmDelinquentComplaintsPacificIslanderPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionRate("Page");
			o.htmShortTermSuspensionsTotal("Page");
			o.htmLongTermSuspensionsTotal("Page");
			o.htmExpulsionsTotal("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("Page");
			o.htmShortTermSuspensionsAsianMale("Page");
			o.htmShortTermSuspensionsAsianTotal("Page");
			o.htmShortTermSuspensionsAsianPercent("Page");
			o.htmShortTermSuspensionsAsianRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("Page");
			o.htmShortTermSuspensionsBlackMale("Page");
			o.htmShortTermSuspensionsBlackTotal("Page");
			o.htmShortTermSuspensionsBlackPercent("Page");
			o.htmShortTermSuspensionsBlackRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsLatinxFemale("Page");
			o.htmShortTermSuspensionsLatinxMale("Page");
			o.htmShortTermSuspensionsLatinxTotal("Page");
			o.htmShortTermSuspensionsLatinxPercent("Page");
			o.htmShortTermSuspensionsLatinxRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndigenousFemale("Page");
			o.htmShortTermSuspensionsIndigenousMale("Page");
			o.htmShortTermSuspensionsIndigenousTotal("Page");
			o.htmShortTermSuspensionsIndigenousPercent("Page");
			o.htmShortTermSuspensionsIndigenousRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("Page");
			o.htmShortTermSuspensionsMultiRacialMale("Page");
			o.htmShortTermSuspensionsMultiRacialTotal("Page");
			o.htmShortTermSuspensionsMultiRacialPercent("Page");
			o.htmShortTermSuspensionsMultiRacialRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("Page");
			o.htmShortTermSuspensionsPacificIslanderMale("Page");
			o.htmShortTermSuspensionsPacificIslanderTotal("Page");
			o.htmShortTermSuspensionsPacificIslanderPercent("Page");
			o.htmShortTermSuspensionsPacificIslanderRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("Page");
			o.htmShortTermSuspensionsWhiteMale("Page");
			o.htmShortTermSuspensionsWhiteTotal("Page");
			o.htmShortTermSuspensionsWhitePercent("Page");
			o.htmShortTermSuspensionsWhiteRate("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAllRate("Page");
			o.htmShortTermSuspensionsBlackVsWhite("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38OverallPercent("Page");
			o.htmExamsCollegeReadyGrades38IndigenousPercent("Page");
			o.htmExamsCollegeReadyGrades38AsianPercent("Page");
			o.htmExamsCollegeReadyGrades38BlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38LatinxPercent("Page");
			o.htmExamsCollegeReadyGrades38MultiRacialPercent("Page");
			o.htmExamsCollegeReadyGrades38PacificIslanderPercent("Page");
			o.htmExamsCollegeReadyGrades38WhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912OverallPercent("Page");
			o.htmExamsCollegeReadyGrades912IndigenousPercent("Page");
			o.htmExamsCollegeReadyGrades912AsianPercent("Page");
			o.htmExamsCollegeReadyGrades912BlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912LatinxPercent("Page");
			o.htmExamsCollegeReadyGrades912MultiRacialPercent("Page");
			o.htmExamsCollegeReadyGrades912PacificIslanderPercent("Page");
			o.htmExamsCollegeReadyGrades912WhitePercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsOverallPercent("Page");
			o.htmGraduateWithin4YearsIndigenousPercent("Page");
			o.htmGraduateWithin4YearsAsianPercent("Page");
			o.htmGraduateWithin4YearsBlackPercent("Page");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsLatinxPercent("Page");
			o.htmGraduateWithin4YearsMultiRacialPercent("Page");
			o.htmGraduateWithin4YearsPacificIslanderPercent("Page");
			o.htmGraduateWithin4YearsWhitePercent("Page");
		} g("div");
	}

	public void htmlFormPOSTTrafficStop(TrafficStop o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("POST");
			o.htmCreated("POST");
			o.htmModified("POST");
			o.htmObjectId("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("POST");
			o.htmDeleted("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTrafficStopStartYear("POST");
			o.htmTrafficStopEndYear("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgencyKey("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsIndigenousMale("POST");
			o.htmPupilsIndigenousFemale("POST");
			o.htmPupilsIndigenousTotal("POST");
			o.htmPupilsIndigenousPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("POST");
			o.htmPupilsAsianFemale("POST");
			o.htmPupilsAsianTotal("POST");
			o.htmPupilsAsianPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsLatinxMale("POST");
			o.htmPupilsLatinxFemale("POST");
			o.htmPupilsLatinxTotal("POST");
			o.htmPupilsLatinxPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("POST");
			o.htmPupilsBlackFemale("POST");
			o.htmPupilsBlackTotal("POST");
			o.htmPupilsBlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("POST");
			o.htmPupilsWhiteFemale("POST");
			o.htmPupilsWhiteTotal("POST");
			o.htmPupilsWhitePercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("POST");
			o.htmPupilsPacificIslanderFemale("POST");
			o.htmPupilsPacificIslanderTotal("POST");
			o.htmPupilsPacificIslanderPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("POST");
			o.htmPupilsMultiRacialFemale("POST");
			o.htmPupilsMultiRacialTotal("POST");
			o.htmPupilsMultiRacialPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("POST");
			o.htmTeachersMale("POST");
			o.htmTeachersFemale("POST");
			o.htmTeachersTotal("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("POST");
			o.htmTeachersWhitePercent("POST");
			o.htmTeachersBlackTotal("POST");
			o.htmTeachersBlackPercent("POST");
			o.htmTeachersOtherTotal("POST");
			o.htmTeachersOtherPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("POST");
			o.htmDelinquentComplaintsAtSchool("POST");
			o.htmDelinquentComplaintsAtSchoolPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("POST");
			o.htmDelinquentComplaintsAsianPercent("POST");
			o.htmDelinquentComplaintsBlack("POST");
			o.htmDelinquentComplaintsBlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsLatinx("POST");
			o.htmDelinquentComplaintsLatinxPercent("POST");
			o.htmDelinquentComplaintsMultiRacial("POST");
			o.htmDelinquentComplaintsMultiRacialPercent("POST");
			o.htmDelinquentComplaintsIndigenous("POST");
			o.htmDelinquentComplaintsIndigenousPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("POST");
			o.htmDelinquentComplaintsWhitePercent("POST");
			o.htmDelinquentComplaintsPacificIslander("POST");
			o.htmDelinquentComplaintsPacificIslanderPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionRate("POST");
			o.htmShortTermSuspensionsTotal("POST");
			o.htmLongTermSuspensionsTotal("POST");
			o.htmExpulsionsTotal("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("POST");
			o.htmShortTermSuspensionsAsianMale("POST");
			o.htmShortTermSuspensionsAsianTotal("POST");
			o.htmShortTermSuspensionsAsianPercent("POST");
			o.htmShortTermSuspensionsAsianRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("POST");
			o.htmShortTermSuspensionsBlackMale("POST");
			o.htmShortTermSuspensionsBlackTotal("POST");
			o.htmShortTermSuspensionsBlackPercent("POST");
			o.htmShortTermSuspensionsBlackRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsLatinxFemale("POST");
			o.htmShortTermSuspensionsLatinxMale("POST");
			o.htmShortTermSuspensionsLatinxTotal("POST");
			o.htmShortTermSuspensionsLatinxPercent("POST");
			o.htmShortTermSuspensionsLatinxRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndigenousFemale("POST");
			o.htmShortTermSuspensionsIndigenousMale("POST");
			o.htmShortTermSuspensionsIndigenousTotal("POST");
			o.htmShortTermSuspensionsIndigenousPercent("POST");
			o.htmShortTermSuspensionsIndigenousRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("POST");
			o.htmShortTermSuspensionsMultiRacialMale("POST");
			o.htmShortTermSuspensionsMultiRacialTotal("POST");
			o.htmShortTermSuspensionsMultiRacialPercent("POST");
			o.htmShortTermSuspensionsMultiRacialRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("POST");
			o.htmShortTermSuspensionsPacificIslanderMale("POST");
			o.htmShortTermSuspensionsPacificIslanderTotal("POST");
			o.htmShortTermSuspensionsPacificIslanderPercent("POST");
			o.htmShortTermSuspensionsPacificIslanderRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("POST");
			o.htmShortTermSuspensionsWhiteMale("POST");
			o.htmShortTermSuspensionsWhiteTotal("POST");
			o.htmShortTermSuspensionsWhitePercent("POST");
			o.htmShortTermSuspensionsWhiteRate("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAllRate("POST");
			o.htmShortTermSuspensionsBlackVsWhite("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38OverallPercent("POST");
			o.htmExamsCollegeReadyGrades38IndigenousPercent("POST");
			o.htmExamsCollegeReadyGrades38AsianPercent("POST");
			o.htmExamsCollegeReadyGrades38BlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38LatinxPercent("POST");
			o.htmExamsCollegeReadyGrades38MultiRacialPercent("POST");
			o.htmExamsCollegeReadyGrades38PacificIslanderPercent("POST");
			o.htmExamsCollegeReadyGrades38WhitePercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912OverallPercent("POST");
			o.htmExamsCollegeReadyGrades912IndigenousPercent("POST");
			o.htmExamsCollegeReadyGrades912AsianPercent("POST");
			o.htmExamsCollegeReadyGrades912BlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912LatinxPercent("POST");
			o.htmExamsCollegeReadyGrades912MultiRacialPercent("POST");
			o.htmExamsCollegeReadyGrades912PacificIslanderPercent("POST");
			o.htmExamsCollegeReadyGrades912WhitePercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsOverallPercent("POST");
			o.htmGraduateWithin4YearsIndigenousPercent("POST");
			o.htmGraduateWithin4YearsAsianPercent("POST");
			o.htmGraduateWithin4YearsBlackPercent("POST");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsLatinxPercent("POST");
			o.htmGraduateWithin4YearsMultiRacialPercent("POST");
			o.htmGraduateWithin4YearsPacificIslanderPercent("POST");
			o.htmGraduateWithin4YearsWhitePercent("POST");
		} g("div");
	}

	public void htmlFormPUTImportTrafficStop(TrafficStop o) {
		{ e("div").a("class", "w3-cell-row ").f();
			e("textarea")
				.a("class", "PUTImport_list w3-input w3-border ")
				.a("style", "height: 400px; ")
				.a("placeholder", "{ \"list\": [ { \"pk\": ... , \"saves\": [ ... ] }, ... ] }")
				;
				f();
			g("textarea");
		} g("div");
	}

	public void htmlFormPUTMergeTrafficStop(TrafficStop o) {
		{ e("div").a("class", "w3-cell-row ").f();
			e("textarea")
				.a("class", "PUTMerge_list w3-input w3-border ")
				.a("style", "height: 400px; ")
				.a("placeholder", "{ \"list\": [ { \"pk\": ... , \"saves\": [ ... ] }, ... ] }")
				;
				f();
			g("textarea");
		} g("div");
	}

	public void htmlFormPUTCopyTrafficStop(TrafficStop o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCreated("PUTCopy");
			o.htmModified("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PUTCopy");
			o.htmDeleted("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTrafficStopStartYear("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsIndigenousMale("PUTCopy");
			o.htmPupilsIndigenousFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("PUTCopy");
			o.htmPupilsAsianFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsLatinxMale("PUTCopy");
			o.htmPupilsLatinxFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("PUTCopy");
			o.htmPupilsBlackFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("PUTCopy");
			o.htmPupilsWhiteFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("PUTCopy");
			o.htmPupilsPacificIslanderFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("PUTCopy");
			o.htmPupilsMultiRacialFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("PUTCopy");
			o.htmTeachersMale("PUTCopy");
			o.htmTeachersFemale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("PUTCopy");
			o.htmTeachersBlackTotal("PUTCopy");
			o.htmTeachersOtherTotal("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("PUTCopy");
			o.htmDelinquentComplaintsAtSchool("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("PUTCopy");
			o.htmDelinquentComplaintsBlack("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsLatinx("PUTCopy");
			o.htmDelinquentComplaintsMultiRacial("PUTCopy");
			o.htmDelinquentComplaintsIndigenous("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("PUTCopy");
			o.htmDelinquentComplaintsPacificIslander("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionRate("PUTCopy");
			o.htmShortTermSuspensionsTotal("PUTCopy");
			o.htmLongTermSuspensionsTotal("PUTCopy");
			o.htmExpulsionsTotal("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("PUTCopy");
			o.htmShortTermSuspensionsAsianMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("PUTCopy");
			o.htmShortTermSuspensionsBlackMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsLatinxFemale("PUTCopy");
			o.htmShortTermSuspensionsLatinxMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndigenousFemale("PUTCopy");
			o.htmShortTermSuspensionsIndigenousMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("PUTCopy");
			o.htmShortTermSuspensionsMultiRacialMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("PUTCopy");
			o.htmShortTermSuspensionsPacificIslanderMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("PUTCopy");
			o.htmShortTermSuspensionsWhiteMale("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38OverallPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades38IndigenousPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades38AsianPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades38BlackPercent("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38LatinxPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades38MultiRacialPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades38PacificIslanderPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades38WhitePercent("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912OverallPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades912IndigenousPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades912AsianPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades912BlackPercent("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912LatinxPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades912MultiRacialPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades912PacificIslanderPercent("PUTCopy");
			o.htmExamsCollegeReadyGrades912WhitePercent("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsOverallPercent("PUTCopy");
			o.htmGraduateWithin4YearsIndigenousPercent("PUTCopy");
			o.htmGraduateWithin4YearsAsianPercent("PUTCopy");
			o.htmGraduateWithin4YearsBlackPercent("PUTCopy");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsLatinxPercent("PUTCopy");
			o.htmGraduateWithin4YearsMultiRacialPercent("PUTCopy");
			o.htmGraduateWithin4YearsPacificIslanderPercent("PUTCopy");
			o.htmGraduateWithin4YearsWhitePercent("PUTCopy");
		} g("div");
	}

	public void htmlFormPATCHTrafficStop(TrafficStop o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmCreated("PATCH");
			o.htmModified("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("PATCH");
			o.htmDeleted("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTrafficStopStartYear("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsIndigenousMale("PATCH");
			o.htmPupilsIndigenousFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("PATCH");
			o.htmPupilsAsianFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsLatinxMale("PATCH");
			o.htmPupilsLatinxFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("PATCH");
			o.htmPupilsBlackFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("PATCH");
			o.htmPupilsWhiteFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("PATCH");
			o.htmPupilsPacificIslanderFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("PATCH");
			o.htmPupilsMultiRacialFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("PATCH");
			o.htmTeachersMale("PATCH");
			o.htmTeachersFemale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("PATCH");
			o.htmTeachersBlackTotal("PATCH");
			o.htmTeachersOtherTotal("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("PATCH");
			o.htmDelinquentComplaintsAtSchool("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("PATCH");
			o.htmDelinquentComplaintsBlack("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsLatinx("PATCH");
			o.htmDelinquentComplaintsMultiRacial("PATCH");
			o.htmDelinquentComplaintsIndigenous("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("PATCH");
			o.htmDelinquentComplaintsPacificIslander("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionRate("PATCH");
			o.htmShortTermSuspensionsTotal("PATCH");
			o.htmLongTermSuspensionsTotal("PATCH");
			o.htmExpulsionsTotal("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("PATCH");
			o.htmShortTermSuspensionsAsianMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("PATCH");
			o.htmShortTermSuspensionsBlackMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsLatinxFemale("PATCH");
			o.htmShortTermSuspensionsLatinxMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndigenousFemale("PATCH");
			o.htmShortTermSuspensionsIndigenousMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("PATCH");
			o.htmShortTermSuspensionsMultiRacialMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("PATCH");
			o.htmShortTermSuspensionsPacificIslanderMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("PATCH");
			o.htmShortTermSuspensionsWhiteMale("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38OverallPercent("PATCH");
			o.htmExamsCollegeReadyGrades38IndigenousPercent("PATCH");
			o.htmExamsCollegeReadyGrades38AsianPercent("PATCH");
			o.htmExamsCollegeReadyGrades38BlackPercent("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38LatinxPercent("PATCH");
			o.htmExamsCollegeReadyGrades38MultiRacialPercent("PATCH");
			o.htmExamsCollegeReadyGrades38PacificIslanderPercent("PATCH");
			o.htmExamsCollegeReadyGrades38WhitePercent("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912OverallPercent("PATCH");
			o.htmExamsCollegeReadyGrades912IndigenousPercent("PATCH");
			o.htmExamsCollegeReadyGrades912AsianPercent("PATCH");
			o.htmExamsCollegeReadyGrades912BlackPercent("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912LatinxPercent("PATCH");
			o.htmExamsCollegeReadyGrades912MultiRacialPercent("PATCH");
			o.htmExamsCollegeReadyGrades912PacificIslanderPercent("PATCH");
			o.htmExamsCollegeReadyGrades912WhitePercent("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsOverallPercent("PATCH");
			o.htmGraduateWithin4YearsIndigenousPercent("PATCH");
			o.htmGraduateWithin4YearsAsianPercent("PATCH");
			o.htmGraduateWithin4YearsBlackPercent("PATCH");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsLatinxPercent("PATCH");
			o.htmGraduateWithin4YearsMultiRacialPercent("PATCH");
			o.htmGraduateWithin4YearsPacificIslanderPercent("PATCH");
			o.htmGraduateWithin4YearsWhitePercent("PATCH");
		} g("div");
	}

	public void htmlFormSearchTrafficStop(TrafficStop o) {
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPk("Search");
			o.htmCreated("Search");
			o.htmModified("Search");
			o.htmObjectId("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmArchived("Search");
			o.htmDeleted("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTrafficStopStartYear("Search");
			o.htmTrafficStopEndYear("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmAgencyKey("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsIndigenousMale("Search");
			o.htmPupilsIndigenousFemale("Search");
			o.htmPupilsIndigenousTotal("Search");
			o.htmPupilsIndigenousPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsAsianMale("Search");
			o.htmPupilsAsianFemale("Search");
			o.htmPupilsAsianTotal("Search");
			o.htmPupilsAsianPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsLatinxMale("Search");
			o.htmPupilsLatinxFemale("Search");
			o.htmPupilsLatinxTotal("Search");
			o.htmPupilsLatinxPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsBlackMale("Search");
			o.htmPupilsBlackFemale("Search");
			o.htmPupilsBlackTotal("Search");
			o.htmPupilsBlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsWhiteMale("Search");
			o.htmPupilsWhiteFemale("Search");
			o.htmPupilsWhiteTotal("Search");
			o.htmPupilsWhitePercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsPacificIslanderMale("Search");
			o.htmPupilsPacificIslanderFemale("Search");
			o.htmPupilsPacificIslanderTotal("Search");
			o.htmPupilsPacificIslanderPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsMultiRacialMale("Search");
			o.htmPupilsMultiRacialFemale("Search");
			o.htmPupilsMultiRacialTotal("Search");
			o.htmPupilsMultiRacialPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmPupilsTotal("Search");
			o.htmTeachersMale("Search");
			o.htmTeachersFemale("Search");
			o.htmTeachersTotal("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmTeachersWhiteTotal("Search");
			o.htmTeachersWhitePercent("Search");
			o.htmTeachersBlackTotal("Search");
			o.htmTeachersBlackPercent("Search");
			o.htmTeachersOtherTotal("Search");
			o.htmTeachersOtherPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsTotal("Search");
			o.htmDelinquentComplaintsAtSchool("Search");
			o.htmDelinquentComplaintsAtSchoolPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsAsian("Search");
			o.htmDelinquentComplaintsAsianPercent("Search");
			o.htmDelinquentComplaintsBlack("Search");
			o.htmDelinquentComplaintsBlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsLatinx("Search");
			o.htmDelinquentComplaintsLatinxPercent("Search");
			o.htmDelinquentComplaintsMultiRacial("Search");
			o.htmDelinquentComplaintsMultiRacialPercent("Search");
			o.htmDelinquentComplaintsIndigenous("Search");
			o.htmDelinquentComplaintsIndigenousPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmDelinquentComplaintsWhite("Search");
			o.htmDelinquentComplaintsWhitePercent("Search");
			o.htmDelinquentComplaintsPacificIslander("Search");
			o.htmDelinquentComplaintsPacificIslanderPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionRate("Search");
			o.htmShortTermSuspensionsTotal("Search");
			o.htmLongTermSuspensionsTotal("Search");
			o.htmExpulsionsTotal("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAsianFemale("Search");
			o.htmShortTermSuspensionsAsianMale("Search");
			o.htmShortTermSuspensionsAsianTotal("Search");
			o.htmShortTermSuspensionsAsianPercent("Search");
			o.htmShortTermSuspensionsAsianRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsBlackFemale("Search");
			o.htmShortTermSuspensionsBlackMale("Search");
			o.htmShortTermSuspensionsBlackTotal("Search");
			o.htmShortTermSuspensionsBlackPercent("Search");
			o.htmShortTermSuspensionsBlackRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsLatinxFemale("Search");
			o.htmShortTermSuspensionsLatinxMale("Search");
			o.htmShortTermSuspensionsLatinxTotal("Search");
			o.htmShortTermSuspensionsLatinxPercent("Search");
			o.htmShortTermSuspensionsLatinxRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsIndigenousFemale("Search");
			o.htmShortTermSuspensionsIndigenousMale("Search");
			o.htmShortTermSuspensionsIndigenousTotal("Search");
			o.htmShortTermSuspensionsIndigenousPercent("Search");
			o.htmShortTermSuspensionsIndigenousRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsMultiRacialFemale("Search");
			o.htmShortTermSuspensionsMultiRacialMale("Search");
			o.htmShortTermSuspensionsMultiRacialTotal("Search");
			o.htmShortTermSuspensionsMultiRacialPercent("Search");
			o.htmShortTermSuspensionsMultiRacialRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsPacificIslanderFemale("Search");
			o.htmShortTermSuspensionsPacificIslanderMale("Search");
			o.htmShortTermSuspensionsPacificIslanderTotal("Search");
			o.htmShortTermSuspensionsPacificIslanderPercent("Search");
			o.htmShortTermSuspensionsPacificIslanderRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsWhiteFemale("Search");
			o.htmShortTermSuspensionsWhiteMale("Search");
			o.htmShortTermSuspensionsWhiteTotal("Search");
			o.htmShortTermSuspensionsWhitePercent("Search");
			o.htmShortTermSuspensionsWhiteRate("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmShortTermSuspensionsAllRate("Search");
			o.htmShortTermSuspensionsBlackVsWhite("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38OverallPercent("Search");
			o.htmExamsCollegeReadyGrades38IndigenousPercent("Search");
			o.htmExamsCollegeReadyGrades38AsianPercent("Search");
			o.htmExamsCollegeReadyGrades38BlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades38LatinxPercent("Search");
			o.htmExamsCollegeReadyGrades38MultiRacialPercent("Search");
			o.htmExamsCollegeReadyGrades38PacificIslanderPercent("Search");
			o.htmExamsCollegeReadyGrades38WhitePercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912OverallPercent("Search");
			o.htmExamsCollegeReadyGrades912IndigenousPercent("Search");
			o.htmExamsCollegeReadyGrades912AsianPercent("Search");
			o.htmExamsCollegeReadyGrades912BlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmExamsCollegeReadyGrades912LatinxPercent("Search");
			o.htmExamsCollegeReadyGrades912MultiRacialPercent("Search");
			o.htmExamsCollegeReadyGrades912PacificIslanderPercent("Search");
			o.htmExamsCollegeReadyGrades912WhitePercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsOverallPercent("Search");
			o.htmGraduateWithin4YearsIndigenousPercent("Search");
			o.htmGraduateWithin4YearsAsianPercent("Search");
			o.htmGraduateWithin4YearsBlackPercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmGraduateWithin4YearsLatinxPercent("Search");
			o.htmGraduateWithin4YearsMultiRacialPercent("Search");
			o.htmGraduateWithin4YearsPacificIslanderPercent("Search");
			o.htmGraduateWithin4YearsWhitePercent("Search");
		} g("div");
		{ e("div").a("class", "w3-cell-row ").f();
			o.htmUserId("Search");
			o.htmUserKey("Search");
			o.htmObjectTitle("Search");
		} g("div");
	}

	@Override public void htmlBodyTrafficStopGenPage() {

		OperationRequest operationRequest = siteRequest_.getOperationRequest();
		JsonObject params = operationRequest.getParams();
		if(listTrafficStop == null || listTrafficStop.size() == 0) {

			{ e("h1").f();
				{ e("a").a("href", "/trafficstop").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-green w3-hover-pale-green ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("report cards").g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			{ e("h2").f();
				{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-green ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx("no report card found").g("span");
				} g("span");
			} g("h2");
		} else if(listTrafficStop != null && listTrafficStop.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			TrafficStop o = listTrafficStop.get(0);
			siteRequest_.setRequestPk(o.getPk());
			if(StringUtils.isNotEmpty(pageH1)) {
				{ e("h1").f();
					{ e("a").a("href", "/trafficstop").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-green w3-hover-pale-green ").f();
						if(contextIconCssClasses != null)
							e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
						e("span").a("class", " ").f().sx(pageH1).g("span");
					} g("a");
				} g("h1");
			}
			e("div").a("class", "w3-padding-16 w3-card-4 w3-light-grey ").f();
			if(StringUtils.isNotEmpty(pageH2)) {
				{ e("h2").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-green ").f();
						e("span").a("class", " ").f().sx(pageH2).g("span");
					} g("span");
				} g("h2");
			}
			if(StringUtils.isNotEmpty(pageH3)) {
				{ e("h3").f();
					{ e("span").a("class", "w3-bar-item w3-padding w3-center w3-block w3-pale-green ").f();
						e("span").a("class", " ").f().sx(pageH3).g("span");
					} g("span");
				} g("h3");
			}
		} else {

			{ e("h1").f();
				{ e("a").a("href", "/trafficstop").a("class", "w3-bar-item w3-btn w3-center w3-block w3-pale-green w3-hover-pale-green ").f();
					if(contextIconCssClasses != null)
						e("i").a("class", contextIconCssClasses + " site-menu-icon ").f().g("i");
					e("span").a("class", " ").f().sx(pageH1).g("span");
				} g("a");
			} g("h1");
			e("div").a("class", "").f();
				{ e("div").f();
					JsonObject queryParams = Optional.ofNullable(operationRequest).map(OperationRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
					Long num = listTrafficStop.getQueryResponse().getResults().getNumFound();
					String q = "*:*";
					String query1 = "objectText";
					String query2 = "";
					String query = "*:*";
					for(String paramName : queryParams.fieldNames()) {
						String entityVar = null;
						String valueIndexed = null;
						Object paramObjectValues = queryParams.getValue(paramName);
						JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

						try {
							for(Object paramObject : paramObjects) {
								switch(paramName) {
									case "q":
										q = (String)paramObject;
										entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
										valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
										query1 = entityVar.equals("*") ? query1 : entityVar;
										query2 = valueIndexed;
										query = query1 + ":" + query2;
								}
							}
						} catch(Exception e) {
							ExceptionUtils.rethrow(e);
						}
					}

					Integer rows1 = Optional.ofNullable(listTrafficStop).map(l -> l.getRows()).orElse(10);
					Integer start1 = Optional.ofNullable(listTrafficStop).map(l -> l.getStart()).orElse(1);
					Integer start2 = start1 - rows1;
					Integer start3 = start1 + rows1;
					Integer rows2 = rows1 / 2;
					Integer rows3 = rows1 * 2;
					start2 = start2 < 0 ? 0 : start2;
					StringBuilder fqs = new StringBuilder();
					for(String fq : Optional.ofNullable(listTrafficStop).map(l -> l.getFilterQueries()).orElse(new String[0])) {
						if(!StringUtils.contains(fq, "(")) {
							String fq1 = StringUtils.substringBefore(fq, "_");
							String fq2 = StringUtils.substringAfter(fq, ":");
							if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
								fqs.append("&fq=").append(fq1).append(":").append(fq2);
						}
					}
					StringBuilder sorts = new StringBuilder();
					for(SortClause sort : Optional.ofNullable(listTrafficStop).map(l -> l.getSorts()).orElse(Arrays.asList())) {
						sorts.append("&sort=").append(StringUtils.substringBefore(sort.getItem(), "_")).append(" ").append(sort.getOrder().name());
					}

					if(start1 == 0) {
						e("i").a("class", "fas fa-arrow-square-left w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/trafficstop?q=", query, fqs, sorts, "&start=", start2, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-left ").f().g("i");
						} g("a");
					}

					if(rows1 <= 1) {
						e("i").a("class", "fas fa-minus-square w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/trafficstop?q=", query, fqs, sorts, "&start=", start1, "&rows=", rows2).f();
							e("i").a("class", "fas fa-minus-square ").f().g("i");
						} g("a");
					}

					{ e("a").a("href", "/trafficstop?q=", query, fqs, sorts, "&start=", start1, "&rows=", rows3).f();
						e("i").a("class", "fas fa-plus-square ").f().g("i");
					} g("a");

					if(start3 >= num) {
						e("i").a("class", "fas fa-arrow-square-right w3-opacity ").f().g("i");
					} else {
						{ e("a").a("href", "/trafficstop?q=", query, fqs, sorts, "&start=", start3, "&rows=", rows1).f();
							e("i").a("class", "fas fa-arrow-square-right ").f().g("i");
						} g("a");
					}
						e("span").f().sx((start1 + 1), " - ", (start1 + rows1), " of ", num).g("span");
				} g("div");
				table1TrafficStopGenPage();
		}

		if(listTrafficStop != null && listTrafficStop.size() == 1 && params.getJsonObject("query").getString("q").equals("*:*")) {
			TrafficStop o = listTrafficStop.first();

			{ e("div").a("class", "").f();

				if(o.getPk() != null) {
					{ e("form").a("action", "").a("id", "TrafficStopForm").a("style", "display: inline-block; width: 100%; ").a("onsubmit", "event.preventDefault(); return false; ").f();
						e("input")
						.a("name", "pk")
						.a("class", "valuePk")
						.a("type", "hidden")
						.a("value", o.getPk())
						.fg();
						e("input")
						.a("name", "focusId")
						.a("type", "hidden")
						.fg();
					} g("form");
					htmlFormPageTrafficStop(o);
				}

			} g("div");

		}
		htmlBodyFormsTrafficStopGenPage();
		g("div");
	}

	public void table1TrafficStopGenPage() {
		{ e("table").a("class", "w3-table w3-bordered w3-striped w3-border w3-hoverable ").f();
			table2TrafficStopGenPage();
		} g("table");
	}

	public void table2TrafficStopGenPage() {
		thead1TrafficStopGenPage();
		tbody1TrafficStopGenPage();
		tfoot1TrafficStopGenPage();
	}

	public void thead1TrafficStopGenPage() {
		{ e("thead").a("class", "w3-pale-green w3-hover-pale-green ").f();
			thead2TrafficStopGenPage();
		} g("thead");
	}

	public void thead2TrafficStopGenPage() {
			{ e("tr").f();
			if(getColumnCreated()) {
				e("th").f().sx("created").g("th");
			}
			if(getColumnObjectTitle()) {
				e("th").f().sx("").g("th");
			}
			} g("tr");
	}

	public void tbody1TrafficStopGenPage() {
		{ e("tbody").f();
			tbody2TrafficStopGenPage();
		} g("tbody");
	}

	public void tbody2TrafficStopGenPage() {
		Map<String, Map<String, List<String>>> highlighting = listTrafficStop.getQueryResponse().getHighlighting();
		for(int i = 0; i < listTrafficStop.size(); i++) {
			TrafficStop o = listTrafficStop.getList().get(i);
			Map<String, List<String>> highlights = highlighting == null ? null : highlighting.get(o.getId());
			List<String> highlightList = highlights == null ? null : highlights.get(highlights.keySet().stream().findFirst().orElse(null));
			String uri = "/trafficstop/" + o.getPk();
			{ e("tr").f();
				if(getColumnCreated()) {
					{ e("td").f();
						{ e("a").a("href", uri).f();
							{ e("span").f();
								sx(o.strCreated());
							} g("span");
						} g("a");
					} g("td");
				}
				if(getColumnObjectTitle()) {
					{ e("td").f();
						{ e("a").a("href", uri).f();
							e("i").a("class", "far fa-newspaper ").f().g("i");
							{ e("span").f();
								sx(o.strObjectTitle());
							} g("span");
						} g("a");
					} g("td");
				}
			} g("tr");
		}
	}

	public void tfoot1TrafficStopGenPage() {
		{ e("tfoot").a("class", "w3-pale-green w3-hover-pale-green ").f();
			tfoot2TrafficStopGenPage();
		} g("tfoot");
	}

	public void tfoot2TrafficStopGenPage() {
		{ e("tr").f();
			SimpleOrderedMap facets = (SimpleOrderedMap)Optional.ofNullable(listTrafficStop.getQueryResponse()).map(QueryResponse::getResponse).map(r -> r.get("facets")).orElse(new SimpleOrderedMap());
			if(getColumnCreated()) {
				e("td").f();
				g("td");
			}
			if(getColumnObjectTitle()) {
				e("td").f();
				g("td");
			}
		} g("tr");
	}

	public Boolean getColumnCreated() {
		return true;
	}

	public Boolean getColumnObjectTitle() {
		return true;
	}

	public void htmlBodyFormsTrafficStopGenPage() {
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("div").a("class", "w3-margin-top ").f();

			if(listTrafficStop != null && listTrafficStop.size() == 1) {
				{ e("button")
					.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
						.a("id", "refreshThisTrafficStopGenPage")
						.a("onclick", "patchTrafficStopVals( [ {name: 'fq', value: 'pk:' + " + siteRequest_.getRequestPk() + " } ], {}, function() { addGlow($('#refreshThisTrafficStopGenPage')); }, function() { addError($('#refreshThisTrafficStopGenPage')); }); return false; ").f();
						e("i").a("class", "fas fa-sync-alt ").f().g("i");
					sx("refresh this report card");
				} g("button");
			}

			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#putimportTrafficStopModal').show(); ")
				.f();
				e("i").a("class", "fas fa-file-import ").f().g("i");
				sx("Import report cards");
			} g("button");
			{ e("div").a("id", "putimportTrafficStopModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putimportTrafficStopModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Import report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").a("id", "putimportTrafficStopFormValues").f();
							TrafficStop o = new TrafficStop();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putimportTrafficStopForm").f();
								htmlFormPUTImportTrafficStop(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "putimportTrafficStop($('#putimportTrafficStopForm')); ")
								.f().sx("Import report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#putmergeTrafficStopModal').show(); ")
				.f();
				e("i").a("class", "fas fa-code-merge ").f().g("i");
				sx("Merge report cards");
			} g("button");
			{ e("div").a("id", "putmergeTrafficStopModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putmergeTrafficStopModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Merge report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").a("id", "putmergeTrafficStopFormValues").f();
							TrafficStop o = new TrafficStop();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putmergeTrafficStopForm").f();
								htmlFormPUTMergeTrafficStop(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "putmergeTrafficStop($('#putmergeTrafficStopForm')); ")
								.f().sx("Merge report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#putcopyTrafficStopModal').show(); ")
				.f();
				e("i").a("class", "fas fa-copy ").f().g("i");
				sx("Duplicate report cards");
			} g("button");
			{ e("div").a("id", "putcopyTrafficStopModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#putcopyTrafficStopModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Duplicate report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").a("id", "putcopyTrafficStopFormValues").f();
							TrafficStop o = new TrafficStop();
							o.setSiteRequest_(siteRequest_);

							// Form PUT
							{ e("div").a("id", "putcopyTrafficStopForm").f();
								htmlFormPUTCopyTrafficStop(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "putcopyTrafficStop($('#putcopyTrafficStopForm'), ", trafficStop_ == null ? "null" : trafficStop_.getPk(), "); ")
								.f().sx("Duplicate report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#postTrafficStopModal').show(); ")
				.f();
				e("i").a("class", "fas fa-file-plus ").f().g("i");
				sx("Create a report card");
			} g("button");
			{ e("div").a("id", "postTrafficStopModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#postTrafficStopModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Create a report card").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").a("id", "postTrafficStopFormValues").f();
							TrafficStop o = new TrafficStop();
							o.setSiteRequest_(siteRequest_);

							// Form POST
							{ e("div").a("id", "postTrafficStopForm").f();
								htmlFormPOSTTrafficStop(o);
							} g("div");
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "postTrafficStop($('#postTrafficStopForm')); ")
								.f().sx("Create a report card")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");


			{ e("button")
				.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
				.a("onclick", "$('#patchTrafficStopModal').show(); ")
				.f();
				e("i").a("class", "fas fa-edit ").f().g("i");
				sx("Modify report cards");
			} g("button");
			{ e("div").a("id", "patchTrafficStopModal").a("class", "w3-modal w3-padding-32 ").f();
				{ e("div").a("class", "w3-modal-content ").f();
					{ e("div").a("class", "w3-card-4 ").f();
						{ e("header").a("class", "w3-container w3-pale-green ").f();
							e("span").a("class", "w3-button w3-display-topright ").a("onclick", "$('#patchTrafficStopModal').hide(); ").f().sx("×").g("span");
							e("h2").a("class", "w3-padding ").f().sx("Modify report cards").g("h2");
						} g("header");
						{ e("div").a("class", "w3-container ").a("id", "patchTrafficStopFormValues").f();
							TrafficStop o = new TrafficStop();
							o.setSiteRequest_(siteRequest_);

							htmlFormPATCHTrafficStop(o);
							e("button")
								.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-margin w3-pale-green ")
								.a("onclick", "patchTrafficStop(null, $('#patchTrafficStopFormValues'), ", Optional.ofNullable(trafficStop_).map(TrafficStop::getPk).map(a -> a.toString()).orElse("null"), ", function() {}, function() {}); ")
								.f().sx("Modify report cards")
							.g("button");

						} g("div");
					} g("div");
				} g("div");
			} g("div");

			g("div");
		}
		htmlSuggestedTrafficStopGenPage(this, null, listTrafficStop);
	}

	/**
	**/
	public static void htmlSuggestedTrafficStopGenPage(PageLayout p, String id, SearchList<TrafficStop> listTrafficStop) {
		SiteRequestEnUS siteRequest_ = p.getSiteRequest_();
		try {
			OperationRequest operationRequest = siteRequest_.getOperationRequest();
			JsonObject queryParams = Optional.ofNullable(operationRequest).map(OperationRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
			String q = "*:*";
			String query1 = "objectText";
			String query2 = "";
			for(String paramName : queryParams.fieldNames()) {
				String entityVar = null;
				String valueIndexed = null;
				Object paramObjectValues = queryParams.getValue(paramName);
				JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

				try {
					for(Object paramObject : paramObjects) {
						switch(paramName) {
							case "q":
								q = (String)paramObject;
								entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
								valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
								query1 = entityVar.equals("*") ? query1 : entityVar;
								query2 = valueIndexed.equals("*") ? "" : valueIndexed;
						}
					}
				} catch(Exception e) {
					ExceptionUtils.rethrow(e);
				}
			}

			Integer rows1 = Optional.ofNullable(listTrafficStop).map(l -> l.getRows()).orElse(10);
			Integer start1 = Optional.ofNullable(listTrafficStop).map(l -> l.getStart()).orElse(1);
			Integer start2 = start1 - rows1;
			Integer start3 = start1 + rows1;
			Integer rows2 = rows1 / 2;
			Integer rows3 = rows1 * 2;
			start2 = start2 < 0 ? 0 : start2;
			StringBuilder fqs = new StringBuilder();
			for(String fq : Optional.ofNullable(listTrafficStop).map(l -> l.getFilterQueries()).orElse(new String[0])) {
				if(!StringUtils.contains(fq, "(")) {
					String fq1 = StringUtils.substringBefore(fq, "_");
					String fq2 = StringUtils.substringAfter(fq, ":");
					if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
						fqs.append("&fq=").append(fq1).append(":").append(fq2);
				}
			}
			StringBuilder sorts = new StringBuilder();
			for(SortClause sort : Optional.ofNullable(listTrafficStop).map(l -> l.getSorts()).orElse(Arrays.asList())) {
				sorts.append("&sort=").append(StringUtils.substringBefore(sort.getItem(), "_")).append(" ").append(sort.getOrder().name());
			}

			if(
					CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), TrafficStopGenPage.ROLES)
					|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), TrafficStopGenPage.ROLES)
					) {
					{ p.e("div").a("class", "").f();
						{ p.e("button").a("id", "refreshAllTrafficStopGenPage", id).a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ").a("onclick", "patchTrafficStopVals([], {}, function() { addGlow($('#refreshAllTrafficStopGenPage", id, "')); }, function() { addError($('#refreshAllTrafficStopGenPage", id, "')); }); ").f();
							p.e("i").a("class", "fas fa-sync-alt ").f().g("i");
							p.sx("refresh all the report cards");
						} p.g("button");
					} p.g("div");
			}
			{ p.e("div").a("class", "w3-cell-row ").f();
				{ p.e("div").a("class", "w3-cell ").f();
					{ p.e("span").f();
						p.sx("search report cards: ");
					} p.g("span");
				} p.g("div");
			} p.g("div");
			{ p.e("div").a("class", "w3-bar ").f();

				p.e("input")
					.a("type", "text")
					.a("class", "suggestTrafficStop w3-input w3-border w3-bar-item ")
					.a("name", "suggestTrafficStop")
					.a("id", "suggestTrafficStop", id)
					.a("autocomplete", "off")
					.a("oninput", "suggestTrafficStopObjectSuggest( [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() }, { 'name': 'rows', 'value': '10' }, { 'name': 'fl', 'value': 'pk,pageUrlPk,trafficStopCompleteName' } ], $('#suggestListTrafficStop", id, "'), ", p.getSiteRequest_().getRequestPk(), "); ")
					.a("onkeyup", "if (event.keyCode === 13) { event.preventDefault(); window.location.href = '/trafficstop?q=", query1, ":' + encodeURIComponent(this.value) + '", fqs, sorts, "&start=", start2, "&rows=", rows1, "'; }"); 
				if(listTrafficStop != null)
					p.a("value", query2);
				p.fg();
				{ p.e("button")
					.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
					.a("onclick", "window.location.href = '/trafficstop?q=", query1, ":' + encodeURIComponent(this.previousElementSibling.value) + '", fqs, sorts, "&start=", start2, "&rows=", rows1, "'; ") 
					.f();
					p.e("i").a("class", "fas fa-search ").f().g("i");
				} p.g("button");

			} p.g("div");
			{ p.e("div").a("class", "w3-cell-row ").f();
				{ p.e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
					{ p.e("ul").a("class", "w3-ul w3-hoverable ").a("id", "suggestListTrafficStop", id).f();
					} p.g("ul");
				} p.g("div");
			} p.g("div");
			{ p.e("div").a("class", "").f();
				{ p.e("a").a("href", "/trafficstop").a("class", "").f();
					p.e("i").a("class", "far fa-newspaper ").f().g("i");
					p.sx("see all the report cards");
				} p.g("a");
			} p.g("div");
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

}
