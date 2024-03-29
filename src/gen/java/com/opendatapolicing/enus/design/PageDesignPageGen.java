package com.opendatapolicing.enus.design;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.opendatapolicing.enus.design.PageDesignGenPage;
import io.vertx.core.logging.Logger;
import java.math.RoundingMode;
import com.opendatapolicing.enus.wrap.Wrap;
import java.math.MathContext;
import com.opendatapolicing.enus.writer.AllWriter;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.opendatapolicing.enus.request.api.ApiRequest;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.opendatapolicing.enus.cluster.Cluster;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opendatapolicing.enus.request.SiteRequestEnUS;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.opendatapolicing.enus.design.PageDesignPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class PageDesignPageGen<DEV> extends PageDesignGenPage {
	protected static final Logger LOGGER = LoggerFactory.getLogger(PageDesignPage.class);

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedPageDesignPage = false;

	public PageDesignPage initDeepPageDesignPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedPageDesignPage) {
			alreadyInitializedPageDesignPage = true;
			initDeepPageDesignPage();
		}
		return (PageDesignPage)this;
	}

	public void initDeepPageDesignPage() {
		initPageDesignPage();
		super.initDeepPageDesignGenPage(siteRequest_);
	}

	public void initPageDesignPage() {
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepPageDesignPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestPageDesignPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageDesignGenPage(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestPageDesignPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainPageDesignPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainPageDesignPage(String var) {
		PageDesignPage oPageDesignPage = (PageDesignPage)this;
		switch(var) {
			default:
				return super.obtainPageDesignGenPage(var);
		}
	}

	///////////////
	// attribute //
	///////////////

	@Override public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributePageDesignPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributePageDesignPage(String var, Object val) {
		PageDesignPage oPageDesignPage = (PageDesignPage)this;
		switch(var) {
			default:
				return super.attributePageDesignGenPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetPageDesignPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetPageDesignPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return PageDesignGenPage.staticSetPageDesignGenPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrPageDesignPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrPageDesignPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageDesignGenPage.staticSolrPageDesignGenPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrPageDesignPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrPageDesignPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageDesignGenPage.staticSolrStrPageDesignGenPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqPageDesignPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqPageDesignPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return PageDesignGenPage.staticSolrFqPageDesignGenPage(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = definePageDesignPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object definePageDesignPage(String var, String val) {
		switch(var) {
			default:
				return super.definePageDesignGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsPageDesignPage();
		super.htmlScripts();
	}

	public void htmlScriptsPageDesignPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptPageDesignPage();
		super.htmlScript();
	}

	public void htmlScriptPageDesignPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyPageDesignPage();
		super.htmlBody();
	}

	public void htmlBodyPageDesignPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlPageDesignPage();
		super.html();
	}

	public void htmlPageDesignPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaPageDesignPage();
		super.htmlMeta();
	}

	public void htmlMetaPageDesignPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesPageDesignPage();
		super.htmlStyles();
	}

	public void htmlStylesPageDesignPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStylePageDesignPage();
		super.htmlStyle();
	}

	public void htmlStylePageDesignPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestPageDesignPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof PageDesignPage) {
			PageDesignPage original = (PageDesignPage)o;
			super.apiRequestPageDesignGenPage();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof PageDesignPage))
			return false;
		PageDesignPage that = (PageDesignPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("PageDesignPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
