package com.opendatapolicing.enus.design;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import com.opendatapolicing.enus.search.SearchList;
import java.util.ArrayList;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.vertx.core.logging.Logger;
import java.math.RoundingMode;
import com.opendatapolicing.enus.wrap.Wrap;
import java.math.MathContext;
import com.opendatapolicing.enus.writer.AllWriter;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.opendatapolicing.enus.request.api.ApiRequest;
import com.opendatapolicing.enus.design.PageDesign;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import com.opendatapolicing.enus.page.PageLayout;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.opendatapolicing.enus.cluster.Cluster;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opendatapolicing.enus.request.SiteRequestEnUS;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.opendatapolicing.enus.design.DesignPdfGenPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class DesignPdfGenPageGen<DEV> extends PageLayout {
	protected static final Logger LOGGER = LoggerFactory.getLogger(DesignPdfGenPage.class);

	////////////////////
	// listPageDesign //
	////////////////////

	/**	 The entity listPageDesign
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<PageDesign> listPageDesign;
	@JsonIgnore
	public Wrap<SearchList<PageDesign>> listPageDesignWrap = new Wrap<SearchList<PageDesign>>().p(this).c(SearchList.class).var("listPageDesign").o(listPageDesign);

	/**	<br/> The entity listPageDesign
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.opendatapolicing.enus.design.DesignPdfGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:listPageDesign">Find the entity listPageDesign in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _listPageDesign(Wrap<SearchList<PageDesign>> c);

	public SearchList<PageDesign> getListPageDesign() {
		return listPageDesign;
	}

	public void setListPageDesign(SearchList<PageDesign> listPageDesign) {
		this.listPageDesign = listPageDesign;
		this.listPageDesignWrap.alreadyInitialized = true;
	}
	public static SearchList<PageDesign> staticSetListPageDesign(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfGenPage listPageDesignInit() {
		if(!listPageDesignWrap.alreadyInitialized) {
			_listPageDesign(listPageDesignWrap);
			if(listPageDesign == null)
				setListPageDesign(listPageDesignWrap.o);
		}
		if(listPageDesign != null)
			listPageDesign.initDeepForClass(siteRequest_);
		listPageDesignWrap.alreadyInitialized(true);
		return (DesignPdfGenPage)this;
	}

	/////////////////
	// pageDesign_ //
	/////////////////

	/**	 The entity pageDesign_
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected PageDesign pageDesign_;
	@JsonIgnore
	public Wrap<PageDesign> pageDesign_Wrap = new Wrap<PageDesign>().p(this).c(PageDesign.class).var("pageDesign_").o(pageDesign_);

	/**	<br/> The entity pageDesign_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:com.opendatapolicing.enus.design.DesignPdfGenPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageDesign_">Find the entity pageDesign_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageDesign_(Wrap<PageDesign> c);

	public PageDesign getPageDesign_() {
		return pageDesign_;
	}

	public void setPageDesign_(PageDesign pageDesign_) {
		this.pageDesign_ = pageDesign_;
		this.pageDesign_Wrap.alreadyInitialized = true;
	}
	public static PageDesign staticSetPageDesign_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignPdfGenPage pageDesign_Init() {
		if(!pageDesign_Wrap.alreadyInitialized) {
			_pageDesign_(pageDesign_Wrap);
			if(pageDesign_ == null)
				setPageDesign_(pageDesign_Wrap.o);
		}
		pageDesign_Wrap.alreadyInitialized(true);
		return (DesignPdfGenPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedDesignPdfGenPage = false;

	public DesignPdfGenPage initDeepDesignPdfGenPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedDesignPdfGenPage) {
			alreadyInitializedDesignPdfGenPage = true;
			initDeepDesignPdfGenPage();
		}
		return (DesignPdfGenPage)this;
	}

	public void initDeepDesignPdfGenPage() {
		initDesignPdfGenPage();
		super.initDeepPageLayout(siteRequest_);
	}

	public void initDesignPdfGenPage() {
		listPageDesignInit();
		pageDesign_Init();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepDesignPdfGenPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestDesignPdfGenPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestPageLayout(siteRequest_);
		if(listPageDesign != null)
			listPageDesign.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestDesignPdfGenPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainDesignPdfGenPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainDesignPdfGenPage(String var) {
		DesignPdfGenPage oDesignPdfGenPage = (DesignPdfGenPage)this;
		switch(var) {
			case "listPageDesign":
				return oDesignPdfGenPage.listPageDesign;
			case "pageDesign_":
				return oDesignPdfGenPage.pageDesign_;
			default:
				return super.obtainPageLayout(var);
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
				o = attributeDesignPdfGenPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeDesignPdfGenPage(String var, Object val) {
		DesignPdfGenPage oDesignPdfGenPage = (DesignPdfGenPage)this;
		switch(var) {
			default:
				return super.attributePageLayout(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetDesignPdfGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetDesignPdfGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSetPageLayout(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrDesignPdfGenPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrDesignPdfGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSolrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrDesignPdfGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrDesignPdfGenPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSolrStrPageLayout(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqDesignPdfGenPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqDesignPdfGenPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
			default:
				return PageLayout.staticSolrFqPageLayout(entityVar,  siteRequest_, o);
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
					o = defineDesignPdfGenPage(v, val);
				else if(o instanceof Cluster) {
					Cluster cluster = (Cluster)o;
					o = cluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineDesignPdfGenPage(String var, String val) {
		switch(var) {
			default:
				return super.definePageLayout(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsDesignPdfGenPage();
		super.htmlScripts();
	}

	public void htmlScriptsDesignPdfGenPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptDesignPdfGenPage();
		super.htmlScript();
	}

	public void htmlScriptDesignPdfGenPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyDesignPdfGenPage();
		super.htmlBody();
	}

	public void htmlBodyDesignPdfGenPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlDesignPdfGenPage();
		super.html();
	}

	public void htmlDesignPdfGenPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaDesignPdfGenPage();
		super.htmlMeta();
	}

	public void htmlMetaDesignPdfGenPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesDesignPdfGenPage();
		super.htmlStyles();
	}

	public void htmlStylesDesignPdfGenPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleDesignPdfGenPage();
		super.htmlStyle();
	}

	public void htmlStyleDesignPdfGenPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestDesignPdfGenPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof DesignPdfGenPage) {
			DesignPdfGenPage original = (DesignPdfGenPage)o;
			super.apiRequestPageLayout();
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
		if(!(o instanceof DesignPdfGenPage))
			return false;
		DesignPdfGenPage that = (DesignPdfGenPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("DesignPdfGenPage { ");
		sb.append(" }");
		return sb.toString();
	}
}
